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
        checkAddress();
        checkCity();
        checkCountry();
    }

    @Override
    protected void controlUpdate() throws CopilotException {
       
    }

    @Override
    protected void controlDelete() throws CopilotException {
       
    }

    private void checkAddress() throws CopilotException {
        if(entity.getAddress().trim().isEmpty() || entity.getAddress()==null){
            throw new CopilotException("Address is required.");
        }
    }

    private void checkCity() throws CopilotException {
        if(entity.getCity().trim().isEmpty() || entity.getCity()==null){
            throw new CopilotException("City is required.");
        }
    }

    private void checkCountry() throws CopilotException {
      if(entity.getCountry().trim().isEmpty() || entity.getCountry()==null){
            throw new CopilotException("Country is required.");
        }
    }
    
}
