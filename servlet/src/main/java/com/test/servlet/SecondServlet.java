package com.test.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.test.data.Livre;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
        
        Livre livre1 = new Livre("L'enfant Noir", "Camara Laye", 2500);
		Livre livre2 = new Livre("Sous l'orage", "Seydou Badian", 1500);
		
		Livre.db.add(livre1);
		Livre.db.add(livre2);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("livres", Livre.db);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/List.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Livre livre = new Livre();
		livre.setTitle(request.getParameter("titre"));
		livre.setAuthor(request.getParameter("auteur"));
		livre.setPrice(Integer.valueOf(request.getParameter("prix")));
		
		Livre.db.add(livre);
		request.setAttribute("livres", Livre.db);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/List.jsp").forward(request, response);
		
	}

}
