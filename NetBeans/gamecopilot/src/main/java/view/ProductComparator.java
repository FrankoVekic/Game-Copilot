/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Comparator;
import model.Product;
import model.Product;

/**
 *
 * @author frank
 */
public class ProductComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        Integer first = o1.getOrders()== null ? 0 : o1.getOrders().size();
        Integer secound = o2.getOrders() == null ? 0 : o2.getOrders().size();
        return secound.compareTo(first);

    }

}
