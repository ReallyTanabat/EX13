/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calcircle;

/**
 *
 * @author Tanabat
 */
public class Calcircle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("calArea r = 10: " +calArea(10));
        System.out.println("calCircumference r = 10: " +calArea(10));
    }

    private static double calArea(double r) {
        service.CalCircleWS_Service service = new service.CalCircleWS_Service();
        service.CalCircleWS port = service.getCalCircleWSPort();
        return port.calArea(r);
    }

    private static double calCircumference(double r) {
        service.CalCircleWS_Service service = new service.CalCircleWS_Service();
        service.CalCircleWS port = service.getCalCircleWSPort();
        return port.calCircumference(r);
    }
    
    
    
}