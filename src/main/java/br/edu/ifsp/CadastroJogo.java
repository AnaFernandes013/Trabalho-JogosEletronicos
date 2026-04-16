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

        // No doGet ou doPost, antes de fazer qualquer operação com a resposta:
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

// Se estiver recebendo dados via requisição, também defina a codificação:
        request.setCharacterEncoding("UTF-8");

        HttpSession sessao = request.getSession();

        if (sessao.getAttribute("usuarioLogado") == null) {
            response.sendRedirect("erro.jsp");
            return;
        }

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

        boolean temErro = false;

        if (titulo == null || titulo.isEmpty()) { // verifica se cada campo esta vazio ou nao
            request.setAttribute("erroTitulo", "Informe o titulo");
            temErro = true;
        }

        if (desenvolvedor == null || desenvolvedor.isEmpty()) {
            request.setAttribute("erroDesenvolvedor", "Informe o desenvolvedor");
            temErro = true;
        }

        if (anoLancamento == null || anoLancamento.isEmpty()) {
            request.setAttribute("erroAno", "Informe o ano de lançamento");
            temErro = true;
        }
        if (genero == null || genero.isEmpty()) {
            request.setAttribute("erroGenero", "Informe o genero");
            temErro = true;
        }
        if (sinopse == null || sinopse.isEmpty()) {
            request.setAttribute("erroSinopse", "Informe a sinopse");
            temErro = true;
        }
        if (idioma == null || idioma.isEmpty()) {
            request.setAttribute("erroIdioma", "Informe o idioma");
            temErro = true;
        }
        if (plataforma == null || plataforma.isEmpty()) {
            request.setAttribute("erroPlataforma", "Informe a plataforma");
            temErro = true;
        }
        if (classificacao == null || classificacao.isEmpty()) {
            request.setAttribute("erroClassificacao", "Informe a classificação");
            temErro = true;
        }

        if (capaPart == null || capaPart.getSize() == 0) {
            request.setAttribute("erroCapa", "Informe a capa");
            temErro = true;
        }

        if (temErro) {
            request.getRequestDispatcher("/cadastroJogo.jsp").forward(request, response);
            return;
        } else {

            //salva a imagem
            String nomeArquivo = capaPart.getSubmittedFileName();

            if (nomeArquivo.contains("\\")) { //remove o caminho do arquivo
                nomeArquivo = nomeArquivo.substring(nomeArquivo.lastIndexOf("\\") + 1);
            }

            // cria um novo nome pra nao dar erro
            nomeArquivo = System.currentTimeMillis() + "_" + nomeArquivo;

            // caminho da pasta imagens
            String caminho = getServletContext().getRealPath("/imagens");

            File pasta = new File(caminho); // cria a pasta se nao existir
            if (!pasta.exists()) {
                pasta.mkdir();
            }

            // junta tudo
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

            List<Jogo> lista = (List<Jogo>) getServletContext().getAttribute("lista"); // pega todos os cadastrados

            if (lista == null) { // se for o primeiro cadastrado ele cria a lista e salva
                lista = new ArrayList<>();
                getServletContext().setAttribute("lista", lista);
            }
            lista.add(j);

            request.setAttribute("msgSucessoJogo", "Jogo cadastrado com sucesso!");
            url = "/listarJogo.jsp";
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
  @Override
    public void init() throws ServletException {

        lista = new ArrayList<>();
        getServletContext().setAttribute("lista", lista); // ajuda a nao precisar ficar criando a lista toda vez


    }

}