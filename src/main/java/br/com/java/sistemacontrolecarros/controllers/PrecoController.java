package br.com.java.sistemacontrolecarros.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import br.com.java.sistemacontrolecarros.models.*;
import br.com.java.sistemacontrolecarros.repository.PrecoRepository;
import br.com.java.sistemacontrolecarros.service.PrecoService;

@Controller
@RequestMapping("/preco")
public class PrecoController {

    @Autowired
    PrecoService precosService;

    @Autowired
    PrecoRepository precoRepository;

    @GetMapping(value = "/cadastrar")
    public ModelAndView novo(Preco Preco) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/preco");
        return modelAndView;
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@Valid Preco preco) {

        
        precosService.salvar(preco);
        return new ModelAndView("redirect:/admin/home");

    }
    @GetMapping(value = "/buscar")
    public Preco buscar(Preco Preco, Veiculo veiculo) {
        return precoRepository.findById(veiculo.getTipoVeiculo()).get();
    }
}
