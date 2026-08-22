import java.util.Scanner;

class fd_maturity_tracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Principal (P): ");
        double p = sc.nextDouble();

        System.out.print("Enter Rate (R): ");
        double r = sc.nextDouble();

        System.out.print("Enter Time (T in years): ");
        int t = sc.nextInt();

        System.out.println("\nYear-wise Amount:");

        for (int year = 1; year <= t; year++) {
            double si = (p * r * year) / 100;
            double amount = p + si;

            System.out.println("Year " + year + " = " + amount);
        }

        sc.close();
    }
}