package startup.init.vault.loader.utils;

import java.io.*;

public class FilesCopier {

    public static void generateCopyFileInPath(String tempFile, String destPath) {
        try {
            //System.out.println("Temp File: "+tempFile+" - DestPath: "+destPath);
            File temp = new File(tempFile);
            //destPath = destPath.concat(temp.getName());
            File dest = new File(destPath);
            fileCopier(temp, dest);
        } catch (NullPointerException e) {
            System.out.println("Error in file: " + e);
        }

    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        //InputStream is = null;
        //OutputStream os = null;
        try {
            InputStream is = new FileInputStream(source);
            OutputStream os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();
        } catch(Exception ext){
            System.out.println("Error: "+ext);
        } finally{
           // is.close();
           // os.close();
        }
    }


    public static void fileCopier(File input, File output) {
        //System.out.println("Input: "+input);
        //System.out.println("Output: "+output);
        try {
            if (input.exists()) {
             copyFileUsingStream(input, output);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Boolean fileExistInPath(String filePathString) {
        boolean flagConfirm = false;
        File f = new File(filePathString);

        if (f.exists() && !f.isDirectory()) {
            flagConfirm = true;
        }
        return flagConfirm;
    }
}