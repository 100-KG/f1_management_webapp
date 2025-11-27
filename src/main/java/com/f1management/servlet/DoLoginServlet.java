package com.f1management.servlet;

import com.f1management.dao.MemberDAO;
import com.f1management.dao.StaffDAO;
import com.f1management.model.Member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/dologin")
public class DoLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String action   = request.getParameter("action");

        if ("viewRanking".equals(action)) {
            response.sendRedirect("views/ViewRanking.jsp");
            return;
        }

        Member m = new Member();
        m.setUsername(username);
        m.setPassword(password);

        MemberDAO memberDAO = new MemberDAO();
        boolean success = memberDAO.checkLogin(m);
        
        if (success) {
            System.out.println("Access granted for user: " + username);
            StaffDAO staffDAO = new StaffDAO();
            Member staff = staffDAO.getStaffInfo(m);

            HttpSession session = request.getSession();
            session.setAttribute("member", m);
            session.setAttribute("staff", staff);

            response.sendRedirect("views/StaffHome.jsp");
        } else {
            request.setAttribute("loginError", "Invalid username or password!");
            System.out.println("Invalid access for user: " + username);
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        }
    }
}
