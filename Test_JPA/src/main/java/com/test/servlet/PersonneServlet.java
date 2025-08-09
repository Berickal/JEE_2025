package com.test.servlet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.test.entities.Personne;

/**
 * Servlet implementation class Personne
 */
@WebServlet("/Personne")
public class PersonneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test_JPA");
		EntityManager em = emf.createEntityManager();
		
		String id = request.getParameter("id");
		if(id != null) {
			Personne targetPersonne = em.find(Personne.class, Integer.valueOf(id));
			request.setAttribute("target", targetPersonne);
		}
		
		
		List<Personne> personnes = em.createQuery("SELECT p FROM Personne p", Personne.class).getResultList();
		
		request.setAttribute("personnes", personnes);
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/Personne.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test_JPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		int id = Integer.valueOf(request.getParameter("id"));
		if(id != -1) {
			Personne targetPersonne = em.find(Personne.class, Integer.valueOf(id));
			targetPersonne.setNom(request.getParameter("nom"));
			targetPersonne.setPrenom(request.getParameter("prenom"));
			targetPersonne.setEmail(request.getParameter("email"));
			em.flush();
		} 
		else {
			Personne personne = new Personne(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("email"));
			em.persist(personne);
		}
		
		tr.commit();
		em.close();
		emf.close();
		
		doGet(request, response);
	}

}
