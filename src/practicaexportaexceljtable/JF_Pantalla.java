package practicaexportaexceljtable;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class JF_Pantalla extends javax.swing.JFrame {

    public JF_Pantalla() {
        initComponents();
        
        MiModeloTabla modelo = new MiModeloTabla();
        
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        Object O[] = null;
        
        for (int i = 0; i < 3 ; i++ ){
            modelo.addRow(O);
            
            if ( i == 0 ){
                modelo.setValueAt("1", i, 0);
                modelo.setValueAt("Marcos", i, 1);
            }else if ( i == 1 ){
                modelo.setValueAt("2", i, 0);
                modelo.setValueAt("Xavier", i, 1);
            }else if ( i == 2 ){
                modelo.setValueAt("3", i, 0);
                modelo.setValueAt("Pedro", i, 1);
            }
        }
        
        jTablePersonalizado1.setModel(modelo);
        jTablePersonalizado1.repintar();
        OcultarColumnasTabla.ocultarColumna(jTablePersonalizado1, 0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JBtn_Exportar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTbl_tabla = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePersonalizado1 = new practicaexportaexceljtable.JTablePersonalizado();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Practica Exportar a Excel");

        JBtn_Exportar.setText("Exportar Tabla a Excel");
        JBtn_Exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBtn_ExportarActionPerformed(evt);
            }
        });

        JTbl_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Levyn", "Miranda", "Zacapa", "4802323"},
                {"Marcos", "Lopez", "Zacapa", "3840923"},
                {"Juan", "Ramos", "Chiquimula", "84230"}
            },
            new String [] {
                "Nombre", "Apellido", "Dirección", "Teléfono"
            }
        ));
        jScrollPane1.setViewportView(JTbl_tabla);

        jTablePersonalizado1.setBackground(new java.awt.Color(204, 204, 204));
        jTablePersonalizado1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Marcos", "Lopez", "Zacapa", "48202329"},
                {"Sergio", "Aguirre", "Estanzuela", "38283828"},
                {"Glezz", "Gonzalez", "Zacapa", "59493829"},
                {"Pedro", "Madrid", "Zacapa", null}
            },
            new String [] {
                "Nombre", "Apellido", "Dirección", "Teléfono"
            }
        ));
        jTablePersonalizado1.setCOLOR_FILA_SELECCIONADA(new java.awt.Color(204, 204, 255));
        jTablePersonalizado1.setCOLOR_FONDO_ENCABEZADO(new java.awt.Color(255, 102, 102));
        jTablePersonalizado1.setCOLOR_IMPARES(new java.awt.Color(153, 153, 255));
        jTablePersonalizado1.setCOLOR_PARES(new java.awt.Color(102, 153, 255));
        jTablePersonalizado1.setFONT_SIZE_ENCABEZADO(14);
        jScrollPane2.setViewportView(jTablePersonalizado1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(JBtn_Exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addComponent(JBtn_Exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBtn_ExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtn_ExportarActionPerformed
        try {
            exportarTabla(JTbl_tabla);
        } catch (IOException ex) {
            Logger.getLogger(JF_Pantalla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JBtn_ExportarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JF_Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JF_Pantalla().setVisible(true);
            }
        });
    }
    
    public void exportarTabla(JTable t) throws IOException {
        JFileChooser chooser = new JFileChooser();
        
        // cremaos el filtro que indica en que formato guardaremos el documento y con que extension
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Libro de Excel", "xlsx"); // "xls"
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar como");
        chooser.setAcceptAllFileFilterUsed(false);
        
        // validamos que solo guarde y lea en que ruta se debe guardar, si el usuario le dio "Guardar"
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xlsx"); // ".xls"
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) { // si hay un archvo que ya existe, lo sobreescribie
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile(); // se crea el archivo en la ruta especificada
                Workbook libro = new HSSFWorkbook();
                
                // se usara el archivo creado, para sobreescribir
                try (FileOutputStream archivo = new FileOutputStream(archivoXLS)) {
                    Sheet hoja = libro.createSheet("Hoja 1"); // se crea la primera hoja
                    hoja.setDisplayGridlines(false);
                    for (int f = 0; f < t.getRowCount(); f++) { // recorrer todas las filas de la tabla "t"
                        Row fila = (Row) hoja.createRow(f); // y por cada cada fila se creara una fila en el archivo
                        for (int c = 0; c < t.getColumnCount(); c++) { // recorre las columnas de esa fila
                            Cell celda = fila.createCell(c); // crea la celda
                            if (f == 0) { 
                                celda.setCellValue(t.getColumnName(c)); // especifa el nombre de la columna
                            }
                        }
                    }
                    int filaInicio = 1;
                    for (int f = 0; f < t.getRowCount(); f++) { // nuevamente recorre las filas para escribir el texto
                        Row fila = hoja.createRow(filaInicio); 
                        filaInicio++;
                        for (int c = 0; c < t.getColumnCount(); c++) {
                            Cell celda = fila.createCell(c); // se creada una celda por la celda de la tabla
                            
                            // validar que tipo de dato podria ser el valor de la celda, para escibir el dato correctamente
                            // escribien en la fila, y columna correspondiente
                            if (t.getValueAt(f, c) instanceof Double) { 
                                
                                celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                            } else if (t.getValueAt(f, c) instanceof Float) {
                                celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                            } else {
                                celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                            }
                        }
                    }
                    libro.write(archivo); // escribir el arhivo creado
                }
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
                throw e;
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBtn_Exportar;
    private javax.swing.JTable JTbl_tabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private practicaexportaexceljtable.JTablePersonalizado jTablePersonalizado1;
    // End of variables declaration//GEN-END:variables
}
