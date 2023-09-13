public class AppConnectProductManager {
    public static void main(String[] args) {
        ConnectToTheProductManagerDatabase connectToTheProductManagerDatabase = new ConnectToTheProductManagerDatabase();
        connectToTheProductManagerDatabase.connect();
    }
}
