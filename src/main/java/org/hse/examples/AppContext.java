package org.hse.examples;

public class AppContext {
    private final EmployeeRepo repo;
    private final InputHandler input;
    private final OutputHandler output;

    public AppContext() {
        this.output = new OutputHandler();
        this.input = new InputHandler();
        this.repo = new EmployeeRepo();
    }

    public AppContext(EmployeeRepo repo, InputHandler input, OutputHandler output) {
        this.repo = repo;
        this.input = input;
        this.output = output;
    }

    public EmployeeRepo repo() { return repo; }
    public InputHandler input() { return input; }
    public OutputHandler output() { return output; }
}
