<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="scrollTabelas">
	<table id="tabela-itens-vendas" class="table table-bordered">
		 <thead class="corHeaderMarca">
		    <tr>
		      <th class="alinha-cor">Servi�o/Produto</th>		     
		      <th class="alinha-cor">Quantidade</th>		
		      <th class="alinha-cor">Valor Unit.</th>						              
		    </tr>
		 </thead>
		 <tbody>
		 	<c:forEach items="${itens}" var="item">
		 		<tr id="item-${item.id}">
		 			<td>${item.produto.nome}</td>
		 			<td >
		 				${item.quantidade}
		 			</td>		
		 			<td><fmt:formatNumber  type="currency" value="${item.valor}" minFractionDigits="2"/></td>		 							
		 		</tr>
		 	</c:forEach>
		 </tbody>
	</table>
</div>