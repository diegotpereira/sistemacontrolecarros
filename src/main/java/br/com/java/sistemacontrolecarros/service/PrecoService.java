package br.com.java.sistemacontrolecarros.service;

import org.springframework.stereotype.Service;
import br.com.java.sistemacontrolecarros.models.*;

@Service
public interface PrecoService {
    
    public Preco salvar(Preco preco);
    public Preco buscar(Veiculo veiculo);
}
