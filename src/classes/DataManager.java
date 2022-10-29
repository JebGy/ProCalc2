/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

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
            try ( FileWriter fr = new FileWriter(f)) {
                fr.append("<Intervalos\n" + this.interval);
                fr.append("\n<Formula\n" + "!" + this.formula);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public String readData() {
        try {
            File f = new File("result.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = br.readLine();
            return line;

        } catch (IOException e) {
            System.out.println("Error: -" + e.toString());
            return null;
        }
    }

    public void runners() {

        try {
            String comand = "py SolverPyKernel.py";
            Runtime.getRuntime().exec(comand);
            JOptionPane.showMessageDialog(null, "Please wait a second :3");
        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "Error: - " + e.toString());
        }

    }
}
