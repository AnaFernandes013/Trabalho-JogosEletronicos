<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%if (session.getAttribute("usuarioLogado") == null) {response.sendRedirect("erro.jsp");return;}%>
<%if (session.getAttribute("usuarioLogado") != null) {
%><c:import url="/includes/headerLogin.jsp"/><%
} else {
%><c:import url="/includes/header.jsp"/><%}%>

<c:if test="${not empty msgSucessoJogo}">
    <div class="alert alert-success">
            ${msgSucessoJogo}
    </div>
    <c:remove var="msgSucessoJogo" scope="session"/>
</c:if>

<c:if test="${not empty sucessoJogo}">
    <div class="alert alert-success">
            ${sucessoJogo}
    </div>
    <c:remove var="sucessoJogo" scope="session"/>
</c:if>

<c:if test="${not empty sucessoExcluir}">
    <div class="alert alert-success">
            ${sucessoExcluir}
    </div>
    <c:remove var="sucessoExcluir" scope="session"/>
</c:if>

<body>
   <div class="container">
       </br>
       <h1>Lista de jogos</h1>
       </br>
       <div class="table-responsive">
            <table class="table table-info">
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
                  <th scope="col">Ação</th>
                </tr>
              </thead>
              <tbody>
              <c:if test="${empty lista}">
                <tr>
                    <td colspan="11">Não há jogos adicionados</td>
                </tr>
              </c:if>
               <c:forEach var="j" items="${lista}">
                <tr>
                    <td>${j.getId()}</td>
                    <td>${j.getTitulo()}</td>
                    <td>${j.getDesenvolvedor()}</td>
                    <td>${j.getAnoLancamento()}</td>
                    <td>${j.getGenero()}</td>
                    <td>
                        <!-- Botão para abrir o Modal -->
                        <button type="button" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#sinopseModal" data-sinopse="${j.getSinopse()}">
                            Ver Sinopse Completa
                        </button>
                    </td>
                    <td>${j.getIdioma()}</td>
                    <td>${j.getPlataforma()}</td>
                    <td>${j.getClassIndicativa()}</td>
                    <td>${j.capa}</td>
                    <td class="d-flex flex-column gap-2">
                        <form action="editar_jogo" method="get">
                            <input type="hidden" name="id" value="${j.id}">
                            <button type="submit" class="btn btn-warning btn-sm w-100">Editar</button>
                        </form>

                        <form action="excluir_jogo" method="post">
                            <input type="hidden" name="id" value="${j.id}">
                            <button type="submit" class="btn btn-danger btn-sm w-100">Excluir</button>
                        </form>
                    </td>
                </tr>
               </c:forEach>
            </table>
       </div>
   </div>

   <!-- Modal para exibir a sinopse completa -->
   <div class="modal fade" id="sinopseModal" tabindex="-1" aria-labelledby="sinopseModalLabel" aria-hidden="true">
     <div class="modal-dialog">
       <div class="modal-content">
         <div class="modal-header">
           <h5 class="modal-title" id="sinopseModalLabel">Sinopse Completa</h5>
           <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
         </div>
         <div class="modal-body">
           <p id="sinopse-texto">Carregando...</p>
         </div>
       </div>
     </div>
   </div>

   <!-- Scripts para o modal -->
   <script>
       // Quando o modal for mostrado, define o texto da sinopse no modal
       $('#sinopseModal').on('show.bs.modal', function (event) {
           var button = $(event.relatedTarget);  // Botão que abriu o modal
           var sinopse = button.data('sinopse');  // Obtém a sinopse do botão
           var modal = $(this);
           modal.find('#sinopse-texto').text(sinopse);  // Define a sinopse no modal
       });
   </script>
</body>

<c:import url="/includes/footer.jsp"/>