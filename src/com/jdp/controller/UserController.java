package com.jdp.controller;

import java.io.IOException;
import java.util.List;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdp.dao.UserDao;
import com.jdp.model.Employee;
import com.jdp.model.User;

public class UserController extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    
    private static String WELCOME = "/Welcome.jsp";
    private static String ERROR = "/Error.jsp";
    private static String SUCCESS = "/Success.jsp";
    
    private UserDao dao;

    public UserController() {
        super();
        dao = new UserDao();
    }

     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        String forward="";
        String action = request.getParameter("action");       
            
        if (action.equalsIgnoreCase("login")){
            
            if (request.getParameter("userlogin").isEmpty()) {
            	
            	forward = ERROR;
            	
            } else {
            	
            	User myUser = new User();
            	
                myUser.setUserLogin(request.getParameter("userlogin"));
                myUser.setUserPwd(request.getParameter("userpwd"));
                        	
                User user =  dao.getUserByUserLogin(request.getParameter("userlogin"));
                
                if (myUser.getUserPwd().equals(user.getUserPwd())) {                	
                	forward = SUCCESS;
                } else {
                	forward = ERROR;
                }          		
            }
        } else if (action.equalsIgnoreCase("register")){
        	
        	User user = new User();
            
            user.setLastName(request.getParameter("lastname"));
            user.setFirstName(request.getParameter("firstname"));
            user.setUserMail(request.getParameter("usermail"));
            user.setUserLogin(request.getParameter("userlogin"));
            user.setUserPwd(request.getParameter("userpwd"));
            
            dao.addUser(user);
            
            forward = WELCOME;
            
        } else if (action.equalsIgnoreCase("listUser")){
        	
        	List<User> usersList = dao.getAllUsers();
            
    	    forward =  "/New.jsp";

    	    request.setAttribute("users", usersList);
    	    
        } else if (action.equalsIgnoreCase("listEmployee")){
        	      	
        	List<Employee> employeesList = dao.getAllEmployees();
        	           
    	    forward =  "/New1.jsp";

    	    request.setAttribute("employees", employeesList);
    	    
        } else {
        	
            forward = ERROR;
        }
        
    	RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }
}