<form id="formulario-selecao-produtos-servicos">
	<div class="container-fluid">
		<div class="card">
			<div class="card-body">
				<div class="row">
					<div class="col-md-12">						
						<h5>Produto/Serviço:</h5>
						<div class="input-group input-group-lg">
							<input type="text" class="form-control" id="nome-produto-servico"/>
							<div class="input-group-prepend">
								<button type="button" class="input-group-text"  id="inputGroup-sizing-lg"><i class="fas fa-search"></i></button>
							</div>
						</div>					
					</div>						
				</div>
				<br>
				<jsp:include page="tabela-lista-produtos-selecao-carrinho.jsp"></jsp:include>	
			</div>
		</div>
	</div>
</form>