/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.ProductOrder;
import util.CopilotException;
import util.Util;

/**
 *
 * @author frank
 */
public class ProductOrderController extends Controller<ProductOrder> {

    @Override
    public List<ProductOrder> read() {
        return session.createQuery("from ProductOrder").list();
    }

    @Override
    protected void controlCreate() throws CopilotException {
        // checkQuantity();
    }

    @Override
    protected void controlUpdate() throws CopilotException {
        checkQuantity();
    }

    @Override
    protected void controlDelete() throws CopilotException {

    }

    private void checkQuantity() throws CopilotException {
        if (entity.getQuantity() == null || entity.getQuantity() <= 0) {
            throw new CopilotException("Quantity must be a positive number.");
        }
        if (entity.getQuantity() > entity.getProduct().getQuantity()) {
            throw new CopilotException("There are: " + entity.getProduct().getQuantity() + " games in stock.");
        }
    }

    @Override
    protected void saveAfter() throws CopilotException {
        session.beginTransaction();       
            entity.getProduct().setQuantity(entity.getProduct().getQuantity() - entity.getQuantity());
            session.save(entity);
        
        session.getTransaction().commit();
    }

}
