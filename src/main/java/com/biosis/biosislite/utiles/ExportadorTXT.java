/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.biosislite.utiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import jxl.write.WriteException;

/**
 *
 * @author Documentos
 */
public class ExportadorTXT {

    private File archivo;
    private JTable tabla;
    private List<String> nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean flag;

    public ExportadorTXT(File archivo, List<JTable> tabla, List<String> nombres, Date fecha_inicio, Date fecha_fin, boolean flag) throws Exception {
        this.archivo = archivo;
        this.tabla = tabla.get(0);
        this.nombre = nombres;
        this.fechaInicio = fecha_inicio;
        this.fechaFin = fecha_fin;
        this.flag = flag;

        if (nombres.size() != tabla.size()) {
            throw new Exception("Error");
        }
    }

    public boolean exportarTXT() {

        try {

//            String sucursalesCSVFile = "src/archivos/DatosTabla.txt";
            BufferedWriter bfw = new BufferedWriter(new FileWriter(archivo));

            for (int i = 0; i < tabla.getRowCount(); i++) //realiza un barrido por filas.
            {
                for (int j = 0; j < tabla.getColumnCount(); j++) //realiza un barrido por columnas.
                {
                    bfw.write(tabla.getValueAt(i, j)+"");
                    if (j < tabla.getColumnCount() - 1) { //agrega separador "," si no es el ultimo elemento de la fila.
                        bfw.write(",");
                    }
                }
                bfw.newLine(); //inserta nueva linea.
            }

            bfw.close(); //cierra archivo!
            System.out.println("El archivo fue salvado correctamente!");
            return true;
        } catch (IOException e) {
            System.out.println("ERROR: Ocurrio un problema al salvar el archivo!" + e.getMessage());
            return false;
        }
    }
}
