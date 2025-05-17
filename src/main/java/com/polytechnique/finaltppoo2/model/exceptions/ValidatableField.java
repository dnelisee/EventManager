package com.polytechnique.finaltppoo2.model.exceptions;

public enum ValidatableField {
    NAME("Name", 25),
    LOCATION("Location", 50),
    THEME("Theme", 50);

    private final String fieldName;
    private final int maxLength;

    ValidatableField(String fieldName, int maxLength) {
        this.fieldName = fieldName;
        this.maxLength = maxLength;
    }

    public String getFieldName() {
        return fieldName;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public Boolean validate(String value) {
        return (value != null && value.length() <= maxLength);
    }
}
