package br.com.java.sistemacontrolecarros.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.sistemacontrolecarros.models.Veiculo;
import br.com.java.sistemacontrolecarros.repository.VeiculoRepository;
import br.com.java.sistemacontrolecarros.service.VeiculoService;

@Service
public class VeiculoServiceImpl implements VeiculoService{

    @Autowired
    VeiculoRepository veiculoRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Override
    public Veiculo salvar(Veiculo veiculo) {
        // TODO Auto-generated method stub
        return veiculoRepository.save(veiculo);
    }

    @Override
    public List<Veiculo> buscarTodos() {
        // TODO Auto-generated method stub
        return (List<Veiculo>) veiculoRepository.findAll();
    }

    @Override
    public Veiculo buscarPorId(Veiculo veiculo) {
        // TODO Auto-generated method stub
        return veiculoRepository.findById(veiculo.getIdVeiculo()).get();
    }
    
}
