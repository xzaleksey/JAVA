package ru.geekbrains.practise.task27;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Doc2toHTML {
    public static void main(String[] args) {

        try (ZipFile zipFile = new ZipFile((System.getProperty("user.dir") + "\\src\\ru\\geekbrains\\practise\\task27\\Courier1.docx"))) {
            ZipEntry entry;
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while ((entry = entries.nextElement()) != null) {
                if (entry.getName().equals("word/document.xml")) break;
            }
            final InputStream input = zipFile.getInputStream(entry);
            parseXml(input);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static void parseXml(InputStream input) {
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean wt = false;
                boolean wbOpen = false;
                boolean wbEnd = true;
                boolean wbFinal = false;
                @Override
                public void startElement(String uri, String localName, String qName,
                                         Attributes attributes) throws SAXException {

//                    System.out.println("Start Element :" + qName);

                    if (qName.equalsIgnoreCase("w:t")) {
                        wt = true;
                        if (wbEnd) { //если не встретился тэг b
                            if (wbOpen) { // если был открыт тэг b ранее
                                wbOpen = false;
                                wbFinal = true;
                            }

                        }
                    } else if (qName.equalsIgnoreCase("w:b")) {
                        if (!wbOpen) { //открыть тэг b, если еще не был открыт
                            wbOpen = true;
                            System.out.print("<b>");
                        }
                        wbEnd = false; // конец b еще не пришел

                    } else if (qName.equalsIgnoreCase("w:r")) {
                        wbEnd = true; //конец тэга b, если не найдем его дальше

                    } else if (qName.equalsIgnoreCase("w:p")) {

                        System.out.print("<p>");
                    }
                }

                @Override
                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {

                    if ("w:p".equals(qName)) {
                        if (wbOpen) {
                            wbOpen = false;
                            System.out.print("</b>");
                        }
                        System.out.println("</p>");
                    } else if ("w:r".equals(qName)) {

                    }

                }

                @Override
                public void characters(char ch[], int start, int length) throws SAXException {

                    if (wt) {
                        String str = new String(ch, start, length);
                        if (wbEnd && !wbOpen && wbFinal) {
                            str = "</b>" + str;
                            wbFinal = false;
                        }
                        System.out.print(str);
                        wt = false;
                    }
                }

            };

            saxParser.parse(input, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}