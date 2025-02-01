package Practice;
import java.io.*;

class PasswordException extends Exception {
    public PasswordException(String message){
        super(message);
    }
}


// User class
class User {
    private String username;
    private String password;
    private int id;
    private String email;

    // Constructor
    public User(String username, String password, int id, String email) throws PasswordException {
        this.username = username;
        setPassword(password);  // Use the setter to validate the password
        this.id = id;
        this.email = email;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    // Setter for password with validation
    public void setPassword(String password) throws PasswordException {
        if (password.length() < 5) {
            throw new PasswordException("Password must be at least 5 characters long.");
        }
        this.password = password;
    }

    // Method to write username and password to a file
    public void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/tmp/userDetails.txt"))) {
            writer.write("Username: " + this.username + "\n");
            writer.write("Password: " + this.password + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            // Example usage
            User user = new User("testUser", "pass123", 1, "test@example.com");
            user.writeToFile();
        } catch (PasswordException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}