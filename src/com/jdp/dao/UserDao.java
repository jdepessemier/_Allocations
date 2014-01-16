package com.jdp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdp.model.AllocationData;
import com.jdp.model.Employee;
import com.jdp.model.User;
import com.jdp.util.DbUtil;

public class UserDao {

    private Connection connection;

    public UserDao() {
        connection = DbUtil.getConnection();
    }
    
    public void addEmployee(Employee employee) {
        try {       	
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into employee(employeeDepartment,employeeService,employeeName) values (?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, employee.getEmployeeDepartment());
            preparedStatement.setString(2, employee.getEmployeeService());
            preparedStatement.setString(3, employee.getEmployeeName());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Employee> getAllEmployees() {
    	
        List<Employee> employees = new ArrayList<Employee>();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select Id,EmployeeDepartment,EmployeeService,EmployeeName from employee");
            while (rs.next()) {
            	
                Employee employee = new Employee();
                
                employee.setEmployeeId(rs.getInt("Id"));
                employee.setEmployeeDepartment(rs.getString("EmployeeDepartment"));
                employee.setEmployeeService(rs.getString("EmployeeService"));
                employee.setEmployeeName(rs.getString("EmployeeName"));

                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    public void addUser(User user) {
        try {
        	
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into users(lastname,firstname,email,userlogin,userpwd) values (?, ?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, user.getLastName());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getUserMail());
            preparedStatement.setString(4, user.getUserLogin());
            preparedStatement.setString(5, user.getUserPwd());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from users where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set lastname=?, firstname=?, email=?, userlogin=?, userpwd=?" +
                            "where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, user.getLastName());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getUserMail());
            preparedStatement.setString(4, user.getUserLogin());
            preparedStatement.setString(5, user.getUserPwd());
            preparedStatement.setInt(6, user.getUserId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
    	
        List<User> users = new ArrayList<User>();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select id,firstname,lastname,email,userlogin,userpwd from users");
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("id"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setUserMail(rs.getString("email"));
                user.setUserLogin(rs.getString("userlogin"));
                user.setUserPwd(rs.getString("userpwd"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public User getUserById(int userId) {
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from users where id=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setUserId(rs.getInt("id"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setUserMail(rs.getString("email"));
                user.setUserLogin(rs.getString("userlogin"));
                user.setUserPwd(rs.getString("userpwd"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    
    public User getUserByUserLogin(String userlogin) {
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from users where userlogin=?");
            preparedStatement.setString(1, userlogin);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setUserId(rs.getInt("id"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setUserMail(rs.getString("email"));
                user.setUserLogin(rs.getString("userlogin"));
                user.setUserPwd(rs.getString("userpwd"));
            } else {
                user.setFirstName("---------");
                user.setLastName("---------");
                user.setUserMail("---------");
                user.setUserLogin("---------");
                user.setUserPwd("---------");          	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
 
    public AllocationData getAllocationData(String personfullname, 
		    								String missionname,
		    								String missiontype,
		    								String activityname,
		    								int year,
		    								int month) {
    	
    	AllocationData allocationdata = new AllocationData();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from allocation where personfullname=? AND " +
									                    			"missionname=? AND " +
									                    			"missiontype=? AND "  +
									                    			"activityname=? AND " +
									                    			"year=? AND " +
									                    			"month=?");
            
            preparedStatement.setString(1, personfullname);
            preparedStatement.setString(2, missionname);
            preparedStatement.setString(3, missiontype);
            preparedStatement.setString(4, activityname);
            preparedStatement.setInt(5, year);
            preparedStatement.setInt(6, month);
            
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	allocationdata.setAllocationId(rs.getInt("id"));
            	allocationdata.setPersonFullName(rs.getString("personfullname"));
            	allocationdata.setMissionName(rs.getString("missionname"));
            	allocationdata.setMissionType(rs.getString("missiontype"));
            	allocationdata.setActivityName(rs.getString("activityname"));
            	allocationdata.setYear(rs.getInt("year"));
            	allocationdata.setMonth(rs.getInt("month"));
            	allocationdata.setWorkDays(rs.getDouble("workdays"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	
    	return allocationdata;
    }

    public void addAllocationData(AllocationData allocationdata) {
        try {
        	
            PreparedStatement preparedStatement = connection
            		.prepareStatement("insert into allocation(personfullname,missionname,missiontype,activityname,year,month,workdays) values (?,?,?,?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, allocationdata.getPersonFullName());
            preparedStatement.setString(2, allocationdata.getMissionName());
            preparedStatement.setString(3, allocationdata.getMissionTypee());
            preparedStatement.setString(4, allocationdata.getActivityName());
            preparedStatement.setInt(5, allocationdata.getYear());
            preparedStatement.setInt(6, allocationdata.getMonth());
            preparedStatement.setDouble(7, allocationdata.getWorkDays());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateAllocationData(AllocationData allocationdata) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update allocation set workdays=? where id=?");
            // Parameters start with 1
            preparedStatement.setDouble(1, allocationdata.getWorkDays());
            preparedStatement.setInt(2, allocationdata.getAllocationId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
