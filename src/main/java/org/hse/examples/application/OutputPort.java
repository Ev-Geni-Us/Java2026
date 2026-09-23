package org.hse.examples.application;

import org.hse.examples.domain.Employee;

public interface OutputPort {
    void printAnswer(Employee employee);
    void printError(String message);
}
