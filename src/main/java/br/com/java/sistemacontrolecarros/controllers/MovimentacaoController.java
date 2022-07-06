package br.com.java.sistemacontrolecarros.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.java.sistemacontrolecarros.models.Movimentacao;
import br.com.java.sistemacontrolecarros.models.Preco;
import br.com.java.sistemacontrolecarros.repository.MovimentacaoRepository;
import br.com.java.sistemacontrolecarros.repository.VeiculoRepository;
import br.com.java.sistemacontrolecarros.service.MovimentacaoService;
import br.com.java.sistemacontrolecarros.service.PrecoService;


@Controller
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    VeiculoRepository veiculoRepository;

    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    @Autowired
	MovimentacaoService movimentacaoService;

    @Autowired
    PrecoService precoService;

    

    @GetMapping("/editar/{id}")
    public ModelAndView exibirEditar(@PathVariable("id") long id, Model model) {
        ModelAndView modelAndView = new ModelAndView();

        Movimentacao movimentacao = movimentacaoRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Id do carro inválido:" + id));
        model.addAttribute("movimentacao", movimentacao);
        modelAndView.setViewName("admin/atualizar");

        return modelAndView;
    }
    @PostMapping("/atualizar/{id}")
    public ModelAndView updateStudent(@PathVariable("id") long id, Movimentacao movimentacao, Model model) {

        movimentacao.setData_entrada(movimentacao.getData_entrada());
        movimentacao.setHora_entrada(movimentacao.getHora_entrada());
        movimentacaoRepository.save(movimentacao);

        return new ModelAndView("redirect:/admin/home");
    }

    @GetMapping("/visualizar/{id}")
    public ModelAndView exibirFormularioFinalizar(@PathVariable("id") long id, Model model, @Valid Preco preco) {

		ModelAndView modelAndView = new ModelAndView();
    
        
        // movimentacaoService.preencherDadosManualmente(movimentacao);
        Movimentacao movimentacao = movimentacaoRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Id de mvovimentação inválido:" + id));
        model.addAttribute("preco", preco);
        modelAndView.addObject("movimentacao", movimentacao);
		modelAndView.setViewName("admin/visualizar");
        return modelAndView;
    }
    @PostMapping("/finalizar/{id}")
    public ModelAndView finalizarCarro(@PathVariable("id") long id, Movimentacao movimentacao, Model model, Preco preco) {

		movimentacaoService.registrarSaida(movimentacao);        
        return new ModelAndView("redirect:/admin/home");
    }
}
