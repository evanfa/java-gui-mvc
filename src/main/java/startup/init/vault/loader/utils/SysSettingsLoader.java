package startup.init.vault.loader.utils;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class SysSettingsLoader {
    private static int screenHeight;
    private static int screenWidth;
    private static JPanel mainPanel;

    /**
     * Function that returns the current main parent of the GUI
     * @return JPanel
     */
    public static JPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * Function that sets the current main parent of the GUI
     * @param mainPanel
     */
    public static void setMainPanel(JPanel mainPanel) {
       mainPanel = mainPanel;
    }

    /**
     * Function that return current screen height
     *
     * @return height
     */
    public static int getScreenHeight() {
        Dimension currentScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) currentScreenSize.getHeight();
    }

    /**
     * Function that return current screen width
     *
     * @return width
     */
    public static int getScreenWidth() {
        Dimension currentScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) currentScreenSize.getWidth();
    }

    /**
     * Function that verify if folder exist.
     *
     * @param {String} folderPathString
     * @return
     */
    public static Boolean folderExistInPath(String folderPathString) {
        boolean flagConfirm = false;
        File f = new File(folderPathString);
        if (f.exists() && f.isDirectory()) {
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
        boolean flagConfirm = false;
        File f = new File(filePathString);
        if (f.exists() && !f.isDirectory()) {
            flagConfirm = true;
        }
        return flagConfirm;
    }

    /**
     * Function that creates a Directory
     *
     * @param {String} destDir Path and name of the new folder
     * @throws IOException
     */
    public static void createDirectory(String destDir) throws IOException {
        File directory = new File(destDir);
        if (!directory.exists()) {
            try {
                directory.mkdir();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Function that copy files.
     *
     * @param {File} input
     * @param {File} output
     */
    public static void fileCopier(File input, File output) {
        try {
            if (input.exists() && output.exists()) {
                copyFileUsingStream(input, output);
            } else JOptionPane.showMessageDialog(null, "File dont exist - Input and/or output");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Function that copy file using stream
     *
     * @param {File} source
     * @param {File} dest
     * @throws IOException
     */
    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

}
