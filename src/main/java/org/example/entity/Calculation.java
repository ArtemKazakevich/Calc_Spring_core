package org.example.entity;

import org.springframework.stereotype.Component;

@Component
public class Calculation {
     public void divOperation(Double a, Double b) {
          double result = a / b;
          System.out.println("Ваш результат = " + result);
     }
     
     public void multOperation(Double a, Double b) {
          double result = a * b;
          System.out.println("Ваш результат = " + result);
     }
     
     public void subOperation(Double a, Double b) {
          double result = a - b;
          System.out.println("Ваш результат = " + result);
     }
     
     public void sumOperation(Double a, Double b) {
          double result = a + b;
          System.out.println("Ваш результат = " + result);
     }
}
