<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp"/>
<body>
<div class="container">

    <div class="container py-5">
        <div class="text-center mb-5">
            <h1 class="fw-bold"></h1>
            <p class="text-muted">Conheça nossos jogos!</p>
        </div>
    </div>

    <c:if test="${empty lista}">
        <p>Não há jogos adicionados</p>
    </c:if>

    <c:if test="${not empty resultados}">
        <h3>Resultados da busca:</h3>

        <c:forEach var="j" items="${resultados}">
            <p>${j.titulo}</p>
        </c:forEach>
    </c:if>


    <div class="row">

        <c:forEach var="j" items="${lista}">
            <div class="col-sm-6 col-md-4 col-lg-3 mb-4">

                <div class="card h-100">

                    <img src="imagens/${j.capa}" class="card-img-top" alt="Capa do jogo">

                    <div class="card-body d-flex flex-column">
                        <h5 class="card-title">${j.titulo}</h5>

                        <p class="card-text">${j.sinopse}</p>

                        <form action="ver_jogo" method="get">
                            <input type="hidden" name="id" value="${j.id}">
                            <button type="submit" class="btn btn-primary mt-auto">Veja mais</button>
                        </form>
                    </div>



                </div>

            </div>
        </c:forEach>

      <%--  <c:if test="${empty comentarios}">
            <p>Não há comentários</p>
        </c:if>
        <c:forEach>

        </c:forEach>--%>

    </div>

</div>

       <script src="js/busca.js"></script>
<c:import url="/includes/footer.jsp"/>
