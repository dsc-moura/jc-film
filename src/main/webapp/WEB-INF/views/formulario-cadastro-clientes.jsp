<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form:form id="FormCliente" action="${s:mvcUrl('CCSC#CadastrarCliente').build()}" method="POST" commandName="cliente">
	<div class="container-fluid">
		<div class="card">
			<div class="card-body">
				<div class="row">					
					<form:input cssClass="form-control" name="id" path="id" id="id" type="hidden" readonly="true"/>					
					<div class="col-md-3">
						<h5>Nome:</h5>
						<div class="input-group input-group-lg">
							<form:input type="text" cssClass="form-control" id="nome" name="nome" path="nome"/>
						</div>					
					</div>	
					
					<div class="col-md-6">
						<h5>Sobrenome:</h5>
						<div class="input-group input-group-lg">
							<form:input type="text" cssClass="form-control" id="sobrenome" name="sobrenome" path="sobrenome"/>
						</div>					
					</div>	
					
					<div class="col-md-3">						
						<h5>CPF:</h5>
						<div class="input-group input-group-lg">
							<form:input type="text" cssClass="form-control" id="cpf" name="cpf" path="cpf"/>
						</div>					
					</div>
																
					<div class="col-md-2">
						<br>
						<h5>CEP:</h5>
						<div class="input-group input-group-lg">
							<form:input type="text" cssClass="form-control" id="cep" name="cep" path="cep"/>
						</div>					
					</div>
					<div class="col-md-3">
						<br>
						<h5>Bairro:</h5>
						<div class="input-group input-group-lg">
							<form:input type="text" cssClass="form-control" id="bairro" name="bairro" path="bairro"/>
						</div>					
					</div>
					
					<div class="col-md-5">
						<br>
						<h5>Endereço:</h5>
						<div class="input-group input-group-lg">
							<form:input type="text" cssClass="form-control" id="endereco" name="endereco" path="endereco"/>
						</div>					
					</div>
					
					<div class="col-md-2">
						<br>
						<h5>Nº:</h5>
						<div class="input-group input-group-lg">
							<form:input type="text" cssClass="form-control" id="numero" name="numero" path="numero"/>
						</div>					
					</div>
					
					<div class="col-md-6">
					<br>
						<h5>Complemento:</h5>
						<div class="input-group input-group-lg">
							<form:input type="text" cssClass="form-control" id="complemento" name="complemento" path="complemento"/>
						</div>					
					</div>
					
					<div class="col-md-6">
						<br>						
						<h5>E-mail:</h5>
						<div class="input-group input-group-lg">
							<div class="input-group-prepend">
								<span class="input-group-text" id="inputGroup-sizing-lg"><i class="fas fa-at"></i></span>
							</div>
							<form:input type="text" cssClass="form-control" id="email" name="email" path="email"/>
						</div>					
					</div>
					
					<div class="col-md-4">	
						<br>					
						<h5>Telefone:</h5>
						<div class="input-group input-group-lg">
							<div class="input-group-prepend">
								<span class="input-group-text" id="inputGroup-sizing-lg"><i class="fas fa-phone"></i></span>
							</div>
							<form:input type="text" cssClass="form-control" id="telefone" name="telefone" path="telefone"/>
						</div>					
					</div>
				</div>	
							  
				<div class="botao">
					<br>
					<button type="submit" id="salvar" class="btn btn-success btn-lg"><i class="far fa-save"></i> SALVAR</button>				
				</div>						
			</div>		
		</div>	
	</div>				
</form:form>	