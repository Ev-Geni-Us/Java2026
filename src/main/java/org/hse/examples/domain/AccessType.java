package org.hse.examples.domain;

// тип доступа, для использования sealed

public sealed interface AccessType
        permits PermanentAccess, TemporaryAccess {
}
