package br.edu.ifsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@MultipartConfig
@WebServlet(name = "CadastroJogo", value = "/cadastrar_jogo")
public class CadastroJogo extends HttpServlet {

    public static List<Jogo> lista = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // faz a requisição, pega do html o name e joga para as variaveis
        String titulo = request.getParameter("titulo");
        String desenvolvedor = request.getParameter("desenvolvedor");
        String anoLancamento = request.getParameter("ano");
        String genero = request.getParameter("genero");
        String sinopse = request.getParameter("sinopse");
        String idioma = request.getParameter("idioma");
        String plataforma = request.getParameter("plataforma");
        String classificacao = request.getParameter("classificacao");

        Part capaPart = request.getPart("capa");

        String url;

        List<String> listaMensagens = new ArrayList<>();

        if(titulo == null || titulo.isEmpty()){ // verifica se cada campo esta vazio ou nao
            listaMensagens.add("Falta o título");
        }

        if(desenvolvedor == null || desenvolvedor.isEmpty()) {
            listaMensagens.add("Falta o desenvolvedor");
        }

        if(anoLancamento == null || anoLancamento.isEmpty()) {
            listaMensagens.add("Falta o ano");
        }
        if(genero == null || genero.isEmpty()) {
            listaMensagens.add("Falta o gênero");
        }
        if(sinopse == null || sinopse.isEmpty()) {
            listaMensagens.add("Falta a sinopse");
        }
        if(idioma == null || idioma.isEmpty()) {
            listaMensagens.add("Falta o idioma");
        }
        if(plataforma == null || plataforma.isEmpty()) {
            listaMensagens.add("Falta a plataforma");
        }
        if(classificacao == null || classificacao.isEmpty()) {
            listaMensagens.add("Falta a classificação");
        }

        if(capaPart == null || capaPart.getSize() == 0){
            listaMensagens.add("Falta a capa");
        }

        if(!listaMensagens.isEmpty()){
            request.setAttribute("listaMensagens", listaMensagens);
            url = "/cadastroJogo.jsp";

        } else {


            String nomeArquivo = capaPart.getSubmittedFileName();

            if(nomeArquivo.contains("\\")){
                nomeArquivo = nomeArquivo.substring(nomeArquivo.lastIndexOf("\\") + 1);
            }


            nomeArquivo = System.currentTimeMillis() + "_" + nomeArquivo;


            String caminho = getServletContext().getRealPath("/imagens");

            File pasta = new File(caminho);
            if(!pasta.exists()){
                pasta.mkdir();
            }


            capaPart.write(caminho + File.separator + nomeArquivo);


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

            url = "/listarJogo.jsp";
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        lista = new ArrayList<>();
        getServletContext().setAttribute("lista", lista);
    }
}