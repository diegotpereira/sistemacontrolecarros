package br.com.java.sistemacontrolecarros.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.sistemacontrolecarros.models.Preco;
import br.com.java.sistemacontrolecarros.models.Veiculo;
import br.com.java.sistemacontrolecarros.repository.PrecoRepository;
import br.com.java.sistemacontrolecarros.service.PrecoService;

@Service
public class PrecoServiceImpl implements PrecoService{

    @Autowired
    PrecoRepository precoRepository;

    public PrecoServiceImpl(PrecoRepository precoRepository) {
        this.precoRepository = precoRepository;
    }

    @Override
    public Preco salvar(Preco preco) {
        // TODO Auto-generated method stub
        return precoRepository.save(preco);
    }

    @Override
    public Preco buscar(Veiculo veiculo) {
        // TODO Auto-generated method stub
        return precoRepository.findById(veiculo.getTipoVeiculo()).get();
    }
    
}
