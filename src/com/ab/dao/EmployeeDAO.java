package com.ab.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ab.domain.Employee;
import com.ab.util.HibernateUtil;

public class EmployeeDAO {
   
	
	//  insert a new employees details
    public void addEmployee(Employee employee) {
           
    	 Transaction tx = null;
           
    	 Session session = HibernateUtil.getSessionFactory().openSession();
           
    	 try 
    	 {
               tx = session.beginTransaction();
               session.save(employee);
               session.getTransaction().commit();
         }
    	 catch (RuntimeException e) 
    	 {
               if (tx != null) {
                   tx.rollback();
         }
               e.printStackTrace();
         } 
    	 finally 
    	 {
               session.flush();
               session.close();
         }
       }//addEmployee
    
    //  read all employees information
   @SuppressWarnings("unchecked")
   public List<Employee> getAllEmployees() {
           
	   Transaction tx = null;
	   List<Employee> employees = new ArrayList<>();
           
	   Session session = HibernateUtil.getSessionFactory().openSession();
           
	   try 
	   {    tx = session.beginTransaction();
            employees = session.createQuery("from Employee").getResultList();
       } 
	   catch (RuntimeException e) 
	   {
		   if (tx != null) {
               tx.rollback();
           }
            e.printStackTrace();
       } 
	   finally 
	   {
               session.flush();
               session.close();
       }
      return employees;
    }//getAllEmployees

   // read information of particular employee
    public Employee getEmployeeById(int employeeId) {
           Transaction tx = null;
    	   Employee employee = null;
           
    	   Session session = HibernateUtil.getSessionFactory().openSession();
    	   tx = session.beginTransaction();
    	   try 
    	   {
               String hqlQuery = "from Employee where id = :id";
              
               @SuppressWarnings("rawtypes")
			  Query query = session.createQuery(hqlQuery);
               query.setParameter("id", employeeId);
               employee = (Employee) query.getSingleResult();
           } 
    	   catch (RuntimeException e) 
    	   {
               e.printStackTrace();
           } 
    	   finally 
    	   {
               session.flush();
               session.close();
           }
         return employee;
       }//getEmployeeById
      
     //Update a particular employees information
       public void updateEmployee(Employee employee) {
           
    	   Transaction tx = null;
           
    	   Session session = HibernateUtil.getSessionFactory().openSession();
           
    	   try 
    	   {
               tx = session.beginTransaction();
               session.update(employee);
               session.getTransaction().commit();
           } 
    	   catch (RuntimeException e) 
    	   {
               if (tx != null) 
                   tx.rollback();
               
               e.printStackTrace();
           } 
    	   finally 
    	   {
               session.flush();
               session.close();
           }
       }//updateEmployee

       //Delete a employee from table
       public void deleteEmployee(int id) {
           
    	   Transaction tx = null;
           
    	   Session session = HibernateUtil.getSessionFactory().openSession();
           try 
           {
               tx = session.beginTransaction();
               Employee employee = (Employee) session.load(Employee.class, new Integer(id));
               session.delete(employee);
               session.getTransaction().commit();
           } 
           catch (RuntimeException e) 
           {
               if (tx != null) 
                   tx.rollback();
               
               e.printStackTrace();
           } 
           finally 
           {
               session.flush();
               session.close();
           }
       }//deleteEmployee

	
}//EmployeeDAO
