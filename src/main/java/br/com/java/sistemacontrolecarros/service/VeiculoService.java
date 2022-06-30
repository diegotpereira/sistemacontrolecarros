package br.com.java.sistemacontrolecarros.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.java.sistemacontrolecarros.models.Veiculo;

@Service
public interface VeiculoService {

    public Veiculo salvar(Veiculo veiculo);
    public List<Veiculo> buscarTodos();
    public Veiculo buscarPorId(Veiculo veiculo);
}
