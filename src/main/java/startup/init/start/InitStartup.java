package startup.init.start;
import startup.init.vault.loader.POJOLoader;
import startup.init.vault.loader.obj.PathLoader;

import java.util.List;

public class InitStartup {

    private static String DEFAULT_CSV_FILE;
    private static List<String> defaultPahts;

    public InitStartup() {
        //this.xmlLoaderDefault = xmlLoaderDefault;

        /*
        POJOLoader pjL = new POJOLoader();
        PathLoader ptL = new PathLoader();
        System.out.println(ptL.getTvdrPath());
        System.out.println(ptL.getTxtlPath());
        System.out.println(ptL.getSdttPath());
        System.out.println(ptL.getTopoPath());
         */
    }

    public static void main(String[] args) {
        //InitStartup initS = new InitStartup();

        POJOLoader ptL = new POJOLoader();
    }

}