package com.usecase;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Encoder;
import org.owasp.esapi.codecs.Codec;
import org.owasp.esapi.codecs.MySQLCodec;
import org.owasp.esapi.codecs.OracleCodec;
import org.owasp.esapi.errors.EncodingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Optional;

public class EncoderDelegate implements SecureEncoder {

    private static final Logger log = LoggerFactory.getLogger(EncoderDelegate.class);

    private Encoder encoder = ESAPI.encoder();

    public EncoderDelegate() {

    }

    @Override
    public String canonicalize(String input) {
        return encoder.canonicalize(input);
    }

    @Override
    public String canonicalize(String input, boolean strict) {
        return encoder.canonicalize(input, strict);
    }

    @Override
    public String canonicalize(String input, boolean restrictMultiple, boolean restrictMixed) {
        return encoder.canonicalize(input, restrictMultiple, restrictMixed);
    }

    @Override
    public String encodeForCSS(String input) {
        return encoder.encodeForCSS(input);
    }

    @Override
    public String encodeForHTML(String input) {
        return encoder.encodeForHTML(input);
    }

    @Override
    public String decodeForHTML(String input) {
        return encoder.decodeForHTML(input);
    }

    @Override
    public String encodeForHTMLAttribute(String input) {
        return encoder.encodeForHTMLAttribute(input);
    }

    @Override
    public String encodeForJavaScript(String input) {
        return encoder.encodeForJavaScript(input);
    }

    @Override
    public String encodeForVBScript(String input) {
        return encoder.encodeForVBScript(input);
    }

    @Override
    public String encodeForSQL(Codec codec, String input) {
        return encoder.encodeForSQL(codec, input);
    }

    @Override
    public String encodeForMySQL(String input) {
        return encoder.encodeForSQL(new MySQLCodec(MySQLCodec.Mode.STANDARD), input);
    }

    @Override
    public String encodeForOracleSQL(String input) {
        return encoder.encodeForSQL(new OracleCodec(), input);
    }

    @Override
    public String encodeForOS(Codec codec, String input) {
        return encoder.encodeForOS(codec, input);
    }

    @Override
    public String encodeForLDAP(String input) {
        return encoder.encodeForLDAP(input);
    }

    @Override
    public String encodeForDN(String input) {
        return encoder.encodeForDN(input);
    }

    @Override
    public String encodeForXPath(String input) {
        return encoder.encodeForXPath(input);
    }

    @Override
    public String encodeForXML(String input) {
        return encoder.encodeForXML(input);
    }

    @Override
    public String encodeForXMLAttribute(String input) {
        return encoder.encodeForXMLAttribute(input);
    }

    @Override
    public Optional<String> encodeForURL(String input) {
        try {
            return Optional.ofNullable(encoder.encodeForURL(input));
        } catch (EncodingException e) {
            log.error(e.getLocalizedMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<String> decodeFromURL(String input) {
        try {
            return Optional.ofNullable(encoder.decodeFromURL(input));
        } catch (EncodingException e) {
            log.error(e.getLocalizedMessage());
            return Optional.empty();
        }
    }

    @Override
    public String encodeForBase64(byte[] input, boolean wrap) {
        return encoder.encodeForBase64(input, wrap);
    }

    @Override
    public byte[] decodeFromBase64(String input) throws IOException {
        return encoder.decodeFromBase64(input);
    }
}
