package org.example.applications;

import org.example.applications.exception.StopApplicationException;
import org.example.applications.operations.*;
import org.example.applications.utils.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Application {

     @Autowired
     @Qualifier("divOperation")
     Operation div;
     
     @Autowired
     @Qualifier("sumOperation")
     Operation sum;
     
     @Autowired
     @Qualifier("subOperation")
     Operation sub;
     
     @Autowired
     @Qualifier("multOperation")
     Operation mult;
     
     @Autowired
     @Qualifier("stopApplication")
     Operation stop;
     
     private Map<Integer, Operation> operationMap = new HashMap<Integer, Operation>() {
          {
               this.put(1, sum);
               this.put(2, sub);
               this.put(3, mult);
               this.put(4, div);
               this.put(0, stop);
          }
     };
     
     public void start() {
          System.out.println("Добро пожаловать!");
          run();
          System.out.println("Всего Доброго!");
     }
     
     public void run() {
          while (true) {
               try {
                    Operation operation = selectOperation();
                    operation.execute();
               } catch (StopApplicationException e) {
                    break;
               }
          }
     }
     
     private Operation selectOperation() {
          showMenu();
          int number = Input.getInt("Выберите операцию:");
          Operation operation = operationMap.get(number);
          if (operation != null) {
               return operation;
          }
          System.out.println("Нет такого действия! Повторите ввод!");
          return selectOperation();
     }
     
     private void showMenu() {
          for (Map.Entry<Integer, Operation> action : operationMap.entrySet()){
               System.out.println(action.getKey() + " - " + action.getValue().getName());
          }
     }
}
