package br.com.jcfilm.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.jcfilm.models.Acesso;
import br.com.jcfilm.models.Usuario;

public class FuncionarioService {
	
	public Acesso EncryptPassword(Acesso acesso) {
		BCryptPasswordEncoder encoderPassword = new BCryptPasswordEncoder();
		 Acesso acess = new Acesso();
		 
		 acess.setSenha(encoderPassword.encode(acesso.getSenha()));
		 acess.setUsuario(acesso.getUsuario());
		 acess.setAcesso(true);
		 return acess;
	}
	
	public Acesso CadastrarFuncionario(Usuario usuario) {
		Acesso acess = new Acesso();	 
		
		 acess.setUsuario(usuario);
		 acess.setAcesso(false);
		 return acess;
	}

}
