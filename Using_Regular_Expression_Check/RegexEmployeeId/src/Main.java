import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập mã nhân viên:");
        String employeeId = input.nextLine();
        String result = isValidId(employeeId) ? "Mã hợp lệ" : "Mã không hợp lệ";
        System.out.println(result);
    }
    private static boolean isValidId(String employeeId) {
        String regex = "^(nv|emp)\\d{6}[a-z]{2,5}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(employeeId);
        return matcher.matches();
    }

}