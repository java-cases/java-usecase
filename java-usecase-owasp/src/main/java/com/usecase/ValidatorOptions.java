package com.usecase;

import org.owasp.esapi.ValidationErrorList;

public class ValidatorOptions {
    public final static int DEFAULT_MAX_LENGTH = 1024 * 1024;

    private final String context;
    private final int maxLength;
    private final boolean allowNull;
    private final boolean canonicalize;
    private final ValidationErrorList errorList;

    public ValidatorOptions(String context, int maxLength, boolean allowNull, boolean canonicalize, ValidationErrorList errorList) {
        this.context = context;
        this.maxLength = maxLength;
        this.allowNull = allowNull;
        this.canonicalize = canonicalize;
        this.errorList = errorList;
    }

    public static ValidatorOptionsBuilder builder() {
        return new ValidatorOptionsBuilder();
    }

    public String getContext() {
        return context;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public boolean isAllowNull() {
        return allowNull;
    }

    public boolean isCanonicalize() {
        return canonicalize;
    }

    public ValidationErrorList getErrorList() {
        return errorList;
    }
}
