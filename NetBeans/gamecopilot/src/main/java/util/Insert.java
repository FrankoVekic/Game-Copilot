package util;

import com.github.javafaker.Faker;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import model.OrderList;
import model.Product;
import model.User;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;

public class Insert {

    public static void execute() {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Faker faker = new Faker();

        List<User> users = generateUsers(faker, session);
        List<Product> products = generateProducts(faker, session);

        OrderList o;
        User u;

        try {
            for (int i = 0; i < (users.size() - 50); i++) {
                u = users.get(i);
                o = new OrderList();
                o.setOrderDate(new Date());
                o.setUser(u);
                o.setCity(faker.address().city());
                o.setAddress(faker.address().fullAddress());
                o.setCountry(faker.address().city());
                Collections.shuffle(users);
                o.setProducts(new ArrayList<>());
                o.getProducts().add(products.get(i));
                session.save(o);
            }
        } catch (Exception e) {
        }
        session.getTransaction().commit();
    }

    private static List<User> generateUsers(Faker faker, Session session) {

        List<User> users = new ArrayList();

        User u;

        for (int i = 0; i < 100; i++) {
            u = new User();
            u.setName(faker.name().firstName());
            u.setSurname(faker.name().lastName());
            u.setPassword(BCrypt.hashpw(Util.generateRandomPassword(), BCrypt.gensalt()));
            u.setEmail(faker.name().firstName() + "." + faker.name().lastName() + "@gmail.com");
            u.setRole("oper");
            session.save(u);
            users.add(u);
            System.out.println("User " + u.getId() + ": " + u.getName() + " " + u.getSurname());
        }
        u = new User();
        u.setName("Franko");
        u.setSurname("Vekić");
        u.setEmail("franko.vekic@gmail.com");
        u.setPassword(BCrypt.hashpw("a", BCrypt.gensalt()));
        u.setRole("admin");
        session.save(u);
        users.add(u);
        return users;
    }

    private static List<Product> generateProducts(Faker faker, Session session) {

        List<Product> products = new ArrayList();

        Product p;

        for (int i = 0; i < 100; i++) {
            p = new Product();
            p.setName(faker.esports().game());
            p.setPrice(new BigDecimal(Math.random() * (100 - 100) + 100));
            p.setQuantity((int) Math.random() * (50 - 5) + 5);
            p.setDescription("");
            session.save(p);
            products.add(p);
            System.out.println("Product created: " + p.getName());
        }

        return products;
    }

}
