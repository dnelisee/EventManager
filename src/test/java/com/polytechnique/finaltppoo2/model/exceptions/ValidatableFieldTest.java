package com.polytechnique.finaltppoo2.model.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidatableFieldTest {

    @Test 
    void testGetFieldName() {
        assertEquals("Name", ValidatableField.NAME.getFieldName());
        assertEquals("Location", ValidatableField.LOCATION.getFieldName()); 
        assertEquals("Theme", ValidatableField.THEME.getFieldName());
    }
    
    @Test 
    void testGetMaxLength() {
        assertEquals(25, ValidatableField.NAME.getMaxLength());
        assertEquals(50, ValidatableField.LOCATION.getMaxLength());
        assertEquals(50, ValidatableField.THEME.getMaxLength()); 
    }

    @Test 
    void testValidateSucess() {
        assertTrue(ValidatableField.NAME.validate("Elisee")); 
        assertTrue(ValidatableField.LOCATION.validate("Tokyo")); 
        assertTrue(ValidatableField.THEME.validate("Galois fields")); 
    }

    @Test 
    void testValidateTooLong() {
        String tooLongStr = "A".repeat(52); 
        assertFalse(ValidatableField.NAME.validate(tooLongStr)); 
        assertFalse(ValidatableField.LOCATION.validate(tooLongStr)); 
        assertFalse(ValidatableField.THEME.validate(tooLongStr));
    }
}
