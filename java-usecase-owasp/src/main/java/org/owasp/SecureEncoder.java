package org.owasp;

import org.owasp.esapi.codecs.Codec;

import java.io.IOException;
import java.util.Optional;

public interface SecureEncoder {
    String canonicalize(String input);

    String canonicalize(String input, boolean strict);

    String canonicalize(String input, boolean restrictMultiple, boolean restrictMixed);

    String encodeForCSS(String input);

    String encodeForHTML(String input);

    String decodeForHTML(String input);

    String encodeForHTMLAttribute(String input);

    String encodeForJavaScript(String input);

    String encodeForVBScript(String input);

    String encodeForSQL(Codec codec, String input);

    String encodeForMySQL(String input);

    String encodeForOracleSQL(String input);

    String encodeForOS(Codec codec, String input);

    String encodeForLDAP(String input);

    String encodeForDN(String input);

    String encodeForXPath(String input);

    String encodeForXML(String input);

    String encodeForXMLAttribute(String input);

    Optional<String> encodeForURL(String input);

    Optional<String> decodeFromURL(String input);

    String encodeForBase64(byte[] input, boolean wrap);

    byte[] decodeFromBase64(String input) throws IOException;
}
