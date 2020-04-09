<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="scrollTabelas">
	<table id="tabela-clientes" class="table table-bordered">
		 <thead class="corHeadAddUser">
		    <tr>		     
		      <th class="alinha-cor">Veículo</th>
		      <th class="alinha-cor">Marca</th>	
		      <th class="alinha-cor">Placa</th>	
		      <th class="alinha-cor">Ano</th>							
		      <th id="coluna-acoes" class="alinha-cor">Ações</th>						              
		    </tr>
		 </thead>
		 <tbody>
		 	<c:forEach items="${veiculos}" var="carro">
		 		<tr id="veiculo-${carro.id}">
		 			<td>${carro.veiculo.nome}</td>
		 			<td>${carro.veiculo.marca.nome}</td>
		 			<td>${carro.placa}</td>
		 			<td>${carro.ano}</td>
		 			<td id="acoes-tabela">								
						<button type="button" class="btn btn-warning" id="update" onclick="editar(${carro.id});" data-toggle="tooltip" data-placement="top" title="Editar"><i class="fas fa-user-edit"></i></button>
						<button type="button" id="delete" class="btn btn-danger" onclick="excluir(${carro.id},'veiculo-${carro.id}')"><i class="fas fa-trash-alt"></i></button>
						<button type="button" class="btn btn-success" id="confirmar" onclick="confirmar(${carro.id},'veiculo-${carro.id}');" style="display: none;" data-toggle="tooltip" data-placement="top" title="Confirmar"><i class="fas fa-check"></i></button>			        	
		        		<button type="button" class="btn btn-danger" id="cancelar" onclick="cancelar('veiuclo-${carro.id}');" style="display: none;" data-toggle="tooltip" data-placement="top" title="Cancelar"><i class="fas fa-times"></i></button>													
		 			</td>
		 		</tr>
		 	</c:forEach>
		 </tbody>
	</table>
</div>