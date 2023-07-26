/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package conversordivisas.vista;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
/**
 *
 * @author MrvMtz
 */
public class NumbersOnlyDocumentFilter extends DocumentFilter {

       @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
        if (text == null) {
            return;
        }

        String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
        String newText = currentText.substring(0, offset) + text + currentText.substring(offset, currentText.length());

        // Verificar que solo se ingresen caracteres numéricos o un punto decimal
        if (newText.matches("\\d*\\.?\\d*")) {
            super.insertString(fb, offset, text, attr);
        }
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text == null) {
            return;
        }

        String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
        String newText = currentText.substring(0, offset) + text + currentText.substring(offset + length, currentText.length());

        // Verificar que solo se ingresen caracteres numéricos o un punto decimal
        if (newText.matches("\\d*\\.?\\d*")) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
}
