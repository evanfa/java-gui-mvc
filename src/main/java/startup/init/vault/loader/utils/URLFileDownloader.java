package startup.init.vault.loader.utils;

import startup.init.start.InitStartup;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class URLFileDownloader {

    public URLFileDownloader(String filePath, String downloadMethod) {

        if(downloadMethod.equals("custom")){
            try {
                customDownloadHTTP(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(downloadMethod.equals("stream")){
            /*
            downloadUsingStream: In this method of java download file from URL,
            we are using URL openStream method to create the input stream.
            Then we are using a file output stream to read data from the input stream and write to the file.
             */
            try {
                downloadUsingStream(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            /*
            downloadUsingNIO: In this download file from URL method, we are creating byte channel from URL stream data.
            Then use the file output stream to write it to file.
             */
            try {
                downloadUsingNIO(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //private static void downloadUsingStream(String urlStr, String file) throws IOException{
    private static void downloadUsingStream(String urlStr) throws IOException{
        urlStr = urlStr.replace(" ","%20");

        URL url = new URL(urlStr);
        String file = urlStr.substring(urlStr.lastIndexOf("/")+1,urlStr.length());

        //String agent = java.security.AccessController.doPrivileged(new sun.security.action.GetPropertyAction("http.agent"));
        //BufferedReader bis = new BufferedReader(new InputStreamReader(((HttpURLConnection) (new URL(urlStr)).openConnection()).getInputStream(), Charset.forName("UTF-8")));

        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(InitStartup.getDefaultFolderSite().concat("/").concat(file));
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }

    private static void downloadUsingNIO(String urlStr) throws IOException {
        urlStr = urlStr.replace(" ","%20");

        URL url = new URL(urlStr);
        String file = urlStr.substring(urlStr.lastIndexOf("/")+1,urlStr.length());
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(InitStartup.getDefaultFolderSite().concat("/").concat(file));
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }

    private  static void customDownloadHTTP(String urlStr) throws IOException{

        InputStream inS = null;

        urlStr = urlStr.replace(" ","%20");

        String file = urlStr.substring(urlStr.lastIndexOf("/")+1,urlStr.length());

        URL jInfo = new URL(urlStr);
        HttpURLConnection htpC = (HttpURLConnection) jInfo.openConnection();

        htpC.addRequestProperty("User-Agent", "Mozilla");
        htpC.setReadTimeout(5000);
        htpC.setConnectTimeout(5000);

        //htpC.addRequestProperty("User-Agent", "Mozilla/4.76");
        //htpC.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");

        System.out.println("Server Response: "+htpC.getResponseCode()+"\nServer Message: "+htpC.getResponseMessage());

        htpC.connect();

        System.out.println(
                "Content Lenght: "+htpC.getContentLength() + "\n" +
                "Content Encodig: "+htpC.getContentEncoding()+ "\n" +
                "Content Date: "+htpC.getDate() + "\n"
        );

            inS = htpC.getInputStream();

        try {
            OutputStream os = new FileOutputStream(InitStartup.getDefaultFolderSite().concat("/").concat(file));
            byte[] buffer = new byte[1024];
            int length;
                while ((length = inS.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
            os.close();
        } finally {
            inS.close();
        }

    }
}
