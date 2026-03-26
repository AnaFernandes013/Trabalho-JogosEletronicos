package br.edu.ifsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CadastroServlet", value = "/cadastrar_tarefa")
public class CadastroServlet extends HttpServlet {

    public static List<Tarefa> lista = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // code
        throw new RuntimeException();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();

        String nomeTarefa = request.getParameter("nome_tarefa");
        String descricao = request.getParameter("descricao");
        String url = null;

        List<String> listaMensagens = new ArrayList<>();
        if(nomeTarefa.isEmpty()) {
            listaMensagens.add("Falta o nome");
        }
        if(descricao.isEmpty()){
            listaMensagens.add("falta descrição");
        }

        if(!listaMensagens.isEmpty()){
            url = "/Cadastro.jsp";
            request.setAttribute("listaMensagens",listaMensagens);
        }else{
            Tarefa t = new Tarefa(nomeTarefa, descricao);

            Object o = getServletContext().getAttribute("lista");
            if(o instanceof ArrayList) {
                List<Tarefa> lista = (List<Tarefa>) getServletContext().getAttribute("lista");
                lista.add(t);
                getServletContext().setAttribute("lista", lista);
                System.out.println(lista.size());
            }

            request.setAttribute("tarefa", t);
            url = "/listar.jsp"; // "/obrigado.jsp";
        }

        getServletContext().getRequestDispatcher(url).forward(request,response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        lista = new ArrayList<>();
        getServletContext().setAttribute("lista", lista);
    }
}