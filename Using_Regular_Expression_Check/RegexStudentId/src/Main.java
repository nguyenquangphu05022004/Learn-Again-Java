import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên: ");
        String studentId = input.nextLine();
        String result = isValidId(studentId) ? "Mã hợp lệ" : "Mã không hợp lệ";
        System.out.println(result);
    }
    private static boolean isValidId(String studentId) {
        String regex = "^(a|b|c)\\d{2}[a-z]{4}\\d{3}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        //không phân biệt chữ hoa và chữ thường
        Matcher matcher = pattern.matcher(studentId);
        return matcher.matches();
    }
}