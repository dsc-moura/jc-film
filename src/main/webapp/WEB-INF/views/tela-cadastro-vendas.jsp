<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Vendas | Orçamentos & Garantias</title>

	<s:url value="/resources/css" var="cssPath"/>
	<s:url value="/resources/js" var="jsPath"/>
	<link rel="stylesheet" href="${cssPath}/bootstrap.min.css">
	<link rel="stylesheet" href="${cssPath}/menu.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css">
	
	<style type="text/css">		
		.botao {		
			text-align: center;
		}
		
		.btnDireita{
			text-align: right;
		}
					
		thead.corHeaderMarca{
			background-color: #00BFFF;
		}	
		
		thead.corHeaderCategoria{
			background-color: #43CD80;
		}	
		
		thead.corHeaderDescarte{
			background-color: #FF6347;
		}
		
		thead.corHeaderPagamento{
			background-color: #4F4F4F;
		}			
			
		th.alinha-cor{
			text-align: center;
			color: #FFFAFA;					
		}		
		td{
			text-align: center;
		}
		
			body{
			background-color: #EE6363;			
		}
		
		#formulario-clientes{
			background-color: #FFFAFA;
			 width: 98%;
		}
		
		.redonda {
			border-radius: 70%;
			display: inline-block;
			
			width:100px;
			height:100px;
		}
		
		.btn-circle.btn-xl{
			width: 120px;
			height: 120px;
			padding: 28px 30px;
			font-size: 50px;
			line-height: 1.33;
			border-radius:100px;	
		}
		
		@keyframes fa-blink {
		     0% { opacity: 1; }
		     50% { opacity: 1.8; }
		     100% { opacity: 0.3; }
		 }
		 
		.fa-blink {
		   -webkit-animation: fa-blink .75s linear infinite;
		   -moz-animation: fa-blink .75s linear infinite;
		   -ms-animation: fa-blink .75s linear infinite;
		   -o-animation: fa-blink .75s linear infinite;
		   animation: fa-blink .75s linear infinite;
		}
		
		.scrollTabelas{
		 	max-height:250px;
		  	overflow-x:auto;
		}	
		
		.scrollTabelasGarantias{
		 	max-height:600px;
		  	overflow-x:auto;
		}			
	</style>	

</head>
<body>

	<div class="page-wrapper chiller-theme toggled">
		<jsp:include page="header.jsp"></jsp:include>
		
		<main class="page-content">				
				<div class="container-fluid" id="formulario-clientes">
					<ul class="nav nav-tabs" id="myTab" role="tablist">
						  <li class="nav-item">
						    	<a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Vendas & Orçamentos</a>
						  </li>
						   <li class="nav-item">
						    	<a class="nav-link" id="profile-tab" data-toggle="tab" href="#garantia" role="tab" aria-controls="profile" aria-selected="false">Consultas & Garantias</a>
						  </li>
					</ul>		
				<br><br>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">		  	
				  		<div id="tabela-clientes">	
				  			<div class="card">
						  		<div class="card-body">
						  			<jsp:include page="formulario-cadastro-vendas.jsp"></jsp:include>
						  			
						  			<br>
						  			<div id="formulario-veiculos-cliente">
						  				<jsp:include page="formulario-cadastro-veiculos.jsp"></jsp:include>
						  			</div>
						  			<br>
						  			
						  			<div class="card">
						  				<div class="card-body">
							  				<div class="row">
								  				<div class="col-md-6">
													<h5>Funcionário Responsável:</h5>
													<div id="combo-funcionarios">
														<div class="input-group input-group-lg">
															<select class="form-control" id="funcionario" >
																<option value="">Selecione o Responsável pelo Serviço</option>
																<c:forEach items="${usuarios}" var="usuario">
																	<option value="${usuario.id}">${usuario.nome} ${usuario.sobrenome}</option>
																</c:forEach>											
															</select>						
														</div>	
													</div>							
												</div>
												<div class="col-md-6">
													<br>
													<div class="btnDireita">	
														<button type="button" class="btn btn-outline-success btn-lg" data-toggle="modal" data-target="#produtos-servicos">
															<i class="fas fa-plus"></i> SERVIÇO/PRODUTO						
														</button>
													</div>
												</div>
											</div>
											<br>
											<div id="tabela-carrinho-compras">
				  								<jsp:include page="tabela-lista-itens-vendas.jsp"></jsp:include>				  								
				  							</div>
			  								<div>
					  							<hr></hr>
					  						</div>
				  							<div class="row">					  							
					  							<div class="col-md-7"></div>				  							
					  							<div class="col-md-5">
						  							<div class="input-group input-group-lg">
							  							<div class="input-group-prepend">
															<button type="button" class="input-group-text"><h4>TOTAL:</h4></button>
														</div>
											 			<input type="text" style="font-family: Tahoma; font-size: 26px" class="form-control" id="total" name="total" readonly="true"/>									
													</div>															
												</div>
											</div>
				  						</div>
				  					</div>
				  				</div>				  				
				  				<div class="card-body">
					  				<div>
					  					<hr></hr>
					  				</div>							
									<div class="btnDireita" id="finalizar-servico-botoes" style="display: none;">										
										<button type="button"  class="btn btn-danger btn-lg" id="btn-cancelcar-venda" data-toggle="modal" data-target="#cancelar-venda">
											<i class="fas fa-times"></i> CANCELAR VENDA						
										</button>	
						  				<button type="button" class="btn btn-success btn-lg" id="btn-finalizar-venda" data-toggle="modal" data-target="#finalizar-venda">
											<i class="fas fa-handshake"></i> FINALIZAR VENDA						
										</button>
									</div>		
				  				</div>				  				
				  		   </div>
				  	    </div>	
				  	</div>
				  	<div class="tab-pane fade" id="garantia" role="tabpanel" aria-labelledby="profile-tab">
				  		<div class="card">
							<div class="card-body">
				  				<div class="row">
									<div class="col-md-12">	
										<div class="input-group input-group-lg">
											<input type="text" placeholder="Informe a placa" class="form-control" id="busca-placa-veiculo"/>
											<div class="input-group-prepend">
												<button type="button" class="input-group-text"  id="inputGroup-sizing-lg"><i class="fas fa-search"></i></button>
											</div>
										</div>					
									</div>						
								</div>
							</div>
						</div>
						<hr></hr>
						
						<div id="tabela-garantia-servicos">
							<jsp:include page="tabela-lista-servicos-garantias.jsp"></jsp:include>
						</div>				  		
				  		
				  		<span class="badge badge-light">Lengenda:</span>
				  		<span class="badge badge-success"><i class="fas fa-check"></i> Venda Finalizada (Paga)</span>
						<span class="badge badge-danger"><i class="fas fa-times"></i> Venda em Aberto (Não Paga)</span>				  		
				  	</div>
				</div>
			</div>	
			
			</div>
		</main>
		
			
	<!-- MODAL NOVO CLIENTE -->
	<div class="modal fade" id="cliente" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLongTitle">CLIENTE</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	     		<jsp:include page="formulario-cadastro-clientes-resumido.jsp"></jsp:include>	      		
	      </div>
	      <div class="modal-footer">
	      	<button type="button" class="btn btn-success" onclick="CadastrarCliente();"><i class="far fa-save"></i> Salvar</button>				
	        <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- MODAL NOVO CLIENTE -->
	<div class="modal fade" id="veiculo-add" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLongTitle">VEÍCULO</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	     	 	<jsp:include page="formulario-cadastro-veiculos-cliente.jsp"></jsp:include>	
	      </div>
	      <div class="modal-footer">
	      	<button type="button" class="btn btn-success" onclick="CadastrarVeiculoCliente();"><i class="far fa-save"></i> Salvar</button>				
	        <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- MODAL LISTA DE SERVIÇOS -->
	<div class="modal fade" id="lista-itens-produtos-servicos" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLongTitle">SERVIÇOS REALIZADOS</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	      		<div id="itens-garantia-cliente"> 
	      			<jsp:include page="tabela-lista-itens-vendidos.jsp"></jsp:include>	
	      		</div>	     	 
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
	      </div>
	    </div>
	  </div>
	</div>
	
		<!-- MODAL NOVO PRODUTOS/SERVIÇOS -->
	<div class="modal fade" id="produtos-servicos" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLongTitle">PRODUTOS/SERVIÇOS</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	     	 	<jsp:include page="formulario-produtos-servicos-selecao.jsp"></jsp:include>	
	      </div>
	      <div class="modal-footer">
	      	<button type="button" class="btn btn-success" onclick="salvar();"><i class="fas fa-arrow-down"></i> Adicionar</button>				
	        <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- MODAL CANCELAR VENDA -->
	<div class="modal fade" id="cancelar-venda" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLongTitle">CANCELAR VENDA</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	      	<div class="botao">
	      	     		
     			<button type="button" class="btn btn-outline-danger btn-circle btn-xl" data-toggle="tooltip" data-placement="bottom" onclick="CancelarVenda();" title="CANCELAR">
					<i class="far fa-sad-tear fa-blink"></i>
					
				</button>
	     
	      	</div>	     	 	
	      </div>
	      <div class="modal-footer">	      				
	        <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- MODAL FINALIZAR VENDA -->
	<div class="modal fade" data-backdrop="static" id="finalizar-venda" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLongTitle">FINALIZAR VENDA</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	   
	        </button>
	      </div>
	      <div class="modal-body">
	     	 	<div class="card">
	  				<div class="card-body">
		  				<div id="finalizar-venda-btn" class="row">		  					
		  					<div class="col-md-6">
								<h5>Pagamento:</h5>
								<div id="lista-veiculos-cliente">
								<div class="input-group input-group-lg">
									<select class="form-control" id="pago">
										<option value="">Houve Pagamento?</option>															
										<option value="false">NÃO</option>
										<option value="true">SIM</option>																									
									</select>						
								</div>	
								</div>							
							</div>
							<div class="col-md-3">
								<h5>Prazo/Garantia:</h5>
								<div class="input-group input-group-lg">
									<input type="text" class="form-control" id="prazo" name="prazo"/>
								</div>					
							</div>
							<div class="col-md-3">
								<h5>Tempo/Garantia:</h5>
								<div id="lista-veiculos-cliente">
								<div class="input-group input-group-lg">
									<select class="form-control" id="tempo" >
										<option value="">Tempo</option>															
										<option value="0">Dia(s)</option>
										<option value="1">Semana(s)</option>
										<option value="2">Mês(es)</option>
										<option value="3">Ano(s)</option>																									
									</select>						
								</div>	
								</div>							
							</div>													
		  				</div>
		  			</div>
	  			</div>
	      </div>
	      <div class="modal-footer">	      				
	      	<button type="button" class="btn btn-success" id="btn-finalizar-venda" onclick="FinalizarVendaServico();"><i class="far fa-save"></i> Salvar</button>				
	        <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
	      </div>
	    </div>
	  </div>
	</div>

	
	<!-- MODAL IMPRESSÃO GARANTIA DO CLIENTE -->
	 <div class="modal fade" id="modal-garantia-cliente">
	   <div class="modal-dialog modal-lg">
		   <div class="modal-content">		      
			   <!-- Modal Header -->
			    <!-- Modal body -->
			   <div class="modal-body">			   
				   <div class="container-fluid"> 
				   		<div style="text-align: right;">
				   			<button type="button" class="btn btn-outline-danger btn-lg" onclick="PrintGarantiaCliente();" ><i class="far fa-file-pdf"> </i> </button>
				   		</div>
				   		<br>				   		
					  <div class="card" id="garantia-servico-cliente">
					   		<div class="card-body">
							   	<div class="card">
							   		<div class="card-body">
							   				 <div class="row">
							   				<div class="col-md-5">							  			
									   			<label>Empresa:</label>
									   			<input type="input" class="form-control" value="JC Film" id="g-nm-empresa" disabled="disabled">									  
								   			</div>
										   <div class="col-md-4">
										   		<label>CNPJ:</label>
										   		<input type="input" class="form-control" value="93.638.398/0004-27" id="g-cnpj-empresa" readonly="true" >
										   </div>
										   <div class="col-md-3">
										   		<label>Telefone:</label>
										   		<input type="input" class="form-control" value="(11) 3941-8413" id="g-telefone-empresa" readonly="true" >
										   </div>
										    <div class="col-md-6">
										   		<label>Endereço:</label>
										   		<input type="input" class="form-control" value="Av. Raimundo Pereira de Magalhães" id="g-endereco-empresa" readonly="true">
										   </div>
										   <div class="col-md-2">
										   		<label>Nº:</label>
										   		<input type="input" class="form-control" value="1800" id="g-numero-empresa" readonly="true" >
										   </div>
										   <div class="col-md-4">
										   		<label>E-mail:</label>
										   		<input type="input" class="form-control" value="jcfilm@gmail.com" id="g-email-empresa" readonly="true" >
										   </div>
							   			</div>
							   		</div>						   
							   </div>	
							   <br>
							   <div class="card">
							   		<div class="card-body">
							   			<div class="row">
							   				<div class="col-md-12">							  			
									   			<label>Cliente:</label>
									   			<input type="text" class="form-control"  id="g-nm-cliente" readonly="true">									   
								   			</div>
										   <div class="col-md-3">
										   		<label>CPF:</label>
										   		<input type="input" class="form-control"  id="g-cpf-cliente" readonly="true">
										   </div>
										   <div class="col-md-3">
										   		<label>Telefone:</label>
										   		<input type="input" class="form-control"  id="g-telefone-cliente" readonly="true">
										   </div>								   
										   <div class="col-md-6">
										   		<label>E-mail:</label>
										   		<input type="input" class="form-control"  id="g-email-cliente" readonly="true">
										   </div>
										    <div class="col-md-3">
										   		<label>Marca:</label>
										   		<input type="input" class="form-control" id="g-marca-veiculo-cliente" readonly="true" >
										   </div>
										   <div class="col-md-4">
										   		<label>Veículo:</label>
										   		<input type="input" class="form-control" id="g-nome-veiculo-cliente" readonly="true" >
										   </div>
										   <div class="col-md-3">
										   		<label>Placa:</label>
										   		<input type="input" class="form-control" id="g-veiculo-placa-cliente" readonly="true" >
										   </div>
										   <div class="col-md-2">
										   		<label>Ano:</label>
										   		<input type="input" class="form-control" id="g-ano-veiculo-cliente" readonly="true" >
										   </div>										  
							   			</div>
							   		</div>						   
							   </div>	
							   <br>
							   <div class="card">
							   		<div class="card-body">
							   			<div class="row">					   				
							   			   <div class="col-md-2">
										   		<label>OS Nº:</label>
										   		<input type="text" class="form-control" id="g-os-id-servico" readonly="true" >
										   </div>
							   				<div class="col-md-10">							  			
									   			<label>Responsável:</label>
									   			<input type="text" class="form-control" id="g-nm-resp-servico" readonly="true" >									 
								   			</div>								 
										   <div class="col-md-4">
										   		<label>Data Serviço:</label>
										   		<input type="text" class="form-control"  id="g-data-servico" readonly="true" >
										   </div>								   
										   <div class="col-md-4">
										   		<label>Venc. Garantia:</label>
										   		<input type="text" class="form-control" id="g-data-garantia-servico" readonly="true" >
										   </div>
										   <div class="col-md-4">
										   		<label>Valor Total:</label>
										   		<input type="text" class="form-control" id="g-total-servico" readonly="true" >
										   </div>
										   
										   <hr>										  
							   			</div>
							   			<br>	
							   			<div id="tabela-itens-para-garantia">
							   				<jsp:include page="tabela-lista-itens-vendidos.jsp"></jsp:include>	
							   			</div>
							   		</div>						   
							   </div>	
				    		</div> 
						</div>   
					</div>
				</div>           
		    </div>
	    </div>
    </div> 
	
	
	<script type="text/javascript" src="${jsPath}/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="${jsPath}/bootstrap.min.js"></script>	
	<script type="text/javascript" src="${jsPath}/bootstrapGrowl.js"></script>	
	<script type="text/javascript" src="${jsPath}/vendas.js"></script>
	<script type="text/javascript" src="${jsPath}/menu.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.3/jspdf.debug.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.js"></script>
</body>
</html>