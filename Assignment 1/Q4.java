// Java Program to find the generate the first 50 numbers of Fibonacci Series

public class Q4 {
    public static void main(String[] args) {
        long sum = 0, a = 0, b = 1, i = 1;
        System.out.println(a);
        System.out.println(b);
        while (i <= 48) {
            sum = a + b;
            System.out.println(sum);
            a = b;
            b = sum;
            i++;
        }
    }
}
