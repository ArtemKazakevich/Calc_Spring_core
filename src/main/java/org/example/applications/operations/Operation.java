package org.example.applications.operations;

import org.example.applications.exception.StopApplicationException;

public interface Operation {
     String getName();
     void execute() throws StopApplicationException;
}
