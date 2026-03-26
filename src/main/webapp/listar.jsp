<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp"/>
    <body>
       <div class="container">
       </br>
       <h1>Lista de tarefa</h1>
       </br>
            <table class="table">
              <thead>
                <tr>
                  <th scope="col">id</th>
                  <th scope="col">Nome</th>
                  <th scope="col">Descrição</th>
                  <th scope="col">Editar</th>
                  <th scope="col">Excluir</th>
                </tr>
              </thead>
              <tbody>
              <c:if test="${lista.size() == null}">
                <tr>
                    <td colspan=3>Não há tarefas adicionadas</td>
                </tr>
              </c:if>
               <c:forEach var="t" items="${lista}">
                <tr>
                    <td>${t.getId()}</td>
                    <td>${t.getNome()}</td>
                    <td>${t.getDesc()}</td>

                    <td>
                        <form action="editar_tarefa" method="post">
                            <input type="hidden" name="id" value="${t.getId()}">
                            <button type="submit" class="btn btn-warning">Editar</button>
                        </form>
                    </td>

                    <td>
                        <form action="excluir_tarefa" method="post">
                            <input type="hidden" name="id" value="${t.getId()}">
                            <button type="submit" class="btn btn-danger">Excluir</button>
                        </form>
                    </td>

                </tr>
               </c:forEach>
            </table>

       </div>
<c:import url="/includes/footer.jsp"/>
