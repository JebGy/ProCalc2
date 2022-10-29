/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author JebGy
 */
public class Inputs extends JTextField{

    public Inputs() {
        this.setBackground(new Color(0,0,0,0));
        this.setBorder(null);
    }
    
    int borderRadius=16;
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(0,0,0,0));
        g2d.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), borderRadius, borderRadius);
        g2d.setColor(new Color(208, 109, 124));
        g2d.drawRoundRect(0, 0, this.getWidth()-4, this.getHeight()-4, borderRadius, borderRadius);
        repaint();
    }

    public int getBorderRadius() {
        return borderRadius;
    }

    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
    }
    
}
