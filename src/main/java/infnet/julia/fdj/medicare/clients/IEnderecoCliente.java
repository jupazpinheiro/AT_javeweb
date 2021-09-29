package infnet.julia.fdj.medicare.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import infnet.julia.fdj.medicare.model.domain.Endereco;

@FeignClient(url = "https://viacep.com.br/ws", name = "enderecoClient")
public interface IEnderecoCliente {

	@GetMapping(value = "/{cep}/json")
	public Endereco obterCep(@PathVariable String cep);
}