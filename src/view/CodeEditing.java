/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import classes.CodeProces;
import classes.DataManager;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author JebGy
 */
public class CodeEditing extends javax.swing.JPanel {

    /**
     * Creates new form MainView
     */
    public CodeEditing() {
        initComponents();
        colors();
        CodeProces cp = new CodeProces();
        cp.codeRead();
        txt_area.setText(cp.fullCode);
    }

    private int ultimaCadena(String text, int index) {
        while (--index > 0) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
        }
        return index;
    }

    private int primeraCadena(String text, int index) {
        while (index < text.length()) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
            index++;
        }
        return index;

    }

    private void colors() {

        final StyleContext cont = StyleContext.getDefaultStyleContext();

        //COLORES 
        final AttributeSet attred = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(234, 122, 125));
        final AttributeSet attyellow = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(244, 179, 26));
        final AttributeSet attblue = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(21, 133, 130));
        final AttributeSet attgreen = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(110, 208, 125));
        final AttributeSet attwhite = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(204, 209, 217));

        //STYLO 
        DefaultStyledDocument doc = new DefaultStyledDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
                super.insertString(offset, str, a);

                String text = getText(0, getLength());
                int before = ultimaCadena(text, offset);
                if (before < 0) {
                    before = 0;
                }
                int after = primeraCadena(text, offset + str.length());
                int wordL = before;
                int wordR = before;

                while (wordR <= after) {
                    if (wordR == after || String.valueOf(text.charAt(wordR)).matches("\\W")) {
                        if (text.substring(wordL, wordR).matches("(\\W)*(import|as|print|'|" + '"' + "|@|from)")) {
                            setCharacterAttributes(wordL, wordR - wordL, attgreen, false);
                        } else if (text.substring(wordL, wordR).matches("(\\W)*(0|1|2|3|4|5|6|7|8|9)")) {
                            setCharacterAttributes(wordL, wordR - wordL, attblue, false);
                        } else if (text.substring(wordL, wordR).matches("(\\W)*(int|if|else|elif|def|str|return|:|,)")) {
                            setCharacterAttributes(wordL, wordR - wordL, attyellow, false);
                        } else if (text.substring(wordL, wordR).matches("(\\W)*(#|=|.)")) {
                            setCharacterAttributes(wordL, wordR - wordL, attred, false);
                        } else {
                            setCharacterAttributes(wordL, wordR - wordL, attwhite, false);
                        }
                        wordL = wordR;

                    }
                    wordR++;
                }
            }

            public void romeve(int offs, int len) throws BadLocationException {
                super.remove(offs, len);

                String text = getText(0, getLength());
                int before = ultimaCadena(text, offs);
                if (before < 0) {
                    before = 0;
                }
            }
        };

        JTextPane txt = new JTextPane(doc);
        String temp = txt_area.getText();
        txt_area.setStyledDocument(txt.getStyledDocument());
        txt_area.setText(temp);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        buttonPanel1 = new componentes.ButtonPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_area = new javax.swing.JTextPane();

        setBackground(new java.awt.Color(44, 44, 44));
        setPreferredSize(new java.awt.Dimension(779, 397));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Lato Light", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("You can edit the code:");

        buttonPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonPanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonPanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonPanel1MouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lato Light", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SaveMod");

        javax.swing.GroupLayout buttonPanel1Layout = new javax.swing.GroupLayout(buttonPanel1);
        buttonPanel1.setLayout(buttonPanel1Layout);
        buttonPanel1Layout.setHorizontalGroup(
            buttonPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );
        buttonPanel1Layout.setVerticalGroup(
            buttonPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        );

        txt_area.setBackground(new java.awt.Color(33, 33, 33));
        txt_area.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        txt_area.setCaretColor(new java.awt.Color(255, 102, 102));
        jScrollPane2.setViewportView(txt_area);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                        .addComponent(buttonPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPanel1MouseEntered
        buttonPanel1.setCr(109);
        buttonPanel1.setCrg(208);
        buttonPanel1.setCrgb(124);
    }//GEN-LAST:event_buttonPanel1MouseEntered

    private void buttonPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPanel1MouseExited
        buttonPanel1.setCr(44);
        buttonPanel1.setCrg(44);
        buttonPanel1.setCrgb(44);
    }//GEN-LAST:event_buttonPanel1MouseExited

    private void buttonPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPanel1MouseClicked
        CodeProces cp = new CodeProces();
        cp.codeWriter(txt_area.getText());
    }//GEN-LAST:event_buttonPanel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.ButtonPanel buttonPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane txt_area;
    // End of variables declaration//GEN-END:variables
}