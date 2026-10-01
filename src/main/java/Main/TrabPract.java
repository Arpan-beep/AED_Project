/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import util.AIDoctor;

/**
 *
 * @author arpan
 */
public class TrabPract {

    public static void main(String[] args) throws FileNotFoundException {
        
        File file = new File("Data_EN.txt");
        Scanner a= new Scanner(file);
        AIDoctor doctor = new AIDoctor();
        doctor.readFile(a);
        doctor.getSymptoms();
        String s= doctor.patientSymptoms();
        System.out.println("The patients symptoms are: "+s);
        System.out.println("Possible illnesses theat match any  symptoms are:");
        doctor.showDiseases(1);
        System.out.println("Possible illnesses theat match atleast two  symptoms are:");
        doctor.showDiseases(2);
        System.out.println("Take care!");
        a.close();
    }
}
