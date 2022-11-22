/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author JebGy
 */
public class ConfigReader {

    public final String FILECONF = "conf.txt";
    public final String FILEWINOPEN = "confOpen.txt";

    public boolean showDepen() {
        try {
            File f = new File(FILECONF);
            String value;
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                value = br.readLine();
            }
            return value.equals("true");

        } catch (IOException e) {
            System.out.println("Error: " + e.toString());
            return false;
        }
    }

    public void saveConf(int i) {
        try {
            File f = new File(FILECONF);
            try (FileWriter fw = new FileWriter(f)) {
                if (i == 1) {
                    fw.append("true");
                } else {
                    fw.append("false");
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.toString());
        }
    }
    
    public int timeToChange(int size,int interval){
        return (size/interval);
    }
}
