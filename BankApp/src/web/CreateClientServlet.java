package web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Client;
import service.BankServiceLocal;

@WebServlet("/CreateClientServlet")
public class CreateClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	BankServiceLocal bank;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String address = request.getParameter("address");
		String name = request.getParameter("name");
		
		Client client = new Client();
		client.setName(name);
		client.setAddress(address);

		String result = null;

		try {
			bank.createClient(client);
			result = "Client successfully created with id "
					+ client.getClientid();
		} catch (Exception e) {
			e.printStackTrace();
			result = "Client could not be created: " + e.getMessage();
		}

		request.setAttribute("resultOfClientCreation", result);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}