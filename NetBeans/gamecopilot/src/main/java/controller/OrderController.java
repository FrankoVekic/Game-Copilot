package controller;

import java.util.List;
import model.OrderList;
import util.GCException;


public class OrderController extends Controller<OrderList> {

    @Override
    public List<OrderList> read() {
        return session.createQuery("from Orders").list();
    }

    @Override
    protected void controlCreate() throws GCException {
        
    }

    @Override
    protected void controlUpdate() throws GCException {
       
    }

    @Override
    protected void controlDelete() throws GCException {
       
    }
    
}
