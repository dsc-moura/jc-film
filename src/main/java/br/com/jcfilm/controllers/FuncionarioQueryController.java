package br.com.jcfilm.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.jcfilm.interfaces.IUsuarioQueryService;
import br.com.jcfilm.models.Acesso;
import br.com.jcfilm.models.Usuario;
import br.com.jcfilm.models.Venda;

@Controller
public class FuncionarioQueryController {

	@Autowired
	IUsuarioQueryService IUsuario;
	
	@RequestMapping("/TelaCadastroFuncionario")
	public ModelAndView TelaCadastroFuncionario(Usuario Usuario, Acesso acesso) {
		ModelAndView model = new ModelAndView("/tela-cadastro-funcionarios");
		model.addObject("funcionarios", IUsuario.ListaUsuarios());
		model.addObject("acessos", IUsuario.ListaAcessos());
		return model;
	}
	
	@RequestMapping("/atualiza-tabela-funcionarios")
	public String listaAtualizada(HttpServletRequest request) {
		request.setAttribute("acessos", IUsuario.ListaAcessos());
		return "/tabela-lista-funcionarios";		 
	}
		
}
