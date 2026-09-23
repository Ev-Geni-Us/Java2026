package org.hse.examples.application;

import org.hse.examples.domain.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final OutputPort output;

    public EmployeeService(EmployeeRepository repository, OutputPort output) {
        this.repository = repository;
        this.output = output;
    }

    public void processEmployee(int id) {
        repository.findById(id).ifPresentOrElse(
                output::printAnswer,
                () -> output.printError("Сотрудник не найден")
        );
    }
}
