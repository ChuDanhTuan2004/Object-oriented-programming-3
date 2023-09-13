import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppDeleteProductManager {
    public static void main(String[] args) {
        ConnectToTheProductManagerDatabase connectToTheProductManagerDatabase = new ConnectToTheProductManagerDatabase();
        Connection conn = connectToTheProductManagerDatabase.connect();

        String query = "DELETE FROM products WHERE id = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);

            pstm.setInt(1, 4);

            int row = pstm.executeUpdate();
            if(row != 0){
                System.out.println("Xóa thành công " + row);
            }

            //Đóng kết nối
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
