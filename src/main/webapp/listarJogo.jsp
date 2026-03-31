<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/headerLogin.jsp"/>
    <body>
       <div class="container">
       </br>
       <h1>Lista de jogos</h1>
       </br>
            <table class="table">
              <thead>
                <tr>
                  <th scope="col">id</th>
                  <th scope="col">Titulo</th>
                  <th scope="col">Desenvolvedor</th>
                  <th scope="col">Ano de lançamento</th>
                  <th scope="col">Genêro</th>
                  <th scope="col">Sinopse</th>
                  <th scope="col">Idioma</th>
                  <th scope="col">Plataforma</th>
                  <th scope="col">Classificação</th>
                  <th scope="col">Capa</th>
                  <th scope="col">Editar</th>
                  <th scope="col">Excluir</th>
                </tr>
              </thead>
              <tbody>
              <c:if test="${empty lista}">
                <tr>
                    <td colspan=3>Não há jogos adicionadas</td>
                </tr>
              </c:if>
               <c:forEach var="j" items="${lista}">
                <tr>
                    <td>${j.getId()}</td>
                    <td>${j.getTitulo()}</td>
                    <td>${j.getDesenvolvedor()}</td>
                    <td>${j.getAnoLancamento()}</td>
                    <td>${j.getGenero()}</td>
                    <td>${j.getSinopse()}</td>
                    <td>${j.getIdioma()}</td>
                    <td>${j.getPlataforma()}</td>
                    <td>${j.getClassIndicativa()}</td>
                    <td>${j.capa}</td>
                    <td>
                        <form action="editar_jogo" method="get">
                            <input type="hidden" name="id" value="${j.id}">
                            <button type="submit" class="btn btn-warning">Editar</button>
                        </form>
                    </td>

                    <td>
                        <form action="excluir_jogo" method="post">
                            <input type="hidden" name="id" value="${j.id}">
                            <button type="submit" class="btn btn-danger">Excluir</button>
                        </form>
                    </td>

                </tr>
               </c:forEach>
            </table>
           <c:if test="${not empty resultados}">
               <h3>Resultados da busca:</h3>

               <c:forEach var="j" items="${resultados}">
                   <p>${j.titulo}</p>
               </c:forEach>
           </c:if>
       </div>
       <script src="js/busca.js"></script>
<c:import url="/includes/footer.jsp"/>
