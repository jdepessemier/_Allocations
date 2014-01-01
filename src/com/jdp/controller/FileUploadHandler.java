package com.jdp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.jdp.dao.UserDao;
import com.jdp.model.Employee;
import com.jdp.util.StringUtil;


public class FileUploadHandler extends HttpServlet {
	
    private UserDao dao;
    
    public FileUploadHandler() {
        super();
        dao = new UserDao();
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
        String action = request.getParameter("action"); 
        
        if (action.equalsIgnoreCase("uploadEmployees")){
        	
    		ServletFileUpload upload = new ServletFileUpload();
    		
    		try {
    			FileItemIterator it = upload.getItemIterator(request);
    			FileItemStream item = it.next();

    	        InputStream stream = item.openStream();
    	        
    	        try {
    	            InputStreamReader inputStreamReader = new InputStreamReader(stream, "ISO-8859-1");
    	            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    	            bufferedReader.readLine();
    	            String line;

    	            while ((line = bufferedReader.readLine()).charAt(0) != ';') {
    	            	
    	            	List<String> itemList = getItemsOfLine(line);
    	            	
    	                String employeeDpt = itemList.get(0);
    	                employeeDpt = StringUtil.trimLeft(employeeDpt);
    	                employeeDpt = StringUtil.trimRight(employeeDpt);
    	                
    	                String employeeSvc = itemList.get(1);
    	                employeeSvc = StringUtil.trimLeft(employeeSvc);
    	                employeeSvc = StringUtil.trimRight(employeeSvc);
    	                
    	                String employeeNme = itemList.get(2).toUpperCase();
    	                employeeNme = StringUtil.trimLeft(employeeNme);
    	                employeeNme = StringUtil.trimRight(employeeNme);
    	                
    	                if (employeeSvc.equals("Svc. IS")|employeeSvc.equals("Svc. WAP") ) {
    	                
    		                Employee newEmployee = new Employee();
    		                
    		                newEmployee.setEmployeeDepartment(employeeDpt);
    		                newEmployee.setEmployeeService(employeeSvc);
    		                newEmployee.setEmployeeName(employeeNme);
    		                
    		                dao.addEmployee(newEmployee);
    	               
    	                }
    	            }
    	        } finally {
    	            stream.close();
    	            request.getRequestDispatcher("/UserController?action=listUser").forward(request, response);
    	        }
    	        
    		} catch (IOException e) {
    			e.printStackTrace();
    		} catch (FileUploadException e) {
    			e.printStackTrace();
    		} 		
    		
        }
	   
   }
   
   private List<String> getItemsOfLine(String line) {
   	
       List<String> itemList = new ArrayList<String>();
       for (int i = 0; i < 3; i++) {
           int pointIndex = line.indexOf(";");
           String item = line.substring(0, pointIndex);
           itemList.add(item);
           line = line.substring(pointIndex + 1);
       }
       itemList.add(line);
       return itemList;
   }
}
