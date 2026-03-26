<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Trabaio</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
  </head>
<body>

    <nav class="navbar navbar-expand-lg bg-body-tertiary w-100">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Teste</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="index.jsp">Index</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="Cadastro.jsp">Cadastrar</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="listar.jsp">Listar</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
   <c:if test="${!empty listaMensagens}">
       <div class="alert alert-danger" role="alert">
           <ul class="list-group">
               <c:forEach var="msg" items="${listaMensagens}">
                   <li>${msg}</li>
               </c:forEach>
           </ul>
       </div>
   </c:if>


