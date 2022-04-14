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
public class ProductOrderTable extends AbstractTableModel {

    private List<ProductOrder> products;

    public ProductOrderTable(List<ProductOrder> products) {
        this.products = products;
    }

    @Override
    public int getRowCount() {
        return products == null ? 0 : products.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProductOrder po = products.get(rowIndex);
        Object value = "??";
        switch (columnIndex) {
            case 0:
                value = po.getProduct();
                break;
            case 1:
                value = po.getProduct().getPrice();
                break;
            case 2:
                value = po.getQuantity();
                break;
        }
        return value;
    }

    private String[] colNames = new String[]{"Title", "Price", "Quantity"};

    @Override
    public String getColumnName(int col) {
        return colNames[col];
    }

    public ProductOrder getProductAt(int row) {
        return products.get(row);
    } 
    
}
