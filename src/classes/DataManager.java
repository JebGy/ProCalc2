/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author JebGy
 */
public class DataManager {

    public String formula = "";
    public String interval = "";
    public int cantidad = 3;

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Write Files
    public void writeData(String fomula, String intervalos) {
        File f = new File("vars.txt");
        try {
            FileWriter fr = new FileWriter(f);
            fr.append("<Intervalos\n" + this.interval);
            fr.append("\n<Formula\n" + "!" + this.formula);
            fr.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
    
    public String readData(){
        try {
            File f = new File("result.txt");
            BufferedReader br= new BufferedReader(new FileReader(f));
            String line= br.readLine();
            return line;
            
        } catch (Exception e) {
            System.out.println("Error: -"+e.toString());
            return null;
        }
    }
    
    public void runners() {
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("SolverPyKernel");
        } catch (Exception e) {
        }
    }
}
