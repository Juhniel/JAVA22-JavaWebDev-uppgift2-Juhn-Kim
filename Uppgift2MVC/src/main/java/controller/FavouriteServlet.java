package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.User;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "FavouriteServlet", value = "/favourite")
public class FavouriteServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String favouriteMovie = request.getParameter("favouriteMovie");

        if (favouriteMovie.isEmpty()) {
            request.setAttribute("error", "Please enter a favourite movie of yours.");
            doPost(request, response);
        }else {
            request.setAttribute("favouriteMovie", "Your favourite movie is: " + favouriteMovie);
            doPost(request, response);
            }
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/view/admin.jsp").forward(request, response);
    }
}
