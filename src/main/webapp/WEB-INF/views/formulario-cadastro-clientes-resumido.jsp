<form id="form-cliente-resumido"  method="POST" >
	<div class="container-fluid">
		<div class="card">
			<div class="card-body">
				<div class="row">					
					<input class="form-control" name="id" id="id" type="hidden" readonly="true"/>					
					
					<div class="col-md-6">						
						<h5>CPF:</h5>
						<div class="input-group input-group-lg">
							<input type="text" class="form-control" id="cpf" name="cpf"/>
						</div>					
					</div>	
					
					<div class="col-md-6">
						<h5>Nome:</h5>
						<div class="input-group input-group-lg">
							<input type="text" class="form-control" id="nome" name="nome"/>
						</div>					
					</div>	
					
					<div class="col-md-6">
						<h5>Sobrenome:</h5>
						<div class="input-group input-group-lg">
							<input type="text" class="form-control" id="sobrenome" name="sobrenome"/>
						</div>					
					</div>	
								
					<div class="col-md-6">						
						<h5>E-mail:</h5>
						<div class="input-group input-group-lg">
							<div class="input-group-prepend">
								<span class="input-group-text" id="inputGroup-sizing-lg"><i class="fas fa-at"></i></span>
							</div>
							<input type="text" class="form-control" id="email" name="email"/>
						</div>					
					</div>
					
					<div class="col-md-6">					
						<h5>Telefone:</h5>
						<div class="input-group input-group-lg">
							<div class="input-group-prepend">
								<span class="input-group-text" id="inputGroup-sizing-lg"><i class="fas fa-phone"></i></span>
							</div>
							<input type="text" class="form-control" id="telefone" name="telefone"/>
						</div>					
					</div>
				</div>							
			</div>		
		</div>	
	</div>				
</form>	