package main.java.com.example;

import java.util.logging.Logger;
import java.util.logging.Level;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws Exception {

        Calculator calc = new Calculator();

        int result = calc.calculate(10, 5, "add");
        LOGGER.log(Level.INFO, "Result: {0}", result);

        UserService service = new UserService();
        service.findUser("admin");
        service.deleteUser("admin");
    }
}