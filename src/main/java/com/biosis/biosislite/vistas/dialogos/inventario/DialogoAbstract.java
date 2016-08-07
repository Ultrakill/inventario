/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.dialogosVista;

import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public abstract class DialogoAbstract extends JDialog implements DialogoInterface{
    private JInternalFrame padre;

    public DialogoAbstract(JInternalFrame padre, boolean modal) {
        super(JOptionPane.getFrameForComponent(padre), modal);
        this.padre = padre;
    }

    public JInternalFrame getPadre() {
        return padre;
    }

    public void setPadre(JInternalFrame padre) {
        this.padre = padre;
    }
}
