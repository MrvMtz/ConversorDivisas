/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package conversordivisas.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author MrvMtz
 */
public class MiPanel extends JPanel {

    public MiPanel(int w, int h, Color color){
        
        setPreferredSize(new Dimension(w, h));
        setBackground(color);
        setLayout(new BorderLayout());
        
    }
    
    protected JLabel crearTexto(String texto, Color color, int fontStyle, int fontSize){
    
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Arial", fontStyle, fontSize));
        label.setForeground(color);
        label.setHorizontalAlignment(JLabel.CENTER);
        
        return label;
    }
}
