package br.edu.ifsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CadastroUsuario", value = "/cadastrar_usuario")
public class CadastroUsuario extends HttpServlet {

    public static List<Usuario> listaUsuarios = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String usuario =  request.getParameter("usuario");
        String email =  request.getParameter("email");
        String senha =  request.getParameter("senha");

        Usuario novoUsuario = new Usuario(usuario, email, senha);

        listaUsuarios.add(novoUsuario);
    }

    @Override
    public void init() throws ServletException {
        // cria a lista
        listaUsuarios = new ArrayList<>();
        // disponibiliza ela para todos
        getServletContext().setAttribute("listaUsuarios", listaUsuarios);

    }
}

