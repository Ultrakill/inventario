/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.utiles;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author Aldo
 */
public class PersButtonUI extends BasicButtonUI{
    
    private String colorBase;
    private String colorSeleccionado;
    
    public PersButtonUI(String colorBase, String colorSeleccionado){
        this.colorBase = colorBase;
        this.colorSeleccionado = colorSeleccionado;
    }
    
    public void paint(Graphics g,JComponent c){
      JButton myButton = (JButton) c;
      ButtonModel buttonModel = myButton.getModel();
      if(buttonModel.isPressed() || buttonModel.isSelected()){
          g.setColor(Color.decode(colorSeleccionado));
      }else{
          g.setColor(Color.decode(colorBase));
      }
      g.fillRect(0, 0, c.getWidth(), c.getHeight());
      super.paint(g,c);
    }
    
}
