/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author frank
 */
public class ProductTableModel extends AbstractTableModel {

    private List<Product> products;

    public ProductTableModel(List<Product> products) {
        this.products = products;
    }

    @Override
    public int getRowCount() {
        return products == null ? 0 : products.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product p = products.get(rowIndex);
        Object value = "??";
        switch (columnIndex) {
            case 0:
                value = p.getName();
                break;
            case 1:
                value = p.getDescription();
                break;
            case 2:
                value = p.getPrice();
                break;
            case 3:
                value = p.getQuantity();
                break;
        }
        return value;
    }

    private String[] colNames = new String[]{"Title", "Description", "Price","In Stock"};

    @Override
    public String getColumnName(int col) {
        return colNames[col];
    }
    
    public Product getProductAt(int row){
        return products.get(row);
    }
}
