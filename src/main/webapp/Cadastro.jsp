<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp"/>
    <body>
       <div class="container">
            <div class="row">
                <div class="col-12">
                    </br>
                    <p class="h1"> Cadastro  de tarefas</p>
                    </br>
                </div>

               <form action="cadastrar_tarefa" method="POST">
                      <div class="mb-3">
                             <label for="nome_tarefa" class="form-label">Nome da tarefa</label>
                            <input type="text" class="form-control" id="nome_tarefa" name="nome_tarefa" placeholder="nome da tarefa">
                      </div>
                      <div class="mb-3">
                            <label for="descricao" class="form-label">Descrição:</label>
                            <textarea class="form-control" id="descricao" name="descricao" rows="3"></textarea>
                        </div>

                        <div class="mb-3">
                            <button class="btn btn-primary" type="submit">Enviar</button>
                        </div>
                      </div>
               </form>
            </div>
       </div>
<c:import url="/includes/footer.jsp"/>
