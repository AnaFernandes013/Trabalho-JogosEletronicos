package br.edu.ifsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "VerJogo", value = "/ver_jogo")
public class VerJogo extends HttpServlet {


    public static List<Jogo> lista = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        // No doGet ou doPost, antes de fazer qualquer operação com a resposta:
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

// Se estiver recebendo dados via requisição, também defina a codificação:
        request.setCharacterEncoding("UTF-8");

        // recuperando listas ja existentes
        List<Jogo> lista = (List<Jogo>) getServletContext().getAttribute("lista");
        List<Comentario> listaComentarios = (List<Comentario>) getServletContext().getAttribute("comentarios");

        if (listaComentarios == null) {
            listaComentarios = new ArrayList<>();
            getServletContext().setAttribute("comentarios", listaComentarios);
        }

        System.out.println(lista);
        System.out.println(listaComentarios);

        for (Jogo j : lista) {
            if (String.valueOf(j.getId()).equals(id)) {

                request.setAttribute("jogo", j);

                    List<Comentario> comentariosDoJogo = new ArrayList<>(); // criando uma nova lista

                for (Comentario c : listaComentarios) {
                    if (c.getJogo().getId() == j.getId()) {
                        comentariosDoJogo.add(c);
                    }
                }

                request.setAttribute("comentarios", comentariosDoJogo);

                break;
            }
        }

        request.getRequestDispatcher("/verJogo.jsp").forward(request, response);
    }


}