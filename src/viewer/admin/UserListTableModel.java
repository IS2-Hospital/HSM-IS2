package viewer.admin;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.User;

public class UserListTableModel<T extends User> extends AbstractTableModel {

	private String[] colNames;
	private List<List<String>> array;

	public UserListTableModel(List<T> users) {
		array = new ArrayList<List<String>>();
		if (users != null) {
			colNames = users.get(0).getColName();
			for(T i :users) {
				array.add(i.asStringList());
			}
		}
	}

	@Override
	public String getColumnName(int col) {
		return colNames[col];
	}

	@Override
	public int getRowCount() {
		return array.size();
	}

	@Override
	public int getColumnCount() {
		return colNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return array.get(rowIndex).get(columnIndex);
	}


}
