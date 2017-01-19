package com.kranjcecni;

import java.util.Scanner;
import java.util.Set;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;



public class HamiltonovCiklus {
	
	 private int V;
     private int[][] graf;
     
     List<Integer> ciklus;
     int posljednjiDodan;
     
     public void ispisiCiklus(){
    	 System.out.print("\nCiklus zadanog grafa: ");
    	 for (Integer i : ciklus) {
			System.out.print(i + " - ");
		}
    	 System.out.println(ciklus.get(0));
     }
     
     public void pronadiCiklus(){
    	 
    	 ciklus = new ArrayList<Integer>();
    	 
    	 ciklus.add(0);
    	 if (ciklusMoguc()){
    		 ispisiCiklus();
    	 }else{
    		 System.out.println("U zadanom grafu Hamiltonov ciklus ne postoji!!");
    	 }
     }
     public boolean moguceSpajanje(int i){
    	 
    	 if (graf[ciklus.get(ciklus.size() - 1)][i] == 0){
    		 return false;
    	 }
    	 
    	 if (ciklus.contains(i)){
    		 return false;
    	 }
    	 
    	 return true;
    	 
     }
     
     public boolean ciklusMoguc(){
    	 
    	 if (ciklus.size() == V){
    		 if (graf[0][ciklus.get(ciklus.size() - 1)] == 1){
    			 return true;
    		 }else{
    			 return false;
    		 }
    	 }
    	 
    	 for (int i = 1; i < V; i++){
    		 
    		 if (moguceSpajanje(i)){
    			 ciklus.add(i);
    			 if(ciklusMoguc()== true){
    				 return true;
    			 }else{
    				 ciklus.remove(ciklus.size() - 1);
    			 }
    		 }
    	 }
    	 
    	 return false;
     }

	public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        HamiltonovCiklus hc = new HamiltonovCiklus();
	 
	        System.out.print("Unesite broj vrhova: ");
	        int V = scan.nextInt();
	 
	        System.out.println("\nPotrebno je unjeti podatke za bridove izmedu svaka dva vrha!\n");
	        int[][] graf = new int[V][V];
	        for (int i = 0; i < V; i++){
	            for (int j = i+1; j < V; j++){
	            	System.out.print("Koliko bridova ima izmedu " + i + " i " + j + ": ");
	                int brojBridova = scan.nextInt();
	            	graf[i][j] = brojBridova;
	                graf[j][i] = brojBridova;
	            }
	        }
	        
	        for (int i = 0; i < V; i++){
	            for (int j = 0; j < V; j++){
	            	if (i == j){
	            	graf[i][j] = 0;
	            	}

	            }
	        }
	        hc.graf = graf;
	        hc.V = V;
	        hc.pronadiCiklus();
	        scan.close();
		
	}

}
