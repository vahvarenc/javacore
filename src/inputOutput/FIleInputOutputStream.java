package inputOutput;

import java.io.*;

/**
 * Created by Vahag on 11/9/2016.
 */
public class FIleInputOutputStream {


    public static void main(String[] args) {
        String s = "ss";
        File outPutFolder = new File("resources");

        if (!outPutFolder.exists()) {
            outPutFolder.mkdir();
        }
        File file = new File(outPutFolder.getName() + File.separator + "Log.txt");
        OutputStream outs = null;
        try {
            outs = new FileOutputStream(file);
            outs.write("Some log info:".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(outs);
        }

        InputStream is = null;
        try {
            is = new FileInputStream(file);
            int length = is.available();
            byte [] buffer = new byte[length];
            is.read(buffer);
            String fileText = new String(buffer);
            System.out.println(fileText);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
           close(is);
        }

        
    }

    private static void close(Closeable closeable){
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
