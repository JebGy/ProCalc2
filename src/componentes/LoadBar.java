package componentes;

import classes.ConfigReader;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import view.InstalDependeces;
import view.Main;
import view.Splash;

/**
 *
 * @author JebGy
 */
public class LoadBar extends JPanel {

    int borderRadius = 20;
    int Cr = 44, Crg = 44, Crgb = 44;
    int wBar = 0;
    String colors = "";

    public LoadBar() {
        this.setBackground(new Color(0, 0, 0, 0));

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        fillBar(1000);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(Cr, Crg, Crgb));
        g2d.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), borderRadius, borderRadius);
        g2d.setColor(new Color(109, 208, 124));
        g2d.drawRoundRect(0, 0, this.getWidth() - 2, this.getHeight() - 2, borderRadius, borderRadius);
        g2d.setColor(new Color(60, 150, 99));
        g2d.fillRoundRect(3, 3, wBar - 3, this.getHeight() - 7, borderRadius, borderRadius);
        repaint();
    }
    public boolean isFinished = false;

    public void fillBar(int time) {
        int v = 50;

        Thread t = new Thread(() -> {
            if (wBar < (this.getWidth() - 4)) {

                try {
                    wBar++;
                    Thread.sleep(time);
                } catch (Exception e) {
                }
            } else {
                isFinished = true;
            }
        });
        t.start();

    }

    public void openView() {
        ConfigReader cr = new ConfigReader();
        if (cr.showDepen()) {

        } else {

        }
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
