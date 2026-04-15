package br.edu.ifsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@MultipartConfig// Permite o envio de arquivos (upload de imagem)
@WebServlet(name = "CadastroJogo", value = "/cadastrar_jogo")
public class CadastroJogo extends HttpServlet {

    // Lista estática para armazenar os jogos em memória
    public static List<Jogo> lista = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // para evitar problemas com acentos
        request.setCharacterEncoding("UTF-8");

        String titulo = request.getParameter("titulo");
        String desenvolvedor = request.getParameter("desenvolvedor");
        String anoLancamento = request.getParameter("ano");
        String genero = request.getParameter("genero");
        String sinopse = request.getParameter("sinopse");
        String idioma = request.getParameter("idioma");
        String plataforma = request.getParameter("plataforma");
        String classificacao = request.getParameter("classificacao");

        // Captura do arquivo enviado (imagem da capa)
        Part capaPart = request.getPart("capa");

        List<String> listaMensagens = new ArrayList<>();

        // VALIDAÇÕES
        if (titulo == null || titulo.isEmpty()) {
            listaMensagens.add("Falta o título");
        }

        if (desenvolvedor == null || desenvolvedor.isEmpty()) {
            listaMensagens.add("Falta o desenvolvedor");
        }

        if (anoLancamento == null || anoLancamento.isEmpty()) {
            listaMensagens.add("Falta o ano");
        }

        if (genero == null || genero.isEmpty()) {
            listaMensagens.add("Falta o gênero");
        }

        if (sinopse == null || sinopse.isEmpty()) {
            listaMensagens.add("Falta a sinopse");
        }

        if (idioma == null || idioma.isEmpty()) {
            listaMensagens.add("Falta o idioma");
        }

        if (plataforma == null || plataforma.isEmpty()) {
            listaMensagens.add("Falta a plataforma");
        }

        if (classificacao == null || classificacao.isEmpty()) {
            listaMensagens.add("Falta a classificação");
        }

        if (capaPart == null || capaPart.getSize() == 0) {
            listaMensagens.add("Falta a capa");
        }

        // SE TEM ERRO
        if (!listaMensagens.isEmpty()) {

            request.getSession().setAttribute("listaMensagens", listaMensagens);
            request.getRequestDispatcher("/cadastroJogo.jsp").forward(request, response);

            return;
        }

        // ----------------------------
        // salvar imagem

        String nomeArquivo = capaPart.getSubmittedFileName();


        // Remove caminho do arquivo
        if (nomeArquivo.contains("\\")) {
            nomeArquivo = nomeArquivo.substring(nomeArquivo.lastIndexOf("\\") + 1);
        }

        // Gera nome único para evitar conflito
        nomeArquivo = System.currentTimeMillis() + "_" + nomeArquivo;

        // Caminho da pasta imagens dentro do projeto
        String caminho = getServletContext().getRealPath("/imagens");

        // Cria pasta se não existir
        File pasta = new File(caminho);
        if (!pasta.exists()) {
            pasta.mkdir();
        }

        capaPart.write(caminho + File.separator + nomeArquivo);

        // ----------------------------
        // CRIAR JOGO
        // ----------------------------
        Jogo j = new Jogo(
                titulo,
                desenvolvedor,
                anoLancamento,
                genero,
                sinopse,
                idioma,
                plataforma,
                classificacao,
                nomeArquivo
        );

        List<Jogo> lista = (List<Jogo>) getServletContext().getAttribute("lista");
        lista.add(j);


        request.getRequestDispatcher("/listarJogo.jsp")
                .forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        lista = new ArrayList<>();
        getServletContext().setAttribute("lista", lista);
        System.out.println("🔥 ENTROU NO SERVLET");
    }
}