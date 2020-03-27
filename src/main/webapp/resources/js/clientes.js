
function cancelarDelete(vlrLinha){
	$('#'+vlrLinha).find('#update,#visualizar,#delete').show();
	$('#'+vlrLinha).find('#confirmar,#cancelar').hide();
}

function excluir(id,vlrLinha){
	$('#'+vlrLinha).find('#update,#delete,#visualizar').hide();
	$('#'+vlrLinha).find('#confirmar,#cancelar').show();
}

$('.nav-tabs a').click(function(){		
	$('#cadastro-update').hide();
	$('#cadastro-clientes').show();
	$(this).tab('show');	  	
})

function cancelar(tab){
	$('#'+tab).tab('show');	   
}


function EditarVisualizar(id,tab,view){
	$.ajax({
	    type:  'PUT',
	    url:   'buscar-cliente/'+id,	   
	    success: function(data){		    	
	    	$('#cadastro-update').show();
	    	$('#cadastro-clientes').hide();	    	
	    	$('#'+tab).tab('show');	    
	    	
	    	$.each(data, function(i) {
    			$('#edit_id').val(data[i].id).prop("disabled",view);
    			$('#edit_nome').val(data[i].nome).prop("disabled",view);
    			$('#edit_sobrenome').val(data[i].sobrenome).prop("disabled",view);
    			$('#edit_cpf').val(data[i].cpf).prop("disabled",view);    			
    			$('#edit_bairro').val(data[i].bairro).prop("disabled",view);    			
    			$('#edit_cep').val(data[i].cep).prop("disabled",view);
    			//$('#edit_veiculo').val( $('option:contains('+data[i].veiculo.nome+')').val()).prop("disabled",view);
    			$('#edit_endereco').val(data[i].endereco).prop("disabled",view);
    			$('#edit_numero').val(data[i].numero).prop("disabled",view);
    			$('#edit_complemento').val(data[i].complemento).prop("disabled",view);
    			$('#edit_email').val(data[i].email).prop("disabled",view);
    			$('#edit_telefone').val(data[i].telefone).prop("disabled",view);    		
    			$('#update-cliente-salvar').prop( "disabled",view);    			
	    	});
	     }
	});
}

function confirmar(id,vlrLinha){
	var tr = $('#'+vlrLinha).closest('tr');	
	$.ajax({
	    type:  'PUT',
	    url:   'excluir-cliente/'+id,
	    statusCode:{
	    	200:function(){
	    		tr.fadeOut(400, function(){tr.remove();});
	    		
	    		setTimeout(function() {
			        $.bootstrapGrowl('<i class="fas fa-check"></i> Cliente excluído com sucesso!', { type: 'success', width: 350, align: 'right', stackup_spacing: 30});
			    }, 300);
	    	},error:function(){
	    		setTimeout(function() {	  		  	  		  		  
		  			$.bootstrapGrowl('<i class="fas fa-times"></i> Não foi possível excluír o cliente!', { type: 'danger', width: 450, align: 'right', stackup_spacing: 30});
	    		}, 300);
	    	}			
	    }
	});
}

