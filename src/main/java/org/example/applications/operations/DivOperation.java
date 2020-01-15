package org.example.applications.operations;

import org.example.applications.exception.StopApplicationException;
import org.example.applications.utils.Input;
import org.example.entity.Calculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DivOperation implements Operation {

     @Autowired
     private Calculation calculation;

     @Override
     public String getName() {
          return "Деление";
     }
     
     @Override
     public void execute() throws StopApplicationException {
          double a = Input.getInt("Введите число a");
          double b = Input.getInt("Введите число b");
          calculation.divOperation(a, b);
     }
}
