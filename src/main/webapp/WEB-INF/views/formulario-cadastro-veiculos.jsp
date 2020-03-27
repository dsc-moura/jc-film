<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form id="form-cliente-veiculo"  method="POST" >
	<div class="container-fluid">
		<div class="card">
			<div class="card-body">
				<div class="row">
					<div class="col-md-4">
						<h5>Ve�culo/Modelo:</h5>
						<div id="lista-veiculos-cliente">
							<div class="input-group input-group-lg">
								<select class="form-control" id="vveiculo" onchange="selecionar(this);" >
									<option value="">Selecione o Ve�culo</option>
									<c:forEach items="${clientes}" var="veiculo">
										<option value="${veiculo.id}">${veiculo.veiculo.nome}</option>
									</c:forEach>											
								</select>						
							</div>	
						</div>							
					</div>
					<div class="col-md-8">
						<br>
						<div class="btnDireita">	
							<button type="button" class="btn btn-outline-warning btn-lg"  data-toggle="modal" data-target="#veiculo-add">
								<i class="fas fa-car"></i> NOVO VE�CULO						
							</button>
						</div>
					</div>	
					
					<div class="col-md-4">
						<h5>Marca:</h5>
						<div class="input-group input-group-lg">
							<input type="text" class="form-control" id="vmarca" name="marca" readonly="true"/>
						</div>					
					</div>
					<div class="col-md-4">
						<h5>Placa:</h5>
						<div class="input-group input-group-lg">
							<input type="text" class="form-control" id="vplaca" name="placa" readonly="true"/>
						</div>					
					</div>					
					<div class="col-md-4">
						<h5>Ano:</h5>
						<div class="input-group input-group-lg">
							<input type="text" class="form-control" id="vano" name="ano" readonly="true"/>
						</div>					
					</div>										
					
				</div>						
			</div>		
		</div>	
	</div>				
</form>