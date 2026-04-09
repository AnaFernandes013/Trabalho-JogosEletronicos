package br.edu.ifsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static br.edu.ifsp.CadastroJogo.lista;

@WebServlet(name = "BuscaTermo", value = "/buscar")

public class BuscaTermo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String termo = request.getParameter("termo");
        String origem = request.getParameter("origem");

        if (origem == null || origem.isEmpty()) {
            origem = "index.jsp";
        } else {
            origem = origem.substring(origem.lastIndexOf("/") + 1);
        }

        if (termo == null || termo.isEmpty()) { // verifica se o termo n ta vazio
            request.setAttribute("resultados", lista);
        } else {
            List<Jogo> resultados = new ArrayList<>();

            for (Jogo jogo : lista) {
                if (jogo.getTitulo().toLowerCase().contains(termo.toLowerCase())) { // procura se o jogo existe
                    resultados.add(jogo); // adiciona
                }
            }

            request.setAttribute("resultados", resultados);
        }

        RequestDispatcher rd = request.getRequestDispatcher(origem);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // code
    }
}