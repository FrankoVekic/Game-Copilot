package controller;

import java.util.List;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.persistence.NoResultException;
import model.Product;
import model.User;
import org.mindrot.jbcrypt.BCrypt;
import util.CopilotException;

public class UserController extends Controller<User> {

    @Override
    public List<User> read() {
        return session.createQuery("from User").list();
    }
    public List<String> readRole(){
        return session.createQuery("select p.role from User p").list();
    }

    @Override
    protected void controlCreate() throws CopilotException {
        checkEmail();
        checkName();
        checkSurname();
        checkPassword();
        checkNewEmail();
    }

    @Override
    protected void controlUpdate() throws CopilotException {
        checkEmail();
        checkUpdateEmail();
        checkName();
        checkSurname();
    }

    @Override
    protected void controlDelete() throws CopilotException {

    }

    private void checkEmail() throws CopilotException {

        if (entity.getEmail() == null || entity.getEmail().trim().isEmpty()) {
            throw new CopilotException("Invalid email.");
        }

        try {
            InternetAddress emailAddr = new InternetAddress(entity.getEmail());
            emailAddr.validate();
        } catch (AddressException ex) {
            throw new CopilotException("Email is invalid.");
        }
    }

    private void checkName() throws CopilotException {

        if (entity.getName() == null || entity.getName().trim().isEmpty()) {
            throw new CopilotException("Invalid name.");
        }
        if (entity.getName().trim().length() > 50) {
            throw new CopilotException("Name is too long.");
        }
        if(entity.getName().trim().length()<3){
            throw new CopilotException("Name is too short (min. 3 characters).");
        }

    }

    private void checkSurname() throws CopilotException {
        if (entity.getSurname() == null || entity.getSurname().trim().isEmpty()) {
            throw new CopilotException("Invalid surname.");
        }
        if (entity.getSurname().trim().length() > 50) {
            throw new CopilotException("Surname is too long.");
        }
        if(entity.getSurname().trim().length()<3){
            throw new CopilotException("Surname is too short (min. 3 characters).");
        }
    }

    private void checkPassword() throws CopilotException {

        if (entity.getPassword() == null || entity.getPassword().trim().isEmpty()) {
            throw new CopilotException("Invalid password.");
        }
        if (entity.getPassword().trim().length() < 6) {
            throw new CopilotException("Password too short.");
        }
        if (entity.getPassword().trim().length() > 60) {
            throw new CopilotException("Password is too long.");
        }

    }

    private boolean validPassword(String s) {

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                return true;
            }
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
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

    private void checkNewEmail() throws CopilotException {
           
        List<User> userList = session.createQuery("from User u "
                + "where u.email=:email")
                .setParameter("email", entity.getEmail()).list();

        if (userList != null && userList.size() > 0) {
            throw new CopilotException("This email is already in use.");
        }
    }

    private void checkUpdateEmail() throws CopilotException {
         List<Product> productList = session.createQuery("from User u "
                + "where u.name=:name and u.id!=:id")
                .setParameter("name", entity.getName())
                .setParameter("id", entity.getId()).list();

        if (productList != null && productList.size() > 0) {
            throw new CopilotException("This EMAIL is already in use.");
        }
    }
    
    public User register(String email){
        
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

        return user;
        
        
    }
}
