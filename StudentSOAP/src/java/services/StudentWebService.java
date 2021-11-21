/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Student;

/**
 *
 * @author Tanabat
 */
@WebService(serviceName = "StudentWebService")
public class StudentWebService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentSOAPPU1");

    
    private void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findStudentById")
    public Student findStudentById(@WebParam(name = "id") int id) {
        EntityManager em = emf.createEntityManager();
        Student s = em.find(Student.class, id);
        return s;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertStudent")
    public String insertStudent(@WebParam(name = "id") int id, @WebParam(name = "name") String name, @WebParam(name = "gpa") double gpa) {
        Student s = new Student(id, name, gpa);
        persist(s);
        return "suscess";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateStudent")
    public String updateStudent(@WebParam(name = "id") int id, @WebParam(name = "name") String name, @WebParam(name = "gpa") double gpa) {
        EntityManager em = emf.createEntityManager();
        Student fromDb = em.find(Student.class, id);
        fromDb.setName(name);
        fromDb.setGpa(gpa);
        em.getTransaction().begin();
        try {
            em.persist(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return "updated";
       
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteStudent")
    public String deleteStudent(@WebParam(name = "id") int id) {
        EntityManager em = emf.createEntityManager();
        Student fromDb = em.find(Student.class, id);
        em.getTransaction().begin();
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return "deleted";
    }

}