package br.edu.ifsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.io.File;

@MultipartConfig
@WebServlet(name = "EditaJogo", value = "/editar_jogo")
public class EditaJogo extends HttpServlet {

    public static List<Jogo> lista = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // No doGet ou doPost, antes de fazer qualquer operação com a resposta:
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

// Se estiver recebendo dados via requisição, também defina a codificação:
        request.setCharacterEncoding("UTF-8");
        HttpSession sessao = request.getSession();

        if(sessao.getAttribute("usuarioLogado") == null){
            response.sendRedirect("erro.jsp");
            return;
        }
        // pega o id pelo get e tras os dados pra mostrar na pagina

        String id = request.getParameter("id");

        List<Jogo> lista = (List<Jogo>) getServletContext().getAttribute("lista");

        for (Jogo j : lista) {
            if (String.valueOf(j.getId()).equals(id)) {
                request.setAttribute("jogo", j);
                break;
            }
        }

        request.getRequestDispatcher("/editarJogo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        // No doGet ou doPost, antes de fazer qualquer operação com a resposta:
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

// Se estiver recebendo dados via requisição, também defina a codificação:
        request.setCharacterEncoding("UTF-8");

        List<Jogo> lista = (List<Jogo>) getServletContext().getAttribute("lista");
        // realiza a edição
        Part capaPart = request.getPart("capa");

        for (Jogo j : lista) {
            if (String.valueOf(j.getId()).equals(id)) {

                j.setTitulo(request.getParameter("novoTitulo"));
                j.setDesenvolvedor(request.getParameter("novoDesenvolvedor"));
                j.setAnoLancamento(request.getParameter("novoAno"));
                j.setGenero(request.getParameter("novoGenero"));
                j.setSinopse(request.getParameter("novoSinopse"));
                j.setIdioma(request.getParameter("novoIdioma"));
                j.setPlataforma(request.getParameter("novoPlataforma"));
                j.setClassIndicativa(request.getParameter("novoClassificacao"));


                if (capaPart != null && capaPart.getSize() > 0) {


                    String nomeArquivo = capaPart.getSubmittedFileName();

                    if(nomeArquivo.contains("\\")){
                        nomeArquivo = nomeArquivo.substring(nomeArquivo.lastIndexOf("\\") + 1);
                    }

                    nomeArquivo = System.currentTimeMillis() + "_" + nomeArquivo;

                    String caminho = getServletContext().getRealPath("/imagens");

                    File pasta = new File(caminho);
                    if (!pasta.exists()) {
                        pasta.mkdir();
                    }

                    capaPart.write(caminho + File.separator + nomeArquivo);


                    j.setCapa(nomeArquivo);
                }

                break;
            }
        }

        HttpSession sessao = request.getSession();
    // envio de msg
        sessao.setAttribute("sucessoJogo", "Jogo atualizado com sucesso!");

        response.sendRedirect("listarJogo.jsp");


    }
}