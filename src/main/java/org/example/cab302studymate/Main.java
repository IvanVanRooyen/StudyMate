package org.example.cab302studymate;

import org.example.cab302studymate.model.DatabaseConnection;
import org.example.cab302studymate.model.UserAccount;
import org.example.cab302studymate.model.DBUserAccountDAO;

import java.sql.Connection;
import java.util.List;

//public class Main extends Application {
//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
public class Main {
    public static void main(String[] args) {
        DBUserAccountDAO userAccountDAO = new DBUserAccountDAO();
        userAccountDAO.createTable();

        // Insert some new records
        userAccountDAO.insert(new UserAccount("John", "Doe", "john.doe@gmail.com"));
        userAccountDAO.insert(new UserAccount("Jane", "Doe", "jane.doe@gmail.com"));
        userAccountDAO.insert(new UserAccount("Alice", "Smith", "alice.smith@gmail.com"));

        // Retrieve all records
        List<UserAccount> accounts = userAccountDAO.getAll();
        for (UserAccount acc : accounts) {
            System.out.println(acc);
        }

        // Retrieve a record by ID
//        UserAccount account = userAccountDAO.getById(2);
//        System.out.println("Before update:");
//        System.out.println(account);

        // Update a record
//        account.setEmailAddress("updated@gmail.com"); // NOT WORKING
//        userAccountDAO.update(account);
//        System.out.println("After update balance to 25000:");
//        System.out.println(userAccountDAO.getById(2));

        // Delete a record
//        System.out.println("Before deleting a record with id = 1:");
//        for (UserAccount acc : userAccountDAO.getAll()) {
//            System.out.println(acc);
//        }
//
//        userAccountDAO.delete(1);
//        System.out.println("After deleting record with id = 1:");
//        for (UserAccount acc : userAccountDAO.getAll()) {
//            System.out.println(acc);
//        }


        userAccountDAO.close();
        Connection connection = DatabaseConnection.getInstance();
    }
}