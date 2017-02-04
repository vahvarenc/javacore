package hospital;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Tigran on 10/24/2016.
 */
public class Building {
private String address;
    private final String name = "Hospital ";



    public void registerPatient(String name,String surName,String diagnosys) {
        try{
            String verify, putData;
            File file = new File("Patient.txt");
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("a");
            bw.flush();
            bw.close();
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while( br.readLine() != null ){
                verify = br.readLine();
                if(verify != null){
                    putData = verify.replaceAll("here", "there");
                    bw.write(putData);
                }
            }
            br.close();


        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
