package startup.init.vault.loader;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import startup.init.vault.loader.obj.Book;
import startup.init.vault.loader.obj.PathObject;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class POJOLoader {

    public static void main(String[] args) {

        JAXBContext jaxbContext = null;
        // JAXBContext jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
        //        .createContext(new Class[]{Path.class}, null);

        try {
            File file = new File("C:\\Users\\fabio_rodriguez\\OneDrive - TransCanada Corporation\\Documents\\IT\\Java-src\\java-gui-mvc\\src\\main\\java\\startup\\init\\config\\xml\\test3.xml");
            if (file.exists()) {
                System.out.println("Exists!");

                Book bl = new Book();
                bl = unmarshall(Path.of(file.getAbsolutePath()));

                System.out.println("Result: "+bl.toString());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Book unmarshall(Path path) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Book.class);
        return (Book) context.createUnmarshaller()
                .unmarshal(new FileReader(String.valueOf(path)));
    }
}
