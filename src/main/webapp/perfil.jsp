<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%if (session.getAttribute("usuarioLogado") == null) {response.sendRedirect("erro.jsp");return;}%>
<%if (session.getAttribute("usuarioLogado") != null) {
%><c:import url="/includes/headerLogin.jsp"/><%
} else {
%><c:import url="/includes/header.jsp"/><%}%>


<c:if test="${not empty sucessoPerfil}">
  <div class="alert alert-success">
      ${sucessoPerfil}
  </div>
</c:if>

<div class="container">

  <h3 class="text-center mb-4">Meu Perfil</h3>

  <form action="editar_perfil" method="post">

    <input type="text" name="novoUsuario" class="form-control mb-2" value="${usuario.getUsuario()}" placeholder="Usuário">
    <div class="erro">${erroUsuario}</div>

    <input type="email" name="novoEmail" class="form-control mb-2" value="${usuario.getEmail()}" placeholder="Email">
    <div class="erro">${erroEmail}</div>

    <input type="password" name="novaSenha" class="form-control mb-2" placeholder="Nova senha">

    <div class="erro">${erroSenha}</div>

    <button type="submit" class="btn btn-primary">Salvar alterações</button>
  </form>
</div>
<c:import url="/includes/footer.jsp"/>