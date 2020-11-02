package practicaexportaexceljtable;

import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.RowSorter.SortKey;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 * A default cell renderer for a JTableHeader.
 * <P>
 * DefaultTableHeaderCellRenderer attempts to provide identical behavior to the
 * renderer which the Swing subsystem uses by default, the Sun proprietary class
 * sun.swing.table.DefaultTableCellHeaderRenderer.
 * <P>
 * To apply any desired customization, DefaultTableHeaderCellRenderer may be
 * suitably extended.
 *
 * @author Darryl
 */
public class DefaultTableHeaderCellRenderer extends DefaultTableCellRenderer {

    /**
     * Indica el color de la celda de los encabezados.
     */
    private Color COLOR_FONDO_ENCABEZADO = new Color(255, 102, 102);

    /**
     * Indica el color del texto de los encabezados.
     */
    private Color COLOR_TEXTO_ENCABEZADO = new Color(255, 255, 255);

    /**
     * Instancia de la tabla personalizada, para poder modificar su encabezado.
     */
    private JTablePersonalizado tabla;

    /**
     * Constructs a <code>DefaultTableHeaderCellRenderer</code>.
     * <P>
     * The horizontal alignment and text position are set as appropriate to a
     * table header cell, and the opaque property is set to false.
     */
    public DefaultTableHeaderCellRenderer() {
        setHorizontalAlignment(CENTER);
        setHorizontalTextPosition(LEFT);
        setVerticalAlignment(BOTTOM);
        //setOpaque(false);
        setOpaque(true);
    }

    public DefaultTableHeaderCellRenderer(JTablePersonalizado tabla) {
        this.tabla = tabla;
        setCOLOR_FONDO_ENCABEZADO(tabla.getCOLOR_FONDO_ENCABEZADO());
        setCOLOR_TEXTO_ENCABEZADO(tabla.getCOLOR_TEXTO_ENCABEZADO());

        setHorizontalAlignment(CENTER);
        setHorizontalTextPosition(LEFT);
        setVerticalAlignment(BOTTOM);
        //setOpaque(false);
        setOpaque(true);
    }

    /**
     * Returns the default table header cell renderer.
     * <P>
     * If the column is sorted, the approapriate icon is retrieved from the
     * current Look and Feel, and a border appropriate to a table header cell is
     * applied.
     * <P>
     * Subclasses may overide this method to provide custom content or
     * formatting.
     *
     * @param table the <code>JTable</code>.
     * @param value the value to assign to the header cell
     * @param isSelected This parameter is ignored.
     * @param hasFocus This parameter is ignored.
     * @param row This parameter is ignored.
     * @param column the column of the header cell to render
     * @return the default table header cell renderer
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        JTableHeader tableHeader = table.getTableHeader();
        
        if (tableHeader != null) {
            setForeground(tableHeader.getForeground());
            setBackground(COLOR_FONDO_ENCABEZADO);
            setForeground(COLOR_TEXTO_ENCABEZADO);
        }
        
        setIcon(getIcon(table, column));
        setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        this.tabla = (JTablePersonalizado) table;
        return this;
    }

    /**
     * Overloaded to return an icon suitable to the primary sorted column, or
     * null if the column is not the primary sort key.
     *
     * @param table the <code>JTable</code>.
     * @param column the column index.
     * @return the sort icon, or null if the column is unsorted.
     */
    protected Icon getIcon(JTable table, int column) {
        SortKey sortKey = getSortKey(table, column);
        if (sortKey != null && table.convertColumnIndexToView(sortKey.getColumn()) == column) {
            switch (sortKey.getSortOrder()) {
                case ASCENDING:
                    return UIManager.getIcon("Table.ascendingSortIcon");
                case DESCENDING:
                    return UIManager.getIcon("Table.descendingSortIcon");
            }
        }
        return null;
    }

    /**
     * Returns the current sort key, or null if the column is unsorted.
     *
     * @param table the table
     * @param column the column index
     * @return the SortKey, or null if the column is unsorted
     */
    protected SortKey getSortKey(JTable table, int column) {
        RowSorter rowSorter = table.getRowSorter();
        if (rowSorter == null) {
            return null;
        }

        List sortedColumns = rowSorter.getSortKeys();
        if (sortedColumns.size() > 0) {
            return (SortKey) sortedColumns.get(0);
        }
        return null;
    }

    public Color getCOLOR_FONDO_ENCABEZADO() {
        return COLOR_FONDO_ENCABEZADO;
    }

    public void setCOLOR_FONDO_ENCABEZADO(Color COLOR_FONDO_ENCABEZADO) {
        this.COLOR_FONDO_ENCABEZADO = COLOR_FONDO_ENCABEZADO;

        JTableHeader tableHeader = tabla.getTableHeader();
        if (tableHeader != null) {
            setForeground(tableHeader.getForeground());
            setBackground(COLOR_FONDO_ENCABEZADO);
            setForeground(COLOR_TEXTO_ENCABEZADO);
        }
    }

    public Color getCOLOR_TEXTO_ENCABEZADO() {
        return COLOR_TEXTO_ENCABEZADO;
    }

    public void setCOLOR_TEXTO_ENCABEZADO(Color COLOR_TEXTO_ENCABEZADO) {
        this.COLOR_TEXTO_ENCABEZADO = COLOR_TEXTO_ENCABEZADO;

        JTableHeader tableHeader = tabla.getTableHeader();
        if (tableHeader != null) {
            setForeground(tableHeader.getForeground());
            setBackground(COLOR_FONDO_ENCABEZADO);
            setForeground(COLOR_TEXTO_ENCABEZADO);
        }
    }

}
