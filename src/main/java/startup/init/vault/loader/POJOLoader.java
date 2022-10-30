package startup.init.vault.loader;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import startup.init.vault.loader.obj.PathLoader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class POJOLoader {

    public POJOLoader() {
    }

    /**
     * JABX Path Loader - Return default paths after unmarshall.
     * @param pathDefaultXML
     * @return
     */
    public static PathLoader defaultLoaderXMLPaths(String pathDefaultXML){
        JAXBContext jaxbContext = null;
        PathLoader bl = null;
        try {
            File file = new File(pathDefaultXML);
            if (file.exists()) {
                System.out.println("Exists!");
                bl = new PathLoader();
                bl = POJOLoader.unmarshall(Path.of(file.getAbsolutePath()));
                return bl;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bl;
    }

    /**
     * Unmarshall XML File - Jakarta
     * @param path
     * @return
     * @throws JAXBException
     * @throws IOException
     */
    public static PathLoader unmarshall(Path path) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(PathLoader.class);
        return (PathLoader) context.createUnmarshaller().unmarshal(new FileReader(String.valueOf(path)));
    }
}
