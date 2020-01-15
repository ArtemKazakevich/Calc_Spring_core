package org.example.applications.operations;

import org.example.applications.exception.StopApplicationException;
import org.example.entity.Calculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StopApplication implements Operation {
     
     @Override
     public String getName() {
          return "Выход";
     }
     
     @Override
     public void execute() throws StopApplicationException {
          throw new StopApplicationException();
     }
}
