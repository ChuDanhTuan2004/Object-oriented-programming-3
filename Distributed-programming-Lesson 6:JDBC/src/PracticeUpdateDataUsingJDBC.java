import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PracticeUpdateDataUsingJDBC {
    public static void main(String[] args) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection conn = connectJDBC.connect();

        String query = "UPDATE Users SET password = ? WHERE idUser = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);

            pstm.setString(1, "bichthuan123");
            pstm.setInt(2, 5);

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
