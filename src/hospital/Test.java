package hospital;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


import static java.lang.System.out;


public class Test {
    public static void main(String[] args) throws IOException {

        boolean hospitalIsOpen = true;
        Patient patient = new Patient();
        Doctor doctor = new Doctor();
        Building building = new Building();
        ArrayList<String> patientList = new ArrayList<>();
        HospitalManager manager = new HospitalManager();


        while (hospitalIsOpen) {
            out.println("");
            out.println("==Navigation==");
            out.println("1: Show all patients");
            out.println("2: Add new patient");
            out.println("3: Edit Patient ");
            out.println("4: Delete Patient ");
            out.println("5: Exit");
            Scanner chooser = new Scanner(System.in);
            int x = chooser.nextInt();
            if (x == 1) {
                try {
                    FileReader fr = new FileReader("Patient.txt");
                    BufferedReader br = new BufferedReader(fr);

                    String str;
                    while ((str = br.readLine()) != null) {
                        out.println(str + "\n");
                    }
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (x == 2) {
                manager.registerPatient(patient);
                manager.addPatient(patient, patientList);
            } else if (x == 5) {
                manager.done();
                hospitalIsOpen = false;


            }
        }
    }
}