package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int sX=0, sY=0, dX=0, dY=0;
        String dir="";

        try {
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); 
            while (sc.hasNextLine()) {
                String input = sc.nextLine();
                String[] cmd = input.split(" ");
                switch (cmd[0]) {
                    case "SOURCE":
                        sX = Integer.parseInt(cmd[1]);
                        sY =  Integer.parseInt(cmd[2]);
                        dir =  cmd[3];
                        break;
                    case "DESTINATION":
                        dX = Integer.parseInt(cmd[1]);
                        dY =  Integer.parseInt(cmd[2]);
                        break;
                    case "PRINT_POWER":
                        int p  = calculatePower(sX, sY, dX, dY, dir);    
                        System.out.println("POWER "+ p);
                        break;                    
                }
            }
            sc.close(); 
        } catch (IOException e) {
        }
    }

    public static int calculatePower(int sX, int sY, int dX, int dY, String dir) {
        int  xt=0, yt =0, tot=0, r=0, turns=0;

        if (dX == sX){                             
        }        
        else if (dX > sX){
            xt = dX - sX;
            switch (dir) {
                case "N":
                    turns++;
                    break;
                case "E":
                    turns++;
                    break;
                case "S":                    
                    turns++;
                    break;
                case "W":
                    turns++;
                    break;
                default:
                    break;
            } 
        }else{
            xt = sX - dX;
            switch (dir) {
                case "N":
                    turns++;
                    break;
                case "E":
                    turns++;
                    break;
                case "S":
                    turns++;
                    break;
                case "W":
                    turns++;
                    break;
                default:
                    break;
            }                            
        }
        if (dY == sY){
        }        
        else if (dY < sY){
            yt = dY - sY;   
            switch (dir) {
                case "N":
                    turns++;
                    break;
                case "E":
                    turns++;
                    break;
                case "S":
                    turns++;
                    break;
                case "W":
                    turns++;
                    break;
                default:
                    break;
            }                             
        }else{
            yt = sY - dY;
            switch (dir) {
                case "N":
                    turns++;
                    break;
                case "E":
                    turns++;
                    break;
                case "S":
                    turns++;
                    break;
                case "W":
                    turns++;
                    break;
                default:
                    break;
            }                                       
        }                                                                           
        tot = xt+yt;                        
        r = 200 - ((tot*10) -(turns*5)) ;
        return r;
    }
}
