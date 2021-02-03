package com.company.carservices.entity;

public enum UserTypeEnum {
    Employee(1), Customer(2);
    private final int value;

    private UserTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
