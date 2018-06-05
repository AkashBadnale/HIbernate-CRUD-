package com.ab.test;

import java.util.Scanner;

import com.ab.dao.EmployeeDAO;
import com.ab.domain.Employee;

public class Test {
   
	public static void main(String[] args) {
		
		EmployeeDAO empDao = new EmployeeDAO();
		
		Scanner input = new Scanner (System.in);
		
		int option = 0;
		
		Employee emp = new Employee();
		
		int id = 0;
		String name = null, department = null;
		String updatedName = null, updatedDepartment = null;
		
		System.out.println(" please choose one of the option from the following ");
		System.out.println("1. insert an employee information");
		System.out.println("2. Update an employee information");
		System.out.println("3. view all employees information");
		System.out.println("4. view information of specific employee");
		System.out.println("5. delete employees information");
		
		option = input.nextInt();
		
		switch (option)
		{
		    case 1:  System.out.println("Enter id");
		                id = input.nextInt();
		             System.out.println("Enter Name");
		                name = input.next();
		             System.out.println("Enter department");
		               department = input.next();
		               
		             emp.setId(id);
		             emp.setName(name);
		             emp.setDepartment(department);
		             
		             empDao.addEmployee(emp);
		             
		             System.out.println(" Records inserted successfully ");
		             
		             break;
		             
		    case 2:  System.out.println(" provide the updated / same name");
		                updatedName = input.next();
		             System.out.println(" provide the updated / name department");
		                updatedDepartment = input.next();
		             System.out.println(" provide the id of employee whose information you want to update ");
		                id = input.nextInt();
		                
		             emp.setName(updatedName);
		             emp.setDepartment(updatedDepartment);
		             emp.setId(id);
		             
		             empDao.updateEmployee(emp);
		             
		             System.out.println(" Records updated successfully");
		             
		             break;
		             
		    case 3: for (Employee allEmp : empDao.getAllEmployees()) {
	                    System.out.println(allEmp.getId()+"  "+allEmp.getName()+"  "+allEmp.getDepartment());
	                }
		                
		            break;
		            
		    case 4: System.out.println(" provide the employee's id whose information you want to see ");
		               id = input.nextInt();
		               
		             Employee aEmp = empDao.getEmployeeById(id);
		             
		             System.out.println(aEmp.getId()+"  "+aEmp.getName()+"  "+aEmp.getDepartment());
		             
		            break;
		            
		    case 5: System.out.println(" provide employee's id whose information you want to delete ");
		              id = input.nextInt();
		              
		            empDao.deleteEmployee(id);
		            
		            System.out.println(" Record deleted successfully ");
		            
		            break;
		               
		}//switch
		
          
	}//main
}//Test
