package inputOutput;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Vahag on 11/8/2016.
 */
public class FilesDemo {
    public static void main(String[] args) {
        File file = new File(".");
        String [] fileList = file.list();
        for (String fileName: fileList) {
            System.out.println(fileName);
        }

    }


}
