package com.f1management.servlet;

import com.f1management.dao.*;
import com.f1management.model.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/doupdate")
public class DoUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        GPinSeasonDAO gpdao = new GPinSeasonDAO();
        session.setAttribute("currentGP", gpdao.getCurrentGP());


        session.removeAttribute("ResultList");
        session.removeAttribute("selectedGP");

        System.out.println("Loaded GP List Successfully");

        response.sendRedirect("views/UpdateResult.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        String gpId = request.getParameter("selectedGP");

        ResultDAO rdao = new ResultDAO();

        if (gpId != null && !"save".equals(action)) {

            Result[] results = rdao.getGPResult(gpId);

            session.setAttribute("currentResult", results);
            session.setAttribute("selectedGP", gpId);

            System.out.println("Loaded Result for GP = " + gpId);
            response.sendRedirect("views/UpdateResult.jsp");
            return;
        }

        if ("save".equals(action)) {

            Result[] rs = (Result[]) session.getAttribute("currentResult");
            if (rs == null) {
                response.sendRedirect("views/UpdateResult.jsp");
                return;
            }

            for (int i = 0; i < rs.length; i++) {
                rs[i].setPoint(Integer.parseInt(request.getParameter("point_" + i)));
                rs[i].setTime(request.getParameter("time_" + i));
                rs[i].setLapFinished(Integer.parseInt(request.getParameter("laps_" + i)));
                rs[i].setPosition(Integer.parseInt(request.getParameter("pos_" + i)));
            }

            boolean ok = rdao.updateResult(rs);

            request.setAttribute("msg", ok ? "Updated Successfully" : "Update Failed");

            System.out.println(ok ? "RESULT UPDATE SUCCESS" : "RESULT UPDATE FAILED");

            request.getRequestDispatcher("views/UpdateResult.jsp").forward(request, response);
        }
    }
}
