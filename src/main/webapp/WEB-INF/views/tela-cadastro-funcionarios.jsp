<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

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
					
		thead.corHeaderProduto{
			background-color: #FA8072;
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
			
		.card-salt {
			 box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
			 transition: 0.3s;
			 width: 100%;
			 margin: auto;
			 background-color: #FFFAFA;
		}		

		.card-salt:hover {
		  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
		}
			
	</style>	
	
<title>Cadastro de Funcionários</title>
</head>
<body>

	<div class="page-wrapper chiller-theme toggled">
		<jsp:include page="header.jsp"></jsp:include>
		
		<main class="page-content">
			<div class="container">
				<div class="card-salt">	
					<div class="container">		
					<br>		
						<div class="btnDireita">
							<!-- BOTÃO MODAL NOVO PRODUTO -->
							<button type="button" class="btn btn-outline-primary btn-lg" onclick="cadastro()" id="btn-modal-cadastro" data-toggle="modal" data-target="#funcionario">
							  <i class="fas fa-plus"></i> Novo Funcionário
							</button>	
						</div>
						<br>
						<!-- TABELA COM TODOS OS PRODUTOS  -->
						<div id="tabela-funcionarios">		
							<jsp:include page="tabela-lista-funcionarios.jsp"></jsp:include>	
						</div>			
					</div>
					<br>
				</div>
			</div>
		</main>		
	</div>
	
		
	<!-- MODAL DE CADASTRO DE ACESSO -->
	<div class="modal fade" id="acessos" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLongTitle">ACESSO</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	      	<jsp:include page="formulario-cadastro-acesso.jsp"></jsp:include>      		
	      </div>	     
	    </div>
	  </div>
	</div>
	
	
	<!-- MODAL NOVO FUNCIONARIO -->
	<div class="modal fade" id="funcionario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLongTitle">FUNCIONÁRIO</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	      	<div id="cadastro-funcionario">
	      		<jsp:include page="formulario-cadastro-funcionario.jsp"></jsp:include>
	      	</div>	      		
	      </div>	     
	    </div>
	  </div>
	</div>
	
	<!-- MODAL NOVO FUNCIONARIO -->
	<div class="modal fade" id="edit_funcionario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLongTitle">FUNCIONÁRIO</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	      	<div id="edit-cad-funcionario">
	      		<jsp:include page="formulario-edit-cadastro-funcionario.jsp"></jsp:include>
	      	</div>	      		
	      </div>	     
	    </div>
	  </div>
	</div>
	
	<script type="text/javascript" src="${jsPath}/jquery-3.3.1.min.js"></script>
	<script src="//plentz.github.io/jquery-maskmoney/javascripts/jquery.maskMoney.min.js"></script>
	<script type="text/javascript" src="${jsPath}/bootstrap.min.js"></script>	
	<script type="text/javascript" src="${jsPath}/funcionario.js"></script>
	<script type="text/javascript" src="${jsPath}/bootstrapGrowl.js"></script>
	<script type="text/javascript" src="${jsPath}/menu.js"></script>
</body>
</html>