package org.hse.examples.domain;

//Сотрудник через record

public record Employee(
        int id,
        String name,
        int accessLevel,
        boolean isActive,
        AccessType accessType
){

    //Валидация на список
    public Employee {
        if (id <= 0) {
            throw new IllegalArgumentException("Отрицательный ID");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Пустое поле имени");
        }
        if (accessLevel < 1 || accessLevel > 5) {
            throw new IllegalArgumentException("Недопустимый уровень доступа");
        }
        if (accessType == null) {
            throw new IllegalArgumentException("Тип доступа не задан");
        }
    }

}