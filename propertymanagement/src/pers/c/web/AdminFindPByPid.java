package pers.c.web;

import pers.c.domain.Proprietor;
import pers.c.service.ProprietorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletAdmin",urlPatterns = "/adminFindPByPid")
public class AdminFindPByPid extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p_id=request.getParameter("p_id");
        System.out.println(p_id);
        ProprietorService service = new ProprietorService();
        try {
            Proprietor proprietor = service.findProprietorById(p_id);
            request.setAttribute("proprietor",proprietor);
            request.getRequestDispatcher("/editor.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
