package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import junit.framework.AssertionFailedError;
import org.junit.Assert;
import org.junit.Test;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HtmlTextConverterTest {
    @Test (expected = IOException.class)
    public void foo() throws Exception {
        HtmlTextConverter converter = new HtmlTextConverter("foo");
        assertEquals("foo", converter.getFilename());
    }

    @Test
    public void WhenConvertingUnicodeReturnsHtml() throws Exception {
        BufferedReader bufferedReaderMock = mock(BufferedReader.class);
        HtmlTextConverter converter = new HtmlTextConverter("foo", bufferedReaderMock);
        when(bufferedReaderMock.readLine()).thenReturn("&<>\"'").thenReturn(null);
        String expectedHtml = "&amp;" + "&lt;" + "&gt;" + "&quot;" + "&quot;" + "<br />";

        String result = converter.convertToHtml();

        assertEquals(expectedHtml, result);
    }

    @Test
    public void WhenConvertingUnicodeTextWithMixedInSymbolsReturnsHtml() throws Exception {
        BufferedReader bufferedReaderMock = mock(BufferedReader.class);
        HtmlTextConverter converter = new HtmlTextConverter("foo", bufferedReaderMock);
        when(bufferedReaderMock.readLine()).thenReturn("They say some are < & some are > but we say \"No more, y'all\"").thenReturn(null);
        String expectedHTML = "They say some are &lt; &amp; some are &gt; but we say &quot;No more, y&quot;all&quot;<br />";

        String result = converter.convertToHtml();

        assertEquals(expectedHTML, result);
    }
}


