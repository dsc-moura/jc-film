<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadastro de Clientes</title>

<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>

	<s:url value="/resources/css" var="cssPath"/>
	<s:url value="/resources/js" var="jsPath"/>
	<link rel="stylesheet" href="${cssPath}/bootstrap.min.css">	
	<link rel="stylesheet" href="${cssPath}/menu.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css">		

	<style type="text/css">		
		.botao {		
			text-align: right;
		}
		
		.btnDireita{
			text-align: right;
		}
					
		thead.corHeadAddUser{
			background-color: #EE6363;
		}		
		th.alinha-cor{
			text-align: center;
			color: #FFFAFA;					
		}		
		td{
			text-align: center;
		}	
		#formulario-clientes{
			background-color: #FFFAFA;
			 width: 98%;
		}
		body{
			background-color: #EE6363;			
		}	
	</style>

</head>
<body>

	<div class="page-wrapper chiller-theme toggled">
		<jsp:include page="header.jsp"></jsp:include>
		
		<main class="page-content">		
			<div class="container" id="formulario-clientes">
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					  <li class="nav-item">
					    	<a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Clientes</a>
					  </li>
					  <li class="nav-item">
					    	<a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Formulário Cadastro de Clientes</a>
					  </li>
				</ul>		
				<br><br>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">		  	
				  		<div id="tabela-clientes">	
				  			<jsp:include page="tabela-lista-clientes.jsp"></jsp:include>	
				  		</div>	
				  	</div>
				  	<div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
				  		
				  		<div id="cadastro-clientes" >
				  			<jsp:include page="formulario-cadastro-clientes.jsp"></jsp:include>
				 		 </div>
				 		 
				 		 <div id="cadastro-update" style="display: none;">
				  			<jsp:include page="formulario-edit-cadastro-clientes.jsp"></jsp:include>
				 		 </div>
				  	</div>
				</div>
			</div>
		</main>
	</div>
	
	<script type="text/javascript" src="${jsPath}/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="${jsPath}/bootstrap.min.js"></script>
	<script type="text/javascript" src="${jsPath}/bootstrapGrowl.js"></script>
	<script type="text/javascript" src="${jsPath}/clientes.js"></script>
	<script type="text/javascript" src="${jsPath}/menu.js"></script>
	
</body>
</html>