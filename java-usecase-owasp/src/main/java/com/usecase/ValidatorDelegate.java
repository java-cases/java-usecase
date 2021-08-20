package com.usecase;

import org.owasp.esapi.ValidationRule;
import org.owasp.esapi.Validator;
import org.owasp.esapi.errors.IntrusionException;
import org.owasp.esapi.errors.ValidationException;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ValidatorDelegate implements SecureValidator {

    private Validator validator;

    public ValidatorDelegate(Validator validator) {
        Objects.requireNonNull(validator);

        this.validator = validator;
    }


    @Override
    public void addRule(ValidationRule rule) {
        validator.addRule(rule);
    }

    @Override
    public ValidationRule getRule(String name) {
        return validator.getRule(name);
    }


    @Override
    public boolean isValidInput(String input, ValidatorType type,
                                final ValidatorOptions options) throws IntrusionException {
        return validator.isValidInput(options.getContext(),
                input,
                type.getName(),
                options.getMaxLength(),
                options.isAllowNull(),
                options.isCanonicalize(),
                options.getErrorList());
    }


    @Override
    public String getValidInput(String input, ValidatorType type,
                                final ValidatorOptions options) throws IntrusionException {
        return validator.getValidInput(options.getContext(),
                input,
                type.getName(),
                options.getMaxLength(),
                options.isAllowNull(),
                options.isCanonicalize(),
                options.getErrorList());
    }


    @Override
    public Date getValidDate(String input, DateFormat format,
                             final ValidatorOptions options) throws IntrusionException {
        return validator.getValidDate(options.getContext(),
                input,
                format,
                options.isAllowNull(),
                options.getErrorList());
    }


    @Override
    public String getValidSafeHTML(String input,
                                   final ValidatorOptions options) throws IntrusionException {
        return validator.getValidSafeHTML(options.getContext(),
                input,
                options.getMaxLength(),
                options.isAllowNull(),
                options.getErrorList());
    }

    @Override
    public String getValidCreditCard(String input,
                                     final ValidatorOptions options) throws IntrusionException {
        return validator.getValidCreditCard(options.getContext(),
                input,
                options.isAllowNull(),
                options.getErrorList());
    }


    @Override
    public boolean isValidDirectoryPath(String input, File parent,
                                        final ValidatorOptions options) throws IntrusionException {
        return validator.isValidDirectoryPath(options.getContext(),
                input,
                parent,
                options.isAllowNull(),
                options.getErrorList());
    }


    @Override
    public String getValidDirectoryPath(String input, File parent,
                                        final ValidatorOptions options) throws IntrusionException {
        return validator.getValidDirectoryPath(options.getContext(),
                input,
                parent,
                options.isAllowNull(),
                options.getErrorList());
    }


    @Override
    public boolean isValidFileName(String input, List<String> allowedExtensions,
                                   final ValidatorOptions options) throws IntrusionException {
        return validator.isValidFileName(options.getContext(),
                input,
                allowedExtensions,
                options.isAllowNull(),
                options.getErrorList());
    }


    @Override
    public String getValidFileName(String input, List<String> allowedExtensions,
                                   final ValidatorOptions options) throws IntrusionException {
        return validator.getValidFileName(options.getContext(),
                input,
                allowedExtensions,
                options.isAllowNull(),
                options.getErrorList());
    }

    @Override
    public boolean isValidNumber(String input, long minValue, long maxValue,
                                 final ValidatorOptions options) throws IntrusionException {
        return validator.isValidNumber(options.getContext(),
                input,
                minValue,
                maxValue,
                options.isAllowNull(),
                options.getErrorList());
    }


    @Override
    public Double getValidNumber(String input, long minValue, long maxValue,
                                 final ValidatorOptions options) throws IntrusionException {
        return validator.getValidNumber(options.getContext(),
                input,
                minValue,
                maxValue,
                options.isAllowNull(),
                options.getErrorList());
    }


    @Override
    public boolean isValidInteger(String input, int minValue, int maxValue,
                                  final ValidatorOptions options) throws IntrusionException {
        return validator.isValidInteger(options.getContext(),
                input,
                minValue,
                maxValue,
                options.isAllowNull(),
                options.getErrorList());
    }


    @Override
    public Integer getValidInteger(String input, int minValue, int maxValue,
                                   final ValidatorOptions options) throws IntrusionException {
        return validator.getValidInteger(options.getContext(),
                input,
                minValue,
                maxValue,
                options.isAllowNull(),
                options.getErrorList());
    }


    @Override
    public boolean isValidDouble(String input, double minValue, double maxValue,
                                 final ValidatorOptions options) throws IntrusionException {
        return validator.isValidDouble(options.getContext(),
                input,
                minValue,
                maxValue,
                options.isAllowNull(),
                options.getErrorList());
    }


    @Override
    public Double getValidDouble(String input, double minValue, double maxValue,
                                 final ValidatorOptions options) throws IntrusionException {
        return validator.getValidDouble(options.getContext(),
                input,
                minValue,
                maxValue,
                options.isAllowNull(),
                options.getErrorList());
    }


    @Override
    public boolean isValidFileContent(byte[] input, int maxBytes,
                                      final ValidatorOptions options) throws IntrusionException {
        return validator.isValidFileContent(options.getContext(),
                input,
                maxBytes,
                options.isAllowNull(),
                options.getErrorList());
    }


    @Override
    public byte[] getValidFileContent(byte[] input, int maxBytes,
                                      final ValidatorOptions options) throws IntrusionException {
        return validator.getValidFileContent(options.getContext(),
                input,
                maxBytes,
                options.isAllowNull(),
                options.getErrorList());
    }

    @Override
    public boolean isValidFileUpload(String filepath, String filename, File parent,
                                     byte[] content, int maxBytes,
                                     final ValidatorOptions options) throws IntrusionException {
        return validator.isValidFileUpload(options.getContext(),
                filepath,
                filename,
                parent,
                content,
                maxBytes,
                options.isAllowNull(),
                options.getErrorList());
    }

    @Override
    public void assertValidFileUpload(String filepath, String filename, File parent,
                                      byte[] content, int maxBytes, List<String> allowedExtensions,
                                      final ValidatorOptions options) throws IntrusionException {
        validator.assertValidFileUpload(options.getContext(),
                filepath,
                filename,
                parent,
                content,
                maxBytes,
                allowedExtensions,
                options.isAllowNull(),
                options.getErrorList());

    }


    @Override
    public boolean isValidListItem(String context, String input, List<String> list)
            throws IntrusionException {
        return false;
    }


    @Override
    public boolean isValidListItem(String input, List<String> list,
                                   final ValidatorOptions options) throws IntrusionException {
        return validator.isValidListItem(options.getContext(),
                input,
                list,
                options.getErrorList());
    }

    @Override
    public String getValidListItem(String input, List<String> list,
                                   final ValidatorOptions options) throws IntrusionException {
        return validator.getValidListItem(options.getContext(),
                input,
                list,
                options.getErrorList());
    }

    @Override
    public boolean isValidHTTPRequestParameterSet(HttpServletRequest request,
                                                  Set<String> required,
                                                  Set<String> optional,
                                                  final ValidatorOptions options) throws IntrusionException {
        return validator.isValidHTTPRequestParameterSet(options.getContext(),
                request,
                required,
                optional,
                options.getErrorList());
    }

    @Override
    public void assertValidHTTPRequestParameterSet(HttpServletRequest request,
                                                   Set<String> required,
                                                   Set<String> optional,
                                                   final ValidatorOptions options) throws IntrusionException {
        validator.assertValidHTTPRequestParameterSet(options.getContext(),
                request,
                required,
                optional,
                options.getErrorList());

    }

    @Override
    public boolean isValidPrintable(char[] input,
                                    final ValidatorOptions options) throws IntrusionException {
        return validator.isValidPrintable(options.getContext(),
                input,
                options.getMaxLength(),
                options.isAllowNull(),
                options.getErrorList());
    }

    @Override
    public char[] getValidPrintable(char[] input,
                                    final ValidatorOptions options) throws IntrusionException {
        return validator.getValidPrintable(options.getContext(),
                input,
                options.getMaxLength(),
                options.isAllowNull(),
                options.getErrorList());
    }

    @Override
    public boolean isValidPrintable(String input,
                                    final ValidatorOptions options) throws IntrusionException {
        return validator.isValidPrintable(options.getContext(),
                input,
                options.getMaxLength(),
                options.isAllowNull(),
                options.getErrorList());
    }


    @Override
    public String getValidPrintable(String input,
                                    final ValidatorOptions options) throws IntrusionException {
        return validator.getValidPrintable(options.getContext(),
                input,
                options.getMaxLength(),
                options.isAllowNull(),
                options.getErrorList());
    }


    @Override
    public boolean isValidRedirectLocation(String input,
                                           final ValidatorOptions options) {
        return validator.isValidRedirectLocation(options.getContext(),
                input,
                options.isAllowNull(),
                options.getErrorList());
    }

    @Override
    public String getValidRedirectLocation(String input,
                                           final ValidatorOptions options) throws IntrusionException {
        return validator.getValidRedirectLocation(options.getContext(),
                input,
                options.isAllowNull(),
                options.getErrorList());
    }


    @Override
    public String safeReadLine(InputStream inputStream, int maxLength)
            throws ValidationException {
        return validator.safeReadLine(inputStream, maxLength);
    }
}
