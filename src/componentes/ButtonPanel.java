package componentes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author JebGy
 */
public class ButtonPanel extends JPanel {

    int borderRadius = 24;
    int Cr = 44, Crg = 44, Crgb = 44;
    String colors="";

    public ButtonPanel() {
        this.setBackground(new Color(0, 0, 0, 0));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(Cr,Crg,Crgb));
        g2d.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), borderRadius, borderRadius);
        g2d.setColor(new Color(109, 208, 124));
        g2d.drawRoundRect(0, 0, this.getWidth()-4, this.getHeight()-4, borderRadius, borderRadius);
        repaint();
    }

    public int getBorderRadius() {
        return borderRadius;
    }

    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
    }

    public int getCr() {
        return Cr;
    }

    public void setCr(int Cr) {
        this.Cr = Cr;
    }

    public int getCrg() {
        return Crg;
    }

    public void setCrg(int Crg) {
        this.Crg = Crg;
    }

    public int getCrgb() {
        return Crgb;
    }

    public void setCrgb(int Crgb) {
        this.Crgb = Crgb;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

}
