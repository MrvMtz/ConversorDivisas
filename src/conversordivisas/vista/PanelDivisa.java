/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package conversordivisas.vista;

import conversordivisas.modelo.ConversorModel;
import conversordivisas.modelo.Moneda;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
//import swingconversor.modelo.ConversorModel;
//import swingconversor.modelo.Moneda;
/**
 *
 * @author MrvMtz
 */
public class PanelDivisa extends MiPanel{

    private JComboBox<Moneda> comboBox1;
    private MiPanel panelIzquierdo = new MiPanel(65, 50, Color.WHITE);
    private JLabel imageLabel;
    public JTextField textField = new JTextField(20);
    
    public PanelDivisa() {
                super(270, 50, Color.WHITE);

        MiPanel panelAlto = new MiPanel(250, 30, Color.white);
        add(panelAlto, BorderLayout.NORTH);


        MiPanel panelBajo = new MiPanel(250, 90, Color.WHITE);
        panelBajo.add(new MiPanel(6, 90, Color.WHITE), BorderLayout.WEST);
        panelBajo.add(new MiPanel(250, 10, Color.WHITE), BorderLayout.NORTH);
        panelBajo.add(new MiPanel(250, 40, Color.WHITE), BorderLayout.SOUTH);
        panelBajo.add(new MiPanel(6, 90, Color.WHITE), BorderLayout.EAST);
        panelBajo.add(textField, BorderLayout.CENTER);
        add(panelBajo, BorderLayout.SOUTH);

        panelIzquierdo.add(crearImagen("/conversordivisas/vista/icons/USD.png"), BorderLayout.EAST);

        add(panelIzquierdo, BorderLayout.WEST);

        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new NumbersOnlyDocumentFilter());
        MiPanel panelDerecho = new MiPanel(200, 10, Color.WHITE);
        panelDerecho.add(new MiPanel(6, 10, Color.WHITE), BorderLayout.EAST);
        comboBox1 = new JComboBox<>(new ConversorModel().getMonedas().toArray(new Moneda[0]));
        comboBox1.setPreferredSize(new Dimension(100, 10));
        panelDerecho.add(comboBox1);
        comboActionListener(comboBox1);

        add(panelDerecho, BorderLayout.EAST);
    }

    
    public JComboBox<Moneda> getComboBox1() {
        return comboBox1;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    
    
    private void comboActionListener(JComboBox<Moneda> comboBox) {

        comboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Moneda divisa = (Moneda) comboBox.getSelectedItem();
                crearImagen(divisa.getPath()); 
            }
        });

    }
    
    private JLabel crearImagen(String path) {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
        Image image = imageIcon.getImage();
        Image resizedImage = image.getScaledInstance(60, 65, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        if (imageLabel == null) {
            // Si la etiqueta de imagen no ha sido creada previamente, la creamos
            imageLabel = new JLabel(resizedIcon);
            panelIzquierdo.add(imageLabel, BorderLayout.EAST);
        } else {
            // Si la etiqueta de imagen ya existe, actualizamos su ícono
            imageLabel.setIcon(resizedIcon);
        }

        return imageLabel;
    }
    
}
