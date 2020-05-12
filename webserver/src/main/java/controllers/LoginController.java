package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import ubbproject.domain.MyUser;
import ubbproject.service.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {

    @Autowired
    private MemberService memberService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher rd = null;

        MyUser result = this.memberService.login(username, password);
        System.out.println(result);

        if (result != null) {
            System.out.println("not null");
            rd = request.getRequestDispatcher("/main.jsp");
            HttpSession session = request.getSession();
            session.setAttribute("user", result);
            rd.forward(request, response);
        } else {
            response.setHeader("error", "Invalid username or password!");
        }
    }
}
