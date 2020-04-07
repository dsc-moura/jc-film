/**
 * 
 */

function acesso(id, nome){
	$('#id_usuario').val(id);
	$('#nm_funcionario').val(nome);
	
}


function cancelar(vlrLinha){
	$('#'+vlrLinha).find('#update,#desativar,#atribuir_retirar').show();
	$('#'+vlrLinha).find('#confirma,#save,#altera-permissao,#cancelar').hide();
}

function desativar(id,vlrLinha){
	$('#'+vlrLinha).find('#update,#desativar,#atribuir_retirar').hide();
	$('#'+vlrLinha).find('#confirma,#cancelar').show();
}

function permissao(vlrLinha){
	$('#'+vlrLinha).find('#update,#desativar,#atribuir_retirar').hide();
	$('#'+vlrLinha).find('#altera-permissao,#cancelar').show();
}


function update(id, nome, sobrenome,email,ativo){
	$('#edit_id').val(id);
	$('#edit_nome').val(nome);
	$('#edit_sobrenome').val(sobrenome);
	$('#edit_email').val(email);
	$('#edit_ativo').val(ativo);
	
}


function confirmar(id,vlrLinha,status){	
	$.ajax({
	    type:  'PUT',
	    url:   'altera-status-funcionario/'+ id +'/'+status,	   
	    statusCode:{
	    	200:function(){
	    		
	    		$.ajax({
	    		    type:  'GET',
	    		    url:   'atualiza-tabela-funcionarios',	    		   
	    		    success: function(data){		    	
	    		    	$('#tabela-funcionarios').html(data);
	    		     }
	    		});
	    		
	    		setTimeout(function() {		    			
			        $.bootstrapGrowl('<i class="fas fa-check"></i> Status do Funcionário alterado!', {
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

function ConfirmaAlteracao(id,vlrLinha,status){	
	$.ajax({
	    type:  'PUT',
	    url:   'altera-permissao-funcionario/'+ id +'/'+status,	   
	    statusCode:{
	    	200:function(){
	    		
	    		$.ajax({
	    		    type:  'GET',
	    		    url:   'atualiza-tabela-funcionarios',	    		   
	    		    success: function(data){		    	
	    		    	$('#tabela-funcionarios').html(data);
	    		     }
	    		});
	    		
	    		setTimeout(function() {		    			
			        $.bootstrapGrowl('<i class="fas fa-check"></i> Status do Funcionário alterado!', {
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