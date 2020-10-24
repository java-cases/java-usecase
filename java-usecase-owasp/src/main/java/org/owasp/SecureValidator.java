package org.owasp;

import org.owasp.esapi.ValidationRule;
import org.owasp.esapi.ValidatorOptions;
import org.owasp.esapi.errors.IntrusionException;
import org.owasp.esapi.errors.ValidationException;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface SecureValidator {
    void addRule(ValidationRule rule);

    ValidationRule getRule(String name);

    boolean isValidInput(String input, ValidatorType type,
                         ValidatorOptions options) throws IntrusionException;

    String getValidInput(String input, ValidatorType type,
                         ValidatorOptions options) throws IntrusionException;

    Date getValidDate(String input, DateFormat format,
                      ValidatorOptions options) throws IntrusionException;

    String getValidSafeHTML(String input,
                            ValidatorOptions options) throws IntrusionException;

    String getValidCreditCard(String input,
                              ValidatorOptions options) throws IntrusionException;

    boolean isValidDirectoryPath(String input, File parent,
                                 ValidatorOptions options) throws IntrusionException;

    String getValidDirectoryPath(String input, File parent,
                                 ValidatorOptions options) throws IntrusionException;

    boolean isValidFileName(String input, List<String> allowedExtensions,
                            ValidatorOptions options) throws IntrusionException;

    String getValidFileName(String input, List<String> allowedExtensions,
                            ValidatorOptions options) throws IntrusionException;

    boolean isValidNumber(String input, long minValue, long maxValue,
                          ValidatorOptions options) throws IntrusionException;

    Double getValidNumber(String input, long minValue, long maxValue,
                          ValidatorOptions options) throws IntrusionException;

    boolean isValidInteger(String input, int minValue, int maxValue,
                           ValidatorOptions options) throws IntrusionException;

    Integer getValidInteger(String input, int minValue, int maxValue,
                            ValidatorOptions options) throws IntrusionException;

    boolean isValidDouble(String input, double minValue, double maxValue,
                          ValidatorOptions options) throws IntrusionException;

    Double getValidDouble(String input, double minValue, double maxValue,
                          ValidatorOptions options) throws IntrusionException;

    boolean isValidFileContent(byte[] input, int maxBytes,
                               ValidatorOptions options) throws IntrusionException;

    byte[] getValidFileContent(byte[] input, int maxBytes,
                               ValidatorOptions options) throws IntrusionException;

    boolean isValidFileUpload(String filepath, String filename, File parent,
                              byte[] content, int maxBytes,
                              ValidatorOptions options) throws IntrusionException;

    void assertValidFileUpload(String filepath, String filename, File parent,
                               byte[] content, int maxBytes, List<String> allowedExtensions,
                               ValidatorOptions options) throws IntrusionException;

    boolean isValidListItem(String context, String input, List<String> list)
            throws IntrusionException;

    boolean isValidListItem(String input, List<String> list,
                            ValidatorOptions options) throws IntrusionException;

    String getValidListItem(String input, List<String> list,
                            ValidatorOptions options) throws IntrusionException;

    boolean isValidHTTPRequestParameterSet(HttpServletRequest request,
                                           Set<String> required,
                                           Set<String> optional,
                                           ValidatorOptions options) throws IntrusionException;

    void assertValidHTTPRequestParameterSet(HttpServletRequest request,
                                            Set<String> required,
                                            Set<String> optional,
                                            ValidatorOptions options) throws IntrusionException;

    boolean isValidPrintable(char[] input,
                             ValidatorOptions options) throws IntrusionException;

    char[] getValidPrintable(char[] input,
                             ValidatorOptions options) throws IntrusionException;

    boolean isValidPrintable(String input,
                             ValidatorOptions options) throws IntrusionException;

    String getValidPrintable(String input,
                             ValidatorOptions options) throws IntrusionException;

    boolean isValidRedirectLocation(String input,
                                    ValidatorOptions options);

    String getValidRedirectLocation(String input,
                                    ValidatorOptions options) throws IntrusionException;

    String safeReadLine(InputStream inputStream, int maxLength)
            throws ValidationException;
}
