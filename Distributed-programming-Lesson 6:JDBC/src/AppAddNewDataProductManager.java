import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppAddNewDataProductManager {
    public static void main(String[] args) {
        ConnectToTheProductManagerDatabase connectToTheProductManagerDatabase = new ConnectToTheProductManagerDatabase();
        Connection conn = connectToTheProductManagerDatabase.connect();

        String query = "INSERT INTO products(id, nameproduct, price) " +
                "VALUES (?,?,?)";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);

            pstm.setString(1, "11");
            pstm.setString(2, "thuoc");
            pstm.setString(3, "99999");

            int row = pstm.executeUpdate();
            if(row != 0){
                System.out.println("Thêm thành công " + row);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
