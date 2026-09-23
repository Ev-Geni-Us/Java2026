package org.hse.examples.domain;

import java.util.Optional;

public interface EmployeeRepository {
    Optional<Employee> findById(int id);
    boolean add(Employee employee);
}
