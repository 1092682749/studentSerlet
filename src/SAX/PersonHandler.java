package SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class PersonHandler extends DefaultHandler {
    Person person;
    List<Person> personList;
    String tag;
    @Override
    public void startDocument() throws SAXException {
        System.out.println("begin:");
        personList = new ArrayList<Person>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("stratElement:");
        if(qName!=null) {
            System.out.println(uri+"..."+localName+"..."+qName+"..."+attributes);
            tag = qName;
            if (tag.equals("person")) {
                person = new Person();
                System.out.println("name is:"+attributes.getValue("name"));
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String info = new String(ch,start,length);
        System.out.println("characters");
        if (tag!=null&&person!=null)
        {
            if (tag.equals("name"))
            {
                person.setName(new String(ch,start,length));
            }
            if (tag.equals("age"))
            {
                person.setAge(new String(ch,start,length));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("endElement");
        if (qName.equals("person"))
        {
            personList.add(person);
        }
        tag=null;
    }

    @Override
    public void endDocument() throws SAXException {

    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
