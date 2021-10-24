/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intheritanceorm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sonon
 */
public class IntheritanceORM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FulltimeEmployee emp1 = new FulltimeEmployee();
        ParttimeEmployee emp2 = new ParttimeEmployee();
        
        EmployeeTable.insertEmployee(emp1);
        //emp1.setName("PANGPOND");
        //emp1.setSalary(5000);
        //emp2.setName("NAHEE");
        //emp2.setHoursWork(8);
        
        //EmployeeTable.updateFullTimeEmployee(emp1);
        //emp1.setName("PANGPOND");
        //emp1.setSalary(5000);
        
        //EmployeeTable.updatePartTimeEmployee(emp2);
        //emp2.setName("NAHEE");
        //emp2.setHoursWork(8);
        
        //EmployeeTable.removeFullTimeEmployee(emp1);
        //EmployeeTable.removePartTimeEmployee(emp2);
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("intheritanceORMPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
