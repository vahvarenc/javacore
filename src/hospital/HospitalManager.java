package hospital;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class HospitalManager {
    FileWriter fw = new FileWriter("Patient.txt");
    BufferedWriter bw = new BufferedWriter(fw);

    public HospitalManager() throws IOException {
    }

    public Patient registerPatient(Patient p1) {
        out.println("=Adding new patient=");
        out.println("Please enter the name");
        Scanner setter = new Scanner(System.in);
        p1.name = setter.nextLine();
        out.println("Enter the surname");
        p1.surName = setter.nextLine();
        out.println("Enter the diagnosys");
        p1.diagnose = setter.nextLine();

        return p1;
    }

    public void addPatient(Patient addThisOne, List<String> patientList) {
        try {
            bw.append(addThisOne.name + ", " + addThisOne.surName + ", " + addThisOne.diagnose);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void done() {             // todo vor es function@ chkanchenq  inch klini,cragir@ chi ashxati senc te nenc?

        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void editor() {

    }


}
