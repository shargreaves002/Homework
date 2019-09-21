import java.util.Scanner;

public class Scan {
    private static final String password = "Password";
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer;
        do {
            System.out.println("What's the password?");
            answer = scanner.nextLine();
            count++;
        } while (!password.equals(answer));

        if (count == 1) {
            System.out.println("You had to try 1 time.");
        } else {
            System.out.println("You had to try " + count + " times.");
        }
    }
}
