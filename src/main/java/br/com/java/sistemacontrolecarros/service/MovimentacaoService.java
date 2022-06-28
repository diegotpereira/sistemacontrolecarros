package br.com.java.sistemacontrolecarros.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import br.com.java.sistemacontrolecarros.models.Movimentacao;

@Service
public interface MovimentacaoService {

    List<Movimentacao> findAll();
    void save(Movimentacao movimentacao);
    Movimentacao getById(Long id);
    List<Movimentacao> getByPlaca(String placa);
    List<Movimentacao> getByModelo(String modelo);
    void deleteById(Long id);

    public BigDecimal calcularDiferenca(Date data1, Date data2);

	public BigDecimal calcularPagamento(BigDecimal preco_Hora, BigDecimal hora);

    public Movimentacao registrarEntrada(Movimentacao movimentacao);

    public Movimentacao registrarSaida(Movimentacao movimentacao);


}
