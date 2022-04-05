package controller;

import java.util.List;
import model.OrderList;
import util.CopilotException;


public class OrderController extends Controller<OrderList> {

    @Override
    public List<OrderList> read() {
        return session.createQuery("from orders").list();
    }

    @Override
    protected void controlCreate() throws CopilotException {
        
    }

    @Override
    protected void controlUpdate() throws CopilotException {
       
    }

    @Override
    protected void controlDelete() throws CopilotException {
       
    }
    
}
