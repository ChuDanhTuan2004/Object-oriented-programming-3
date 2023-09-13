import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PracticeDeleteRecordsUsingJDBC {
    public static void main(String[] args) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection conn = connectJDBC.connect();

        String query = "DELETE FROM Users WHERE idUser = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);

            pstm.setInt(1, 5);

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
