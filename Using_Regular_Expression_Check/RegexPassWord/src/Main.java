import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    /**
     * Yêu cầu:
     * Định dạng mật khẩu của tài khoản người dùng trong một
     * hệ thống nào đó được cho như sau:
     * Dài tối thiểu 8 kí tự
     * Bao gồm cả kí tự chữ cái thường, chữ cái hoa
     * Chứa tối thiểu 1 kí tự số và 1 kí tự đặc biệt(~!#$^&)
     * Mật khẩu không được trùng với địa chỉ email của người dùng
     *
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập mật khẩu:");
        String passWord = input.nextLine();
        String result = isValidPassWord(passWord) ?
                "Mật khẩu hợp lệ" : "Mật khẩu không hợp lệ";
        System.out.println(result);
    }

    private static boolean isValidPassWord(String passWord) {
        String regex1 = "^.{8,}$";
        String regex2 = "^.*[a-z]+.*$";
        String regex3 = "^.*\\d{1,}.*$";
        String regex4 = "^.*[~!@#$%^&*]+.*$";
        String regex5 = "^.*[A-Z]+.*$";
        return  passWord.matches(regex1) && passWord.matches(regex2) &&
                passWord.matches(regex4) && passWord.matches(regex3) &&
                passWord.matches(regex5);
    }
}