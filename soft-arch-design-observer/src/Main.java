import java.util.Scanner;
import java.util.concurrent.Flow.Subscriber;

public class Main {
    public static void main(String[] args) {
        StringPublisher publisher = new StringPublisher();
        Scanner scanner = new Scanner(System.in);
        String s = "";

        Subscriber alphabetSubscriber = new AlphabetSubscriber();
        Subscriber symbolSubscriber = new SymbolSubscriber();
        Subscriber numberSubscriber = new NumberSubscriber();

        publisher.subscribe(alphabetSubscriber);
        publisher.subscribe(symbolSubscriber);
        publisher.subscribe(numberSubscriber);

        while (true) {
            System.out.print("Enter text: ");
            s = scanner.nextLine();
            publisher.publish(s);
        }
    }
}
