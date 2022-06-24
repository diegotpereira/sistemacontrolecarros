package br.com.java.sistemacontrolecarros.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import br.com.java.sistemacontrolecarros.models.User;
import br.com.java.sistemacontrolecarros.service.UserService;

@Controller
public class LoginController {
    
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");

        return modelAndView;
    }
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();

        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");

        return modelAndView;
    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
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
    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());

        modelAndView.addObject("userName", "Bem-Vindo " + user.getUserName() + "/" + user.getName() + " " + user.getLastname() + " (" + user.getEmail() + " )");
        modelAndView.addObject("adminMessage", "Conteúdo disponível apenas para usuários com função de administrador");
        modelAndView.setViewName("admin/home");

        return modelAndView;
    }
}
