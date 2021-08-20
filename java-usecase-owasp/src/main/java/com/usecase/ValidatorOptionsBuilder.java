package com.usecase;

import org.owasp.esapi.ValidationErrorList;

public class ValidatorOptionsBuilder {
    private String context;
    private int maxLength;
    private boolean allowNull;
    private boolean canonicalize;
    private ValidationErrorList errorList;

    public ValidatorOptionsBuilder context(String context) {
        this.context = context;
        return this;
    }

    public ValidatorOptionsBuilder maxLength(int maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    public ValidatorOptionsBuilder allowNull(boolean allowNull) {
        this.allowNull = allowNull;
        return this;
    }

    public ValidatorOptionsBuilder canonicalize(boolean canonicalize) {
        this.canonicalize = canonicalize;
        return this;
    }

    public ValidatorOptionsBuilder errorList(ValidationErrorList errorList) {
        this.errorList = errorList;
        return this;
    }

    public ValidatorOptions build() {
        return new ValidatorOptions(context, maxLength, allowNull, canonicalize, errorList);
    }

    public ValidatorOptions buildDefault() {
        this.maxLength(ValidatorOptions.DEFAULT_MAX_LENGTH);
        this.allowNull(false);
        this.canonicalize(true);
        this.errorList(new ValidationErrorList());
        return this.build();
    }
}