package org.owasp.esapi;

import org.owasp.esapi.errors.IntrusionException;
import org.owasp.esapi.errors.ValidationException;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ValidatorProxy implements Validator {

    private Validator validator = ESAPI.validator();

    public ValidatorProxy() {

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
    public boolean isValidInput(String context, String input, String type,
                                int maxLength, boolean allowNull) throws IntrusionException {
        return validator.isValidInput(context, input, type, maxLength, allowNull);
    }

    @Override
    public boolean isValidInput(String context, String input, String type,
                                int maxLength, boolean allowNull, ValidationErrorList errorList)
            throws IntrusionException {
        return validator.isValidInput(context, input, type, maxLength, allowNull, errorList);
    }

    @Override
    public boolean isValidInput(String context, String input, String type,
                                int maxLength, boolean allowNull, boolean canonicalize)
            throws IntrusionException {
        return validator.isValidInput(context, input, type, maxLength, allowNull, canonicalize);
    }

    @Override
    public boolean isValidInput(String context, String input, String type,
                                int maxLength, boolean allowNull, boolean canonicalize, ValidationErrorList errorList)
            throws IntrusionException {
        return validator.isValidInput(context, input, type, maxLength, allowNull, canonicalize, errorList);
    }

    @Override
    public String getValidInput(String context, String input, String type,
                                int maxLength, boolean allowNull)
            throws ValidationException, IntrusionException {
        return validator.getValidInput(context, input, type, maxLength, allowNull);
    }

    @Override
    public String getValidInput(String context, String input, String type,
                                int maxLength, boolean allowNull, boolean canonicalize)
            throws ValidationException, IntrusionException {
        return validator.getValidInput(context, input, type, maxLength, allowNull, canonicalize);
    }

    @Override
    public String getValidInput(String context, String input, String type,
                                int maxLength, boolean allowNull, ValidationErrorList errorList)
            throws IntrusionException {
        return validator.getValidInput(context, input, type, maxLength, allowNull, errorList);
    }

    @Override
    public String getValidInput(String context, String input, String type,
                                int maxLength, boolean allowNull, boolean canonicalize, ValidationErrorList errorList)
            throws IntrusionException {
        return validator.getValidInput(context, input, type, maxLength, allowNull, canonicalize, errorList);
    }

    @Override
    public boolean isValidDate(String context, String input, DateFormat format, boolean allowNull)
            throws IntrusionException {
        return validator.isValidDate(context, input, format, allowNull);
    }

    @Override
    public boolean isValidDate(String context, String input, DateFormat format, boolean allowNull,
                               ValidationErrorList errorList)
            throws IntrusionException {
        return validator.isValidDate(context, input, format, allowNull, errorList);
    }

    @Override
    public Date getValidDate(String context, String input, DateFormat format, boolean allowNull)
            throws ValidationException, IntrusionException {
        return validator.getValidDate(context, input, format, allowNull);
    }

    @Override
    public Date getValidDate(String context, String input, DateFormat format, boolean allowNull,
                             ValidationErrorList errorList) throws IntrusionException {
        return validator.getValidDate(context, input, format, allowNull, errorList);
    }

    @Override
    public boolean isValidSafeHTML(String context, String input, int maxLength, boolean allowNull)
            throws IntrusionException {
        return validator.isValidSafeHTML(context, input, maxLength, allowNull);
    }

    @Override
    public boolean isValidSafeHTML(String context, String input, int maxLength, boolean allowNull,
                                   ValidationErrorList errorList)
            throws IntrusionException {
        return validator.isValidSafeHTML(context, input, maxLength, allowNull, errorList);
    }

    @Override
    public String getValidSafeHTML(String context, String input, int maxLength, boolean allowNull)
            throws ValidationException, IntrusionException {
        return validator.getValidSafeHTML(context, input, maxLength, allowNull);
    }

    @Override
    public String getValidSafeHTML(String context, String input, int maxLength, boolean allowNull,
                                   ValidationErrorList errorList) throws IntrusionException {
        return validator.getValidSafeHTML(context, input, maxLength, allowNull, errorList);
    }

    @Override
    public boolean isValidCreditCard(String context, String input, boolean allowNull)
            throws IntrusionException {
        return validator.isValidCreditCard(context, input, allowNull);
    }

    @Override
    public boolean isValidCreditCard(String context, String input, boolean allowNull,
                                     ValidationErrorList errorList) throws IntrusionException {
        return validator.isValidCreditCard(context, input, allowNull, errorList);
    }

    @Override
    public String getValidCreditCard(String context, String input, boolean allowNull)
            throws ValidationException, IntrusionException {
        return validator.getValidCreditCard(context, input, allowNull);
    }

    @Override
    public String getValidCreditCard(String context, String input, boolean allowNull,
                                     ValidationErrorList errorList)
            throws IntrusionException {
        return validator.getValidCreditCard(context, input, allowNull, errorList);
    }

    @Override
    public boolean isValidDirectoryPath(String context, String input, File parent, boolean allowNull)
            throws IntrusionException {
        return validator.isValidDirectoryPath(context, input, parent, allowNull);
    }

    @Override
    public boolean isValidDirectoryPath(String context, String input, File parent, boolean allowNull,
                                        ValidationErrorList errorList)
            throws IntrusionException {
        return validator.isValidDirectoryPath(context, input, parent, allowNull, errorList);
    }

    @Override
    public String getValidDirectoryPath(String context, String input, File parent, boolean allowNull)
            throws ValidationException, IntrusionException {
        return validator.getValidDirectoryPath(context, input, parent, allowNull);
    }

    @Override
    public String getValidDirectoryPath(String context, String input, File parent, boolean allowNull,
                                        ValidationErrorList errorList)
            throws IntrusionException {
        return validator.getValidDirectoryPath(context, input, parent, allowNull, errorList);
    }

    @Override
    public boolean isValidFileName(String context, String input, boolean allowNull)
            throws IntrusionException {
        return validator.isValidFileName(context, input, allowNull);
    }

    @Override
    public boolean isValidFileName(String context, String input, boolean allowNull,
                                   ValidationErrorList errorList)
            throws IntrusionException {
        return validator.isValidFileName(context, input, allowNull, errorList);
    }

    @Override
    public boolean isValidFileName(String context, String input, List<String> allowedExtensions, boolean allowNull)
            throws IntrusionException {
        return validator.isValidFileName(context, input, allowedExtensions, allowNull);
    }

    @Override
    public boolean isValidFileName(String context, String input, List<String> allowedExtensions, boolean allowNull,
                                   ValidationErrorList errorList)
            throws IntrusionException {
        return validator.isValidFileName(context, input, allowedExtensions, allowNull, errorList);
    }

    @Override
    public String getValidFileName(String context, String input, List<String> allowedExtensions, boolean allowNull)
            throws ValidationException, IntrusionException {
        return validator.getValidFileName(context, input, allowedExtensions, allowNull);
    }

    @Override
    public String getValidFileName(String context, String input, List<String> allowedExtensions, boolean allowNull,
                                   ValidationErrorList errorList) throws IntrusionException {
        return validator.getValidFileName(context, input, allowedExtensions, allowNull, errorList);
    }

    @Override
    public boolean isValidNumber(String context, String input, long minValue, long maxValue, boolean allowNull)
            throws IntrusionException {
        return validator.isValidNumber(context, input, minValue, maxValue, allowNull);
    }

    @Override
    public boolean isValidNumber(String context, String input, long minValue, long maxValue, boolean allowNull,
                                 ValidationErrorList errorList)
            throws IntrusionException {
        return validator.isValidNumber(context, input, minValue, maxValue, allowNull, errorList);
    }

    @Override
    public Double getValidNumber(String context, String input, long minValue, long maxValue, boolean allowNull)
            throws ValidationException, IntrusionException {
        return validator.getValidNumber(context, input, minValue, maxValue, allowNull);
    }

    @Override
    public Double getValidNumber(String context, String input, long minValue, long maxValue, boolean allowNull,
                                 ValidationErrorList errorList)
            throws IntrusionException {
        return validator.getValidNumber(context, input, minValue, maxValue, allowNull, errorList);
    }

    @Override
    public boolean isValidInteger(String context, String input, int minValue, int maxValue, boolean allowNull)
            throws IntrusionException {
        return validator.isValidInteger(context, input, minValue, maxValue, allowNull);
    }

    @Override
    public boolean isValidInteger(String context, String input, int minValue, int maxValue, boolean allowNull,
                                  ValidationErrorList errorList)
            throws IntrusionException {
        return validator.isValidInteger(context, input, minValue, maxValue, allowNull, errorList);
    }

    @Override
    public Integer getValidInteger(String context, String input, int minValue, int maxValue, boolean allowNull)
            throws ValidationException, IntrusionException {
        return validator.getValidInteger(context, input, minValue, maxValue, allowNull);
    }

    @Override
    public Integer getValidInteger(String context, String input, int minValue, int maxValue, boolean allowNull,
                                   ValidationErrorList errorList)
            throws IntrusionException {
        return validator.getValidInteger(context, input, minValue, maxValue, allowNull, errorList);
    }

    @Override
    public boolean isValidDouble(String context, String input, double minValue, double maxValue, boolean allowNull)
            throws IntrusionException {
        return validator.isValidDouble(context, input, minValue, maxValue, allowNull);
    }

    @Override
    public boolean isValidDouble(String context, String input, double minValue, double maxValue, boolean allowNull,
                                 ValidationErrorList errorList)
            throws IntrusionException {
        return validator.isValidDouble(context, input, minValue, maxValue, allowNull, errorList);
    }

    @Override
    public Double getValidDouble(String context, String input, double minValue, double maxValue, boolean allowNull)
            throws ValidationException, IntrusionException {
        return validator.getValidDouble(context, input, minValue, maxValue, allowNull);
    }

    @Override
    public Double getValidDouble(String context, String input, double minValue, double maxValue, boolean allowNull,
                                 ValidationErrorList errorList)
            throws IntrusionException {
        return validator.getValidDouble(context, input, minValue, maxValue, allowNull, errorList);
    }

    @Override
    public boolean isValidFileContent(String context, byte[] input, int maxBytes, boolean allowNull)
            throws IntrusionException {
        return validator.isValidFileContent(context, input, maxBytes, allowNull);
    }

    @Override
    public boolean isValidFileContent(String context, byte[] input, int maxBytes, boolean allowNull,
                                      ValidationErrorList errorList)
            throws IntrusionException {
        return validator.isValidFileContent(context, input, maxBytes, allowNull, errorList);
    }

    @Override
    public byte[] getValidFileContent(String context, byte[] input, int maxBytes, boolean allowNull)
            throws ValidationException, IntrusionException {
        return validator.getValidFileContent(context, input, maxBytes, allowNull);
    }

    @Override
    public byte[] getValidFileContent(String context, byte[] input, int maxBytes, boolean allowNull,
                                      ValidationErrorList errorList)
            throws IntrusionException {
        return validator.getValidFileContent(context, input, maxBytes, allowNull, errorList);
    }

    @Override
    public boolean isValidFileUpload(String context, String filepath, String filename, File parent,
                                     byte[] content, int maxBytes, boolean allowNull)
            throws IntrusionException {
        return validator.isValidFileUpload(context, filepath, filename, parent, content, maxBytes, allowNull);
    }

    @Override
    public boolean isValidFileUpload(String context, String filepath, String filename, File parent,
                                     byte[] content, int maxBytes, boolean allowNull, ValidationErrorList errorList)
            throws IntrusionException {
        return validator.isValidFileUpload(context, filepath, filename, parent, content, maxBytes, allowNull, errorList);
    }

    @Override
    public void assertValidFileUpload(String context, String filepath, String filename, File parent,
                                      byte[] content, int maxBytes, List<String> allowedExtensions, boolean allowNull)
            throws ValidationException, IntrusionException {
        validator.assertValidFileUpload(context, filepath, filename, parent,
                content, maxBytes, allowedExtensions, allowNull);

    }

    @Override
    public void assertValidFileUpload(String context, String filepath, String filename, File parent,
                                      byte[] content, int maxBytes, List<String> allowedExtensions, boolean allowNull,
                                      ValidationErrorList errorList)
            throws IntrusionException {
        validator.assertValidFileUpload(context, filepath, filename, parent,
                content, maxBytes, allowedExtensions, allowNull, errorList);

    }

    @Override
    public boolean isValidListItem(String context, String input, List<String> list)
            throws IntrusionException {
        return validator.isValidListItem(context, input, list);
    }

    @Override
    public boolean isValidListItem(String context, String input, List<String> list, ValidationErrorList errorList)
            throws IntrusionException {
        return validator.isValidListItem(context, input, list, errorList);
    }

    @Override
    public String getValidListItem(String context, String input, List<String> list)
            throws ValidationException, IntrusionException {
        return validator.getValidListItem(context, input, list);
    }

    @Override
    public String getValidListItem(String context, String input, List<String> list, ValidationErrorList errorList)
            throws IntrusionException {
        return validator.getValidListItem(context, input, list, errorList);
    }

    @Override
    public boolean isValidHTTPRequestParameterSet(String context, HttpServletRequest request, Set<String> required, Set<String> optional)
            throws IntrusionException {
        return validator.isValidHTTPRequestParameterSet(context, request, required, optional);
    }

    @Override
    public boolean isValidHTTPRequestParameterSet(String context, HttpServletRequest request,
                                                  Set<String> required, Set<String> optional, ValidationErrorList errorList)
            throws IntrusionException {
        return validator.isValidHTTPRequestParameterSet(context, request, required, optional, errorList);
    }

    @Override
    public void assertValidHTTPRequestParameterSet(String context, HttpServletRequest request, Set<String> required, Set<String> optional)
            throws ValidationException, IntrusionException {
        validator.assertValidHTTPRequestParameterSet(context, request, required, optional);
    }

    @Override
    public void assertValidHTTPRequestParameterSet(String context, HttpServletRequest request, Set<String> required, Set<String> optional, ValidationErrorList errorList)
            throws IntrusionException {
        validator.assertValidHTTPRequestParameterSet(context, request, required, optional, errorList);
    }

    @Override
    public boolean isValidPrintable(String context, char[] input, int maxLength, boolean allowNull)
            throws IntrusionException {
        return validator.isValidPrintable(context, input, maxLength, allowNull);
    }

    @Override
    public boolean isValidPrintable(String context, char[] input, int maxLength, boolean allowNull, ValidationErrorList errorList)
            throws IntrusionException {
        return validator.isValidPrintable(context, input, maxLength, allowNull, errorList);
    }

    @Override
    public char[] getValidPrintable(String context, char[] input, int maxLength, boolean allowNull)
            throws ValidationException {
        return validator.getValidPrintable(context, input, maxLength, allowNull);
    }

    @Override
    public char[] getValidPrintable(String context, char[] input, int maxLength, boolean allowNull, ValidationErrorList errorList)
            throws IntrusionException {
        return validator.getValidPrintable(context, input, maxLength, allowNull, errorList);
    }

    @Override
    public boolean isValidPrintable(String context, String input, int maxLength, boolean allowNull)
            throws IntrusionException {
        return validator.isValidPrintable(context, input, maxLength, allowNull);
    }

    @Override
    public boolean isValidPrintable(String context, String input, int maxLength, boolean allowNull, ValidationErrorList errorList)
            throws IntrusionException {
        return validator.isValidPrintable(context, input, maxLength, allowNull, errorList);
    }

    @Override
    public String getValidPrintable(String context, String input, int maxLength, boolean allowNull)
            throws ValidationException {
        return validator.getValidPrintable(context, input, maxLength, allowNull);
    }

    @Override
    public String getValidPrintable(String context, String input, int maxLength, boolean allowNull, ValidationErrorList errorList)
            throws IntrusionException {
        return validator.getValidPrintable(context, input, maxLength, allowNull, errorList);
    }

    @Override
    public boolean isValidRedirectLocation(String context, String input, boolean allowNull) {
        return validator.isValidRedirectLocation(context, input, allowNull);
    }

    @Override
    public boolean isValidRedirectLocation(String context, String input, boolean allowNull, ValidationErrorList errorList) {
        return validator.isValidRedirectLocation(context, input, allowNull, errorList);
    }

    @Override
    public String getValidRedirectLocation(String context, String input, boolean allowNull)
            throws ValidationException, IntrusionException {
        return validator.getValidRedirectLocation(context, input, allowNull);
    }

    @Override
    public String getValidRedirectLocation(String context, String input, boolean allowNull, ValidationErrorList errorList)
            throws IntrusionException {
        return validator.getValidRedirectLocation(context, input, allowNull, errorList);
    }

    @Override
    public String safeReadLine(InputStream inputStream, int maxLength)
            throws ValidationException {
        return validator.safeReadLine(inputStream, maxLength);
    }

}
