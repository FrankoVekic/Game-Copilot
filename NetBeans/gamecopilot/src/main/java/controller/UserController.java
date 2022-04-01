package controller;

import java.util.List;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.persistence.NoResultException;
import model.Product;
import model.User;
import org.mindrot.jbcrypt.BCrypt;
import util.GCException;

public class UserController extends Controller<User> {

    @Override
    public List<User> read() {
        return session.createQuery("from User").list();
    }
    public List<String> readRole(){
        return session.createQuery("select p.role from User p").list();
    }

    @Override
    protected void controlCreate() throws GCException {
        checkEmail();
        checkName();
        checkSurname();
        checkPassword();
        checkNewEmail();

    }

    @Override
    protected void controlUpdate() throws GCException {
        
        checkUpdateEmail();
    }

    @Override
    protected void controlDelete() throws GCException {

    }

    private void checkEmail() throws GCException {

        if (entity.getEmail() == null || entity.getEmail().trim().isEmpty()) {
            throw new GCException("Invalid email.");
        }

        try {
            InternetAddress emailAddr = new InternetAddress(entity.getEmail());
            emailAddr.validate();
        } catch (AddressException ex) {
            throw new GCException("Email is invalid.");
        }
    }

    private void checkName() throws GCException {

        if (entity.getName() == null || entity.getName().trim().isEmpty()) {
            throw new GCException("Invalid name.");
        }
        if (entity.getName().trim().length() > 50) {
            throw new GCException("Name is too long.");
        }

    }

    private void checkSurname() throws GCException {
        if (entity.getSurname() == null || entity.getSurname().trim().isEmpty()) {
            throw new GCException("Invalid surname.");
        }
        if (entity.getSurname().trim().length() > 50) {
            throw new GCException("Surname is too long.");
        }
    }

    private void checkPassword() throws GCException {

        if (entity.getPassword() == null || entity.getPassword().trim().isEmpty()) {
            throw new GCException("Invalid password.");
        }
        if (entity.getPassword().trim().length() < 6) {
            throw new GCException("Password too short.");
        }
        if (entity.getPassword().trim().length() > 60) {
            throw new GCException("Password too long.");
        }
        if (!this.validPassword(entity.getPassword())) {
            throw new GCException("Password must contain atleast 1 upper letter and 1 number.");
        }

    }

    private boolean validPassword(String s) {

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                return false;
            }
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public User authorize(String email, String password){
        
        User user = null;
        try {
            user = (User)session.createQuery("from User where email =:email")
                .setParameter("email", email).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        
        if(user == null){
            return null;
        }

        return BCrypt.checkpw(password, user.getPassword()) ? user : null;
        
    }

    private void checkNewEmail() throws GCException {
           
        List<User> userList = session.createQuery("from User u "
                + "where u.email=:email")
                .setParameter("email", entity.getEmail()).list();

        if (userList != null && userList.size() > 0) {
            throw new GCException("This email is already in use.");
        }
    }

    private void checkUpdateEmail() throws GCException {
         List<Product> productList = session.createQuery("from User u "
                + "where u.name=:name and u.id!=:id")
                .setParameter("name", entity.getName())
                .setParameter("id", entity.getId()).list();

        if (productList != null && productList.size() > 0) {
            throw new GCException("This EMAIL is already in use.");
        }
    }
    
}
