<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table class="table table-bordered">
   <thead class="corHeaderProduto">
		<tr>
			<th class="alinha-cor">ID</th>
			<th class="alinha-cor">Serviço/Produto</th>
			<th class="alinha-cor">Preço</th>
			<th class="alinha-cor">Ações</th>
		</tr>
	</thead>
	<tbody>	
		<c:forEach items="${produtos}" var="produto">
			<tr id="produto-${produto.id}">
				<td>${produto.id}</td>
				<td>${produto.nome}</td>
				<td>
					<span id="spanProdutoPreco-${produto.id}"><fmt:formatNumber  type="currency" value="${produto.preco}" minFractionDigits="2"/></span>
				</td>
				<td id="acoes">
					<button type="button" id="update" class="btn btn-warning" onclick="update(${produto.id},'${produto.nome}','${produto.preco}')" data-toggle="modal" data-target="#produto">
						<i class="fas fa-pencil-alt"></i>					
					</button>	
					<button type="button" id="delete" class="btn btn-danger" onclick="excluir(${produto.id},'produto-${produto.id}')">
						<i class="fas fa-trash-alt"></i>
					</button>
					<button type="button" id="confirma" class="btn btn-success" onclick="confirmar(${produto.id},'produto-${produto.id}')" style="display: none;">
						<i class="fas fa-check"></i>
					</button>
					<button type="button" id="cancelar" class="btn btn-danger" onclick="cancelar('produto-${produto.id}')" style="display: none;">
						<i class="fas fa-times"></i>
					</button>							
				</td>											
			</tr>
		</c:forEach>
	</tbody>
</table>	