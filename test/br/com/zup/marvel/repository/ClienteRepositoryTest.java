package br.com.zup.marvel.repository;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.zup.marvel.entity.Cliente;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteRepositoryTest {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Test
	public void createDevePercistirOsDados() {
		
		Cliente cliente = new Cliente();
		cliente.setNome("douglas");
		cliente.setCpf("123");
		cliente.setIdade(26);
		cliente.setEmail("douglas@zup.com");
		cliente.setTelefone("987654321");
		cliente.setEndereco("rua: francisco belato");
		this.clienteRepository.save(cliente);
		
		Assertions.assertThat(cliente.getNome()).isEqualTo("douglas");
		Assertions.assertThat(cliente.getEmail()).isEqualTo("douglas@zup.com");
		Assertions.assertThat(cliente.getCpf()).isEqualTo("123");
		Assertions.assertThat(cliente.getEmail()).isEqualTo("douglas@zup.com");
		Assertions.assertThat(cliente.getTelefone()).isEqualTo("987654321");
		Assertions.assertThat(cliente.getEndereco()).isEqualTo("rua: francisco belato");
		
	}
	
	@Test
	public void deleteDeveRemorerDado() {
		
		Cliente cliente = new Cliente();
		cliente.setNome("douglas");
		cliente.setCpf("123");
		cliente.setIdade(26);
		cliente.setEmail("douglas@zup.com");
		cliente.setTelefone("987654321");
		cliente.setEndereco("rua: francisco belato");
		
		this.clienteRepository.save(cliente);
		this.clienteRepository.deleteById(cliente.getCpf());
		
		Assertions.assertThat(clienteRepository.findById(cliente.getCpf())).isEmpty();
	}
	
	@Test
	public void updateDeveMudarEPercistirOsDados() {
		
		Cliente cliente = new Cliente();
		cliente.setNome("douglas");
		cliente.setCpf("123");
		cliente.setIdade(26);
		cliente.setEmail("douglas@zup.com");
		cliente.setTelefone("987654321");
		cliente.setEndereco("rua: francisco belato");
		
		this.clienteRepository.save(cliente);
		cliente.setNome("Douglas Moreira");
		this.clienteRepository.save(cliente);
		cliente = this.clienteRepository.findById(cliente.getCpf()).get();
		
		Assertions.assertThat(cliente.getNome()).isEqualTo("Douglas Moreira");
		Assertions.assertThat(cliente.getEmail()).isEqualTo("douglas@zup.com");
		Assertions.assertThat(cliente.getCpf()).isEqualTo("123");
		Assertions.assertThat(cliente.getEmail()).isEqualTo("douglas@zup.com");
		Assertions.assertThat(cliente.getTelefone()).isEqualTo("987654321");
		Assertions.assertThat(cliente.getEndereco()).isEqualTo("rua: francisco belato");
		
	}
}
