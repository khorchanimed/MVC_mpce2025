package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.ArticleDB;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/articles")
public class Article extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("id"));
		ArrayList<model.Article> articles = new ArrayList<model.Article>();

		switch (action) {
		case "supp":

			ArticleDB.supprimerArticle(id);

			articles = ArticleDB.getAllArticles();

			request.setAttribute("articles", articles);

			request.getRequestDispatcher("accueil.jsp").forward(request, response);break ; 

		case "modifier":

			model.Article art = ArticleDB.getArticleById(id);

			request.setAttribute("article", art);

			request.getRequestDispatcher("modifier.jsp").forward(request, response);

			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		ArrayList<model.Article> articles = new ArrayList<model.Article>();

		switch (action) {
		case "ajouter":

			String nom = request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));

			model.Article art = new model.Article(nom, prix);

			ArticleDB.ajouterArticle(art);

			articles = ArticleDB.getAllArticles();

			request.setAttribute("articles", articles);

			request.getRequestDispatcher("accueil.jsp").forward(request, response);
			break ; 

		case "modifier":

			int id = Integer.parseInt(request.getParameter("id"));
			String nomMod = request.getParameter("nom");
			double prixMod = Double.parseDouble(request.getParameter("prix"));

			model.Article article = new model.Article(id, nomMod, prixMod);

			ArticleDB.updateArticle(article);

			articles = ArticleDB.getAllArticles();

			request.setAttribute("articles", articles);

			request.getRequestDispatcher("accueil.jsp").forward(request, response);

			break;
		
		}

	}

}
