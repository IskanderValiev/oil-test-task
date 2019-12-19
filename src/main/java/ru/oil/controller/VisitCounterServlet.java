package ru.oil.controller;

import ru.oil.service.VisitsCounterService;
import ru.oil.service.VisitsCounterServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Iskander Valiev
 * created by isko
 * on 12/19/19
 */
@WebServlet("/")
public class VisitCounterServlet extends HttpServlet {

    private VisitsCounterService counterService;

    @Override
    public void init() throws ServletException {
        counterService = new VisitsCounterServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        counterService.updateVisitsCount();
        req.setAttribute("visitsCount", counterService.getVisitsCount());
        getServletContext().getRequestDispatcher("/counter_view.jsp").forward(req, resp);
    }
}
