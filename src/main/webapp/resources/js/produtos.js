$('#preco').maskMoney({
	  allowNegative: true,
	  decimal: '.',
	  thousands: '.'
});	

$('#edit_preco').maskMoney({
	  allowNegative: true,
	  decimal: '.',
	  thousands: '.'
});	

function cadastro(){
	$('#update-produto').hide();
	$('#cadastro-produto').show();
}

function update(id,nome,preco){
	$('#edit_id').val(id);
	$('#edit_nome').val(nome);
	$('#edit_preco').val(preco);
	
	$('#update-produto').show();
	$('#cadastro-produto').hide();
}

function cancelar(vlrLinha){
	$('#'+vlrLinha).find('#update,#delete,span').show();
	$('#'+vlrLinha).find('#confirma,#save,#cancelar,.form-control').hide();
}

function excluir(id,vlrLinha){
	$('#'+vlrLinha).find('#update,#delete').hide();
	$('#'+vlrLinha).find('#confirma,#cancelar').show();
}

var tempo;
var intervaloDeTempo = 1000;
var registroEdit = null;

$('#buscarProduto').keyup(function() {
	  clearTimeout(tempo);
	  if ($('#buscarProduto')) {
		  tempo = setTimeout(buscarProdutoNaLista, intervaloDeTempo);
	  }
});

//FUNÇÃO SERVE PARA REALIZAR UMA BUSCA DENTRO DA PROPRIA TABELA USANDO O NOME DO PRODUTO.
function buscarProdutoNaLista() {
	var nmProduto= retira_acentos($('#buscarProduto').val());
	var produtos = $('.produto');
	
	for(var i = 0; produtos.length > i; i++){		
		if(nmProduto != ""){	
			var nmProdutoTabela = retira_acentos($('#'+produtos[i].id).find('#nmProduto').text().toUpperCase());
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

function confirmar(id,vlrLinha){	
	var tr = $('#'+vlrLinha).closest('tr');	
	
	$.ajax({
	    type:  'PUT',
	    url:   'excluir-produto/'+ id,	   
	    statusCode:{
	    	200:function(){
	    		setTimeout(function() {
	    			tr.fadeOut(400, function(){tr.remove();});
			        $.bootstrapGrowl('<i class="fas fa-check"></i> Produto excluído com sucesso!', {
			            type: 'success',
			            width: 350,
			            align: 'right',
			            stackup_spacing: 30
			        });
			    }, 300);
	    	}
	    }
	}); 
}
