package br.com.java.sistemacontrolecarros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.java.sistemacontrolecarros.models.Movimentacao;
import br.com.java.sistemacontrolecarros.repository.MovimentacaoRepository;
import br.com.java.sistemacontrolecarros.service.MovimentacaoService;

@Controller
public class MovimentacaoController {

	// private final MovimentacaoRepository movimentacaoRepository;
	// @Autowired
	// private MovimentacaoService movimentacaoService;

	// @Autowired
	// public MovimentacaoController(MovimentacaoRepository movimentacaoRepository) {
	// 	this.movimentacaoRepository = movimentacaoRepository;
	// }

    // @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    // public String exibirMovimentacao(Model model) {

	// 	List<Movimentacao> carros = movimentacaoService.findAll();
    //     model.addAttribute("carros", carros);
		
	// 	return "index";
	// }
    
}
