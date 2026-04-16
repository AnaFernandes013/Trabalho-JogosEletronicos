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
        // No doGet ou doPost, antes de fazer qualquer operação com a resposta:
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

// Se estiver recebendo dados via requisição, também defina a codificação:
        request.setCharacterEncoding("UTF-8");
        HttpSession sessao = request.getSession();

        // SESSAO
        if (sessao.getAttribute("usuarioLogado") == null) {
            response.sendRedirect("erro.jsp");
            return;
        }

        String texto = request.getParameter("comentario");
        String jogoId = request.getParameter("jogoId");

        if (texto == null || texto.trim().isEmpty()) {
            response.sendRedirect("ver_jogo?id=" + jogoId);
            return;
        }

        Usuario usuario = (Usuario) sessao.getAttribute("usuario");

        List<Jogo> listaJogos = (List<Jogo>) getServletContext().getAttribute("lista");

        Jogo jogoSelecionado = null;

        for (Jogo j : listaJogos) {
            if (String.valueOf(j.getId()).equals(jogoId)) {
                jogoSelecionado = j;
                break;
            }
        }

        // PEGAR LISTA UMA VEZ SÓ
        List<Comentario> listaComentario = (List<Comentario>) getServletContext().getAttribute("comentarios");

        if (listaComentario == null) {
            listaComentario = new ArrayList<>(); // cria a lista comentarios
            getServletContext().setAttribute("comentarios", listaComentario);
        }

        // criar comentário
        Comentario c = new Comentario(texto, usuario, jogoSelecionado);

        listaComentario.add(c); // adiciona o comentario na lista

        getServletContext().setAttribute("comentarios", listaComentario);

        response.sendRedirect("ver_jogo?id=" + jogoId);
    }
}