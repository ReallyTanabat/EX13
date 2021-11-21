/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import services.Student;

/**
 *
 * @author Tanabat
 */
public class StudentClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        insertStudent(4, "K vin", 5.00);
        updateStudent(4, "K arbuba", 4.00);
        deleteStudent(4);
    }

    private static String insertStudent(int id, java.lang.String name, double gpa) {
        services.StudentWebService_Service service = new services.StudentWebService_Service();
        services.StudentWebService port = service.getStudentWebServicePort();
        return port.insertStudent(id, name, gpa);
    }

    private static String updateStudent(int id, java.lang.String name, double gpa) {
        services.StudentWebService_Service service = new services.StudentWebService_Service();
        services.StudentWebService port = service.getStudentWebServicePort();
        return port.updateStudent(id, name, gpa);
    }

    private static String deleteStudent(int id) {
        services.StudentWebService_Service service = new services.StudentWebService_Service();
        services.StudentWebService port = service.getStudentWebServicePort();
        return port.deleteStudent(id);
    }

    
    
}