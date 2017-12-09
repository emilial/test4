import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public final class Model implements TableModel
{
    public final int ROWS_QUANTITY = getRowCount();
    public final int COLUMNS_QUANTITY = getColumnCount();

    private Object[][] values = tabela.body;

    public Model(Object[][] data, String[] columnNames)
    {
 //       this.values = TableFile.readData(ROWS_QUANTITY, COLUMNS_QUANTITY);
    }

	public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return true;
    }

    public Object getValueAt(int rowIndex, int columnIndex)
    {
        return this.values[rowIndex][columnIndex];
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        this.values[rowIndex][columnIndex] = aValue;
        TableFile.writeData(null, null, this.values, values);
    }

    public void addTableModelListener(TableModelListener l)
    {
    }

    public void removeTableModelListener(TableModelListener l)
    {
    }

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}
}

