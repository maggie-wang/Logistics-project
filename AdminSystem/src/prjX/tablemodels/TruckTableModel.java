package prjX.tablemodels;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import prjX.entities.ShipDAO;
import prjX.entities.TruckDAO;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

public class TruckTableModel extends AbstractTableModel {
	
    String[] COLUMN_NAMES = {"Truck ID", "Truck Type", "Truck Status"};    
    protected static final Class[] COLUMN_TYPES = {Integer.class, String.class, String.class};
    private List<TruckDAO> trucks;

    public TruckTableModel(List<TruckDAO> trucks) {
        this.trucks = new ArrayList<>(trucks);
    }

    @Override
    public int getRowCount() {
        return trucks.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return COLUMN_TYPES[columnIndex];
    }

    protected TruckDAO getTruckForRow(int row) {
        return trucks.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TruckDAO truck = getTruckForRow(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = truck.getId();
                break;
            case 1:
                value = truck.getType();
                break;
            case 2:
                value = truck.getStatus();
                break;
        }
        return value;
    }

}