package br.com.bjbraz.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bjbraz.domain.Conta;
import br.com.bjbraz.domain.Transacao;
import br.com.bjbraz.dto.TransacaoDTO;
import br.com.bjbraz.repo.ContaRepository;
import br.com.bjbraz.repo.TransacaoRepository;

/**
 * 
 * @author asimas
 *
 */
@Service
public class TransacaoService {
	
	private static final int nota100 = 100;
	private static final int nota50 = 50;
	private static final int nota20 = 20;
	private static final int nota10 = 10;
	
	@Autowired
	private TransacaoRepository transacaoRepo;
	
	@Autowired
	private ContaRepository contaRepo;

	private static final String RETORNO_ERRO_VALOR_NAO_PERMITIDO = "Value not allowed";
	private static final String RETORNO_ERRO_VALOR_NEGATIVO = "Negative value not allowed";
	private static final String RETORNO_SUCESSO = "Sucess";


	@Transactional
	public Transacao salvar(Transacao c) {
		return transacaoRepo.save(c);
	}
	
	public TransacaoDTO saque(final TransacaoDTO simpleTransacao) throws IllegalArgumentException{
		contarNotas(simpleTransacao);
		
		Optional<Conta> opCionalOrigem    = contaRepo.findById(Long.parseLong(simpleTransacao.getOrigem()));
		
		if(opCionalOrigem == null) {
			throw new IllegalArgumentException(RETORNO_ERRO_VALOR_NAO_PERMITIDO);
		}
		
		if(opCionalOrigem.get().getSaldo().compareTo(BigDecimal.ZERO) == -1){
			throw new IllegalArgumentException(RETORNO_ERRO_VALOR_NAO_PERMITIDO);
		}
		
		Transacao transacao = new Transacao();
		transacao.setDataTransacao(new Date());
		transacao.setOrigem(opCionalOrigem.get());
		transacao.setVlrValor(new BigDecimal(simpleTransacao.getValor()));
		opCionalOrigem.get().setSaldo(opCionalOrigem.get().getSaldo().subtract(transacao.getVlrValor()));
		transacao.setQtdNotasCem(simpleTransacao.getQtdNotasCem());
		transacao.setQtdNotasCinquenta(simpleTransacao.getQtdNotasCinquenta());
		transacao.setQtdNotasVinte(simpleTransacao.getQtdNotasVinte());
		transacao.setQtdNotasDez(simpleTransacao.getQtdNotasDez());
		
		/**
		 * Salva a transacao
		 */
		transacao = transacaoRepo.save(transacao);
		
		/**
		 * Salva o novo saldo da conta
		 */
		contaRepo.save(opCionalOrigem.get());
		simpleTransacao.setMensagem(RETORNO_SUCESSO);
		
		return simpleTransacao;
	}
	
	/**
	 * S
	 * 
	 * @param valor
	 * @return
	 */
	public void contarNotas(final TransacaoDTO retorno) {
		
		if (retorno == null) {
			throw new IllegalArgumentException(RETORNO_ERRO_VALOR_NAO_PERMITIDO);
		}		

		if (retorno.getValor() == null) {
			throw new IllegalArgumentException(RETORNO_ERRO_VALOR_NAO_PERMITIDO);
		}

		if (retorno.getValor() < 0) {
			throw new IllegalArgumentException(RETORNO_ERRO_VALOR_NEGATIVO);
		}

		int valorInteiro = retorno.getValor().intValue();

		int totalNotas100 = quantidadeNotas(valorInteiro, nota100);

		valorInteiro -= totalNotas100 * nota100;

		int totalNotas50 = quantidadeNotas(valorInteiro, nota50);

		valorInteiro -= totalNotas50 * nota50;

		int totalNotas20 = quantidadeNotas(valorInteiro, nota20);

		valorInteiro -= totalNotas20 * nota20;

		int totalNotas10 = quantidadeNotas(valorInteiro, nota10);

		valorInteiro -= totalNotas10 * nota10;

		retorno.setQtdNotasCem(totalNotas100);
		retorno.setQtdNotasCinquenta(totalNotas50);
		retorno.setQtdNotasVinte(totalNotas20);
		retorno.setQtdNotasDez(totalNotas10);
	}

	/**
	 * 
	 * @param valor
	 * @param valorNota
	 * @return
	 */
	private int quantidadeNotas(int valor, final int valorNota) {
		int retorno = 0;
		retorno = valor / valorNota;

		if (retorno > 0) {
			valor -= valorNota * retorno;
		}

		return retorno;
	}

	public List<Transacao> listarTodos() {
		return transacaoRepo.findAll();
	}
	
}
