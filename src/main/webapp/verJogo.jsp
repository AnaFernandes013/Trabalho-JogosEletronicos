<jsp:useBean id="jogo" scope="request" type="br.edu.ifsp.Jogo"/>
<%--
  Created by IntelliJ IDEA.
  User: ferna
  Date: 31/03/2026
  Time: 09:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/headerLogin.jsp"/>

<body>
<div class="container py-5">
  <div class="row">

    <!-- IMAGEM -->
    <div class="col-md-4 text-center">
      <img src="imagens/${jogo.capa}"
           class="img-fluid rounded shadow"
           alt="Capa do jogo">
    </div>

    <!-- INFORMAÇÕES -->
    <div class="col-md-8">

      <h2 class="mb-3">${jogo.titulo}</h2>

      <p><strong>Desenvolvedor:</strong> ${jogo.desenvolvedor}</p>

      <p><strong>Ano de lançamento:</strong> ${jogo.anoLancamento}</p>

      <p><strong>Gênero:</strong> ${jogo.genero}</p>

      <p><strong>Idioma:</strong> ${jogo.idioma}</p>

      <p><strong>Plataforma:</strong> ${jogo.plataforma}</p>

      <p><strong>Classificação:</strong> ${jogo.classIndicativa}</p>

      <hr>

      <h5>Sinopse</h5>
      <p>${jogo.sinopse}</p>

    </div>

    </br>
    </br>
    <h5>Comentarios</h5>
    <p>TESTEE TESTANDOOO</p>

  </div>

  <div class="mt-4">
    <a href="index.jsp" class="btn btn-secondary">Voltar</a>
  </div>

</div>
</body>

<c:import url="/includes/footer.jsp"/>
