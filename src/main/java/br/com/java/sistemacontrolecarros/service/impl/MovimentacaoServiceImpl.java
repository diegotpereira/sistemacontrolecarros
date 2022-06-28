package br.com.java.sistemacontrolecarros.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.sistemacontrolecarros.models.Movimentacao;
import br.com.java.sistemacontrolecarros.repository.MovimentacaoRepository;
import br.com.java.sistemacontrolecarros.service.MovimentacaoService;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService{

    private final MovimentacaoRepository movimentoRepository;

    @Autowired
    public MovimentacaoServiceImpl(MovimentacaoRepository movimentoRepository) {
        this.movimentoRepository = movimentoRepository;
    }

    @Override
    public List<Movimentacao> findAll() {
        // TODO Auto-generated method stub
        List<Movimentacao> carros = new ArrayList<>();

        for(Movimentacao movimentacao : movimentoRepository.findAll()) {
            carros.add(movimentacao);
        }

        return carros;
    }

    @Override
    public void save(Movimentacao movimentacao) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Movimentacao getById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Movimentacao> getByPlaca(String placa) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Movimentacao> getByModelo(String modelo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public BigDecimal calcularDiferenca(Date data_entrada, Date data_saida) {
        // TODO Auto-generated method stub
        DateTime entrada = new DateTime(data_entrada);
        DateTime saida = new DateTime(data_saida);

        BigDecimal minutos = new BigDecimal(Minutes.minutesBetween(entrada, saida).getMinutes());
        BigDecimal horas = minutos.divide(new BigDecimal("60"), 2, RoundingMode.HALF_UP);
        return horas;
    }

    @Override
    public BigDecimal calcularPagamento(BigDecimal preco_Hora, BigDecimal horas) {
        // TODO Auto-generated method stub
        BigDecimal valor_pago = preco_Hora.multiply(horas);
        
        return valor_pago;
    }

    public Movimentacao registrarEntrada(Movimentacao movimentacao) {

        movimentacao.setData_entrada(LocalDate.now());
        movimentacao.setHora_entrada(LocalTime.now());

        return movimentoRepository.save(movimentacao);
    }
    public Movimentacao registrarSaida(Movimentacao movimentacao) {

        Movimentacao movimentacaoSaindo = movimentoRepository.findById(movimentacao.getId()).get();
		Movimentacao movimentacaoSaindoRegistrado = registrarHoraSaida(registrarDataSaida(movimentacaoSaindo));

        return movimentoRepository.save(movimentacaoSaindoRegistrado);
    }

    public Movimentacao registrarDataSaida(Movimentacao movimentacao) {
		
		movimentacao.setData_saida(LocalDate.now());
		
		return movimentacao;
	}
    public Movimentacao registrarHoraSaida(Movimentacao movimentacao) {
        movimentacao.setHora_saida(LocalTime.now());
        
        return movimentacao;
}
}
