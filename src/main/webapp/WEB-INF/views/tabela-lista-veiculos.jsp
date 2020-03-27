<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="scrollTabelas">
	<table class="table table-bordered">
	   <thead class="corHeaderMarca">
			<tr>
				<th class="alinha-cor">Marca</th>
				<th class="alinha-cor">Modelo/Veículo</th>
				<th class="alinha-cor">Ações</th>
			</tr>
		</thead>
		<tbody id="tabela-veiculos">	
			<c:forEach items="${veiculos}" var="veiculo">
				<tr class="veiculo" id="veiculo-${veiculo.id}">	
					<td id="id" style="display: none;">${veiculo.id}</td>	
					<td>
						<span id="id_marca">${veiculo.marca.nome}</span>		
						
						<select class="form-control" id="id_marca-${veiculo.id}" style="display: none;">
							<option value="">Selecione a Marca</option>
							<c:forEach items="${marcas}" var="mrc">
								<option value="${mrc.id}">${mrc.nome}</option>
							</c:forEach>											
						</select>			
					</td>		
					<td>
						<span id="id_veiculo">${veiculo.nome}</span>
						<input type="text" class="form-control" id='nome' style="display: none">		
					</td>
					<td id="acoes">
						<button type="button" id="update" class="btn btn-warning" onclick="update(${veiculo.id},'veiculo-${veiculo.id}')"><i class="fas fa-pencil-alt"></i></button>
						<button type="button" id="delete" class="btn btn-danger" onclick="excluir(${veiculo.id},'veiculo-${veiculo.id}')"><i class="fas fa-trash-alt"></i></button>
						<button type="button" id="save" class="btn btn-success" onclick="salvar(4,${veiculo.id},'veiculo-${veiculo.id}')" style="display: none;"><i class="far fa-save"></i></button>
						<button type="button" id="confirma" class="btn btn-success" onclick="confirmar(2,${veiculo.id},'veiculo-${veiculo.id}')" style="display: none;"><i class="fas fa-check"></i></button>
						<button type="button" id="cancela" class="btn btn-danger" onclick="cancelarAlteracao('veiculo-${veiculo.id}')" style="display: none;"><i class="fas fa-times"></i></button>				
					</td>											
				</tr>
			</c:forEach>
		</tbody>
	</table>	
</div>