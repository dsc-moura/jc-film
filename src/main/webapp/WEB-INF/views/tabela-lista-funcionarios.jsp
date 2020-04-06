<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table class="table table-bordered">
   <thead class="corHeaderProduto">
		<tr>			
			<th class="alinha-cor">Nome</th>
			<th class="alinha-cor">E-mail</th>
			<th class="alinha-cor">Ações</th>
		</tr>
	</thead>
	<tbody>	
		<c:forEach items="${acessos}" var="acesso">
			<tr id="funcionario-${acesso.id}">					
				<td>${acesso.usuario.nome} ${acesso.usuario.sobrenome}</td>
				<td>${acesso.usuario.email}</td>				
				<td id="acoes">
					<c:choose>
							<c:when test="${acesso.acesso}">
								<button type="button" id="acesso" class="btn btn-success" onclick="retirar_acesso(${acesso.id},'${acesso.usuario.nome} ${acesso.usuario.sobrenome}')" data-toggle="modal" data-target="#acessos">
									<i class="fas fa-key"></i>			
								</button>	
							</c:when>
							<c:otherwise>
									<button type="button" id="acesso" class="btn btn-secondary" onclick="acesso(${acesso.id},'${acesso.usuario.nome} ${acesso.usuario.sobrenome}')" data-toggle="modal" data-target="#acessos">
										<i class="fas fa-unlock-alt"></i>
									</button>	
							</c:otherwise>
						</c:choose>	
					
					<button type="button" id="update" class="btn btn-warning" onclick="update(${acesso.id},'${acesso.usuario.nome}','${acesso.usuario.sobrenome}',${acesso.usuario.email}')" data-toggle="modal" data-target="#funcionario">
						<i class="fas fa-pencil-alt"></i>					
					</button>	
					<button type="button" id="delete" class="btn btn-danger" onclick="excluir(${acesso.id},'funcionario-${acesso.id}')">
						<i class="fas fa-trash-alt"></i>
					</button>
					<button type="button" id="confirma" class="btn btn-success" onclick="confirmar(${acesso.id},'funcionario-${acesso.id}')" style="display: none;">
						<i class="fas fa-check"></i>
					</button>
					<button type="button" id="cancelar" class="btn btn-danger" onclick="cancelar('funcionario-${acesso.id}')" style="display: none;">
						<i class="fas fa-times"></i>
					</button>							
				</td>											
			</tr>
		</c:forEach>
	</tbody>
</table>	