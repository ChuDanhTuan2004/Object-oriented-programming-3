import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PracticeAddNewDataUsingJDBC {
    public static void main(String[] args) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection conn = connectJDBC.connect();

        String query = "INSERT INTO Users(username, password, email) " +
                "VALUES (?,?,?)";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);

            pstm.setString(1, "Do Bich Thuan");
            pstm.setString(2, "123456789");
            pstm.setString(3, "thuan.do@codegym.vn");

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
