/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import javax.swing.JOptionPane;

/**
 *
 * @author JebGy
 */
public class DependencesInstaller {

    public void downloadPython() {
        Desktop enlace = Desktop.getDesktop();
        try {
            String comand = "https://www.python.org/ftp/python/3.11.0/python-3.11.0-amd64.exe";
            try {
                enlace.browse(new URI(comand));
            } catch (URISyntaxException ex) {
                JOptionPane.showMessageDialog(null, "Error: - " + ex.toString());
            }
        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "Error: - " + e.toString());
        }
    }

    
}
