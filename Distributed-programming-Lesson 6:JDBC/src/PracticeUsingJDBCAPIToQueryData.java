import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PracticeUsingJDBCAPIToQueryData {
    public static void main(String[] args) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection conn = connectJDBC.connect();
        String query = "SELECT * FROM Users";

        Statement stm = null;
        try {
            stm = conn.createStatement();

            ResultSet rs = stm.executeQuery(query);

            while (rs.next()){  //Di chuyển con trỏ xuống bản ghi kế tiếp
                int id = rs.getInt("idUser");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                System.out.println(id + " - " + username + " - " + password + " - " + email);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
