<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="scrollTabelas">
	<table class="table table-bordered">
	   <thead class="corHeaderMarca">
			<tr>
				<th class="alinha-cor">Marca</th>
				<th class="alinha-cor">Ações</th>
			</tr>
		</thead>
		<tbody id="tabelaDeMarcas">	
			<c:forEach items="${marcas}" var="marca">
				<tr class="marca" id="marca-${marca.id}">	
					<td id="id" style="display: none;">${marca.id}</td>			
					<td>
						<span>${marca.nome}</span>
						<input type="text" class="form-control" id='nome' style="display: none">		
					</td>
					<td id="acoes">
						<button type="button" id="update" class="btn btn-warning" onclick="update(${marca.id},'marca-${marca.id}')"><i class="fas fa-pencil-alt"></i></button>
						<button type="button" id="delete" class="btn btn-danger" onclick="excluir(${marca.id},'marca-${marca.id}')"><i class="fas fa-trash-alt"></i></button>
						<button type="button" id="save" class="btn btn-success" onclick="salvar(3,${marca.id},'marca-${marca.id}')" style="display: none;"><i class="far fa-save"></i></button>
						<button type="button" id="confirma" class="btn btn-success" onclick="confirmar(1,${marca.id},'marca-${marca.id}')" style="display: none;"><i class="fas fa-check"></i></button>
						<button type="button" id="cancela" class="btn btn-danger" onclick="cancelarAlteracao('marca-${marca.id}')" style="display: none;"><i class="fas fa-times"></i></button>				
					</td>											
				</tr>
			</c:forEach>
		</tbody>
	</table>	
</div>