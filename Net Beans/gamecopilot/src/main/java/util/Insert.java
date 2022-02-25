package util;

import com.github.javafaker.Faker;
import org.hibernate.Session;

public class Insert {

    public static void execute() {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Faker faker = new Faker();

        
    }

}
