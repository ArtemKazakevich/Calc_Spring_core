package org.example.applications.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Input {
     private static Scanner scanner = new Scanner(System.in);
     
     public static int getInt(){
          if (scanner.hasNextInt()){
               return scanner.nextInt();
          }
          scanner.next("[\\d]+");
          System.out.println("Это не число. Повторите ввод");
          return getInt();
     }
     
     public static int getInt(String message){
          System.out.println(message);
          return getInt();
     }
     
     public static String getString(){
          return scanner.next();
     }
     
     public static String getString(String message){
          System.out.println(message);
          return getString();
     }
}
