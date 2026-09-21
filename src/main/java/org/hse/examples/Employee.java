package org.hse.examples;

//Сотрудник через record

record Employee(
        int id,
        String name,
        int accessLevel,
        boolean isActive,
        int accessType
){
    // Добавил константы для типа доступа
    private static final int permanentAccessCode = 1;
    private static final int temporaryAccessCode = 2;

    //Валидация на список
    public Employee {
        if (id < 0) {
            throw new IllegalArgumentException("Отрицательный ID");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Пустое поле имени");
        }
        if (accessLevel < 1 || accessLevel > 5) {
            throw new IllegalArgumentException("Не допустимый уровень доступа");
        }
    }

    // Switch с типами доступа
    public AccessType getAccessType() {
        return switch (accessType) {
            case permanentAccessCode -> new PermanentAccess();
            case temporaryAccessCode -> new TemporaryAccess();
            // при отсутствии или ошибке -> временный
            default -> new TemporaryAccess();
        };
    }
}