/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import MyCollections.LinkedMap;
import MyCollections.linkedlists.SinglyLinkedList;
import MyCollections.linkedlists.SortedDoublyLinkedList;
import java.util.Scanner;

/**
 *
 * @author arpan
 */
public class AIDoctor {

    private LinkedMap<String, SinglyLinkedList<String>> associatedIllnesses;
    private SinglyLinkedList<String> patientSymptoms;

    public AIDoctor() {
        associatedIllnesses = new LinkedMap();
        patientSymptoms = new SinglyLinkedList();

    }

    public void readFile(Scanner data) {

        while (data.hasNextLine()) {
            String line = data.nextLine();
            //System.out.println(line);

            String[] parts = line.split(":");
            if (parts.length == 2) {
                String disease = parts[0].trim();
                String[] ArraySymptoms = parts[1].split(",");

                SinglyLinkedList<String> symp = new SinglyLinkedList<>();
                for (String it : ArraySymptoms) {
                    symp.addLast(it.trim());
                }

                associatedIllnesses.put(disease, symp);

            }
        }
    }

    public void showSymptomList() {
        SortedDoublyLinkedList<String> allSymptoms = new SortedDoublyLinkedList<>();

        for (String disease : associatedIllnesses.keySet()) {
            SinglyLinkedList<String> diseasesymptoms = associatedIllnesses.get(disease);
            for (String str : diseasesymptoms) {
                allSymptoms.put(str);
            }

        }
        for (String it : allSymptoms) {
            System.out.print("{" + it + "} ");

        }
        System.out.println();
    }

    public String patientSymptoms() {
        return this.toString();

    }

    public void clearSymptoms() {
        if (patientSymptoms.isEmpty()) {
            return;
        } else {
            while (!patientSymptoms.isEmpty()) {
                patientSymptoms.removeFirst();
            }
        }
        System.out.println("All the symptoms are cleared.");
    }

    public void showDiseases(int nSintomas) {
        
        boolean found = false;
        for (String disease : associatedIllnesses.keySet()) {
            SinglyLinkedList<String> symptoms = associatedIllnesses.get(disease);
            int match=0;
            
            for(String ps: patientSymptoms){
                for(String illnesssymp : symptoms){
                    if(ps.equalsIgnoreCase(illnesssymp)){
                        match++;
                        break;
                    }
                }
            }
            if(match>=nSintomas){
                System.out.println("Disease: "+disease+" matches "+ match+" symptoms.");
                found=true;  
            }
            
            
            }
         
            
        if(!found){
            System.out.println("None!");
        }
        
        System.out.println(); 
        
        }

        
    

    public void getSymptoms() {

        while (true) {
            System.out.println("The possible symptoms are: ");
            showSymptomList();
            Scanner input = new Scanner(System.in);
            System.out.print("Enter a symptom or done if you are finished: ");
            String s = input.nextLine();
            System.out.println();
            if (s.equals("done")) {
                break;
            } else {
                patientSymptoms.addFirst(s);
            }

        }

    }

    @Override
    public String toString() {
        if (patientSymptoms.size() == 0) {
            return "The patient Symptoms are: None";
        } else {
            StringBuilder result = new StringBuilder();
            for (String it : patientSymptoms) {
                result.append(it).append(",");
            }
            result.setLength(result.length() - 1);

            return result.toString() + ".";
        }

    }

}
