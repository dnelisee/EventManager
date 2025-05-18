package com.polytechnique.finaltppoo2.model.exceptions;

public class LengthException extends RuntimeException {

    public LengthException(ValidatableField field) {
        super(
            String.format("%s length exceeded; max size = %d", field.getFieldName(), field.getMaxLength())
        );
    }

}
