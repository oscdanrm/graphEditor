/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grapheditor.functions;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author oscardanielrangelmartinez
 */
public class MainFunctionallity {
    
    
    public void graphEditor(){
        Boolean executionApp = true;
        String[][] mat = null;
        while(executionApp){
            System.out.println("Hi enter any of the following commands");
            System.out.println("1.- I M N to Create a pixel matrix");
            System.out.println("2.- C to clear the table");
            System.out.println("3.- L X Y C to set a color on any position");
            System.out.println("4.- V X Y Y C to set color on vertical position");
            System.out.println("5.- H X X Y C to set color on horizontal position");
            System.out.println("6.- F X Y C to fill matrix with color");
            System.out.println("7.- S Show content of the current image");
            System.out.println("8.- X End Session");
            Scanner sc = new Scanner(System.in);
            String command = sc.nextLine();
            String[] splitCommand = command.split(" ");
            String onlyCommand = splitCommand[0];
            onlyCommand = onlyCommand.toUpperCase();
            
            System.out.println("You chose option: "+ command);
            System.out.println(" ");
            System.out.println("--------------------------------");
            System.out.println(" ");
            
            switch(onlyCommand){
                case "I":
                    mat = createMatrix(command);
                    break;
                case "C":
                    mat = clearMatrix(mat);
                    break;
                case "L":
                    mat = lCommand(mat, command);
                    break;
                case "V":
                    mat = vCommand(mat, command);
                    break;
                case "H":
                    mat = hCommand(mat, command);
                    break;
                case "F":
                    mat = fillColorMatrix(mat, command);
                    break;
                case "S":
                    printMatrix(mat);
                    break;
                case "X":
                    executionApp = endApp(executionApp);
                    break;
                
            }
            
            /*if(onlyCommand.equals("I")){
                mat = createMatrix(command);
                printMatrix(mat);
            }
            
            if(onlyCommand.equals("C")){
                mat = clearMatrix(mat);
                printMatrix(mat);
            }
            
            if(onlyCommand.equals("L")){
                mat = lCommand(mat, command);
                printMatrix(mat);
            }
            
            if(onlyCommand.equals("V")){
                mat = vCommand(mat, command);
                printMatrix(mat);
            }
            
            if(onlyCommand.equals("H")){
                mat = hCommand(mat, command);
                printMatrix(mat);
            }
            
            if(onlyCommand.equals("F")){
                mat = fillColorMatrix(mat, command);
                printMatrix(mat);
            }*/
            
        }
    
    }
    
    public String[][] createMatrix(String command){
       String[] parts = command.split(" ");      
       int m = Integer.parseInt(parts[1]);
       int n = Integer.parseInt(parts[2]);
       String[][] matrix = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = "O";
            }
        }
       return matrix;
    }
    
    public String[][] clearMatrix(String[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = "O";
            }
        }
        return matrix;
    }
    
    public void printMatrix(String[][] matrix){
        /*for (String[] row: matrix) {
            System.out.println(Arrays.toString(row));
        }*/
        
        for (int row=0; row<matrix[0].length; row++) {
            for (int col=0; col<matrix.length; col++) {
                String[] column = matrix[col];
                System.out.print(column[row]+" ");        
            }
            System.out.println();
            
        }
        
        System.out.println(" ");
        System.out.println("--------------------------------");
        System.out.println(" ");
        
        return;
    }
    
    public String[][] lCommand(String[][] matrix, String command){

        String[] parts = command.split(" ");      
        int x = Integer.parseInt(parts[1]);
        int y = Integer.parseInt(parts[2]);
        String c = parts[3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(x-1 == i && y-1 == j){
                    matrix[x-1][y-1] = c;
                }

            }
        }
       
        return matrix;
    }
    
    public String[][] vCommand(String[][] matrix, String command){

        String[] parts = command.split(" ");
        int x = Integer.parseInt(parts[1]);
        int y = Integer.parseInt(parts[2]);
        int y2 = Integer.parseInt(parts[3]);
        String c = parts[4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(x-1 == i && y-1 == j){
                    matrix[x-1][y-1] = c;
                }
                
                if(x-1 == i && y2-1 == j){
                    matrix[x-1][y2-1] = c;
                }
                
            }
        }
       
        return matrix;
    }
    
    public String[][] hCommand(String[][] matrix, String command){

        String[] parts = command.split(" ");
        int x = Integer.parseInt(parts[1]);
        int x2 = Integer.parseInt(parts[2]);
        int y = Integer.parseInt(parts[3]);
        String c = parts[4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(x-1 == i && y-1 == j){
                    matrix[x-1][y-1] = c;
                }
                
                if(x2-1 == i && y-1 == j){
                    matrix[x2-1][y-1] = c;
                }
                
            }
        }
       
        return matrix;
    }
    
    public String[][] fillColorMatrix(String[][] matrix, String command){
       String[] parts = command.split(" ");      
       int x = Integer.parseInt(parts[1]);
       int y = Integer.parseInt(parts[2]);
       String c = parts[3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(x-1 != i && y-1 != j){
                    matrix[i][j] = c;
                }
            }
        }
        return matrix;
    }
    
    public Boolean endApp(Boolean executionApp){
        System.out.println("Bye bye! c=");
        executionApp = false;
        return executionApp;
        
    }
    
}
