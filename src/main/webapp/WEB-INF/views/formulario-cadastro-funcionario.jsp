<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form:form id="Form-cad-usuarios" action="${s:mvcUrl('FCSC#CadastrarFuncionario').build()}" method="POST" commandName="usuario">
	<div class="modal-body">
		<div class="container-fluid">
			<div class="card">
				<div class="card-body">
					<div class="row">			
						<form:input cssClass="form-control" name="id" path="id" id="id" type="hidden" readonly="true"/>					
						<div class="col-md-4">
							<h5>Nome:</h5>
							<div class="input-group input-group-lg">
								<form:input type="text" cssClass="form-control" id="nome" name="nome" path="nome"/>
							</div>					
						</div>	
						
						<div class="col-md-8">
							<h5>Sobrenome:</h5>
							<div class="input-group input-group-lg">
								<form:input type="text" cssClass="form-control" id="sobrenome" name="sobrenome" path="sobrenome"/>
							</div>					
						</div>				
						<div class="col-md-12">
							<br>						
							<h5>E-mail:</h5>
							<div class="input-group input-group-lg">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-lg"><i class="fas fa-at"></i></span>
								</div>
								<form:input type="text" cssClass="form-control" id="email" name="email" path="email"/>
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