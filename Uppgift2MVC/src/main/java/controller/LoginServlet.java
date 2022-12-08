package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.User;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    User admin = new User("admin", "admin", false);
    User bob = new User("bob", "bob", false);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("online") != null) {
                getServletContext().getRequestDispatcher("/view/admin.jsp").forward(request, response);
            } else if(request.getSession().getAttribute("online") == null){
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String userPassword = request.getParameter("password");
        HttpSession session;
        boolean isUserOne = userName.equals(admin.getUserName()) && userPassword.equals(admin.getUserPassword());
        boolean isUserTwo = userName.equals(bob.getUserName()) && userPassword.equals(bob.getUserPassword());

        if (userName.isEmpty()) {
            request.setAttribute("error", "A username was not provided.");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

        } else if (userPassword.isEmpty()) {
            request.setAttribute("error", "A password was not provided.");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

        } else if (isUserOne || isUserTwo) {
            session = request.getSession();
            session.setAttribute("online", new User(userName,userPassword,true));
            session.setMaxInactiveInterval(50);
            RequestDispatcher rd = request.getRequestDispatcher("/view/admin.jsp");
            rd.forward(request, response);
        }else {
            request.setAttribute("error", "wrong password or username");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

        }

    }
}
