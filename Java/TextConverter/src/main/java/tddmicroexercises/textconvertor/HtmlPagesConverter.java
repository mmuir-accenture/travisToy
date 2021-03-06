package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlPagesConverter {

    private String filename;
    private List<Integer> breaks = new ArrayList<Integer>();
    private BufferedReader reader;
    
    HtmlPagesConverter(String filename) throws IOException {
        this.filename = filename;
        this.breaks.add(0);

    }

    private void dividePage() throws IOException {
        reader = new BufferedReader(new FileReader(this.filename));
        int cumulativeCharCount = 0;
        String line = reader.readLine();
        while (line != null)
        {
            cumulativeCharCount += line.length() + 1; // add one for the newline
            if (line.contains("PAGE_BREAK")) {
                breaks.add(cumulativeCharCount);
            }
            line = reader.readLine();
        }
        reader.close();
    }

    public String getHtmlPage(int page) throws IOException {
        reader = new BufferedReader(new FileReader(this.filename));
        reader.skip(breaks.get(page));
        StringBuffer htmlPage = new StringBuffer();
        String line = reader.readLine();
        while (line != null)
        {
            if (line.contains("PAGE_BREAK")) {
                break;
            }
            htmlPage.append(StringEscapeUtils.escapeHtml(line));
            htmlPage.append("<br />");
            
            line = reader.readLine();
        }
        reader.close();
        return htmlPage.toString();
    }

    String getFilename() {
        return this.filename;
    }
    
}
