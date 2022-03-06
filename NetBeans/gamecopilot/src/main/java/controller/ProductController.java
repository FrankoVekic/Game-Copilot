package controller;

import java.math.BigDecimal;
import java.util.List;
import model.Product;
import util.GCException;

public class ProductController extends Controller<Product> {

    @Override
    public List<Product> read() {
        return session.createQuery("from Product").list();
    }

    @Override
    protected void controlCreate() throws GCException {
        checkName();
        checkDescription();
        checkPrice();
        checkQuantity();
    }

    @Override
    protected void controlUpdate() throws GCException {
      
    }

    @Override
    protected void controlDelete() throws GCException {
      
    }

    private void checkName() throws GCException {

        if (entity.getName() == null || entity.getName().trim().isEmpty()) {
            throw new GCException("Name is required.");
        }

        if (entity.getName().trim().length() > 40) {
            throw new GCException("Name can have up to 40 characters.");
        }

        if (entity.getName().trim().length() < 3) {
            throw new GCException("Name must have atleast 3 characters.");
        }
    }

    private void checkDescription() throws GCException {

        if (entity.getDescription() == null || entity.getDescription().trim().isEmpty()) {
            throw new GCException("Description is required");
        }
        if (entity.getDescription().trim().length() < 10) {
            throw new GCException("Description is too short.");
        }
        if (entity.getDescription().trim().length() > 8000) {
            throw new GCException("Description is too big.");
        }

    }

    private void checkPrice() throws GCException {
        if (entity.getPrice() == null) {
            throw new GCException("Invalid price.");
        }
        if (entity.getPrice().compareTo(BigDecimal.ZERO) < 0 || entity.getPrice().compareTo(BigDecimal.ZERO) == 0) {
            throw new GCException("Price must be a positive number.");

        }
        if (entity.getPrice().compareTo(new BigDecimal(5000)) > 0) {
            throw new GCException("Max price is 5000.");
        }
    }

    private void checkQuantity() throws GCException {
        if (entity.getQuantity() == null) {
            throw new GCException("Invalid quantity");
        }
        if (entity.getQuantity() <= 0) {
            throw new GCException("Price must be a positive number.");

        }
        if (entity.getQuantity() > 1000) {
            throw new GCException("Max quantity is 1000.");
        }
    }

}
