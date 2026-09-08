package org.hse.examples;

// тип доступа, для использования sealed

sealed interface AccessType
        permits PermanentAccess, TemporaryAccess {
    String getDescription();
}

record PermanentAccess() implements AccessType {
    @Override
    public String getDescription() {
        return "Постоянный доступ";
    }
}
record TemporaryAccess() implements AccessType {
    @Override
    public String getDescription() {
        return "Временный доступ";
    }
}
