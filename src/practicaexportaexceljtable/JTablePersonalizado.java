package practicaexportaexceljtable;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * JTable personalizado, para que al agregarse datos a la tabla automaticamente,
 * se intercale colores
 *
 * @author lgmarcos
 *
 */
public class JTablePersonalizado extends JTable {

    /**
     * ID serializable, para que el el cargador de la clase pueda comprobar que
     * los objetos sean compatibles con respecto a esta serializacion.
     */
    private static final long serialVersionUID = 7258991861712868898L;

    /**
     * Indica el color de las celdas para las filas impares.
     */
    private Color COLOR_IMPARES = new Color(255, 255, 255);

    /**
     * Indica el color de las cledas para las filas pares.
     */
    private Color COLOR_PARES = new Color(255, 255, 255);

    /**
     * Indica el color de la celda de los encabezados.
     */
    private Color COLOR_FONDO_ENCABEZADO = new Color(51, 51, 255);

    /**
     * Indica el color del texto de los encabezados.
     */
    private Color COLOR_TEXTO_ENCABEZADO = new Color(255, 255, 255);

    /**
     * Indica el color de la fila que este selccionada.
     */
    private Color COLOR_FILA_SELECCIONADA = new Color(153, 153, 255);

    /**
     * Indica la fuente del encabezado.
     */
    private String FONT_NAME_ENCABEZADO = "Tahoma";

    /**
     * Indica el tamaño de la fuente del encabezado.
     */
    private int FONT_SIZE_ENCABEZADO = 12;

    /**
     * Indica el estilo de la fuente del encabezado.
     *
     * @see Font
     */
    private int FONT_STYLE_ENCABEZADO = Font.BOLD;

    /**
     * Indica la fuente del encabezado.
     */
    private String FONT_NAME_CELDA = "Tahoma";

    /**
     * Indica el tamaño de la fuente del encabezado.
     */
    private int FONT_SIZE_CELDA = 11;

    /**
     * Indica el estilo de la fuente del encabezado.
     *
     * @see Font
     */
    private int FONT_STYLE_CELDA = Font.PLAIN;
    
    /**
     * Clase para editar el encabezado
     */
    private DefaultTableHeaderCellRenderer encabezado = new DefaultTableHeaderCellRenderer(this);

    /**
     * Constructor para iniciar a construir el JTable personalizado
     */
    public JTablePersonalizado() {
        setAutoCreateColumnsFromModel(true);
        setAutoscrolls(true);
        setVisible(true);

        FilasRenderer filasRenderer = new FilasRenderer(2);
        setDefaultRenderer(Object.class, filasRenderer);
        setFillsViewportHeight(true);

        
        encabezado.setCOLOR_FONDO_ENCABEZADO(COLOR_FONDO_ENCABEZADO);
        encabezado.setCOLOR_TEXTO_ENCABEZADO(COLOR_TEXTO_ENCABEZADO);
        getTableHeader().setDefaultRenderer(encabezado);
        getTableHeader().setReorderingAllowed(false); // deshabilitar el movimiento de las columnas
        setRowHeight(25); // altura de cada celda
    }

    @SuppressWarnings("unused")
    private class FilasRenderer extends DefaultTableCellRenderer {

        /**
         * ID serializable, para que el el cargador de la clase pueda comprobar
         * que los objetos sean compatibles con respecto a esta serializacion.
         */
        private static final long serialVersionUID = 7612531644848425175L;
        private final int nFila;

        /**
         * Definir la cantidad de filas a renderizar.
         *
         * @param nFila
         */
        @SuppressWarnings("unused")
        public FilasRenderer(int nFila) {
            this.nFila = nFila;
        }

        /**
         * Obtener el componente para renderizar las celdas de la tabla.
         * @param table
         * @param value
         * @param isSelected
         * @param hasFocus
         * @param row
         * @param column
         * @return
         */
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            this.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            this.setFont(new java.awt.Font(FONT_NAME_CELDA, FONT_STYLE_CELDA, FONT_SIZE_CELDA));

            if (row % 2 == 0) {
                if (isSelected) {
                    this.setBackground(COLOR_FILA_SELECCIONADA);
                } else {
                    this.setBackground(COLOR_PARES);
                }
            } else {
                if (isSelected) {
                    this.setBackground(COLOR_FILA_SELECCIONADA);
                } else {
                    this.setBackground(COLOR_IMPARES);
                }

            }

            // Agregado para poder agregar JButtons        
            if (value instanceof JLabel) {
                JLabel lbl = (JLabel) value;
                return lbl;
            }
            // -------------------------------------------------------------
            if (value instanceof JButton) {
                JButton button = (JButton) value;
                if (isSelected) {
                    button.setForeground(table.getSelectionForeground());
                    button.setBackground(table.getSelectionBackground());
                } else {
                    button.setForeground(table.getForeground());
                    button.setBackground(UIManager.getColor("Button.background"));
                }
                return button;
            }
            // -------------------------------------------------------------
            // agregado para agregar JCheckBox
            if (value instanceof JCheckBox) {
                JCheckBox casilla = (JCheckBox) value;
                return casilla;
            }
            // -------------------------------------------------------------
            // -------------------------------------------------------------
            // agregado para agregar JComboBox
            if (value instanceof JComboBox) {
                JComboBox<?> combo = (JComboBox<?>) value;
                return combo;
            }
            // -------------------------------------------------------------
            return this;
        }

        @SuppressWarnings("unused")
        public int getnFila() {
            return nFila;
        }
    }

    public Color getCOLOR_IMPARES() {
        return COLOR_IMPARES;
    }

    public void setCOLOR_IMPARES(Color COLOR_IMPARES) {
        this.COLOR_IMPARES = COLOR_IMPARES;
    }

    public Color getCOLOR_PARES() {
        return COLOR_PARES;
    }

    public void setCOLOR_PARES(Color COLOR_PARES) {
        this.COLOR_PARES = COLOR_PARES;
    }

    public Color getCOLOR_FONDO_ENCABEZADO() {
        return COLOR_FONDO_ENCABEZADO;
    }

    public void setCOLOR_FONDO_ENCABEZADO(Color COLOR_FONDO_ENCABEZADO) {
        this.COLOR_FONDO_ENCABEZADO = COLOR_FONDO_ENCABEZADO;
    }

    public Color getCOLOR_TEXTO_ENCABEZADO() {
        return COLOR_TEXTO_ENCABEZADO;
    }

    public void setCOLOR_TEXTO_ENCABEZADO(Color COLOR_TEXTO_ENCABEZADO) {
        this.COLOR_TEXTO_ENCABEZADO = COLOR_TEXTO_ENCABEZADO;
    }

    public Color getCOLOR_FILA_SELECCIONADA() {
        return COLOR_FILA_SELECCIONADA;
    }

    public void setCOLOR_FILA_SELECCIONADA(Color COLOR_FILA_SELECCIONADA) {
        this.COLOR_FILA_SELECCIONADA = COLOR_FILA_SELECCIONADA;
    }

    public String getFONT_NAME_ENCABEZADO() {
        return FONT_NAME_ENCABEZADO;
    }

    public void setFONT_NAME_ENCABEZADO(String fONT_NAME_ENCABEZADO) {
        FONT_NAME_ENCABEZADO = fONT_NAME_ENCABEZADO;
    }

    public int getFONT_SIZE_ENCABEZADO() {
        return FONT_SIZE_ENCABEZADO;
    }

    public void setFONT_SIZE_ENCABEZADO(int fONT_SIZE_ENCABEZADO) {
        FONT_SIZE_ENCABEZADO = fONT_SIZE_ENCABEZADO;
        repintar();
    }

    public int getFONT_STYLE_ENCABEZADO() {
        return FONT_STYLE_ENCABEZADO;
    }

    public void setFONT_STYLE_ENCABEZADO(int fONT_STYLE_ENCABEZADO) {
        FONT_STYLE_ENCABEZADO = fONT_STYLE_ENCABEZADO;
        repintar();
    }

    public String getFONT_NAME_CELDA() {
        return FONT_NAME_CELDA;
    }

    public void setFONT_NAME_CELDA(String fONT_NAME_CELDA) {
        FONT_NAME_CELDA = fONT_NAME_CELDA;
    }

    public int getFONT_SIZE_CELDA() {
        return FONT_SIZE_CELDA;
    }

    public void setFONT_SIZE_CELDA(int fONT_SIZE_CELDA) {
        FONT_SIZE_CELDA = fONT_SIZE_CELDA;
    }

    public int getFONT_STYLE_CELDA() {
        return FONT_STYLE_CELDA;
    }

    public void setFONT_STYLE_CELDA(int fONT_STYLE_CELDA) {
        FONT_STYLE_CELDA = fONT_STYLE_CELDA;
    }

    /**
     * Metodo para repintar los encabezados de la tabla.
     * Llamar cada vez que quiera cambiar el estilo del encabezado.
     */
    public void repintar(){
        encabezado.setCOLOR_FONDO_ENCABEZADO(COLOR_FONDO_ENCABEZADO);
        encabezado.setCOLOR_TEXTO_ENCABEZADO(COLOR_TEXTO_ENCABEZADO);
        this.getTableHeader().setDefaultRenderer(encabezado);
        this.getTableHeader().setReorderingAllowed(false); // deshabilitar el movimiento de las columnas
    }
}
