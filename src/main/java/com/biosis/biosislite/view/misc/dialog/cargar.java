/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biosis.biosislite.view.misc.dialog;

import javax.swing.JProgressBar;

/**
 *
 * @author Documentos
 */
public class cargar extends Thread{
    
    JProgressBar progreso;

        public cargar(JProgressBar progreso) {
            super();
            this.progreso = progreso;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 100; i++) {
                progreso.setValue(i);
                pausa(90);
            }
        }

        public void pausa(int mili) {
            try {

                Thread.sleep(mili);

            } catch (Exception e) {

            }
        }
    
}
