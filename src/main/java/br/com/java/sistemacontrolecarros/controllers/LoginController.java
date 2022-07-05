package br.com.java.sistemacontrolecarros.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import br.com.java.sistemacontrolecarros.models.*;
import br.com.java.sistemacontrolecarros.repository.MovimentacaoRepository;
import br.com.java.sistemacontrolecarros.service.*;

@Controller
public class LoginController {
    
    @Autowired
    private UserService userService;

    @Autowired
    VeiculoService veiculoService;

    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    @GetMapping(value = {"/", "/login"})
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");

        return modelAndView;
    }
    @GetMapping(value = "/registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();

        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");

        return modelAndView;
    }
    @PostMapping(value = "/registration")
    public ModelAndView criarUsuario(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        User usuarioExiste = userService.findUserByUserName(user.getUserName());

        if (usuarioExiste != null) {
            bindingResult
            .rejectValue("userName", "error.user", 
            "Já existe um usuário registrado com o nome de usuário fornecido");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "O usuário foi registrado com sucesso");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }
    @GetMapping(value = "/admin/home")
    public ModelAndView home(Model model) {
        ModelAndView modelAndView = new ModelAndView();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());

        modelAndView.addObject("userName", "Bem-Vindo " + user.getName() + " " + user.getLastname() );
        modelAndView.addObject("adminMessage", "Conteúdo disponível apenas para usuários com função de administrador");
        modelAndView.setViewName("admin/home");

        List<Veiculo> carros = veiculoService.buscarTodos();
        List<Movimentacao> movimentacoes = movimentacaoRepository.findAll();
        model.addAttribute("carros", carros);
        model.addAttribute("movimentacoes", movimentacoes);
        

        return modelAndView;
    }
}
