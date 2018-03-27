package MyHibernate;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.*;

public class ParaseXML extends DefaultHandler{
    List<String> colus = new ArrayList<>();
    String tableName;
    Map<String,List<String>> tableMap;
    String tag=null;
    @Override
    public void startDocument() throws SAXException {
        tableMap = new HashMap<String,List<String>>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        System.out.println("start");
        if (qName!=null)
        {
            tag = qName;
        }if(qName.equals("table"))
        {
           colus = new ArrayList<String>();
           tableName = attributes.getValue("name");
           System.out.println(tableName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        List<String> columnList = new ArrayList<String>();
        if (tag!=null)
        {
            if (tag.equals("table"))
            {
                String table = new String(ch,start,length);

            }else if (tag.equals("column"))
            {
                String column = new String(ch,start,length);
                colus.add(column);
                System.out.println("cun"+column);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        System.out.println(tag);
        tag = qName;
        if (tag.equals("table"))
        {
            tableMap.put(tableName,colus);
            System.out.println("down");
        }
        tag=null;
    }

    @Override
    public void endDocument() throws SAXException {

    }

    public Map<String, List<String>> getTableMap() {
        return tableMap;
    }

    public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        ParaseXML paraseXML = new ParaseXML();
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("MyHibernate/web.xml"),paraseXML);
        Map<String,List<String>> listMap = paraseXML.getTableMap();
        Iterator<Map.Entry<String,List<String>>> iterator = listMap.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String,List<String>> t = iterator.next();
            System.out.println(t.getKey());
            List<String> columns = listMap.get(t.getKey());
            for (String clomn : columns)
            {
                System.out.println("column is "+clomn);
            }
        }
    }
}
