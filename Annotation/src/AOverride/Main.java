package AOverride;

interface Calculator {
    int tong(int a, int b);
    int hieu(int a, int b);
    int tich(int a, int b);
    float thuong(int a, int b);
}
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator() {

            @Override
            public int tong(int a, int b) {
                return a + b;
            }

            @Override
            public int hieu(int a, int b) {
                return a - b;
            }

            @Override
            public int tich(int a, int b) {
                return a * b;
            }

            @Override
            public float thuong(int a, int b) {
                return (float) ((a * 1.0)/b);
            }
        };
        System.out.println(calculator.tong(100, 200));
    }
}