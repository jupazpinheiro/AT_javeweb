package infnet.julia.fdj.medicare.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import infnet.julia.fdj.medicare.clients.IEnderecoCliente;
import infnet.julia.fdj.medicare.model.domain.Endereco;

@Service
public class EnderecoService {
	
	@Autowired
	private IEnderecoCliente enderecoCliente;

	public Endereco obterCep(String cep) {

		return enderecoCliente.obterCep(cep);
	}
}