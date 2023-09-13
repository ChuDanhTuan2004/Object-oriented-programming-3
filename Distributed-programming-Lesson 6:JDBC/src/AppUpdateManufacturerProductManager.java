import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppUpdateManufacturerProductManager {
    public static void main(String[] args) {
        ConnectToTheProductManagerDatabase connectToTheProductManagerDatabase = new ConnectToTheProductManagerDatabase();
        Connection conn = connectToTheProductManagerDatabase.connect();

        String query = "UPDATE products SET manufacturer = ?, price=? WHERE id = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);

            pstm.setString(1, "apple");
            pstm.setDouble(2, 12000000);
            pstm.setInt(3, 2);

            int row = pstm.executeUpdate();
            if(row != 0){
                System.out.println("Cập nhật thành công " + row);
            }

            //Đóng kết nối
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
