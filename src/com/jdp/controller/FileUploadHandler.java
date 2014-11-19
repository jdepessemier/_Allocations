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
import com.jdp.model.AllocationData;
import com.jdp.model.Employee;
import com.jdp.model.SnapshotData;
import com.jdp.util.StringUtil;


public class FileUploadHandler extends HttpServlet {
	
    private UserDao dao;
    
    private static int CURRENT_YEAR = 2014;
    
    public FileUploadHandler() {
        super();
        dao = new UserDao();
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
        String action = request.getParameter("action");
        
        
        if (action.equalsIgnoreCase("uploadSnaphot")){
        	
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
    	            	
    	            	List<String> itemList = getItemsOfLine(line,22);
    	            	
    	                String CAProjet = itemList.get(0).toUpperCase();
    	                CAProjet = StringUtil.trimLeft(CAProjet);
    	                CAProjet = StringUtil.trimRight(CAProjet);
    	                
    	                String LibelleProjet = itemList.get(1).toUpperCase();
    	                LibelleProjet = StringUtil.trimLeft(LibelleProjet);
    	                LibelleProjet = StringUtil.trimRight(LibelleProjet);
    	                
    	                String Director = itemList.get(2).toUpperCase();
    	                Director = StringUtil.trimLeft(Director);
    	                Director = StringUtil.trimRight(Director);

    	                String ProjectManager = itemList.get(3).toUpperCase();
    	                ProjectManager = StringUtil.trimLeft(ProjectManager);
    	                ProjectManager = StringUtil.trimRight(ProjectManager);    	                
    	                
    	                String yearValue = itemList.get(4);
    	                yearValue = StringUtil.trimLeft(yearValue);
    	                yearValue = StringUtil.trimRight(yearValue);
    	                int year = Integer.parseInt(yearValue); 
    	                   	                
    	                String TypeInput = itemList.get(11).toUpperCase();
    	                TypeInput = StringUtil.trimLeft(TypeInput);
    	                TypeInput = StringUtil.trimRight(TypeInput);
    	                
    	                String DocumentNb = itemList.get(14).toUpperCase();
    	                DocumentNb = StringUtil.trimLeft(DocumentNb);
    	                DocumentNb = StringUtil.trimRight(DocumentNb);
    	                
    	                String Date = itemList.get(15).toUpperCase();
    	                Date = StringUtil.trimLeft(Date);
    	                Date = StringUtil.trimRight(Date);
    	                
    	                String Comment = itemList.get(16).toUpperCase();
    	                Comment = StringUtil.trimLeft(Comment);
    	                Comment = StringUtil.trimRight(Comment);  	                
    	                    	                
    	                double Montant = round(Double.valueOf(itemList.get(18).replace(",", ".")),2);
    	                
   	                	  	                	             
    		            SnapshotData newSnapshotData = new SnapshotData(CAProjet,
    		            										        LibelleProjet,
    		            										        Director,
    		            										        ProjectManager,
    		            										        year,
    		            										        TypeInput,
    		            										        DocumentNb,
    		            										        Comment,
    		            										        Date,
    		            										        Montant);
    		                  	
    		            dao.addSnapshotData(newSnapshotData);
    		            
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
    	            	
    	            	List<String> itemList = getItemsOfLine(line,3);
    	            	
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
        
        if (action.equalsIgnoreCase("uploadAllocations")){
        	
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
    	            	
    	            	List<String> itemList = getItemsOfLine(line,6);
    	            	
    	                String personFullName = itemList.get(0).toUpperCase();
    	                personFullName = StringUtil.trimLeft(personFullName);
    	                personFullName = StringUtil.trimRight(personFullName);
    	                
    	                String yearValue = itemList.get(1);
    	                yearValue = StringUtil.trimLeft(yearValue);
    	                yearValue = StringUtil.trimRight(yearValue);
    	                int year = Integer.parseInt(yearValue); 
    	                
    	                String monthValue = itemList.get(2);
    	                monthValue = StringUtil.trimLeft(monthValue);
    	                monthValue = StringUtil.trimRight(monthValue);
    	                int month = Integer.parseInt(monthValue);
    	                
    	                String missionType = itemList.get(3).toUpperCase();
    	                personFullName = StringUtil.trimLeft(personFullName);
    	                personFullName = StringUtil.trimRight(personFullName);
    	                
    	                
    	                String missionName = itemList.get(4).toUpperCase();
    	                missionName = StringUtil.trimLeft(missionName);
    	                missionName = StringUtil.trimRight(missionName); 
    	                
    	                String activityName = itemList.get(5).toUpperCase();
    	                activityName = StringUtil.trimLeft(activityName);
    	                activityName = StringUtil.trimRight(activityName); 
    	                
    	                double workDays = round(Double.valueOf(itemList.get(6).replace(",", ".")),2);
    	                
    	                if (activityName.equalsIgnoreCase("TOTAL")){
    	                	activityName = "Projets";
    	                }

    	                if (activityName.equalsIgnoreCase("ABSENCE")){
    	                	activityName = "Congés & Absences";
    	                }
    	                
    	                if (activityName.equalsIgnoreCase("OTHERS")){
    	                	activityName = "Activités Hors Projets";
    	                }
    	                
    	                if (activityName.equalsIgnoreCase("FORMATIONS")){
    	                	activityName = "Formations";
    	                }
    	                
    	                if (year == CURRENT_YEAR) {
    	                	  	                	             
    		                AllocationData newAllocationData = new AllocationData();
    		                
    		                newAllocationData = dao.getAllocationData(personFullName, 
    		                										  missionName,
    		                										  missionType,
    		                										  activityName,
    		                										  year,
    		                										  month);
    		                
    		                if (!newAllocationData.getPersonFullName().isEmpty()) {
    		                	
    		                	newAllocationData.setWorkDays(workDays);
    		                	dao.updateAllocationData(newAllocationData);
    		                	
    		                } else {		                	
    		                	
    		                	newAllocationData.setPersonFullName(personFullName);
    		                	newAllocationData.setMissionName(missionName);
    		                	newAllocationData.setMissionType(missionType);
    		                	newAllocationData.setActivityName(activityName);
    		                	newAllocationData.setYear(year);
    		                	newAllocationData.setMonth(month);
    		                	newAllocationData.setWorkDays(workDays);        	
    		                	dao.addAllocationData(newAllocationData);
    		                }	               
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
   
   private List<String> getItemsOfLine(String line, int nbOfItems ) {
   	
       List<String> itemList = new ArrayList<String>();
       for (int i = 0; i < nbOfItems; i++) {
           int pointIndex = line.indexOf(";");
           String item = line.substring(0, pointIndex);
           itemList.add(item);
           line = line.substring(pointIndex + 1);
       }
       itemList.add(line);
       return itemList;
   }
   
   public double round(double what, int howmuch) {
   	return (double)( (int)(what * Math.pow(10,howmuch) + .5) ) / Math.pow(10,howmuch);
   }
   
}
