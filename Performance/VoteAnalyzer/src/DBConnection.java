import java.sql.*;

public class DBConnection {

    private static Connection connection;

    private static final String dbName = "learn";
    private static final String dbUser = "root";
    private static final String dbPass = "testtest";

    private static StringBuilder insertQuery = new StringBuilder();
    private static Statement statement;

    static {
        try {
            statement = DBConnection.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + dbName +
                                "?user=" + dbUser + "&password=" + dbPass);
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
                connection.createStatement().execute("CREATE TABLE voter_count(" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "name TINYTEXT NOT NULL, " +
                        "birthDate DATE NOT NULL, " +
                        "`count` INT NOT NULL, " +
                        "PRIMARY KEY(id), " +
                        "UNIQUE KEY name_date(name(50), birthDate))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static Statement getStatement() {
        return statement;
    }

    public static void executeMultiInsert() throws SQLException {
        String sql = "INSERT INTO voter_count(name, birthDate, `count`) " +
                    "VALUES" + insertQuery + "ON DUPLICATE KEY UPDATE `count`=`count` + 1";
        statement.addBatch(sql);
        statement.executeBatch();
        insertQuery.setLength(0);
    }

    public static void countVoter(String name, String birthDay) throws SQLException {
        birthDay = birthDay.replace('.', '-');
        insertQuery.append((insertQuery.length() == 0 ? "" : ",") + "('" + name + "', '" + birthDay + "', 1)");
    }

    public static void printVoterCounts() throws SQLException {
        String sql = "SELECT name, birthDate, `count` FROM voter_count WHERE `count` > 1";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
        while (rs.next()) {
            System.out.println("\t" + rs.getString("name") + " (" +
                rs.getString("birthDate") + ") - " + rs.getInt("count"));
        }
    }
}