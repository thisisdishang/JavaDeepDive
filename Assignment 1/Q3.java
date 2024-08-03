// Java Program to find the first 20 Prime Numbers

public class Q3 {
    public static void main(String[] args) {
        int counter;
        System.out.println("First 20 Prime Numbers:-");
        for (int i = 2; i <= 20; i++) {
            counter = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    counter++;
                }
            }
            if (counter == 2) {
                System.out.print(i + " ");
            }
        }
    }
}
