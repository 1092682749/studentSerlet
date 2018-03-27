package MyHibernate;

import annotation.CreatTable;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParaseXML2 extends DefaultHandler {
    List<String> classNameList;
    String tag;
    @Override
    public void startDocument() throws SAXException {
        classNameList = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName!=null&&qName.equals("class"))
        {
            tag=qName;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (tag.equals("class")&&tag!=null)
        {
            String className = new String(ch,start,length);
            classNameList.add(className);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (tag!=null)
        {
            tag=null;
        }
    }

    @Override
    public void endDocument() throws SAXException {

    }

    public List<String> getClassNameList() {
        return classNameList;
    }

    public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException, SQLException, ClassNotFoundException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        ParaseXML2 paraseXML2 = new ParaseXML2();
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("MyHibernate/web2.xml"),paraseXML2);
        List<String> classList = paraseXML2.getClassNameList();
        for (String s : classList)
        {
            System.out.println(s);
            CreatTable creatTable = new CreatTable();
            creatTable.creatTable(s);
        }
    }
}
