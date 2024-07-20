/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import models.Printing;

public class CalculateCost {

    public static double getCost(Printing printing, int pages, int copies) {

        double baseCost = 100;

        if (printing.getType().equals("BlackAndWhite")) {
            baseCost += 10;
        } else if (printing.getType().equals("Colored")) {
            baseCost += 30;
        } else if (printing.getType().equals("Laser")) {
            baseCost += 40;
        }

        if (printing.getSize().equals("A7")) {
            baseCost += 5;
        } else if (printing.getSize().equals("A6")) {
            baseCost += 15;
        } else if (printing.getSize().equals("A5")) {
            baseCost += 25;
        } else if (printing.getSize().equals("A4")) {
            baseCost += 35;
        } else if (printing.getSize().equals("A3")) {
            baseCost += 45;
        } else if (printing.getSize().equals("A2")) {
            baseCost += 55;
        } else if (printing.getSize().equals("A1")) {
            baseCost += 65;
        }
        
        if(printing.getOrientation().equals("Portrait")){
            baseCost += 0;
        }else if(printing.getOrientation().equals("Landscape")){
            baseCost += 10;
        }
        
        if(printing.getSlides() <= 10){
            baseCost += printing.getSlides() * 5;
        }else{
            baseCost += printing.getSlides() * 2;
        }
        
        

        return baseCost + pages * copies;

    }

}
