package SAX;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class ParseDome {
    public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException {
        //获取解析工场
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //获取解析器
        SAXParser parser = factory.newSAXParser();
        //加载文档，编写处理器
        PersonHandler personHandler = new PersonHandler();
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("SAX/my.xml"),personHandler);
        List<Person> personList = personHandler.getPersonList();
        for (Person p : personList)
        {
            System.out.println(p.toString());
        }
    }
}
