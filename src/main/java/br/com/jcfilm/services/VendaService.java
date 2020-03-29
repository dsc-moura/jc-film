package br.com.jcfilm.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;


import br.com.jcfilm.interfaces.IVendaQueryService;
import br.com.jcfilm.models.ItemVenda;
import br.com.jcfilm.models.Venda;

@Service
public class VendaService {

	public List<Venda> EncontrarDatasVencimento(List<Venda> vendas){		
		List<Venda> lista = new ArrayList<>();		
		
		for(int i = 0; i<  vendas.size(); i++) {
			Venda v = new Venda();
			
			v.setId(vendas.get(i).getId());
			v.setData(vendas.get(i).getData());
			v.setPrazo(vendas.get(i).getPrazo());
			v.setVencimento(ObterVencimento(vendas.get(i).getData(),vendas.get(i).getTempo(),vendas.get(i).getPrazo()));
			
			switch (vendas.get(i).getTempo()) {
			case 0:
				v.setDescPrazo("Dia(s)");					
				break;
			case 1:
				v.setDescPrazo("Semana(s)");					
				break;
			case 2:
				v.setDescPrazo("Mês(es)");										
				break;
			case 3:
				v.setDescPrazo("Ano(s)");					
				break;
			default:
				break;
			}		
			
			lista.add(v);		
		}
		return lista;
	}
	
	public List<Venda> ListaVendas(List<Venda> vendas, List<Venda> datas, List<ItemVenda> carrinho){		
		List<Venda> lista = new ArrayList<>();	
		
		for(int i = 0; i<  vendas.size(); i++) {
			Venda v = new Venda();			
			if(vendas.get(i).getId() == datas.get(i).getId()) {
				v.setId(vendas.get(i).getId());
				v.setVeiculo(vendas.get(i).getVeiculo());
				v.setCliente(vendas.get(i).getCliente());
				v.setUsuario(vendas.get(i).getUsuario());			
				v.setServico(vendas.get(i).isServico());
				v.setData(vendas.get(i).getData());
				v.setOrcamento(vendas.get(i).isOrcamento());
				v.setSituacao(vendas.get(i).isSituacao());
				v.setPrazo(vendas.get(i).getPrazo());
				v.setDescPrazo(datas.get(i).getDescPrazo());
				v.setVencimento(datas.get(i).getData());	
				v.setTotal(ObterValorTotalVenda(vendas.get(i).getId(),carrinho));
				lista.add(v);
			}		
		}
		return lista;
	}
	
	public Calendar ObterVencimento(Calendar data,int tempo ,int prazo) {		
		switch (tempo) {
		case 0:			
			 data.add(Calendar.DAY_OF_WEEK,prazo);
			break;
		case 1:			
			data.add(Calendar.WEEK_OF_MONTH,prazo);
			break;
		case 2:			
			data.add(Calendar.MONTH,prazo);
			break;
		case 3:			
			 data.add(Calendar.YEAR,prazo);
			break;
		default:
			break;
		}			
		return data;
	}	
	
	public double ObterValorTotalVenda(int id, List<ItemVenda> carrinho) {
		double total = 0, valor = 0;
		int quantidade = 0;
		
		for(ItemVenda item : carrinho) {
			if(item.getVenda().getId() == id) {
				valor = item.getValor();//item.getProduto().getPreco();
				quantidade = item.getQuantidade();
				valor = valor * quantidade;
				total += valor;
			}
		}
		return total;
	}
}
