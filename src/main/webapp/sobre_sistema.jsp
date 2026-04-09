<%--
  Created by IntelliJ IDEA.
  User: ferna
  Date: 28/03/2026
  Time: 08:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/headerLogin.jsp"/>

<!--se o usuario digitou algo param.termo(valor que veio do formulário)-->
<c:if test="${not empty param.termo}">
    <h3>Resultados da busca:</h3>

    <c:if test="${empty resultados}">
        <p>Nenhum jogo encontrado</p>
    </c:if>

    <c:forEach var="j" items="${resultados}">
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
</c:if>



<div class="cont">
    <h1>️ Sobre o Sistema</h1>

    <div class="section">
        <h2>Sobre o Sistema</h2>
        <p>
            O sistema de gerenciamento de jogos eletrônicos foi desenvolvido para facilitar o cadastro,
            a organização e a visualização de informações sobre diversos jogos.
        </p>
        <p>
            A plataforma permite que usuários explorem uma coleção de jogos, visualizando detalhes como título,
            desenvolvedor, ano de lançamento, gênero, sinopse, idioma, plataforma, classificação indicativa e
            avaliação dos usuários.
        </p>
    </div>

    <div class="section">
        <h2> Funcionalidades</h2>
        <ul>
            <li>Cadastro de novos jogos</li>
            <li>Visualização de jogos cadastrados</li>
            <li>Edição de informações dos jogos</li>
            <li>Remoção de jogos</li>
            <li>Sistema de login para controle de acesso</li>
            <li>Barra de busca para encontrar jogos facilmente</li>
        </ul>
        <p>
            Apenas usuários autenticados podem adicionar, editar ou excluir jogos, garantindo maior segurança e
            controle das informações.
        </p>
    </div>

    <div class="section">
        <h2> Controle de Acesso</h2>
        <p>
            O sistema conta com um mecanismo de autenticação que restringe ações sensíveis apenas a usuários cadastrados.
        </p>
        <p>
            Caso um usuário tente acessar áreas protegidas sem estar logado, ele será redirecionado para uma página de
            erro com uma mensagem informativa.
        </p>
    </div>

    <div class="section">
        <h2> Página Inicial</h2>
        <p>Na página inicial (Home), são exibidos:</p>
        <ul>
            <li>Lançamentos recentes</li>
            <li>Jogos</li>
        </ul>
        <p>
            Essa organização facilita a navegação e melhora a experiência do usuário.
        </p>
    </div>

    <div class="section">
        <h2>Objetivo do Sistema</h2>
        <p>
            O principal objetivo do sistema é proporcionar uma forma simples, intuitiva e eficiente de gerenciar
            informações sobre jogos eletrônicos, permitindo que usuários tenham acesso rápido e organizado aos dados.
        </p>
    </div>

    <div class="section">
        <h2>Desenvolvedor</h2>
        <p>
            Sistema desenvolvido por <strong>Ana Luiza Fernandes dos Santos & Lara Saquete Carvalho</strong> como parte de um projeto acadêmico.
        </p>
    </div>

</div>
<c:import url="/includes/footer.jsp"/>
