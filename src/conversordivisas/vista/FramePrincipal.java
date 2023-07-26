/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package conversordivisas.vista;

import conversordivisas.modelo.ConversorModel;
import conversordivisas.modelo.Moneda;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author MrvMtz
 */
public class FramePrincipal extends JFrame{

    private PanelDivisa panelDivisa1 = new PanelDivisa();
    private PanelDivisa panelDivisa2 = new PanelDivisa();
    private Color azulOscuro = new Color(0, 0, 128);
    
    public FramePrincipal(){
        
        setTitle("Conversor de Divisas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 300);

        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        
        MiPanel panelTitulo = new MiPanel(500, 50, azulOscuro);
        panelTitulo.add(panelTitulo.crearTexto("CONVIERTA SU MONEDA FÁCIL Y RÁPIDO.", Color.white, Font.BOLD, 16), BorderLayout.CENTER);
        add(panelTitulo, BorderLayout.NORTH);

        addDocumentListenerToTextField(panelDivisa1.getTextField());
        add(panelDivisa1, BorderLayout.WEST);

        panelDivisa2.getTextField().setEditable(false);
        add(panelDivisa2, BorderLayout.EAST);

        MiPanel panelFooter = new MiPanel(500, 50, Color.LIGHT_GRAY);
        panelFooter.add(panelFooter.crearTexto("MrvMtz - Alura Challenge 2", azulOscuro, Font.PLAIN, 12), BorderLayout.CENTER);
        add(panelFooter, BorderLayout.SOUTH);
    
}
    
    private void addDocumentListenerToTextField(JTextField textField) {

        textField.getDocument().addDocumentListener(new DocumentListener() {

            ConversorModel conversor = new ConversorModel();
            Double cantidadOrigen;

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTextField();
                
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTextField();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateTextField();
            }

            private void updateTextField() {
                String texto = textField.getText();
                try {
                    cantidadOrigen = Double.parseDouble(texto);
                } catch (NumberFormatException ex) {
                    cantidadOrigen = 0.0;
                }
                
                    Moneda monedaOrigen = obtenerItemCombo(panelDivisa1);
                    Moneda monedaDestino = obtenerItemCombo(panelDivisa2);
                    panelDivisa2.getTextField().setText(String.valueOf(actualizarTextFieldDestino(monedaOrigen, monedaDestino)));
                   
    }

        private double actualizarTextFieldDestino(Moneda origen, Moneda destino) {
                Double cantidadDestino;

                if (origen.getId() == 1) {
                    cantidadDestino = conversor.DolaraOtraDivisa(cantidadOrigen, destino.getValor());
                } else if (destino.getId() == 1) {
                    cantidadDestino = conversor.otraDivisaADolar(cantidadOrigen, origen.getValor());
                } else {
                    cantidadOrigen = conversor.otraDivisaADolar(cantidadOrigen, origen.getValor());
                    cantidadDestino = conversor.DolaraOtraDivisa(cantidadOrigen, destino.getValor());
                }

                return cantidadDestino;
            }
        });
    }

    public Moneda obtenerItemCombo(PanelDivisa panel) {
        return (Moneda) panel.getComboBox1().getSelectedItem();
    }
}
