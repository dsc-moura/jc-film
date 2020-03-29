var tempo;
var intervaloDeTempo = 1000;

$('#nome-produto-servico').keyup(function() {
	  clearTimeout(tempo);
	  if ($('#nome-produto-servico')) {
		  tempo = setTimeout(FiltraListaProdutoServico, intervaloDeTempo);
	  }
});

$('#busca-placa-veiculo').keyup(function() {
	  clearTimeout(tempo);
	  if ($('#busca-placa-veiculo')) {
		  tempo = setTimeout(FiltraListaGarantias, intervaloDeTempo);
	  }
});

function PrintGarantiaCliente(){	 
    //send the div to PDF
    html2canvas($("#garantia-servico-cliente"), { // DIV ID HERE
        onrendered: function(canvas) {
            var imgData = canvas.toDataURL('image/png'); 
            var doc = new jsPDF('portrait');
            doc.addImage(imgData, 'PDF', 6.7, 2); // defini o posicionameto da div na tela de impressão
            doc.setProperties({
                title: "Garantia Cliente"
            });
                     
            //doc.output('dataurlnewwindow');
            doc.save("Garantia-Serviço.pdf");
        }
    });
}

//FUNÇÃO SERVE PARA REALIZAR UMA BUSCA DENTRO DA PROPRIA TABELA USANDO O NOME DO PRODUTO.
function FiltraListaProdutoServico() {
	var nmProduto= retira_acentos($('#nome-produto-servico').val());
	var produtos = $('.produtos-servicos');
	
	for(var i = 0; produtos.length > i; i++){		
		if(nmProduto != ""){	
			var nmProdutoTabela = retira_acentos($('#'+produtos[i].id).find('#nm-produto-servico').text().toUpperCase());
			if(nmProdutoTabela.match(nmProduto.toUpperCase())){
				$('#'+produtos[i].id).show();
			}else{
				$('#'+produtos[i].id).hide();
			}
		}else{
			$('#'+produtos[i].id).show();
		}
	}
}

function FiltraListaGarantias() {
	var nmProduto= retira_acentos($('#busca-placa-veiculo').val());
	var produtos = $('.lista-garantias');
	
	for(var i = 0; produtos.length > i; i++){		
		if(nmProduto != ""){	
			var nmProdutoTabela = retira_acentos($('#'+produtos[i].id).find('#nm-placa-veiculo').text().toUpperCase());
			if(nmProdutoTabela.match(nmProduto.toUpperCase())){
				$('#'+produtos[i].id).show();
			}else{
				$('#'+produtos[i].id).hide();
			}
		}else{
			$('#'+produtos[i].id).show();
		}
	}
}


//FUNÇÃO RETIRA CARACTER ESPECIAL DO NOME QUE FOI DIGITADO NA CONSULTA E DO NOME NA TABELA
function retira_acentos(nome) {
	com_acento = "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝŔÞßàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿŕ";
	sem_acento = "AAAAAAACEEEEIIIIDNOOOOOOUUUUYRsBaaaaaaaceeeeiiiionoooooouuuuybyr";
	novoNome="";
	for(i=0; i<nome.length; i++) {
		troca=false;
		for (a=0; a<com_acento.length; a++) {
			if (nome.substr(i,1)==com_acento.substr(a,1)) {
				novoNome+=sem_acento.substr(a,1);
				troca=true;
				break;
			}
		}
		if (troca==false) {
			novoNome+=nome.substr(i,1);
		}
	}
	return novoNome;
}


function buscar(){
	var cpf = $('#vcpf').val();	
	if(cpf != null){
		pesquisar(cpf);
	}
}

function FinalizarVendaServico(){
	var listaVendas = $('.produtos-servicos-carrinho');
	var venda = PreencherObjetoVendaFinalizada();
	
	if(venda.id == "" || listaVendas.length <= 0){
		setTimeout(function() {	  		  	  		  		  
  			$.bootstrapGrowl('<i class="fas fa-times"></i> Não existe nenhum produto ou serviço selecionado!', { type: 'danger', width: 450, align: 'right', stackup_spacing: 30});
		}, 300);
	}else{		
	 	$.ajax({
		    type:  'POST',
		    contentType: "application/json",
		    url:   'finalizar-venda',	 
		    data: JSON.stringify(venda),
		    dataType: 'json',
		    statusCode:{
		    	200:function(){	   	    		
		    		setTimeout(function() {
				        $.bootstrapGrowl('<i class="fas fa-check"></i> Venda finalizada com sucesso!', { type: 'success', width: 350, align: 'right', stackup_spacing: 30});
				    }, 300);
		    		
		    		if(venda.situacao){
		    			//$('#imprimir-garantia-cliente').show();
		    			
		    			//$('#finalizar-venda-btn,#btn-cancelcar-venda').hide();
		    			AtualizarPagina();
		    		}
		    		
		    		$('#finalizar-venda').modal('hide');
		    		
		    	},error:function(){
		    		setTimeout(function() {	  		  	  		  		  
			  			$.bootstrapGrowl('<i class="fas fa-times"></i> Erro ao finalizar a venda!', { type: 'danger', width: 450, align: 'right', stackup_spacing: 30});
		    		}, 300);
		    	}			
		    }
		});	
	}
}


function PreencherObjetoVendaFinalizada(){
	var Venda = new Object();	
	Venda = {
			situacao :  $("#pago option:selected").val(),
			prazo : $('#prazo').val(),
			tempo : $("#tempo option:selected").val(),
			id: $('#id-codigo-venda').val(),
	}	
	return Venda
}

var registroEdit = null;
function update(id,vlrLinha){
	if(registroEdit == null || registroEdit == vlrLinha){
		registroEdit = vlrLinha;
	}else if($('#'+registroEdit).find($('#salvar-quantidade').is(':visible'))){
		cancelar(registroEdit);
		registroEdit = vlrLinha;
	}
	var qtdproduto = $('#'+vlrLinha).find('#qtde-produto-servico').text().trim();	
	$('#'+vlrLinha).find('span,#update,#delete').hide();	
	$('#'+vlrLinha).find('#cancelar,#salvar-quantidade,#qtd-venda-produto,#aumentar,#diminuir').show();
	$('#'+vlrLinha).find('#qtd-venda-produto').val(qtdproduto);
}

function cancelar(vlrLinha){
	$('#'+vlrLinha).find('#delete,#update,span').show();
	$('#'+vlrLinha).find('#confirmar,#cancelar,#salvar-quantidade,#aumentar,#diminuir,#qtd-venda-produto').hide();
}

function excluir(id,vlrLinha){
	$('#'+vlrLinha).find('#delete,#update').hide();
	$('#'+vlrLinha).find('#confirmar,#cancelar').show();
}

function aumentar(vlrLinha){
	var quantidade = $('#'+vlrLinha).find('#qtd-venda-produto').val();
	quantidade++;
	 $('#'+vlrLinha).find('#qtd-venda-produto').val(quantidade);	
}

function diminuir(vlrLinha){
	var quantidade =  $('#'+vlrLinha).find('#qtd-venda-produto').val();
	if(quantidade > 1){
		quantidade--;
	}	
	 $('#'+vlrLinha).find('#qtd-venda-produto').val(quantidade);	
}


function SalvarAlteracaoQuantidade(id,vlrLinha){	
	var qtdProduto = $('#'+vlrLinha).find('#qtd-venda-produto').val().trim();
	
	$.ajax({
		type: 'PUT',
	    url:   'update-quantidade-produto/'+id+"/"+qtdProduto,
	    statusCode:{
	    	200:function(){	   	    		
	    		$('#'+vlrLinha).find('#qtd-produto-'+id).html(qtdProduto);	
	    		cancelar(vlrLinha);
	    		pegarValorTotal();
	    		
	    	},error:function(){
	    		setTimeout(function() {	  		  	  		  		  
		  			$.bootstrapGrowl('<i class="fas fa-times"></i>  Não foi possível alterar a quantidade!', { type: 'danger', width: 450, align: 'right', stackup_spacing: 30});
	    		}, 300);
	    	}			
	    }	  	
	});	
}

function ExcluirItemCarrinho(id,tr){	
	$.ajax({
	    type:  'PUT',
	    url:   'excluir-item-carrinho-compra/'+id,
	    statusCode:{
	    	200:function(){	   	    		
	    		tr.fadeOut(300, function(){tr.remove();});
	    		
	    	},error:function(){
	    		setTimeout(function() {	  		  	  		  		  
		  			$.bootstrapGrowl('<i class="fas fa-times"></i>  Não foi possível excluir o item!', { type: 'danger', width: 450, align: 'right', stackup_spacing: 30});
	    		}, 300);
	    	}			
	    }
	});
}

function ImprimirGarantia(id){	
	$.ajax({
	    type:  'PUT',
	    url:   'imprimir-relario/venda',
	    statusCode:{
	    	200:function(){	   	    		
	    		tr.fadeOut(300, function(){tr.remove();});
	    		
	    	},error:function(){
	    		setTimeout(function() {	  		  	  		  		  
		  			$.bootstrapGrowl('<i class="fas fa-times"></i>  Não foi possível excluir o item!', { type: 'danger', width: 450, align: 'right', stackup_spacing: 30});
	    		}, 300);
	    	}			
	    }
	});
}

function confirmar(id,vlrLinha){
	var tr = $('#'+vlrLinha).closest('tr');	
	ExcluirItemCarrinho(id,tr);
	setTimeout(function() {	  		  	  		  		  
		pegarValorTotal();
	}, 400);
	
}

function selecionar(e){
	var id = $("#vveiculo option:selected").val();
	if($.isNumeric(id)){
		$.ajax({
		    type:  'PUT',
		    url:   'buscar-detalhes-veiculo-cliente/'+id,	   
		    success: function(data){	    	
		    	$.each(data, function(i) {
		    		$('#vmarca').val(data[i].veiculo.marca.nome);
		    		$('#vplaca').val(data[i].placa);
		    		$('#vano').val(data[i].ano);
		    	});
		     } 
		}); 
	}
}

function ListaCarrinhoCompras(modo,id){
	$.ajax({
	    type:  'GET',
	    url:   'buscar-produtos-servicos-cliente-compras',
	    data: {
	    	modo: modo,
	    	id: id,
	    },
	    dataType: 'html',	    
	    success: function(data){
	    	$('#tabela-carrinho-compras').html(data);
	    	PegarIdVendaAberta();
	    	pegarValorTotal();	 
	    
	    	setTimeout(function() {	  		  	  		  		  
	    		PegarDados();
    		}, 50);
	     }		    
	}); 
}

function VisualizarServico(id){
	$.ajax({
	    type:  'GET',
	    url:   'buscar-produtos-servicos-cliente-compras',
	    data: {
	    	modo: 'garantia',
	    	id: id,
	    },
	    dataType: 'html',	    
	    success: function(data){
	    	$('#itens-garantia-cliente').html(data);
	    	$('#tabela-itens-para-garantia').html(data);    
	     }		    
	}); 
}

function BuscaDadosParaGarantia(id,vlrLinha){
	
	var garantia = $('.lista-garantias');
	
	$.each(garantia,function(i){
		if(parseInt($('#'+garantia[i].id).find('#codigo-id-venda').text()) == id){
			
			$('#g-os-id-servico').val(id);
			$('#g-data-servico').val($('#'+garantia[i].id).find('#dt-venda-'+id).text());
			$('#g-data-garantia-servico').val($('#'+garantia[i].id).find('#dt-venc-garantia-'+id).text());
			$('#g-nm-resp-servico').val($('#'+garantia[i].id).find('#nm-responsavel-'+id).text());
			$('#g-total-servico').val($('#'+garantia[i].id).find('#vlr-total-'+id).text());			
		}		
	});
	
	VisualizarServico(id);
	
	if($.isNumeric(id)){
		$.ajax({
		    type:  'PUT',
		    url:   'buscar-dados-vendas/'+id,	   
		    success: function(data){	    	
		    	$.each(data, function(i) {	    	
		    		console.log(data);
		    		$('#g-nm-cliente').val(data[i].cliente.nome + " " + data[i].cliente.sobrenome);
		    		$('#g-cpf-cliente').val(data[i].cliente.cpf);
		    		$('#g-telefone-cliente').val(data[i].cliente.telefone);
		    		$('#g-email-cliente').val(data[i].cliente.email);
		    		$('#g-marca-veiculo-cliente').val(data[i].veiculo.veiculo.marca.nome);
		    		$('#g-nome-veiculo-cliente').val(data[i].veiculo.veiculo.nome);
		    		$('#g-veiculo-placa-cliente').val(data[i].veiculo.placa);
		    		$('#g-ano-veiculo-cliente').val(data[i].veiculo.ano);
		    		
		    	});
		     } 
		});
	}
	
}

function PegarDados(){
	var id = $('#id-codigo-venda').val();
	if($.isNumeric(id)){
		$.ajax({
		    type:  'PUT',
		    url:   'buscar-dados-vendas/'+id,	   
		    success: function(data){	    	
		    	$.each(data, function(i) {	    	
		    		
		    		  $('#vveiculo').val($('option:contains('+data[i].veiculo.veiculo.nome+')').val());
		    		  $('#funcionario').val($('option:contains('+data[i].usuario.nome +" "+ data[i].usuario.sobrenome+')').val());
		    		
		    		  $("#vveiculo").change();
	
		    	});
		     } 
		});
	}
}

function PegarIdVendaAberta(){
	var vendas = $('.produtos-servicos-carrinho');
	$(vendas).each(function(i){
		$('#id-codigo-venda').val($('#'+vendas[i].id).find('#codigo-id-venda').text().trim());
	});
}

function AdicionarProdutoNoCarrinho(id){
	var lista = ListaCarrinhoProdutosServicos();
	var carrinho = ListaProdutosCarrinho(lista,id)
	
 	$.ajax({
	    type:  'POST',
	    contentType: "application/json",
	    url:   'iniciar-processo-venda-inserir-produto-servico',	 
	    data: JSON.stringify(carrinho),
	    dataType: 'json',
	    statusCode:{
	    	200:function(){	   	    		
	    		ListaCarrinhoCompras('compra',id);	    		
	    		$('#produtos-servicos').modal('hide');
	    		
	    	},error:function(){
	    		setTimeout(function() {	  		  	  		  		  
		  			$.bootstrapGrowl('<i class="fas fa-times"></i> Carrinho Vazio!', { type: 'danger', width: 450, align: 'right', stackup_spacing: 30});
	    		}, 300);
	    	}			
	    }
	});	
}


function salvar(){
	var cod_compra = $('#id-codigo-venda').val();
	
	if(cod_compra == ""){
		var venda = PreencherParametrosIniciarVenda();	
		
		if(venda.usuario.id == "" || venda.veiculo.id == ""){
			 $.bootstrapGrowl('<i class="fas fa-user-times"></i> Informe o reponsável e o veículo!', { type: 'danger', width: 380, align: 'right', stackup_spacing: 30 });
		}else{
			$.ajax({
			    type:  'POST',
			    contentType: "application/json",
			    url:   'iniciar-processo-venda',	 
			    data: JSON.stringify(venda),
			    dataType: 'json',
			    success: function(id_compra){	    	    	
			    	AdicionarProdutoNoCarrinho(id_compra); 
			    	$('#id-codigo-venda').val(id_compra);
			    }
			});	
		}
	}else{
		LimparCarrinhoCompra(cod_compra);
		AdicionarProdutoNoCarrinho(cod_compra); 
	}
	
}

function LimparCarrinhoCompra(id){
	$.ajax({
	    type:  'PUT',
	    url:   'limpar-itens-carrinho-compra/'+id,
	    statusCode:{
	    	200:function(){	   	    		
	    		console.log("Itens anteriores excluídos do carrinho!");	    		
	    	},error:function(){
	    		setTimeout(function() {	  		  	  		  		  
		  			$.bootstrapGrowl('<i class="fas fa-times"></i>  Não foi possível excluir o item!', { type: 'danger', width: 450, align: 'right', stackup_spacing: 30});
	    		}, 300);
	    	}			
	    }
	}); 
}

function PreencherParametrosIniciarVenda(){
	var Venda = new Object();
	var cliente = new Object();
	var ClienteVeiculo = new Object();
	var usuario = new Object();
	Venda = {
			orcamento: false,
			servico: true,
			situacao: false,
			cliente : cliente = { id: $('#vid-cliente').val() },
			usuario : usuario = { id: $('#funcionario option:selected').val() },
			veiculo : ClienteVeiculo = {id :$('#vveiculo option:selected').val()},
	}	
	return Venda;
}

function ListaProdutosCarrinho(lista,id){
	var carrinho = [];
	var ItemVenda = new Object();	
	var Venda = new Object();	
	var Produto = new Object();	
	$(lista).each(function(i){
		if(lista[i].selecao == "true"){
			ItemVenda = {
					produto : Produto = {id : parseInt(lista[i].id),} ,
					venda : Venda = {id: id,},
					quantidade : 1,
					valor : parseFloat(lista[i].valor),
			};
			carrinho.push(ItemVenda);	
		}
	});
	return carrinho;
}

function ListaCarrinhoProdutosServicos(){
	var lista = [];
	var Produto = new Object();	
	var produtos = $('.produtos-servicos');		
	$(produtos).each(function(i){
		Produto = {
			id: $('#'+produtos[i].id).find('#id').text().trim(),
			selecao: $('#'+produtos[i].id).find('#btn-selecao-produtos-servicos').val(),
			valor: $('#'+produtos[i].id).find('#valor').text(),
		};
		lista.push(Produto);		
	});
	return lista;
}


function SelecionarProdutoServico(e) {
	var valor = $(e).val();
	if(valor == "false"){
		$(e).attr('class', 'btn btn-success');
		$(e).val("true");
	}if(valor == "true"){
		$(e).attr('class', 'btn btn-secondary');
		$(e).val("false");
	}
}


function pesquisar(cpf){
	$.ajax({
	    type:  'PUT',
	    url:   'buscar-cliente-cpf/'+cpf,
	    success: function(data){
	    	if(data.length < 1){
	    	     $.bootstrapGrowl('<i class="fas fa-user-times"></i> Cliente não encontrado, faça o cadastro!', { type: 'danger', width: 380, align: 'right', stackup_spacing: 30 });
	    	}else{
	    		$.each(data, function(i) {
		    		$('#vid-cliente').val(data[i].id);
		    		$('#vcpf').val(data[i].cpf);
		    		$('#vnome').val(data[i].nome);
		    		$('#vsobrenome').val(data[i].sobrenome);
		    		
		    		VeiculosCliente(data[i].id);
		    		ListaCarrinhoCompras('cliente',data[i].id);		    		
		    	});	    		
	    	}		    	
	     }
	});
}

function VeiculosCliente(id){
	$.ajax({
	    type:  'GET',
	    url:   'buscar-veiculos-cliente',
	    data: {
	    	id: id
	    },
	    dataType: 'html',	    
	    success: function(data){
	    	$('#formulario-veiculos-cliente').html(data);
	     }		    
	}); 	
}

function CadastrarCliente(){
	var cliente = preencherObjetoCliente();
	
	if(cliente.cpf == "" || cliente.nome == "" || cliente.sobrenome == "" || cliente.email == "" || cliente.telefone == ""){
		  $.bootstrapGrowl('<i class="fas fa-user-times"></i> É necessário preencher todos os campos!', { type: 'danger', width: 380, align: 'right', stackup_spacing: 30});
	}else{
		$.ajax({
		    type:  'POST',
		    contentType: "application/json",
		    url:   'cadastrar-novo-cliente',	 
		    data: JSON.stringify(cliente),
		    dataType: 'json',
		    statusCode:{
		    	200:function(){	    		
		    		setTimeout(function() {
				        $.bootstrapGrowl('<i class="fas fa-check"></i> Cliente cadastrado com sucesso!', { type: 'success', width: 350, align: 'right', stackup_spacing: 30});
				    }, 300);
		    		
		    		pesquisar(cliente.cpf);
		    		
		    		$('#cliente').modal('hide');
		    		
		    	},error:function(){
		    		setTimeout(function() {	  		  	  		  		  
			  			$.bootstrapGrowl('<i class="fas fa-times"></i> Cadastro não efetuado!', { type: 'danger', width: 450, align: 'right', stackup_spacing: 30});
		    		}, 300);
		    	}			
		    }
		});		
	}	
}


function CadastrarVeiculoCliente() {
	var veiculo = preencherObjetoVeiculoCliente();
	if(veiculo.cliente.id == ""){
		setTimeout(function() {	  		  	  		  		  
  			$.bootstrapGrowl('<i class="fas fa-times"></i> Selecione o cliente!', { type: 'danger', width: 450, align: 'right', stackup_spacing: 30});
		}, 300);
	}else{
		if(veiculo.ano == "" || veiculo.placa == "" || veiculo.veiculo.id == ""){
			 $.bootstrapGrowl('<i class="fas fa-car"></i> É necessário preencher todos os campos!', { type: 'danger', width: 380, align: 'right', stackup_spacing: 30 });
		}else{
			$.ajax({
			    type:  'POST',
			    contentType: "application/json",
			    url:   'cadastrar-veiculo-cliente',	 
			    data: JSON.stringify(veiculo),
			    dataType: 'json',
			    statusCode:{
			    	200:function(){		    		
			    		setTimeout(function() {
					        $.bootstrapGrowl('<i class="fas fa-check"></i> Veículo cadastrado com sucesso!', { type: 'success', width: 350, align: 'right', stackup_spacing: 30});
					    }, 300);
			    		
			    		VeiculosCliente(veiculo.cliente.id);			    		
			    		$('#veiculo-add').modal('hide');
			    		
			    	},error:function(){
			    		setTimeout(function() {	  		  	  		  		  
				  			$.bootstrapGrowl('<i class="fas fa-times"></i> Cadastro não efetuado!', { type: 'danger', width: 450, align: 'right', stackup_spacing: 30});
			    		}, 300);
			    	}			
			    }
			});
		}
	}	
}

function pegarValorTotal(){
	valorTotal = 0;
	var produtos = $('.produtos-servicos-carrinho');
	if(produtos.length > 0){
		$('#finalizar-servico-botoes').show();
	}else{
		$('#finalizar-servico-botoes').hide();
	}
	$.each(produtos, function(i){
		var valor = parseFloat($('#'+produtos[i].id).find('#valor-item').val());
		var quantidade = parseInt($('#'+produtos[i].id).find('#qtde-produto-servico').text().trim());		
		valor = valor * quantidade;
		valorTotal += valor;			
	});	
	$('#total').val(formatter.format(valorTotal));
}

function CancelarVenda(){
	var id = $('#id-codigo-venda').val();
	if($.isNumeric(id)){
		$.ajax({
		    type:  'PUT',
		    url:   'cancelar-venda/'+id,
		    statusCode:{
		    	200:function(){	   	
		    
		    		AtualizarPagina();
		    		
		    		setTimeout(function() {
				        $.bootstrapGrowl('<i class="fas fa-check"></i> Venda cancelada com sucesso!', { type: 'success', width: 350, align: 'right', stackup_spacing: 30});
				    }, 300);
		    		
		    	},error:function(){
		    		setTimeout(function() {	  		  	  		  		  
			  			$.bootstrapGrowl('<i class="fas fa-times"></i>  Erro ao cancelar a venda!', { type: 'danger', width: 450, align: 'right', stackup_spacing: 30});
		    		}, 300);
		    	}			
		    }
		}); 
	}
}

function AtualizarPagina(){
	location.reload();
}

var formatter = new Intl.NumberFormat('pt-BR', {
  style: 'currency',
  currency: 'BRL',
  minimumFractionDigits: 2,
});

function preencherObjetoVeiculoCliente(){	
	var cliente = new Object();
	var modelo = new Object();	
	var veiculo = new Object();
	
	veiculo = {
		ano:  $('#ano').val(),	
		placa:  $('#placa').val(),	
		cliente: cliente = { id:$('#vid-cliente').val() },
		veiculo: modelo = { id: $('#veiculo').val() },	
	}
	return veiculo;
}

function preencherObjetoCliente(){
	var cliente = new Object();	
	cliente = {
		nome: $('#nome').val(),
		cpf : $('#cpf').val(),
		sobrenome : $('#sobrenome').val(),
		email : $('#email').val(),
		telefone : $('#telefone').val(),
	}		
	return cliente;
}


