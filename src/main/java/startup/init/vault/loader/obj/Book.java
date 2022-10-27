package startup.init.vault.loader.obj;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import startup.init.vault.loader.DateAdapter;

import java.util.Date;

@XmlRootElement(name = "book")
@XmlType(propOrder = { "id", "name","author","date" })
public class Book {
    private Long id;
    private String name;
    private String author;
    private String date;

    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "title")
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "author")
    public void setAuthor(String author) {
        this.author = author;
    }

    //@XmlJavaTypeAdapter(DateAdapter.class)
    @XmlElement(name = "date")
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                '}';
    }

    // constructor, getters and setters
    /*
    @XmlRootElement: The name of the root XML element is derived from the class name, and we can also specify the name of the root element of the XML using its name attribute.
    @XmlType: define the order in which the fields are written in the XML file
    @XmlElement: define the actual XML element name that will be used
    @XmlAttribute: define the id field is mapped as an attribute instead of an element
    @XmlTransient: annotate fields that we don't want to be included in XML
     */
}