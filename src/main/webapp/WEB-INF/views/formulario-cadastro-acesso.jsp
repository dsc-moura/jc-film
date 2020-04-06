<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form:form id="form-acessos" action="${s:mvcUrl('FCSC#CadastroAcessoFuncionario').build()}" method="POST" commandName="acesso">
	<div class="modal-body">
		<div class="container-fluid">
			<div class="card">
				<div class="card-body">
					<div class="row">			
						<form:input cssClass="form-control" name="usuario.id" path="usuario.id" id="id_usuario" type="hidden" readonly="true"/>								
						<div class="col-md-7">
							<h5>Funcionário:</h5>
							<div class="input-group input-group-lg">
								<input type="text" class="form-control" id="nm_funcionario" name="nm_funcionario" readonly="true"/>
							</div>	
						</div>
						<div class="col-md-5">
							<h5>Senha:</h5>
							<div class="input-group input-group-lg">
								<form:input type="password" cssClass="form-control" id="senha" name="senha" path="senha"/>
							</div>	
						</div>			
					</div>								
				</div>		
			</div>	
		</div>		
	</div>		
	<div class="modal-footer">
 		<button type="submit" id="salvar" class="btn btn-success"><i class="far fa-save"></i> Salvar</button>				
        <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
	</div>
</form:form>