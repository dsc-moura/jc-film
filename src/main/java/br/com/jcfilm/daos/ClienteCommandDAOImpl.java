package br.com.jcfilm.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import br.com.jcfilm.interfaces.IClienteCommandService;
import br.com.jcfilm.models.Cliente;
import br.com.jcfilm.models.ClienteVeiculo;

@Repository
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class ClienteCommandDAOImpl implements IClienteCommandService{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	@Transactional
	public void create(Cliente cliente) {
		// TODO Auto-generated method stub
		try {
			manager.persist(cliente);
		}finally{
			manager.close();
		}		
		
	}
	
	@Override
	@Transactional
	public void createVeiculoCliente(ClienteVeiculo veiculo) {
		// TODO Auto-generated method stub
		try {
			manager.persist(veiculo);
		}finally{
			manager.close();
		}			
	}

	@Override
	@Transactional
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub
		try {
			manager.createQuery("update Cliente "
					+ "set nome = :nome "
					+ ",sobrenome = :sobrenome"
					+ ",cpf = :cpf"
					+ ",cep = :cep"
					+ ",bairro = :bairro"
					+ ",endereco = :endereco"
					+ ",numero = :numero"
					+ ",complemento = :complemento"
					+ ",email = :email"
					+ ",telefone = :telefone"
					+ " where id = :id")
			.setParameter("nome", cliente.getNome())
			.setParameter("sobrenome", cliente.getSobrenome())
			.setParameter("cpf", cliente.getCpf())
			.setParameter("cep", cliente.getCep())
			.setParameter("bairro", cliente.getBairro())
			.setParameter("endereco", cliente.getEndereco())
			.setParameter("numero", cliente.getNumero())
			.setParameter("complemento", cliente.getComplemento())
			.setParameter("email", cliente.getEmail())
			.setParameter("telefone", cliente.getTelefone())
			.setParameter("id", cliente.getId())
			.executeUpdate();
		}finally {
			manager.close();
		}
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		try {
			manager.createQuery("delete Cliente "
					+ " where id = :id")
			.setParameter("id", id)
			.executeUpdate();
		}finally {
			manager.close();
		}		
	}

}
