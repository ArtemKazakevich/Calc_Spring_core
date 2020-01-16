package org.example.applications;

import org.example.applications.exception.StopApplicationException;
import org.example.applications.operations.*;
import org.example.applications.utils.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class Application {

     private Map<Integer, Operation> operationMap;

     final
     Operation div;
     
     final
     Operation sum;
     
     final
     Operation sub;
     
     final
     Operation mult;
     
     final
     Operation stop;
     
     @PostConstruct
     public void init(){
           operationMap = new HashMap<Integer, Operation>() {
               {
                    this.put(1, sum);
                    this.put(2, sub);
                    this.put(3, mult);
                    this.put(4, div);
                    this.put(0, stop);
               }
          };
     }

     public Application(@Qualifier("divOperation") Operation div, @Qualifier("sumOperation") Operation sum, @Qualifier("subOperation") Operation sub, @Qualifier("multOperation") Operation mult, @Qualifier("stopApplication") Operation stop) {
          this.div = div;
          this.sum = sum;
          this.sub = sub;
          this.mult = mult;
          this.stop = stop;
     }

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
