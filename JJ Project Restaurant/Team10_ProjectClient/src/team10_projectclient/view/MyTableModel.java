/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team10_projectclient.view;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Patryk
 */
public class MyTableModel extends AbstractTableModel {
    
    private String [] columnNames = {"Reservation ID","Customer username","Number of seats","Time","Date","Table ID","Restaurant ID"};
    private Object[][] data;
    
    public MyTableModel(String[][] data) {
        this.data = data;
    }    
    public boolean isCellEditable(int row, int column){  
          return false;  
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
    public String getColumnName(int col) {
        return columnNames[col];
    }
}
