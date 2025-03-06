import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccessObject {
    public Connection connection;
    public DatabaseAccessObject(Connection connection){
        this.connection = connection;
    }

    public void addUser(User user) throws SQLException{
        String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        PreparedStatement smt = connection.prepareStatement(query);
        smt.setString(1, user.getName());
        smt.setString(2, user.getEmail());
        smt.setString(3, user.getPassword());
        smt.executeUpdate();
    }

    public List<User> getAllUsers() throws SQLException{
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        Statement smt = connection.createStatement();
        ResultSet rs = smt.executeQuery(query);
        while (rs.next()){
            users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password")));
        }
        return users;
    }

}
