// Java Program to find the factorial of 50 (Use Recursive function)

import java.math.BigInteger;
import java.util.Scanner;

public class Q5 {

    static BigInteger myfactorial(BigInteger num) {
        if (num.equals(BigInteger.ZERO) || num.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }
        return num.multiply(myfactorial(num.subtract(BigInteger.ONE)));
    }

    public static void main(String[] args) {
        System.out.println("Enter the number for factorial: ");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("Factorial of " + n + " is " + myfactorial(BigInteger.valueOf(n)));
    }
}
