package com.appui;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class Table extends JPanel {
    public Table(){
        super(new GridLayout(1,0));
        JTable table = new JTable(new MyTableModel());
        table.setPreferredScrollableViewportSize(new Dimension( 500,70));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

    }
}
class MyTableModel extends AbstractTableModel{
    String[] columnNames={
            "Nazwa studenta",
            "Temat Pracy",
            "Strony Pracy",
            "Nazwa Promotora",
            "Ocena promotora",
            "Nazwa recenzenta",
            "Ocena recenzenta pracy"
    };
    Object [][] data ={{"","",new Integer(0),"",new Integer(0),"",new Integer(0)}};

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    public String getColumnNames(int col) {
        return columnNames[col];
    }
    public boolean isCellEditable(int row,int col)
    {

            return true;

    }
    public void setValueAt(Object value,int row,int col){
        data[row][col]=value;
        fireTableCellUpdated(row,col);
    }
}