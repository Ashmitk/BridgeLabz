import java.util.Scanner;
import java.util.ArrayList;

public class library_fine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String choice;

        int fine = 5;
        int totalFineCollected = 0;
        int totalBooksProcessed = 0;

        ArrayList<String> lateBooks = new ArrayList<>();

        do {
            System.out.print("Enter the book id: ");
            int bookId = sc.nextInt();

            System.out.print("Enter the due date: ");
            int dueDate = sc.nextInt();

            System.out.print("Enter the return date: ");
            int returnDate = sc.nextInt();

            totalBooksProcessed++;

            if (returnDate > dueDate) {
                int daysLate = returnDate - dueDate;
                int totalFine = daysLate * fine;

                totalFineCollected += totalFine;

                lateBooks.add(String.valueOf(bookId));

                System.out.println(
                    "The book is returned late. Fine: "
                    + totalFine + " units."
                );

            } else {
                System.out.println(
                    "The book is returned on time. No fine."
                );
            }

            System.out.print("Do you want to continue? (y/n): ");
            choice = sc.next();

        } while (choice.equalsIgnoreCase("y"));

        System.out.println("\n===== Library Summary =====");
        System.out.println("Total books processed: " + totalBooksProcessed);
        System.out.println("Total fine collected: " + totalFineCollected + " units.");

        System.out.println("Books returned late:");

        if (lateBooks.isEmpty()) {
            System.out.println("No books were returned late.");
        } else {
            for (String book : lateBooks) {
                System.out.println(book);
            }
        }

        System.out.println("\nThank you for using the library fine calculator.");

        sc.close();
    }
}
