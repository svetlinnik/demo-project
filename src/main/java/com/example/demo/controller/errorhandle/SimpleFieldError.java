package com.example.demo.controller.errorhandle;

public final class SimpleFieldError {
	
	private String fieldName;
    private String message;

    public SimpleFieldError(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public SimpleFieldError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFieldName() {
        return fieldName;
    }
}
