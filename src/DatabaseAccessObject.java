import java.sql.Connection;

public class DatabaseAccessObject {
    public Connection connection;
    public DatabaseAccessObject(Connection connection){
        this.connection = connection;
    }
}
