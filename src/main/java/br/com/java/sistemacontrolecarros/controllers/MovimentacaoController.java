package br.com.java.sistemacontrolecarros.controllers;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.java.sistemacontrolecarros.models.Movimentacao;
import br.com.java.sistemacontrolecarros.repository.MovimentacaoRepository;
import br.com.java.sistemacontrolecarros.service.MovimentacaoService;

@Controller
public class MovimentacaoController {

	private final MovimentacaoRepository movimentacaoRepository;
	
	@Autowired
	MovimentacaoService movimentacaoService;

	@Autowired
	public MovimentacaoController(MovimentacaoRepository movimentacaoRepository) {
		this.movimentacaoRepository = movimentacaoRepository;
	}

    // @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    // public String exibirMovimentacao(Model model) {

	// 	List<Movimentacao> carros = movimentacaoService.findAll();
    //     model.addAttribute("carros", carros);
		
	// 	return "index";
	// }
	@GetMapping(value = "/admin/cadastrar")
    public ModelAndView exibirFormularioCarros(Model model) {
		ModelAndView modelAndView = new ModelAndView();

        Movimentacao movimentacao = new Movimentacao();

        model.addAttribute("add", true);
        model.addAttribute("movimentacao", movimentacao);
		modelAndView.setViewName("admin/cadastrar");
     
        return modelAndView;
    }
    @PostMapping(value = {"/carros/add"})
    public ModelAndView addCarros(Model model, Movimentacao movimentacao) {
		// ModelAndView modelAndView = new ModelAndView();

        // Date data_entrada = new Date();
        // movimentacao.setData_entrada(data_entrada);
        movimentacaoService.registrarEntrada(movimentacao);

        movimentacaoRepository.save(movimentacao);
		// modelAndView.setViewName("admin/home");

        return new ModelAndView("redirect:/admin/home");
    }
	@GetMapping("/carros/editar/{id}")
    public ModelAndView exibirFormularioAtualizar(@PathVariable("id") long id, Model model) {

		ModelAndView modelAndView = new ModelAndView();
        Movimentacao movimentacao = movimentacaoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Id do carro inválido:" + id));
        model.addAttribute("movimentacao", movimentacao);

		modelAndView.setViewName("admin/atualizar");
        return modelAndView;
    }
	@PostMapping("/atualizar/{id}")
    public ModelAndView ataulizarCarro(@PathVariable("id") long id, Movimentacao movimentacao, Model model) {
        
        movimentacaoRepository.save(movimentacao);
        model.addAttribute("movimentacao", movimentacaoRepository.findAll());
        return new ModelAndView("redirect:/admin/home");
    }

	@GetMapping("/carros/finalizar/{id}")
    public ModelAndView exibirFormularioFinalizar(@PathVariable("id") long id, Model model) {

		ModelAndView modelAndView = new ModelAndView();
        Movimentacao movimentacao = movimentacaoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Id do carro inválido:" + id));
        model.addAttribute("movimentacao", movimentacao);

		modelAndView.setViewName("admin/saida");
        return modelAndView;
    }
	@PostMapping("/finalizar/{id}")
    public ModelAndView finalizarCarro(@PathVariable("id") long id, Movimentacao movimentacao, Model model) {

        
		movimentacaoService.registrarSaida(movimentacao);

    
        model.addAttribute("movimentacao", movimentacaoRepository.findAll());
        return new ModelAndView("redirect:/admin/home");
    }
}
