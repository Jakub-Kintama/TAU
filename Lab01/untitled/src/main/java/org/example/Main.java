package org.example;

import org.apache.commons.validator.routines.UrlValidator;
import org.junit.Assert;
import org.junit.Test;

public class Main
{
    public static boolean urlValidator(String url)
    {
        // Get an `UrlValidator` using default schemes
        UrlValidator defaultValidator = new UrlValidator();
        return defaultValidator.isValid(url);
    }

    @Test
    public void testGoogleReturnTrue(){
        Assert.assertTrue(urlValidator("https://www.google.com"));
    }

    @Test
    public void testNoHttpsReturnFalse(){
        Assert.assertFalse(urlValidator("www.google.com"));
    }

    @Test
    public void testNullReturnFalse(){
        Assert.assertFalse(urlValidator(null));
    }

    @Test
    public void testManyDotsReturnFalse(){
        Assert.assertFalse(urlValidator("https://www..google.com"));
    }
}