import java.util.Scanner;

public class e_commerce_shipping {

    static double[] prices;
    static double weight;
    static int distance;
    static boolean express;
    static String coupon;

    // Calculate shipping cost
    static double calshipping(double weight, int distance) {
        double shipping = 50 + (10 * weight) + (2 * distance);

        if (express) {
            shipping += 100;
        }

        return shipping;
    }

    // Calculate cart total
    static double calcarttotal() {
        double cartTotal = 0;

        for (double price : prices) {
            cartTotal += price;
        }

        cartTotal += calshipping(weight, distance);

        return cartTotal;
    }

    // Apply coupon
    static double applycoupon(double total) {
        double discount = 0;

        if (coupon.equalsIgnoreCase("SAVE10")) {
            discount = total * 0.10;
        } 
        else if (coupon.equalsIgnoreCase("SAVE20")) {
            discount = total * 0.20;
        } 
        else if (coupon.equalsIgnoreCase("FLAT100")) {
            discount = 100;

            if (discount > total) {
                discount = total;
            }
        }

        return total - discount;
    }

    // Generate invoice
    static void generateinvoice() {
        double productTotal = 0;

        for (double price : prices) {
            productTotal += price;
        }

        double shipping = calshipping(weight, distance);
        double beforeDiscount = productTotal + shipping;
        double finalTotal = applycoupon(beforeDiscount);
        double discount = beforeDiscount - finalTotal;

        System.out.println("\n----- INVOICE -----");
        System.out.println("Product Total : ₹" + productTotal);
        System.out.println("Shipping      : ₹" + shipping);
        System.out.println("Discount      : ₹" + discount);
        System.out.println("Final Total   : ₹" + finalTotal);
        System.out.println("-------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        prices = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter price of product " + (i + 1) + ": ");
            prices[i] = sc.nextDouble();
        }

        System.out.print("Enter weight: ");
        weight = sc.nextDouble();

        System.out.print("Enter distance: ");
        distance = sc.nextInt();

        System.out.print("Is express shipping required (true/false): ");
        express = sc.nextBoolean();

        System.out.print("Enter coupon code: ");
        coupon = sc.next();

        generateinvoice();

        sc.close();
    }
}
