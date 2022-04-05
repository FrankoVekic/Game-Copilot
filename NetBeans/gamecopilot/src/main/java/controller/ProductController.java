package controller;

import java.math.BigDecimal;
import java.util.List;
import model.Product;
import util.CopilotException;

public class ProductController extends Controller<Product> {

    @Override
    public List<Product> read() {
        return session.createQuery("from Product").list();
    }

    @Override
    protected void controlCreate() throws CopilotException {
        checkName();
        controlNewTitle();
        checkDescription();
        checkPrice();
        checkQuantity();
    }

    @Override
    protected void controlUpdate() throws CopilotException {
        checkName();
        controlChangeTitle();
        checkPrice();
        checkDescription();
        checkQuantity();
    }

    @Override
    protected void controlDelete() throws CopilotException {
        if (entity.getOrders() != null && entity.getOrders().size() > 0) {
            throw new CopilotException("You can not delete this product.");
        }
    }

    private void checkName() throws CopilotException {

        if (entity.getName() == null || entity.getName().trim().isEmpty()) {
            throw new CopilotException("Title is required.");
        }

        if (entity.getName().trim().length() > 40) {
            throw new CopilotException("Title can have up to 40 characters.");
        }

        if (entity.getName().trim().length() < 3) {
            throw new CopilotException("Title must have atleast 3 characters.");
        }
    }

    private void checkDescription() throws CopilotException {

        if (entity.getDescription() == null || entity.getDescription().trim().isEmpty()) {
            throw new CopilotException("Description is required");
        }
        if (entity.getDescription().trim().length() < 10) {
            throw new CopilotException("Description is too short.");
        }
        if (entity.getDescription().trim().length() > 8000) {
            throw new CopilotException("Description is too big.");
        }

    }

    private void checkPrice() throws CopilotException {
        if (entity.getPrice() == null) {
            throw new CopilotException("Invalid price.");
        }
        if (entity.getPrice().compareTo(BigDecimal.ZERO) < 0 || entity.getPrice().compareTo(BigDecimal.ZERO) == 0) {
            throw new CopilotException("Price must be a positive number.");

        }
        if (entity.getPrice().compareTo(new BigDecimal(5000)) > 0) {
            throw new CopilotException("Max price is 5000.");
        }
    }

    private void checkQuantity() throws CopilotException {
        if (entity.getQuantity() == null) {
            throw new CopilotException("Invalid quantity");
        }
        if (entity.getQuantity() <= 0) {
            throw new CopilotException("Price must be a positive number.");

        }
        if (entity.getQuantity() > 1000) {
            throw new CopilotException("Max quantity is 1000.");
        }
    }

    private void controlNewTitle() throws CopilotException {

        List<Product> productList = session.createQuery("from Product p "
                + "where p.name=:name")
                .setParameter("name", entity.getName()).list();

        if (productList != null && productList.size() > 0) {
            throw new CopilotException("This title is already in use.");
        }
    }

    private void controlChangeTitle() throws CopilotException {
        List<Product> productList = session.createQuery("from Product p "
                + "where p.name=:name and p.id!=:id")
                .setParameter("name", entity.getName())
                .setParameter("id", entity.getId()).list();

        if (productList != null && productList.size() > 0) {
            throw new CopilotException("This title is already in use.");
        }
    }

}
