package net.javaguides.registeration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.registeration.dao.EmployeeDao;
import net.javaguides.registeration.model.Employee;

import java.io.IOException;

@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public EmployeeServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Views/employeeregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");

		Employee employee = new Employee();
		EmployeeDao employeeDao = new EmployeeDao();

		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setUsername(username);
		employee.setPassword(password);
		employee.setAddress(address);
		employee.setContact(contact);

		try {
			employeeDao.registerEmployee(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Views/employeedetails.jsp");
		dispatcher.forward(request, response);
	}

}
