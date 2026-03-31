package br.edu.ifsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static br.edu.ifsp.CadastroJogo.lista;

@WebServlet(name = "buscaTermo", value = "/buscar")

public class buscaTermo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String termo = request.getParameter("termo");

        List<Jogo> resultados = new ArrayList<>();

        for (Jogo jogo : lista) {
            if (jogo.getTitulo().toLowerCase().contains(termo.toLowerCase())) {
                resultados.add(jogo);
            }
        }

        request.setAttribute("resultados", resultados);

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // code
    }
}