package com.polytechnique.finaltppoo2.model.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LengthExceptionTest {

    @Test 
    void testLengthException() {
        ValidatableField field = ValidatableField.NAME; 
        LengthException ex = new LengthException(field); 

        String message = "Name length exceeded; max size = 25"; 

        assertEquals(message, ex.getMessage());
    }

}
