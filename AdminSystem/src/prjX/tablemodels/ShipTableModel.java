package prjX.tablemodels;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import prjX.entities.ShipDAO;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

public class ShipTableModel extends AbstractTableModel {
	
    String[] COLUMN_NAMES = {"Ship ID", "Ship Name", "Company Name", "Volume Type"};    
    protected static final Class[] COLUMN_TYPES = {Integer.class, String.class, Double.class, Integer.class};
    private List<ShipDAO> ships;

    public ShipTableModel(List<ShipDAO> Ships) {
        this.ships = new ArrayList<>(Ships);
    }
    public ShipTableModel() {
    }
    
    @Override
    public int getRowCount() {
        return ships.size();
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

    protected ShipDAO getShipForRow(int row) {
        return ships.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ShipDAO ship = getShipForRow(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = ship.getId();
                break;
            case 1:            	
                value = ship.getName();
                break;
            case 2:
                value = ship.getCompany();
                break;
            case 3:
                value = ship.getVolumeType();
                break;
        }
        return value;
    }
    
    public void removeRow(int row) {
        ships.remove(row);
    }
    
    public void addRow(String name, String company, String volumeType) {
    	ShipDAO ship = new ShipDAO();
        ship.setId(new Integer(ships.size()));
        ship.setName(name);
        ship.setCompany(company);
        ship.setVolumeType(volumeType);
        ships.add(ship);

    }
}