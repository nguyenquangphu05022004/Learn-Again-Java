package customannotation;

public class Test {
    public static void main(String[] args) {
        Employee employee = new Employee("EMP1001","phú", "nguyễn",
                        "quangphu2050@gmail.com", "hà nội", 12.5f);
        var converter = new ObjectToJsonConverter();
        var result = converter.convertToJson(employee);
        System.out.println(result);
    }
}
