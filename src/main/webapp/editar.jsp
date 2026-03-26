<%--
  Created by IntelliJ IDEA.
  User: ferna
  Date: 19/03/2026
  Time: 08:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp"/>
<body>
  <div class="container">
    <div class="row">
      <div class="col-12">
        <p class="h1"> Edição de tarefas</p>
      </div>

      <form action="salvar_edicao" method="POST">
        <input type="hidden" name="id" value="${tarefa.id}">

            <div class="mb-3">
              <label for="nome_tarefa" class="form-label">Nome da tarefa</label>
              <input type="text" class="form-control" id="nome_tarefa" name="novoNome_tarefa" value="${tarefa.getNome()}">
            </div>
            <div class="mb-3">
              <label for="descricao" class="form-label">Descrição:</label>
              <textarea class="form-control" id="descricao" name="novoDescricao" rows="3">${tarefa.getDesc()} </textarea>
            </div>
            <div class="mb-3">
              <button class="btn btn-primary" type="submit">Salvar alterações</button>
            </div>
      </form>
    </div>
  </div>
<c:import url="/includes/footer.jsp"/>
