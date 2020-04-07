<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>

<title>Cadastros</title>

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
		
		.scrollTabelas{
		 	max-height:500px;
		  	overflow-x:auto;
		}		
	</style>	

</head>
<body>

	<div class="page-wrapper chiller-theme toggled">
		<jsp:include page="header.jsp"></jsp:include>
		
		<main class="page-content">
			<div class="container-fluid">
				<div class="row">
					<!-- TABELA & CADASTRO DE MARCAS -->
					<div class="col-md-6">
						<div class="card">
							<div class="card-body">	
								
								<!-- BOTÃO MODAL CADASTRO DE MARCA -->
								<div class="btnDireita">
									<button type="button" class="btn btn-outline-primary btn-lg" data-toggle="modal" data-target="#marca">
								 		<i class="fas fa-plus"></i> Nova Marca
									</button>	
								</div>												
								
								<div id="tabelaDeMarcas">
								<br>	
									<jsp:include page="tabela-lista-marcas.jsp"></jsp:include>	
								</div>											
							</div>
						</div>
					</div>
			
					<!-- TABELA & CADASTRO DE CATEGORIAS -->
					<div class="col-md-6">
						<div class="card">
							<div class="card-body">	
								
								<!-- BOTÃO MODAL CADASTRO DE CATEGORIA -->
								<div class="btnDireita">
									<button type="button" class="btn btn-outline-primary btn-lg" data-toggle="modal" data-target="#veiculo">
									 	<i class="fas fa-plus"></i> Novo Veículo
									</button>					
								</div>
								
								<div id="tabelaDeCategorias">
								<br>
									<jsp:include page="tabela-lista-veiculos.jsp"></jsp:include>				
								</div>						
							</div>
						</div>
					</div>	
				
				</div>			
			</div>
		</main>
	</div>
	
	<!-- MODAL DE CADASTRO DE VEÍCULOS -->
	<div class="modal fade" id="veiculo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">VEÍCULO</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>      
	        <form:form id="formVeiculo" action="${s:mvcUrl('CCC#CadastrarVeiculo').build()}" method="POST" commandName="veiculo">
			  	<div class="modal-body">
					<div class="container-fluid">
						<div class="card">
							<div class="card-body">	
								<div class="row">
									<div class="col-md-6">						
										<h5>Marca:</h5>
										<div class="input-group input-group-lg">
											<form:select cssClass="form-control" id="marc" path="marca.id">
												<option value="">Selecione a Marca</option>
												<c:forEach items="${marcas}" var="marca">
													<option value="${marca.id}">${marca.nome}</option>
												</c:forEach>											
											</form:select>						
										</div>								
									</div>
									<div class="col-md-6">						
										<h5>Modelo/Veículo:</h5>
										<div class="input-group input-group-lg">
											<form:input type="text" cssClass="form-control" id="nome" name="nome" path="nome"/>
										</div>						
									</div>
								</div>																		
							</div>	
						</div>	
					</div>	
				</div>	
				<div class="modal-footer">
				 	<button type="submit" class="btn btn-success"><i class="far fa-save"></i> Salvar</button>				
	        		<button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
	      		</div>	
			</form:form>	
	      </div>	     
	    </div>
	  </div>

	
	

	
	<!-- MODAL DE CADASTRO DE MARCAS -->
	<div class="modal fade" id="marca" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">MARCA</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>  	      
	      <form:form id="formMarca" action="${s:mvcUrl('CCC#CadastrarMarca').build()}" method="POST" commandName="marca">
			<div class="modal-body">
				<div class="container-fluid">
					<div class="card">
						<div class="card-body">												
							<form:input cssClass="form-control" name="id" path="id" id="id" type="hidden" readonly="true"/>								
							<h5>Marca:</h5>
							<div class="input-group input-group-lg">
								<form:input type="text" cssClass="form-control" id="nome" name="nome" path="nome"/>
							</div>														
						</div>	
					</div>	
				</div>
		  	</div>	
		  	<div class="modal-footer">
		  		<button type="submit" class="btn btn-success"><i class="far fa-save"></i> Salvar</button>				
	        	<button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
	        </div>		
		 </form:form>     
	    </div>
	  </div>
	</div>
	
	
	
	<script type="text/javascript" src="${jsPath}/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="${jsPath}/bootstrap.min.js"></script>	
	<script type="text/javascript" src="${jsPath}/cadastros.js"></script>
	<script type="text/javascript" src="${jsPath}/bootstrapGrowl.js"></script>
	<script type="text/javascript" src="${jsPath}/menu.js"></script>
</body>
</html>