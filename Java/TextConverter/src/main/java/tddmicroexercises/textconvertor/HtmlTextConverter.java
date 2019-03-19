package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HtmlTextConverter
{
	private BufferedReader reader;
    private String fullFilenameWithPath;

    public HtmlTextConverter(String fullFilenameWithPath) throws IOException {
		this.fullFilenameWithPath = fullFilenameWithPath;
		reader = new BufferedReader(new FileReader(fullFilenameWithPath));
	}

    public HtmlTextConverter(String fullFilenameWithPath, BufferedReader injectedReader) {
    	this.fullFilenameWithPath = fullFilenameWithPath;
    	reader = injectedReader;
	}

    public String convertToHtml() throws IOException{

	    String line = reader.readLine();
	    String html = "";
	    while (line != null)
	    {
	    	html += StringEscapeUtils.escapeHtml(line);
	        html += "<br />";
	        line = reader.readLine();
	    }
	    return html;

    }

	public String getFilename() {
		return this.fullFilenameWithPath;
	}
}
