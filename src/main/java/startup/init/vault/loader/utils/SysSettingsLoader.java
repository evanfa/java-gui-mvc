package startup.init.vault.loader.utils;

import java.awt.*;
import java.io.File;

public class SysSettingsLoader {
    private int screenHeight;
    private int screenWidth;

    /**
     * Function that return current screen height
     * @return height
     */
    public static int getScreenHeight() {
        Dimension currentScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) currentScreenSize.getHeight();
    }

    /**
     * Function that return current screen width
     * @return width
     */
    public static int getScreenWidth() {
        Dimension currentScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) currentScreenSize.getWidth();
    }

    /**
     * Function that verify if folder exist.
     * @param {String} folderPathString
     * @return
     */
    public static Boolean folderExistInPath(String folderPathString){
        boolean flagConfirm = false;
        File f = new File(folderPathString);
        if (f.exists() && f.isDirectory()){
            flagConfirm = true;
        }
        return flagConfirm;
    }

    /**
     * Function that verify if file exist.
     *
     * @param {String} filePathString
     * @return {String} flagConfirm
     */
    public static Boolean fileExistInPath(String filePathString) {

        System.out.println("input: "+filePathString);
        boolean flagConfirm = false;
        File f = new File(filePathString);

        if(f.exists()){
            System.out.println("Exits input: "+filePathString);
        }

        if (f.exists() && !f.isDirectory()) {
            flagConfirm = true;
        }
        return flagConfirm;
    }
}
