import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập email:");
        String email = input.nextLine();
        String result = isValidEmail(email) ? "Email hợp lệ" : "Email không hợp lệ";
        System.out.println(result);
    }

    private static boolean isValidEmail(String email) {
        String regex = "^[a-z]{1,}[\\w_.]*@gmail.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}