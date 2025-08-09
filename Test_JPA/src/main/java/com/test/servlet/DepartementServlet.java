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

import com.test.entities.Departement;
import com.test.entities.Personne;

/**
 * Servlet implementation class Departement
 */
@WebServlet("/Departement")
public class DepartementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test_JPA");
		EntityManager em = emf.createEntityManager();
		
		Departement targetDp = new Departement();
		String addEmploye = request.getParameter("add");
		String idDp = request.getParameter("id");
		
		if(idDp != null) {
			targetDp = em.find(Departement.class, Integer.valueOf(idDp));
			request.setAttribute("target", targetDp);
		}
		
		if(addEmploye != null && idDp != null) {
			EntityTransaction tr = em.getTransaction();
			
			tr.begin();
			Personne targetPersonne = em.find(Personne.class, Integer.valueOf(addEmploye));
			
			List<Personne> dpEmploye = targetDp.getEmployes();
			dpEmploye.add(targetPersonne);
			targetDp.setEmployes(dpEmploye);
			
			em.flush();
			tr.commit();
		}
		
		
		List<Personne> personnes = em.createQuery("SELECT p FROM Personne p", Personne.class).getResultList();
		List<Departement> departement = em.createQuery("SELECT d FROM Departement d", Departement.class).getResultList();
		
		em.close();
		emf.close();
		
		request.setAttribute("personnes", personnes);
		request.setAttribute("departement", departement);
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/Departement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test_JPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		
		tr.begin();
		Departement dp = new Departement();
		dp.setNom(request.getParameter("nom"));
		
		em.persist(dp);
		tr.commit();
		
		em.close();
		emf.close();
		
		doGet(request, response);
	}

}
