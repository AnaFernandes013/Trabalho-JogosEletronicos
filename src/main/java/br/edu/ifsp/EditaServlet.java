package br.edu.ifsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EditaServlet", value = "/editar_tarefa")
public class EditaServlet extends HttpServlet {

   // public static List<Tarefa> lista = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // code
        throw new RuntimeException();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        List<Tarefa> lista = (List<Tarefa>) getServletContext().getAttribute("lista");
        Tarefa tarefaEncontrada =null;

        for (int i = 0; i < lista.size(); i++) {
            Tarefa t = lista.get(i);

            if (String.valueOf(t.getId()).equals(id)) {
              tarefaEncontrada = t;
            }
        }

        request.setAttribute("tarefa", tarefaEncontrada);
        request.getRequestDispatcher("/editar.jsp").forward(request, response);
    }
}
