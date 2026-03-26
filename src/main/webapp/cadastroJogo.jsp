<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp"/>

    <body>
    <div class="container">
        <div class="container-form">
            <h3 class="text-center mb-4">Cadastro de jogos</h3>

            <form action="cadastrar_jogo" method="post" enctype="multipart/form-data">
                <div class="row">


                    <div class="col-md-4">
                        <div class="capa mb-3" id="areaUpload">
                            <img id="preview" src="" alt="" style="display: none;">
                            <span id="texto">Clique para adicionar imagem</span>
                        </div>

                        <input type="file" id="inputImagem" name="capa" accept="image/*" style="display: none;">
                    </div>

                    <!-- CAMPOS -->
                    <div class="col-md-8">

                        <input type="text" name="titulo" class="form-control mb-2" placeholder="Título">

                        <input type="text" name="desenvolvedor" class="form-control mb-2" placeholder="Desenvolvedor">

                        <input type="number" name="ano" class="form-control mb-2" placeholder="Ano de lançamento">

                        <select name="genero" class="form-select mb-2">
                            <option value="">Selecione o genêro</option>
                            <option value="acao">Ação</option>
                            <option value="aventura">Aventura</option>
                            <option value="rpg">RPG</option>
                            <option value="estrategia">Estratégia</option>
                            <option value="simulacao">Simulação</option>
                            <option value="esporte">Esportes</option>
                            <option value="puzzle">Puzzle</option>
                        </select>

                        <textarea name="sinopse" class="form-control mb-2" placeholder="Sinopse"></textarea>

                        <input type="text" name="idioma" class="form-control mb-2" placeholder="Idioma">

                        <input type="text" name="plataforma" class="form-control mb-2" placeholder="Plataforma">

                        <select name="classificacao" class="form-select mb-2">
                            <option value="">Selecione a classificação</option>
                            <option value="L">Livre</option>
                            <option value="10">10 anos</option>
                            <option value="12">12 anos</option>
                            <option value="14">14 anos</option>
                            <option value="16">16 anos</option>
                            <option value="18">18 anos</option>
                        </select>

                        <button type="submit" class="btn btn-dark mt-2">Cadastrar</button>
                    </div>

                </div>
            </form>
        </div>
    </div>

    <script src="js/cadastro.js"></script>
<c:import url="/includes/footer.jsp"/>
