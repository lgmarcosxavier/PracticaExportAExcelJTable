package practicaexportaexceljtable;

import javax.swing.JTable;
//import rojerusan.RSTableMetro;

/**
 * Clase para "ocultar" la nColumna de una tabla.
 * @author lgmar
 *
 */
public class OcultarColumnasTabla {
    
    private OcultarColumnasTabla() {
    }
    
//    public static void ocultarColumna(RSTableMetro tabla, int nColumna){
//        tabla.getColumnModel().getColumn(nColumna).setMaxWidth(0);
//        tabla.getColumnModel().getColumn(nColumna).setMinWidth(0);
//        tabla.getColumnModel().getColumn(nColumna).setPreferredWidth(0);
//        tabla.getColumnModel().getColumn(nColumna).setResizable(false);
//    }
    
    public static void ocultarColumna(JTablePersonalizado tabla, int nColumna){
        tabla.getColumnModel().getColumn(nColumna).setMaxWidth(0);
        tabla.getColumnModel().getColumn(nColumna).setMinWidth(0);
        tabla.getColumnModel().getColumn(nColumna).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(nColumna).setResizable(false);
    }
    
    public static void ocultarColumna(JTable tabla, int nColumna){
        tabla.getColumnModel().getColumn(nColumna).setMaxWidth(0);
        tabla.getColumnModel().getColumn(nColumna).setMinWidth(0);
        tabla.getColumnModel().getColumn(nColumna).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(nColumna).setResizable(false);
    }
    
}
