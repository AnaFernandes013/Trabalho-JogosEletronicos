package br.edu.ifsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "VerJogo", value = "/ver_jogo")
public class VerJogo extends HttpServlet {


    public static List<Jogo> lista = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        List<Jogo> lista = (List<Jogo>) getServletContext().getAttribute("lista");

        for (Jogo j : lista) {
            if (String.valueOf(j.getId()).equals(id)) {
                request.setAttribute("jogo", j);
                break;
            }
        }

        request.getRequestDispatcher("/verJogo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // code
    }
}