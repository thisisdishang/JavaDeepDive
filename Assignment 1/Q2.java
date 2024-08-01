// Java Program to find the factorial of 20
class Q2 {
    public static void main(String[] args) {
        // for whole number we use long datatype
        long factorial = 1;
        int i = 1;
        while (i <= 20) {
            factorial *= i;
            i++;
        }
        System.out.println("Factorial Of is: " + factorial);

    }
}
