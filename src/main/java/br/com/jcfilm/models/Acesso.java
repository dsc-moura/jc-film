package br.com.jcfilm.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="jcf_tbl_cad_acessos")
public class Acesso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	@ManyToOne
	@JoinColumn(name="id_usuario",nullable=false)
	private Usuario usuario;
	@Column(nullable = true)
	private String senha;
	private boolean acesso;
	
	public Acesso() {}
	
	public Acesso(int id, Usuario usuario, String senha, boolean acesso) {
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.acesso = acesso;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isAcesso() {
		return acesso;
	}
	public void setAcesso(boolean acesso) {
		this.acesso = acesso;
	}
	
	@Override
	public String toString() {
		return "Acesso [id=" + id + ", usuario=" + usuario + ", senha=" + senha + ", acesso=" + acesso + "]";
	}
	
}
