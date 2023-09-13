import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppQueryDataFullTableProductManager {
    public static void main(String[] args) {
        ConnectToTheProductManagerDatabase connectToTheProductManagerDatabase = new ConnectToTheProductManagerDatabase();
        Connection conn = connectToTheProductManagerDatabase.connect();
        String query = "SELECT * FROM products";

        Statement stm = null;
        try {
            stm = conn.createStatement();

            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {  //Di chuyển con trỏ xuống bản ghi kế tiếp
                int id = rs.getInt("id");
                String nameproduct = rs.getString("nameproduct");
                Double price = rs.getDouble("price");
                String detail = rs.getString("detail");
                String manufacturer = rs.getString("manufacturer");
                int numberproduct = rs.getInt("numberproduct");
                String status = rs.getString("status");
                System.out.println(id + " - "
                        + nameproduct + " - "
                        + price + " - "
                        + detail + " - "
                        + manufacturer + " - "
                        + numberproduct + " - "
                        + status);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
