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
public class CodeProces {
    
    public File file= new File("GraphApp.py");
    public String code="";
    public String fullCode="";
    
    public void codeRead(){
        try {
            BufferedReader br=new BufferedReader(new FileReader(file));
            
            while ((code=br.readLine())!=null) {                
                fullCode+=code+"\n";
                System.out.println(fullCode);
            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error! - "+e.toString());
        }
    }
    
    public void editStyle(String style,String intervals){
        try {
            FileWriter fr= new FileWriter("varsGraph.txt");
            fr.append(intervals);
            fr.append("\n<"+style);
            fr.close();
        } catch (IOException e) {
            System.out.println("Error: "+e.toString());
        }
    }
    
    public void codeWriter(String codeLine){
        try {
            FileWriter fr= new FileWriter(file);
            fr.append(codeLine);
            fr.close();
        } catch (IOException e) {
            System.out.println("Error: "+e.toString());
        }
    }
    public void graphCode(){
        try {
            String comand="py GraphApp.py";
            Runtime.getRuntime().exec(comand);
            JOptionPane.showMessageDialog(null, "Please wait a second :3");
        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "Error: - "+e.toString());
        }
    }
}
