package org.example.cab302studymate.model;

// Imports
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Database management functions
public class DBUserAccountDAO {
    // Establish connection
    private Connection connection;
    public DBUserAccountDAO() {
        connection = DatabaseConnection.getInstance();
    }

    // Create a new table if one does not exist
    public void createTable() {
        try {
            Statement createTable = connection.createStatement();
            createTable.execute(
                    "CREATE TABLE IF NOT EXISTS userAccounts ("
                            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + "firstName VARCHAR NOT NULL, "
                            + "lastName VARCHAR NOT NULL, "
                            + "emailAddress VARCHAR NOT NULL"
                            + ")"
            );
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    // Insert user account details
    public void insert(UserAccount userAccount) {
        try {
            PreparedStatement insertAccount = connection.prepareStatement(
                    "INSERT INTO userACCOUNTS (firstName, lastName, emailAddress) VALUES (?, ?, ?)"
            );
            insertAccount.setString(1, userAccount.getFirstName());
            insertAccount.setString(2, userAccount.getLastName());
            insertAccount.setString(3, userAccount.getEmailAddress());
            insertAccount.execute();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    // Update user account details
    public void update(UserAccount userAccount) {
        try {
            PreparedStatement updateAccount = connection.prepareStatement(
                    "UPDATE userAccounts SET firstName = ?, lastName = ?, emailAddress = ? WHERE id = ?"
            );
            updateAccount.setString(1, userAccount.getFirstName());
            updateAccount.setString(2, userAccount.getLastName());
            updateAccount.setString(3, userAccount.getEmailAddress());
            updateAccount.setInt(4, userAccount.getId());
            updateAccount.execute();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    // Delete specific accounts
    public void delete(int id) {
        try {
            PreparedStatement deleteAccount = connection.prepareStatement("DELETE FROM userAccounts WHERE id = ?");
            deleteAccount.setInt(1, id);
            deleteAccount.execute();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    // List all user accounts
    public List<UserAccount> getAll() {
        List<UserAccount> accounts = new ArrayList<>();
        try {
            Statement getAll = connection.createStatement();
            ResultSet rs = getAll.executeQuery("SELECT * FROM userAccounts");
            while (rs.next()) {
                accounts.add(
                        new UserAccount(
                                rs.getInt("id"),
                                rs.getString("firstName"),
                                rs.getString("lastName"),
                                rs.getString("emailAddress")
                        )
                );
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return accounts;
    }

    // User account selector
    public UserAccount getById(int id) {
        try {
            PreparedStatement getAccount = connection.prepareStatement("SELECT * FROM userAccounts WHERE id = ?");
            getAccount.setInt(1, id);
            ResultSet rs = getAccount.executeQuery();
            if (rs.next()) {
                return new UserAccount(
                        rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("emailAddress")
                );
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return null;
    }

    // Close DB connection
    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
}
