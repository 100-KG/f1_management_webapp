package com.f1management.servlet;

import com.f1management.dao.*;
import com.f1management.model.Result;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/doupdate") 
public class DoUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        if (action == null) action = "load";

        GPinSeasonDAO gpDAO   = new GPinSeasonDAO();
        ResultDAO resultDAO   = new ResultDAO();
        ContractDAO contractDAO = new ContractDAO();

        if (action.equals("load")) {

            String selectedGP = request.getParameter("selectedGP");

            session.setAttribute("currentGP", gpDAO.getCurrentGP());  
            session.setAttribute("ResultList", resultDAO.getGPResult(selectedGP));  

            response.sendRedirect("views/UpdateResult.jsp");
            return;
        }

        if (action.equals("save")) {

            List<Result> results = (List<Result>) session.getAttribute("ResultList");

            for (int i = 0; i < results.size(); i++) {
                Result r = results.get(i);

                r.setPoint(Integer.parseInt(request.getParameter("point_" + i)));
                r.setTime(request.getParameter("time_" + i));
                r.setLapFinished(Integer.parseInt(request.getParameter("laps_" + i)));
            }

            boolean success = resultDAO.updateResult(results);

            if (success) {
                session.setAttribute("ResultSaved", "Update successful!");
            } else {
                session.setAttribute("ResultSaved", "Update FAILED!");
            }

            response.sendRedirect("views/UpdateResult.jsp");
        }
    }
}
