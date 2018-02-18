package seguros.api.spring;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import seguros.api.domain.Conta;
import seguros.api.domain.Transacao;
import seguros.api.domain.Usuario;
import seguros.api.dto.Historico;
import seguros.api.dto.StatusLogin;
import seguros.api.dto.TransacaoDTO;
import seguros.api.spring.repo.ContaRepository;
import seguros.api.spring.repo.TransacaoRepository;
import seguros.api.spring.repo.UsuarioRepository;

/**
 * 
 * @author alex.braz
 *
 */
@RestController
public class IndexController {
 
	private static final String ADMIN     = "admin";
	private static final String PRONATURA = "pronatura";
	private static final String ZSCORE    = "zscore";

	@SuppressWarnings("unused")
	private final UsuarioRepository usuarioRepo;
	
	@SuppressWarnings("unused")
	private final TransacaoRepository transacaoRepo;
	
	@SuppressWarnings("unused")
	private final ContaRepository contaRepo;
	
	private static final String PASSWD = "deltasp5k";
	private static final String DIRECTORY = "/home/asimas/projetos/quorum/";
	private Web3j quorum = Web3j.build(new HttpService("http://52.170.112.209:22006")); //6 sempre um a menos do que o geth
	
	private static final String ACCOUNT            = "0x50a24bc7b7b3ef09185c3f003fa154777ef73e0c";
	private static final String ACCOUNT_PRO_NATURA = "0xfe8bb5ff6a162f8baf2e0c18cfeaf6ee45cf91f8";
	private static final String ACCOUNT_ZSCORE     = "0xf4748c80f69a5a79a903ce4830faaa94ca533b19";
	private static final String ACCOUNT_ONU        = "0xc93c6ebdf802061d88b1d26e93f9779fc5f25ac6";
	
	private static final String FILE_ACCOUNT            = "UTC--2018-01-23T19-10-13.645631416Z--50a24bc7b7b3ef09185c3f003fa154777ef73e0c";	
	private static final String FILE_ACCOUNT_PRO_NATURA = "UTC--2018-01-23T19-13-40.235369250Z--fe8bb5ff6a162f8baf2e0c18cfeaf6ee45cf91f8";	
	private static final String FILE_ACCOUNT_ONU        = "UTC--2018-01-23T19-14-17.130936432Z--c93c6ebdf802061d88b1d26e93f9779fc5f25ac6";
	
    private static final int SLEEP_DURATION = 15000;
    private static final int ATTEMPTS = 40;	
	private static final BigInteger GAS_PRICE = BigInteger.valueOf(30_000_000_000L);
	private static final BigInteger GAS_LIMIT = BigInteger.valueOf(940_000_000L);
	private static final String tokenName    = "ZCO";
	private static final String tokenSymbol  = "ZCO2";
	private BigInteger initialSupply = BigInteger.valueOf(100_000_000L);
	private String contractAddress = "0xbf3c78616c12e99d686d60ea197c4b61cf65204b";
	

	@Autowired
	IndexController(UsuarioRepository usuarioRepo, TransacaoRepository transacaoRepo, ContaRepository contaRepo) {
		this.usuarioRepo   = usuarioRepo;
		this.transacaoRepo = transacaoRepo;
		this.contaRepo     = contaRepo;
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		System.out.println("Executou... /login");
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping("/proNatura")
	public ModelAndView proNatura() {
		System.out.println("Executou... /proNatura");
		ModelAndView mav = new ModelAndView("home_pronatura");
		return mav;
	}
	
	@RequestMapping("/zscore")
	public ModelAndView zscore() {
		System.out.println("Executou... /zscore");
		ModelAndView mav = new ModelAndView("home_zscore");
		return mav;
	}

	@RequestMapping("/index")
	public ModelAndView index() {
		System.out.println("Executou... /index");
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	@RequestMapping("/proccess")
	public ModelAndView proccess() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		ModelAndView mav = null;
		
		if(ADMIN.equals(currentPrincipalName)){
			System.out.println("Executou... /home " + currentPrincipalName);
			mav = new ModelAndView("home");
		}
		
		if(PRONATURA.equals(currentPrincipalName)){
			System.out.println("Executou... /home_pronatura " + currentPrincipalName);
			mav = new ModelAndView("home_pronatura");
		}
		
		if(ZSCORE.equals(currentPrincipalName)){
			System.out.println("Executou... /home_zscore " + currentPrincipalName);
			mav = new ModelAndView("home_zscore");
		}		
		
		return mav;
	}	

	@RequestMapping("/home")
	public ModelAndView home() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		
		System.out.println("Executou... /home " + currentPrincipalName);
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
	
	@RequestMapping("/teste")
	public Usuario teste() {
		Usuario retorno = usuarioRepo.findByNomeAndPassword("admin", "admin");
		return retorno;
	}
	
	@CrossOrigin
	@RequestMapping(value = ContractRestURIConstants.LOGIN, method = RequestMethod.POST)
	public Usuario efetuarLogin(@RequestBody StatusLogin login){
		try{
			Usuario retorno = usuarioRepo.findByNomeAndPassword(login.getUsuario().getEmail(), login.getUsuario().getPassword());
			return retorno;
		}catch(Exception e){
			return null;
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = ContractRestURIConstants.LOGIN+"/json", method = RequestMethod.GET)
	public StatusLogin efetuarLoginTeste(){
		StatusLogin sl = new StatusLogin();
		sl.setEmail("");
		sl.setNome("");
		sl.setUsuario(new Usuario());
		sl.getUsuario().setEmail("EMAIL");
		sl.getUsuario().setPassword("PASSWD");
		return sl;
	}	
	
	@CrossOrigin
	@RequestMapping(value = ContractRestURIConstants.SALDO, method = RequestMethod.GET)
	public String consultarSaldo(@PathVariable("id") String sconta){
		Conta conta = contaRepo.findById(Long.parseLong(sconta));
		
		String retorno = "";
		
		try{
			if(conta!=null && conta.getSaldo() != null){
				BigDecimal bd = conta.getSaldo();
				
				DecimalFormatSymbols symbol = new DecimalFormatSymbols();
				symbol.setDecimalSeparator(' ');
				symbol.setGroupingSeparator(' ');
				
				DecimalFormat df = new DecimalFormat("#,###", symbol);
			    retorno = df.format(bd);
			}
		}catch(Exception e){
			retorno = "0";
		}
		
		
		return retorno;
	}
	
	@CrossOrigin
	@RequestMapping(value = ContractRestURIConstants.TRANSFERE, method = RequestMethod.POST)
	public String transferir(@RequestBody TransacaoDTO simpleTransacao){
		System.out.println("Transacao recebida ");
		System.out.println("Transacao recebida Destino " + simpleTransacao.getDestino());
		System.out.println("Transacao recebida Origem " + simpleTransacao.getOrigem());
		System.out.println("Transacao recebida Pontos " + simpleTransacao.getQtdPontos());
		
		if(simpleTransacao == null || simpleTransacao.getQtdPontos() == null){
			return "Erro";
		}
		
		try{
			Transacao transacao = new Transacao();
			
			Conta origem = contaRepo.findById(Long.parseLong(simpleTransacao.getOrigem()));
			Conta destino = contaRepo.findById(Long.parseLong(simpleTransacao.getDestino()));
			Usuario usuario = usuarioRepo.findById(Long.parseLong(simpleTransacao.getIdUsuario()));
			
			transacao.setDataTransacao(new Date());
			transacao.setDestino(destino);
			transacao.setOrigem(origem);
			transacao.setUsuarioInclusao(usuario);
			transacao.setQtdPontos(new BigDecimal(simpleTransacao.getQtdPontos()));
			transacao.setHash("Pending...");
			
			System.out.println("Transacao convertida origem " + origem.getId() + " " + origem.getEndereco());
			System.out.println("Transacao convertida destino " + destino.getId() + " " + destino.getEndereco());
			System.out.println("Transacao convertida pontos " + transacao.getQtdPontos());
			
			origem.setSaldo(origem.getSaldo().subtract(transacao.getQtdPontos()));
			destino.setSaldo(destino.getSaldo().add(transacao.getQtdPontos()));
			
			System.out.println("Saldo origem "  + origem.getId() + " " + origem.getSaldo());
			System.out.println("Saldo destino " + destino.getId() + " " + destino.getSaldo());
			
			if(origem.getSaldo().compareTo(BigDecimal.ZERO) == -1){
				return "Erro";
			}
			
			String hash = processarBlockchain(origem.getEndereco(), destino.getEndereco(), transacao.getQtdPontos().toBigInteger());
			transacao.setHash(hash);
			
			transacao = transacaoRepo.save(transacao);
			origem = contaRepo.save(origem);
			destino = contaRepo.save(destino);
			
			System.out.println("Depois de salvar Saldo origem "  + origem.getId() + " " + origem.getSaldo());
			System.out.println("Depois de salvar Saldo destino " + destino.getId() + " " + destino.getSaldo());
			
			return transacao.getHash();
		}catch(Exception e){
			return "Erro";
		}
		
	}
	
	/**
	 * 
	 * @param endereco
	 * @param endereco2
	 * @param qtdPontos
	 */
	private String processarBlockchain(String accountOrigem, String accountDestino, BigInteger qtdPontos) {
		String retorno = null;
		try{
			if(ACCOUNT.equals(accountOrigem)){
//				File accountFile = new File(DIRECTORY+FILE_ACCOUNT) ;
//				Credentials credentials = WalletUtils.loadCredentials(PASSWD, accountFile);
//				QuorumTokenERC20 token = QuorumTokenERC20.load(contractAddress, quorum, credentials, GAS_PRICE, GAS_LIMIT);
//				TransactionReceipt transacao = token.transfer(accountDestino, qtdPontos).send();
//				retorno = transacao.getTransactionHash();
			}else if(ACCOUNT_PRO_NATURA.equals(accountOrigem)){
//				File accountFile = new File(DIRECTORY+FILE_ACCOUNT_PRO_NATURA) ;
//				Credentials credentials = WalletUtils.loadCredentials(PASSWD, accountFile);
//				QuorumTokenERC20 token = QuorumTokenERC20.load(contractAddress, quorum, credentials, GAS_PRICE, GAS_LIMIT);
//				TransactionReceipt transacao = token.transfer(accountDestino, qtdPontos).send();
//				retorno = transacao.getTransactionHash();
			}
		}catch(Exception e){
			e.printStackTrace();
			retorno = "Peding";
		}
		
		return retorno;
	}

	@CrossOrigin
	@RequestMapping(value = ContractRestURIConstants.TRANSFERE+"/json", method = RequestMethod.GET)
	public TransacaoDTO transferir(){
		Transacao transacao = new Transacao();
		transacao.setDataTransacao(new Date());
		transacao.setDestino(new Conta());
		transacao.getDestino().setId(1l);
		transacao.setOrigem(new Conta());
		transacao.getOrigem().setId(2l);
		transacao.setQtdPontos(new BigDecimal(10D));
		
		Conta origem = contaRepo.findById(transacao.getOrigem().getId());
		Conta destino = contaRepo.findById(transacao.getDestino().getId());
		
		transacao.setHash("0x41a22d895fe2ce5e14fad657b9258768559c9cbe98d93cd2bdaf628dd4f13259");
		transacao.setDestino(destino);
		transacao.setOrigem(origem);
		transacao.setUsuarioInclusao(usuarioRepo.findById(1L));
		
		origem.setSaldo(origem.getSaldo().subtract(transacao.getQtdPontos()));
		destino.setSaldo(destino.getSaldo().add(transacao.getQtdPontos()));
				
		return new TransacaoDTO(transacao);
	}
	
	@CrossOrigin
	@RequestMapping(value = ContractRestURIConstants.LISTAR_HISTORICO, method = RequestMethod.GET)
	public Historico listarHistorico(@PathVariable("id") String conta){
		Historico retorno = new Historico();
		retorno.setConta(conta);
		retorno.setTransacoes(new ArrayList<TransacaoDTO>());
		
		List<Transacao> transacoes = transacaoRepo.findAll();
		
		if(transacoes != null && transacoes.size() > 0){
			Collections.reverse(transacoes);

			for(Transacao t : transacoes){
				retorno.getTransacoes().add(new TransacaoDTO(t));
			}
		}
		
		return retorno;
		
	}
	
	@CrossOrigin
	@RequestMapping(value = ContractRestURIConstants.LISTAR_HISTORICO+"/json", method = RequestMethod.GET)
	public Historico listarHistoricoTeste(@PathVariable("id") String conta){
		Historico retorno = new Historico();
		retorno.setConta(conta);
		retorno.setTransacoes(new ArrayList<TransacaoDTO>());
		
		Transacao t = new Transacao();
		t.setHash("0xxxx");
		t.setDataTransacao(new Date());
		t.setDestino(new Conta());
		t.getDestino().setNome("Destino");
		
		t.setOrigem(new Conta());
		t.getOrigem().setNome("Origem");
		t.setQtdPontos(new BigDecimal(100D));
		
		retorno.getTransacoes().add(new TransacaoDTO(t));
		
		Transacao t1 = new Transacao();
		t1.setDataTransacao(new Date());
		t1.setHash("0yyyyy");
		t1.setDestino(new Conta());
		t1.getDestino().setNome("Destino");
		
		t1.setOrigem(new Conta());
		t1.getOrigem().setNome("Origem");
		t1.setQtdPontos(new BigDecimal(90D));
		
		retorno.getTransacoes().add(new TransacaoDTO(t1));
		
		Transacao t2 = new Transacao();
		t2.setDataTransacao(new Date());
		t2.setDestino(new Conta());
		t2.getDestino().setNome("Destino");
		t2.setHash("0zzzzz");
		t2.setOrigem(new Conta());
		t2.getOrigem().setNome("Origem");
		t2.setQtdPontos(new BigDecimal(10D));
		
		retorno.getTransacoes().add(new TransacaoDTO(t2));
		
		return retorno;
		
	}	

}
