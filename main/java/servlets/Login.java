package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ArticleDB;
import model.User;
import model.UserDB;
import model.Article;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getSession().invalidate();
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String pw = request.getParameter("pwd");

		User user = UserDB.getUser(login, pw);

		if (user != null) {
			ArrayList<Article> articles = new ArrayList<Article>();

			// HttpSession session = request.getSession();

			request.getSession().setAttribute("user", user);

			articles = ArticleDB.getAllArticles();

			request.setAttribute("articles", articles);

			request.getRequestDispatcher("accueil.jsp").forward(request, response);

		} else {
			request.setAttribute("erreur", 0);
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}

	}

}
