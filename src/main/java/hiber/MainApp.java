package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User u1 = new User("Volodya", "Levin", "levin263825@ya.ru");
      u1.setCar(new Car("Skoda", 5));
      userService.add(u1);

      User u2 = new User("Vadim", "Drakon", "vadim_nikadim@mail.ru");
      u2.setCar(new Car("Opel", 2));
      userService.add(u2);

      User u3 = new User("Alexey", "Logan", "logan21@gmail.com");
      u3.setCar(new Car("Volkswagen", 5));
      userService.add(u3);

      User u4 = new User("Maxim", "Ship", "miximilian@rambler.ru");
      u4.setCar(new Car("Lada", 2105));
      userService.add(u4);

      List<User> list = userService.listUsers();
      for (User user : list) {
         System.out.println(user.toString());
      }

      System.out.println(userService.getUserByCar("Opel", 2));

      context.close();
   }
}
