package main;

import util.HibernateUtil;
import util.Insert;
import view.SplashScreen;

public class Start {
    
    public static void main(String[] args) {
        
      // HibernateUtil.getSession();
      // Insert.execute();
         new SplashScreen().setVisible(true);
    }
    
}
