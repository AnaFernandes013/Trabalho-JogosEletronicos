package br.edu.ifsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ComentarioServlet", value = "/Cadastro_Comentario")
public class ComentarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String texto = request.getParameter("comentario");
        String jogoId = request.getParameter("jogoId");

        List<String> listaMensagens = new ArrayList<>();

        if (texto == null || texto.isEmpty()) {
            listaMensagens.add("Falta o comentário");
        }

        // pegar usuário da sessão OLHA AQUI LARAA!!
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

        // pegar lista de jogos
        List<Jogo> listaJogos = (List<Jogo>) getServletContext().getAttribute("lista");

        Jogo jogoSelecionado = null;

        for (Jogo j : listaJogos) {
            if (String.valueOf(j.getId()).equals(jogoId)) {
                jogoSelecionado = j;
                break;
            }
        }

        // criar comentário
        Comentario c = new Comentario(texto, usuario, jogoSelecionado);

        // pegar lista de comentários (ou criar se não existir)
        List<Comentario> listaComentario = (List<Comentario>) getServletContext().getAttribute("comentarios");

        if (listaComentario == null) {
            listaComentario = new ArrayList<>();
        }

        listaComentario.add(c);

        getServletContext().setAttribute("comentarios", listaComentario);

        // redirecionar de volta pro jogo
        response.sendRedirect("ver_jogo?id=" + jogoId);
    }
}