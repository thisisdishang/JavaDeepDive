// Java Program to generate String data dynamically with an alphabet {'A', 'B', 'C', 'D'}
// Use Math.random() to generate alphabets randomly.

import java.util.Random;

public class Q6 {
    public static void main(String[] args) {
        Character[] alphabet = { 'A', 'B', 'C', 'D' };
        int n = alphabet.length;
        Random random = new Random();

        for (int i = 0; i < alphabet.length; i++) {
            System.out.println(alphabet[random.nextInt(n)]);
        }
    }
}
