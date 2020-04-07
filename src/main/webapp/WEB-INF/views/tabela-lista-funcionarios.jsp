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
			<tr id="funcionario-${acesso.usuario.id}">					
				<td>${acesso.usuario.nome} ${acesso.usuario.sobrenome}</td>
				<td>${acesso.usuario.email}</td>				
				<td id="acoes">
					<c:choose>
							<c:when test="${acesso.acesso}">
								<button type="button" id="atribuir_retirar"  class="btn btn-success" onclick="permissao('funcionario-${acesso.usuario.id}')" >
									<i class="fas fa-key"></i>			
								</button>	
								<button type="button" id="altera-permissao" class="btn btn-success" onclick="ConfirmaAlteracao(${acesso.usuario.id},'funcionario-${acesso.usuario.id}',false)" style="display: none;">
									<i class="fas fa-check"></i>
								</button>
							</c:when>
							<c:otherwise>
									<button type="button" id="atribuir_retirar" class="btn btn-secondary" onclick="acesso(${acesso.usuario.id},'${acesso.usuario.nome} ${acesso.usuario.sobrenome}')" data-toggle="modal" data-target="#acessos">
										<i class="fas fa-unlock-alt"></i>
									</button>	
									<button type="button" id="altera-permissao" class="btn btn-success" onclick="ConfirmaAlteracao(${acesso.usuario.id},'funcionario-${acesso.usuario.id}',true)" style="display: none;">
										<i class="fas fa-check"></i>
									</button>
							</c:otherwise>
						</c:choose>	
					
					<button type="button" id="update" class="btn btn-warning" onclick="update(${acesso.usuario.id},'${acesso.usuario.nome}','${acesso.usuario.sobrenome}','${acesso.usuario.email}',${acesso.usuario.ativo})" data-toggle="modal" data-target="#edit_funcionario">
						<i class="fas fa-pencil-alt"></i>					
					</button>
					
					<c:choose>
							<c:when test="${acesso.usuario.ativo}">
								<button type="button" id="desativar" class="btn btn-success" onclick="desativar(${acesso.usuario.id},'funcionario-${acesso.usuario.id}')">
									<i class="fas fa-power-off"></i>
								</button>
								<button type="button" id="confirma" class="btn btn-success" onclick="confirmar(${acesso.usuario.id},'funcionario-${acesso.usuario.id}',false)" style="display: none;">
									<i class="fas fa-check"></i>
								</button>
								
							</c:when>
							<c:otherwise>
									<button type="button" id="desativar" class="btn btn-danger" onclick="desativar(${acesso.usuario.id},'funcionario-${acesso.usuario.id}')">
										<i class="fas fa-power-off"></i>
									</button>
									
									<button type="button" id="confirma" class="btn btn-success" onclick="confirmar(${acesso.usuario.id},'funcionario-${acesso.usuario.id}',true)" style="display: none;">
										<i class="fas fa-check"></i>
									</button>
							</c:otherwise>
						</c:choose>						
					<button type="button" id="cancelar" class="btn btn-danger" onclick="cancelar('funcionario-${acesso.usuario.id}')" style="display: none;">
						<i class="fas fa-times"></i>
					</button>							
				</td>											
			</tr>
		</c:forEach>
	</tbody>
</table>	