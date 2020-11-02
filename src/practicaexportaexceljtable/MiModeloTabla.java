package practicaexportaexceljtable;

import javax.swing.table.DefaultTableModel;

public class MiModeloTabla extends DefaultTableModel{
	private static final long serialVersionUID = 1L;
	public static int EDITAR_COLUMNA = -1;
    private int columnaEditable;
    private boolean permitirEditable;

    /**
     * Constructor vacio, que no permitirá que ninguna celda pueda editarse.
     */
    public MiModeloTabla() {
        super();
        permitirEditable = false;
    }
    
    /**
     * Constructor que recibe el EDITAR_COLUMNA, solo para indicar que se podra
     * editar alguna columna, luego debes hacer uso del método setColumnaEditable
     * para indicar que columna desea que sea la editable.
     * @param editar 
     */
    public MiModeloTabla(int editar) {
        permitirEditable = true;
        this.columnaEditable = editar;
    }
    
    /**
     * Metodo sobreescrito, para permitir o no que celdas podrian editarse
     * @param row
     * @param column
     * @return 
     */
    @Override
    public final boolean isCellEditable(int row, int column) {
        if ( permitirEditable == false ){
            return false;
        }else if (permitirEditable == true ){
            if ( column == columnaEditable ){
                return true;
            }
        }
        return false;
    }

    /**
     * Indica el numero de columna que sea editable, recuerde que en la tabla
     * la primera celda es 0
     * @param columnaEditable 
     */
    public void setColumnaEditable(int columnaEditable) {
        this.columnaEditable = columnaEditable;
    }
}
