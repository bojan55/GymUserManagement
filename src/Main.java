import java.sql.Connection;
public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            DatabaseAccessObject databaseAccessObject = new DatabaseAccessObject(connection);

            User newUser = new User(0, "Marko", "marko@email.com", "marko123");
            databaseAccessObject.addUser(newUser);

            for (User user : databaseAccessObject.getAllUsers()) {
                System.out.println(user.getName() + " - " + user.getEmail());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}