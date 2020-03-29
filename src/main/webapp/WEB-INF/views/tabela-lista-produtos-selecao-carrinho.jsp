<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="scrollTabelas">
	<table class="table table-bordered">
	   <thead class="corHeaderMarca">
			<tr>
				<th class="alinha-cor">Selecionar</th>
				<th class="alinha-cor">Serviço/Produto</th>
				<th class="alinha-cor">Preço</th>			
			</tr>
		</thead>
		<tbody>	
			<c:forEach items="${produtos}" var="produto">
				<tr class="produtos-servicos" id="produto-${produto.id}">
					<td id="selecao">
						<button type="button" id="btn-selecao-produtos-servicos"  class="btn btn-secondary"  onclick="SelecionarProdutoServico(this);" value="false">
								<i class="fas fa-check"></i>
						</button>	
					</td>
					<td id="id" style="display: none;">${produto.id}</td>			
					<td id="nm-produto-servico">${produto.nome}</td>
					<td>
						<span id="spanProdutoPreco-${produto.id}"><fmt:formatNumber type="currency" value="${produto.preco}" minFractionDigits="2"/></span>
					</td>	
					<td id="valor" style="display: none;">${produto.preco}</td>													
				</tr>
			</c:forEach>
		</tbody>
	</table>	
</div>