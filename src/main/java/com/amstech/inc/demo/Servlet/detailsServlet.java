package com.amstech.inc.demo.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amstech.inc.demo.DAO.UserDAO;
import com.amstech.inc.demo.DTO.UserDTO;

/**
 * Servlet implementation class detailsServlet
 * @param <Int>
 */
@WebServlet("/detailsServlet")
public class detailsServlet<Int> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public detailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		String task = request.getParameter("task");
		service(task, request, response);
	}

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String task = request.getParameter("task");
		service(task, request, response);
	}
    
    
    
    private void service(String task, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Task : " + task);
		
		if(task == null){
			System.out.println("No task found");
		}
		
		if(task.equalsIgnoreCase("login")){
			System.out.println("Login");
			login(request,response);
			
		}else 
			if(task.equalsIgnoreCase("signup")){
			System.out.println("Signup");
			save(request,response);
			
		}else 
			if (task.equalsIgnoreCase("delete")){
			
			System.out.println("Delete");
			delete(task, request, response);
		}else 
			if (task.equalsIgnoreCase("findall")) {
			System.out.println("findAll");
			findAll(task,request, response);
			
		}else if (task.equalsIgnoreCase("findById")){
			System.out.println("findById");
			findById(task,request, response);
		}else{
			System.out.println("Task not found");
		}
	}
    
    
    
    private void findById(String task, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void save(HttpServletRequest request, HttpServletResponse response) {
		try {

			System.out.println("POST");
			
			String firstname = request.getParameter("firstName");
			String lastname = request.getParameter("lastName");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			System.out.println("Data Get");
			
			
			UserDTO userDTO = new UserDTO();
			
		
			userDTO.setFirstName(firstname);
			userDTO.setLastName(lastname);
			userDTO.setEmail(email);
			userDTO.setPassword(password);
			
			System.out.println("Data set");
			
			int save = UserDAO.save(userDTO);
			System.out.println("count : " + save);
			String message = "";

			if (save != 0) {

				System.out.println("Data save successfully");
				message = "Data save successfully";
			} else {
				System.out.println("Data save failed");
				message = "Data save failed";

			}

			PrintWriter writer = response.getWriter();
			writer.append("<html><body onload='myFunction()'><script>function myFunction(){alert('" + message
					+ "');}</script></body></html>");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.include(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	
	private void login(HttpServletRequest request, HttpServletResponse response) {
		try{
			System.out.println("POST");
			
			PrintWriter writer = response.getWriter();
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			UserDTO userDTO = UserDAO.findByEmailPassword1(email, password);
			
			if (userDTO != null){
				System.out.println("useDTO : " + userDTO.toString());
				
				request.setAttribute("userDTO", userDTO);
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
				requestDispatcher.forward(request, response); 
			}else {
				
				System.out.println("User not Exist");
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
	}
	
	
	private void delete(String task, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(task);
		
		try{
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			UserDTO userDTO = UserDAO.findByEmailPassword1(email, password);
			
			int id = userDTO.getId();
			int count = UserDAO.deleteById(2);
			
			if(count != 0){
				System.out.println("User deleted successfuly");
			}else{
				
				System.out.println("Failed to delete ");
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	
	private void findAll(String task, HttpServletRequest request, HttpServletResponse response){
		System.out.println(task);
		
		try {
			List<UserDTO> userDTO  = UserDAO.findAll();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
