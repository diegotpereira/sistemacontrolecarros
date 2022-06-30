package br.com.java.sistemacontrolecarros.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import br.com.java.sistemacontrolecarros.models.*;
import br.com.java.sistemacontrolecarros.service.*;

@Controller
@RequestMapping("/veiculo")
public class VeiculoController {
  
    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    MovimentacaoService movimentacaoService;

    @GetMapping(value = "/cadastrar")
    public ModelAndView novo(Veiculo veiculo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/cadastrar");
        return modelAndView;
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@Valid Veiculo veiculo, BindingResult result, Model model, Movimentacao movimentacao) {

        if (result.hasErrors()) {
			return novo(veiculo);
		}
        model.addAttribute("veiculo", veiculo);
        veiculoService.salvar(veiculo);
        movimentacaoService.registrarEntrada(movimentacao);

        return new ModelAndView("redirect:/admin/home");
    }
}
