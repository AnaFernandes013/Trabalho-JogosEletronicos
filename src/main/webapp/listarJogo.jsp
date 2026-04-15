<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/includes/header.jsp" />
<body>
<div class="container">
    <br>
    <h1>Lista de jogos</h1>
    <br>
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

            <!-- Caso não tenha nada pra mostrar -->
            <c:if test="${empty lista}">
                <tr>
                    <td colspan="11">Nenhum jogo encontrado</td>
                </tr>
            </c:if>


            <c:forEach var="j" items="${lista}">
                <tr>
                    <td>${j.id}</td>
                    <td>${j.titulo}</td>
                    <td>${j.desenvolvedor}</td>
                    <td>${j.anoLancamento}</td>
                    <td>${j.genero}</td>
                    <td>${j.sinopse}</td>
                    <td>${j.idioma}</td>
                    <td>${j.plataforma}</td>
                    <td>${j.classIndicativa}</td>
                    <td>${j.capa}</td>

                    <td class="d-flex flex-column gap-2">
                        <form action="editar_jogo" method="get">
                            <input type="hidden" name="id" value="${j.id}">
                            <button type="submit" class="btn btn-warning btn-sm w-100">
                                Editar
                            </button>
                        </form>

                        <form action="excluir_jogo" method="post">
                            <input type="hidden" name="id" value="${j.id}">
                            <button type="submit" class="btn btn-danger btn-sm w-100">
                                Excluir
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>

</div>


</body>

<script src="js/busca.js"></script>

<c:import url="/includes/footer.jsp"/>