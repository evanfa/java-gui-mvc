package startup.init.vault.loader;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import startup.init.vault.loader.obj.PathLoader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class POJOLoader {

    private PathLoader bl = null;

    public POJOLoader() {
        JAXBContext jaxbContext = null;
        try {
            File file = new File("C:\\Users\\fabio_rodriguez\\OneDrive - TransCanada Corporation\\Documents\\IT\\Java-src\\java-gui-mvc\\src\\main\\java\\startup\\init\\config\\xml\\paths_config.xml");
            if (file.exists()) {
                System.out.println("Exists!");
                bl = new PathLoader();
                bl = unmarshall(Path.of(file.getAbsolutePath()));

                System.out.println("Result: " + bl.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PathLoader unmarshall(Path path) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(PathLoader.class);
        return (PathLoader) context.createUnmarshaller().unmarshal(new FileReader(String.valueOf(path)));
    }

    /*
    JAXBContext jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
    .createContext(new Class[]{PathLoader.class}, null);
     */
}
