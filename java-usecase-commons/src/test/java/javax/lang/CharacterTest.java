package javax.lang;

import org.junit.Assert;
import org.junit.Test;

public class CharacterTest {

    @Test
    public void newCharacter() {
        Character ch = new Character('a');
        Character other = new Character('a');

        Assert.assertTrue(ch.charValue() == 'a');
        Assert.assertTrue(ch.charValue() == other.charValue());

        Assert.assertFalse(ch == other);
    }

    @Test
    public void valueOf() {
        Character ch = Character.valueOf('a');
        Character other = Character.valueOf('a');

        Assert.assertTrue(ch.charValue() == 'a');
        Assert.assertTrue(ch.charValue() == other.charValue());

        Assert.assertTrue(ch == other);
    }

    @Test
    public void hashCodeOfCharacter() {
        Character ch = Character.valueOf('a');

        Assert.assertTrue(ch.hashCode() == 'a');

        Assert.assertTrue(ch.hashCode() == (int) 'a');
    }

    @Test
    public void hashCodeOfChar() {
        int hashCode = Character.hashCode('a');

        Assert.assertTrue(hashCode == (int) 'a');
    }

    @Test
    public void isUpperCase() {
        Assert.assertTrue(Character.isUpperCase('A'));

        Assert.assertFalse(Character.isUpperCase('a'));

        Assert.assertFalse(Character.isUpperCase('0'));

        Assert.assertFalse(Character.isUpperCase('.'));
    }

    @Test
    public void isLowerCase() {
        Assert.assertFalse(Character.isLowerCase('A'));

        Assert.assertTrue(Character.isLowerCase('a'));

        Assert.assertFalse(Character.isLowerCase('0'));

        Assert.assertFalse(Character.isLowerCase('.'));
    }

    @Test
    public void isTitleCase() {
        Assert.assertFalse(Character.isTitleCase('A'));

        Assert.assertFalse(Character.isTitleCase('a'));

        Assert.assertFalse(Character.isTitleCase('0'));

        Assert.assertFalse(Character.isTitleCase('.'));
    }

    @Test
    public void isDigit() {
        Assert.assertFalse(Character.isDigit('A'));

        Assert.assertFalse(Character.isDigit('a'));

        Assert.assertTrue(Character.isDigit('0'));

        Assert.assertFalse(Character.isDigit('.'));
    }

    @Test
    public void isDefined() {
        //字符是否在unicode范围
        Assert.assertTrue(Character.isDefined('A'));

        Assert.assertTrue(Character.isDefined('a'));

        Assert.assertTrue(Character.isDefined('0'));

        Assert.assertTrue(Character.isDefined('.'));
    }

    @Test
    public void isLetter() {
        Assert.assertTrue(Character.isLetter('A'));

        Assert.assertTrue(Character.isLetter('a'));

        Assert.assertFalse(Character.isLetter('0'));

        Assert.assertFalse(Character.isLetter('.'));
    }

    @Test
    public void isLetterOrDigit() {
        Assert.assertTrue(Character.isLetterOrDigit('A'));

        Assert.assertTrue(Character.isLetterOrDigit('a'));

        Assert.assertTrue(Character.isLetterOrDigit('0'));

        Assert.assertFalse(Character.isLetterOrDigit('.'));
    }

    @Test
    public void isJavaIdentifierStart() {
    }

    @Test
    public void isJavaIdentifierPart() {
    }

    @Test
    public void getNumericValue() {
    }

    @Test
    public void isSpaceChar() {
    }

    @Test
    public void isWhitespace() {
    }

    @Test
    public void toUpperCase() {
    }

    @Test
    public void toUpperCase1() {
    }

    @Test
    public void toLowerCase() {
    }

    @Test
    public void toTitleCase() {
    }

    @Test
    public void digit() {
    }

    @Test
    public void compare() {
    }

    @Test
    public void getName() {
    }
}