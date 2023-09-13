package baitap2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập địa chỉ IP cần phân tích: ");
        String ipAddress = scanner.nextLine();

        if (isValidIpAddress(ipAddress)) {
            String[] octets = ipAddress.split("\\.");

            System.out.println("Địa chỉ IP hợp lệ!");
            System.out.println("Octet 1: " + octets[0]);
            System.out.println("Octet 2: " + octets[1]);
            System.out.println("Octet 3: " + octets[2]);
            System.out.println("Octet 4: " + octets[3]);
        } else {
            System.out.println("Địa chỉ IP không hợp lệ!");
        }

        scanner.close();
    }

    private static boolean isValidIpAddress(String ipAddress) {
        String patternString = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(ipAddress);

        return matcher.matches();
    }
}
