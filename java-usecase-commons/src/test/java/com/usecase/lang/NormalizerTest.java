package com.usecase.lang;

import org.junit.Assert;
import org.junit.Test;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NormalizerTest {

    @Test
    public void normalize() {

        //包含全角尖括号
        String input = "\uFe64tag\uFe65" + "command" + "\uFe64/tag\uFe65";
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFKC);

        System.out.println(normalized);
        Assert.assertEquals("<tag>command</tag>", normalized);

        //包含半角尖括号
        input = "\u003Ctag\u003E" + "command" + "\u003C/tag\u003E";
        normalized = Normalizer.normalize(input, Normalizer.Form.NFKC);

        System.out.println(normalized);
        Assert.assertEquals("<tag>command</tag>", normalized);
    }

    @Test
    public void isNormalized() {

        //包含全角尖括号
        String input = "\uFe64tag\uFe65" + "command" + "\uFe64/tag\uFe65";
        Boolean normalized = Normalizer.isNormalized(input, Normalizer.Form.NFKC);

        Assert.assertEquals(false, normalized);

        //包含半角尖括号
        input = "\u003Ctag\u003E" + "command" + "\u003C/tag\u003E";
        normalized = Normalizer.isNormalized(input, Normalizer.Form.NFKC);

        Assert.assertEquals(true, normalized);

        input = "<tag>command</tag>";
        normalized = Normalizer.isNormalized(input, Normalizer.Form.NFKC);

        Assert.assertEquals(true, normalized);
    }

    @Test
    public void matchPattern() {

        Pattern pattern = Pattern.compile("<\\s*tag\\s*>");

        String input = "<tag>command</tag>";
        Matcher matcher = pattern.matcher(input);
        Assert.assertTrue(matcher.find());

        //包含全角尖括号
        input = "\uFe64tag\uFe65";
        matcher = pattern.matcher(input);
        Assert.assertFalse(matcher.find());

        matcher = pattern.matcher(Normalizer.normalize(input, Normalizer.Form.NFKC));
        Assert.assertTrue(matcher.find());

        //包含半角尖括号
        input = "\u003Ctag\u003E";
        matcher = pattern.matcher(input);
        Assert.assertTrue(matcher.find());

        matcher = pattern.matcher(Normalizer.normalize(input, Normalizer.Form.NFKC));
        Assert.assertTrue(matcher.find());

    }
}