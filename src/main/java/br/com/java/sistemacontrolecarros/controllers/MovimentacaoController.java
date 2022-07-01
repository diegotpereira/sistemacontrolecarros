package br.com.java.sistemacontrolecarros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.java.sistemacontrolecarros.models.Movimentacao;
import br.com.java.sistemacontrolecarros.repository.MovimentacaoRepository;
import br.com.java.sistemacontrolecarros.repository.VeiculoRepository;
import br.com.java.sistemacontrolecarros.service.MovimentacaoService;


@Controller
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    VeiculoRepository veiculoRepository;

    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    @Autowired
	MovimentacaoService movimentacaoService;

    @GetMapping("/visualizar/{id}")
    public ModelAndView exibirFormularioFinalizar(@PathVariable("id") long id, Model model) {

		ModelAndView modelAndView = new ModelAndView();
    
        
        // movimentacaoService.preencherDadosManualmente(movimentacao);
        Movimentacao movimentacao = movimentacaoRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Id do carro inválido:" + id));

        modelAndView.addObject("movimentacao", movimentacao);
		modelAndView.setViewName("admin/saida");
        return modelAndView;
    }
    @PostMapping("/finalizar/{id}")
    public ModelAndView finalizarCarro(@PathVariable("id") long id, Movimentacao movimentacao, Model model) {

		movimentacaoService.registrarSaida(movimentacao);
        

        // model.addAttribute("movimentacao", movimentacaoRepository.findAll());
        return new ModelAndView("redirect:/admin/home");
    }
    // public Movimentacao preencherDadosManualmente(Movimentacao movimentacao) {
	// 	return movimentacaoService.preencherDadosManualmente(movimentacao);
	// }
}
