package javaproject;

import java.io.*;
import java.util.*;
import javax.swing.*;

public class JavaProject {
    public static void main( String[] args ) throws IOException, InterruptedException{  
        int elementnum = 0, varz = 0, vard;
		String remove, viewchoices, mainchoices;
		Element[] Elements = new Element[9999999];
                Element el  = new Element();
		Scanner input = new Scanner(System.in);
                JPanel panel = new JPanel();
                JDialog.setDefaultLookAndFeelDecorated(true);
                JFrame frame = new JFrame();
		
                loop:
		do{
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");Thread.sleep(500);
                        System.out.println("||\t\tPeriodic Table of Elements\t\t||");Thread.sleep(500);
                        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");Thread.sleep(500);
			System.out.println("|| 1. Add Elements\t\t\t\t\t||");Thread.sleep(500);
			System.out.println("|| 2. View Elements\t\t\t\t\t||");Thread.sleep(500);
			System.out.println("|| 3. Edit Elements\t\t\t\t\t||");Thread.sleep(500);
			System.out.println("|| 4. Delete Elements\t\t\t\t\t||");Thread.sleep(500);
                        System.out.println("|| 5. About\t\t\t\t\t\t||");Thread.sleep(500);
                        System.out.print("|| 6. Exit\t\t\t\t\t\t||\n");Thread.sleep(500);
                        System.out.println("==========================================================");Thread.sleep(500);
			System.out.print("|| Enter choice: ");
			mainchoices = input.next();
                        System.out.println("==========================================================");
                        System.out.println();
//=====================================================================================================================================			
                if (    "1".equals(mainchoices)){
                    if(elementnum<50){
                        int atomnum = 0;
                        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        System.out.println("||\t\t===== ADD ELEMENT =====\t\t\t||");
                        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                        
                        System.out.print("|| Element Name    : ");
                        String name = input.next();
                        System.out.print("|| Atomic Symbol   : ");
                        String symbol = input.next();
                        System.out.print("|| Element Group   : ");
                        String group = input.next();
                        
                        do{
                            System.out.print("|| Atomic Number   : ");
                            atomnum = input.nextInt();
                            
                            if(atomnum <= 118 && atomnum > 0){
                                JOptionPane.showMessageDialog(panel, "ATOMIC NUMBER IS RESERVED. INVALID", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            else if(atomnum <= 0){
                                JOptionPane.showMessageDialog(panel, "PROGRAM CAN ONLY ACCEPT POSITIVE NUMBERS AS ATOMIC NUMBER.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }while(atomnum <= 118);
                        
                        System.out.print("|| Atomic Mass     : ");
                        double atommass = input.nextDouble();
                        System.out.print("|| Atomic Density  : ");
                        double atomdense = input.nextDouble();
                        System.out.print("|| Melting Point   : ");
                        double melt = input.nextDouble();
                        System.out.print("|| Boiling Point   : ");
                        double boil = input.nextDouble();
                        System.out.print("|| Uses            : ");
                        String use = input.next();
                        System.out.println("==========================================================");
                        
                        Element s = new Element(name, group, atomnum, symbol, atommass, atomdense, melt, boil, use);
                        
                        Elements[elementnum] = s;
                        elementnum++;
                        System.out.println("\n");
                    }
                    else{
                        JOptionPane.showMessageDialog(panel, "CAN'T ADD NEW ELEMENT, ELEMENT ARRAY IS FULL", "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("\n");
                    }
                }
//=====================================================================================================================================
                else if ("2".equals(mainchoices)) {
                    exit:
                    do{
                        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        System.out.println("||\t\t===== VIEW ELEMENT =====\t\t||");
                        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			System.out.println("|| 1. View Default Elements\t\t\t\t||");Thread.sleep(300);
			System.out.println("|| 2. View User Elements\t\t\t\t||");Thread.sleep(300);
                        System.out.print("|| 3. Back to Main Menu\t\t\t\t\t||\n");Thread.sleep(300);
			
                        System.out.println("==========================================================");
			System.out.print("|| Enter choice: ");viewchoices = input.next();
                        System.out.println("==========================================================\n");
                        
                        if (viewchoices.equals("1")){
                            searchdefault();
                            continue exit;
                        }
                        else if (viewchoices.equals("2")){
                            if (elementnum == 0){
                                JOptionPane.showMessageDialog(panel, "EMPTY ELEMENT DATABASE. NOTHING TO VIEW", "Warning", JOptionPane.WARNING_MESSAGE);
                            }
                            else{
                                System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                                System.out.println("||\t\t===== VIEW ELEMENT =====\t\t||");
                                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

                                for(int i=0;i<elementnum;i++){
                                    System.out.println("__________________________________________________________");
                                    Element s = Elements[i];
                                    System.out.printf("||\t\t[%d] - Element %d\n",i+1 , Elements[i].getAtomnum());
                                    System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

                                    System.out.printf("|| Element Name   : %s\n",s.getName());Thread.sleep(300);
                                    System.out.printf("|| Atomic Symbol  : %s\n", s.getSymbol());Thread.sleep(300);
                                    System.out.printf("|| Element Group  : %s\n", s.getGroup());Thread.sleep(300);
                                    System.out.printf("|| Atomic Number  : %d\n", s.getAtomnum());Thread.sleep(300);
                                    System.out.printf("|| Atomic Mass    : %.2f\n", s.getAtommass());Thread.sleep(300);
                                    System.out.printf("|| Atomic Density : %.2f g/cm3\n", s.getAtomdense());Thread.sleep(300);
                                    System.out.printf("|| Melting Point  : %.1f °C\n", s.getMelt());Thread.sleep(300);
                                    System.out.printf("|| Boiling Point  : %.1f °C\n", s.getBoil());Thread.sleep(300);
                                    System.out.printf("|| Uses           : %s\n", s.getUse());
                                    System.out.println("==========================================================\n");
                                }
                            }
                        }
                        else if (viewchoices.equals("3")){
                            continue loop;
                        }
                        else{
                            JOptionPane.showMessageDialog(panel, "INVALID INPUT. PLEASE TRY AGAIN", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }while(elementnum != 0);
                }
//=====================================================================================================================================
                else if ("3".equals(mainchoices)) {
                    if (elementnum == 0){
                        JOptionPane.showMessageDialog(panel, "EMPTY ELEMENT DATABASE. NOTHING TO EDIT", "Warning", JOptionPane.WARNING_MESSAGE);
                        System.out.print("\n");
                    }
                    else{
                        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        System.out.println("||\t   ===== MODIFY USER ELEMENT =====   \t\t||");
                        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
                        
                        System.out.println("__________________________________________________________");
                        System.out.println("|| \t\tELEMENTS READY FOR EDITING\t\t||");
                        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                        for(int i = 0; i < elementnum; i++){
                            System.out.printf(" [%d] - Element %d\n",i+1 , Elements[i].getAtomnum());
                        }
                        
                        System.out.println("\n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                        int tryenter = 3;
                        check:
                        do{
                            System.out.printf("|| ENTER ENTRY NUMBER TO MODIFY: ");
                            String modify = input.next();
                            
                            varz = Integer.parseInt(modify);
                            Elements [varz-1] = el;            
                            
                            if( 0 == varz || varz > elementnum || varz < 0){
                                JOptionPane.showMessageDialog(panel, "ENTRY NUMBER DOES'NT EXIST. CHOOSE ONLY\n\t\t\tWHAT'S ON THE LIST", "Warning", JOptionPane.WARNING_MESSAGE);
                                tryenter --;
                                
                                if (tryenter == 0){
                                    int response = JOptionPane.showConfirmDialog(null, "ARE YOU STUCK ? DO YOU WISH TO EXIT?", "Confirm",
                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                    
                                    if (response == JOptionPane.YES_OPTION) {
                                        System.out.println("\n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n");
                                        continue loop;
                                    } 
                                    else if (response == JOptionPane.CLOSED_OPTION) {
                                        continue check;
                                    }
                                }
                                if(tryenter == -3){
                                    JOptionPane.showMessageDialog(frame,"WE REALLY THINK YOU ARE STUCK ! AND FOR THAT REASON\n\t"
                                            +"WE ARE REDIRECTING YOU TO THE MAIN MEMU.","REDIRECTING", JOptionPane.INFORMATION_MESSAGE);
  

                                    System.out.println("__________________________________________________________");
                                    System.out.printf("|| REDIRECTING. PLEASE WAIT ");Thread.sleep(300);
                                    System.out.printf("˳");Thread.sleep(300);
                                    System.out.printf("˳");Thread.sleep(300);	
                                    System.out.printf("˳");Thread.sleep(300);
                                    System.out.printf("˳");Thread.sleep(300);
                                    System.out.printf("˳");Thread.sleep(300);
                                    System.out.println("\t\t\t||\n|| SUCCESSFULLY REDIRECTED!\t\t\t\t||");
                                    System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                                    continue loop;
                                }
                                continue check;
                            }
                            else{
                                System.out.println("\n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                                System.out.println(" ENTER NEW ATTRIBUTES FOR ELEMENT "+modify);
                                System.out.println("__________________________________________________________");
                                System.out.print("|| Element Name   : ");
                                el.setName(input.next());
                                System.out.print("|| Atomic Symbol  : ");
                                el.setSymbol(input.next());
                                System.out.print("|| Element Group  : ");
                                el.setGroup(input.next());
                                
                                do{
                                    System.out.print("|| Atomic Number  : ");
                                    el.setAtomnum(input.nextInt());
                                    if(el.atomnum <= 118 && el.atomnum > 0){
                                        JOptionPane.showMessageDialog(panel, "ATOMIC NUMBER IS RESERVED. INVALID", "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                    else if(el.atomnum <= 0){
                                        JOptionPane.showMessageDialog(panel, "PROGRAM CAN ONLY ACCEPT POSITIVE NUMBERS AS ATOMIC NUMBER.", "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                }while(el.atomnum <= 118);
                                
                                System.out.print("|| Atomic Mass    : ");
                                el.setAtommass(input.nextDouble());
                                System.out.print("|| Atomic Density : ");
                                el.setAtomdense(input.nextDouble());
                                System.out.print("|| Melting Point  : ");
                                el.setMelt(input.nextDouble());
                                System.out.print("|| Boiling Point  : ");
                                el.setBoil(input.nextDouble());
                                System.out.print("|| Uses           : ");
                                el.setUse(input.next());
                                System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                            }
                            
                        }while( varz > elementnum || varz == 0 );
                        System.out.println("__________________________________________________________");
                        System.out.printf("|| EDITING DATA. PLEASE WAIT ");Thread.sleep(300);
                        System.out.printf("˳");Thread.sleep(300);
                        System.out.printf("˳");Thread.sleep(300);	
                        System.out.printf("˳");Thread.sleep(300);
                        System.out.printf("˳");Thread.sleep(300);
                        System.out.printf("˳");Thread.sleep(300);
                        System.out.println("\t\t\t||\n|| DATA SUCCESSFULLY EDITED!\t\t\t\t||");
                        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                    }
                }
//=====================================================================================================================================               
                else if ("4".equals(mainchoices)) {
                    if (elementnum == 0){
                        JOptionPane.showMessageDialog(panel, "EMPTY ELEMENT DATABASE. NOTHING TO DELETE", "Warning", JOptionPane.WARNING_MESSAGE);
                        System.out.print("\n");
                        continue loop;
                    }
                    
                    System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    System.out.println("||\t\t===== DELETE ELEMENT =====\t\t||");
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    
                    System.out.println("__________________________________________________________");
                    System.out.printf("|| \t\tELEMENTS READY FOR DELETING\t\t||\n");
                    System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                    for(int i = 0; i < elementnum; i++){
                        System.out.printf(" [%d] - Element %d\n",i+1 , Elements[i].getAtomnum());
                    }
                    
                    int tryenterdel = 3;
                    delete:
                    do{
                        System.out.println("__________________________________________________________");
                        System.out.printf("|| ENTER ENTRY NUMBER TO DELETE: ");
                        remove = input.next();
                        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                        vard = Integer.parseInt(remove);

                        if( vard > elementnum ){
                            JOptionPane.showMessageDialog(panel, "ENTRY NUMBER DOES'NT EXIST. CHOOSE ONLY\n\t\t\tWHAT'S ON THE LIST", "Warning", JOptionPane.WARNING_MESSAGE);
                            tryenterdel--;
                            
                             if (tryenterdel == 0){
                                    int response = JOptionPane.showConfirmDialog(null, "ARE YOU STUCK ? DO YOU WISH TO EXIT?", "Confirm",
                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                    
                                    if (response == JOptionPane.YES_OPTION) {
                                        System.out.println("\n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n");
                                        continue loop;
                                    } 
                                    else if (response == JOptionPane.CLOSED_OPTION) {
                                        continue delete;
                                    }
                                }
                            if(tryenterdel == -3){
                                    JOptionPane.showMessageDialog(frame,"WE REALLY THINK YOU ARE STUCK ! AND FOR THAT REASON\n\t"
                                            +"WE ARE REDIRECTING YOU TO THE MAIN MEMU.","REDIRECTING", JOptionPane.INFORMATION_MESSAGE);
  

                                    System.out.println("__________________________________________________________");
                                    System.out.printf("|| REDIRECTING. PLEASE WAIT ");Thread.sleep(300);
                                    System.out.printf("˳");Thread.sleep(300);
                                    System.out.printf("˳");Thread.sleep(300);	
                                    System.out.printf("˳");Thread.sleep(300);
                                    System.out.printf("˳");Thread.sleep(300);
                                    System.out.printf("˳");Thread.sleep(300);
                                    System.out.println("\t\t\t||\n|| SUCCESSFULLY REDIRECTED!\t\t\t\t||");
                                    System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                                    continue loop;
                                }
                        }
                        else{
                            int response = JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO DELETE ELEMENT"+remove+" ?", "Confirm",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                    
                            if (response == JOptionPane.YES_OPTION) {
                                for(int r = vard - 1;  r < elementnum - 1; r++){
                                    Elements [r] = Elements [r+1];
                                }
                                elementnum--;
                                System.out.println("__________________________________________________________");
                                System.out.printf("|| DELETING DATA. PLEASE WAIT ");Thread.sleep(300);
                                System.out.printf("˳");Thread.sleep(300);
                                System.out.printf("˳");Thread.sleep(300);	
                                System.out.printf("˳");Thread.sleep(300);
                                System.out.printf("˳");Thread.sleep(300);
                                System.out.printf("˳");Thread.sleep(300);
                                System.out.println("\t\t\t||\n|| DATA SUCCESSFULLY REMOVED!\t\t\t\t||");
                                System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n"); 	
                                continue loop;
                            }
                            else if (response == JOptionPane.CLOSED_OPTION) {
                                continue loop;
                            }
                        }
                    }while( varz > elementnum || varz == 0 );
                }
//=====================================================================================================================================
            else if (   "5".equals(mainchoices)) {
                    JOptionPane.showMessageDialog(frame,
                    "PERIODIC TABLE OF ELEMENTS                      \n"
                            + "PROJECT IN OBJECT ORIENTED PROGRAMMING\n"
                            + "BSIT - 2A\n"
                            + "BATCH 2016\n"
                            + "FIRST SEMESTER\n"
                            + "CREATOR : JOHN CARLO C. NAÑOZ\n"
                            + "INSTRUCTOR : MR. JAYVEE NEIL SIAS",
                    "ABOUT THE PROGRAM.",
                    JOptionPane.INFORMATION_MESSAGE);
                    System.out.println();
            }
//=====================================================================================================================================
            else if (   "6".equals(mainchoices)) {
                    int response = JOptionPane.showConfirmDialog(null, "DO YOU REALLY WISH TO EXIT?", "Confirm",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (response == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(frame, "PROGRAM TERMINATED","ABOUT THE PROGRAM.", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0); 
                    } 
                    else if (response == JOptionPane.CLOSED_OPTION) {
                        continue loop;
                    } 
            }
//=====================================================================================================================================          
            else{
                JOptionPane.showMessageDialog(panel, "INVALID INPUT. PLEASE TRY AGAIN", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }while(true);
    }
    
    public static void searchdefault() throws FileNotFoundException{
        Scanner input = new Scanner(System.in);
        int elserch;
        System.out.println("__________________________________________________________");
	System.out.print("|| Enter Element Number ( 1~118 ): ");
        elserch = input.nextInt();
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n");
        
        if(elserch <= 118 && elserch > 0){
            final String FILE_NAME = "C:\\Default Elements\\"+elserch+".txt";
            try (Scanner scnr = new Scanner(new FileInputStream(FILE_NAME))) {
                while (scnr.hasNextLine()) {
                    System.out.println(scnr.nextLine());
                }
            }System.out.println("\n");
        }
        
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        
        else{
            JOptionPane.showMessageDialog(null, "ELEMENT NOT FOUND. INVALID", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}