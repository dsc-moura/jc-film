<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="scrollTabelas">
	<table id="tabela-clientes" class="table table-bordered">
		 <thead class="corHeadAddUser">
		    <tr>
		      <th class="alinha-cor">ID</th>
		      <th class="alinha-cor">Nome</th>
		      <th class="alinha-cor">Sobrenome</th>				
		      <th id="coluna-acoes" class="alinha-cor">Ações</th>						              
		    </tr>
		 </thead>
		 <tbody>
		 	<c:forEach items="${clientes}" var="cliente">
		 		<tr id="cliente-${cliente.id}">
		 			<td>${cliente.id}</td>
		 			<td>${cliente.nome}</td>
		 			<td>${cliente.sobrenome}</td>
		 			<td id="acoes-tabela">					
						<button type="button" class="btn btn-primary" id="visualizar" onclick="EditarVisualizar('${cliente.id}','profile-tab',true);" data-toggle="tooltip" data-placement="top" title="Visualizar"><i class="far fa-eye"></i></button>
						<button type="button" class="btn btn-warning" id="update" onclick="EditarVisualizar('${cliente.id}','profile-tab',false);" data-toggle="tooltip" data-placement="top" title="Editar"><i class="fas fa-user-edit"></i></button>
						<button type="button" id="delete" class="btn btn-danger" onclick="excluir(${cliente.id},'cliente-${cliente.id}')"><i class="fas fa-trash-alt"></i></button>
						<button type="button" class="btn btn-success" id="confirmar" onclick="confirmar(${cliente.id},'cliente-${cliente.id}');" style="display: none;" data-toggle="tooltip" data-placement="top" title="Confirmar"><i class="fas fa-check"></i></button>			        	
		        		<button type="button" class="btn btn-danger" id="cancelar" onclick="cancelarDelete('cliente-${cliente.id}');" style="display: none;" data-toggle="tooltip" data-placement="top" title="Cancelar"><i class="fas fa-times"></i></button>													
		 			</td>
		 		</tr>
		 	</c:forEach>
		 </tbody>
	</table>
</div>