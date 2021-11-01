import java.util.ArrayList;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.regex.Matcher;

public class StringPublisher implements Publisher<String> {
    private ArrayList<Subscriber> subscriptions = new ArrayList();

    @Override
    public void subscribe(Subscriber subscriber) {
        subscriptions.add(subscriber);
    }

    public void publish(String str) {
        for (Subscriber subscription : subscriptions) {
            String allMatches = "";
            Matcher matcher = ((StringSubscriber) subscription).getPattern().matcher(str);
            while (matcher.find()) {
                allMatches += matcher.group();
            }
            if (!allMatches.equals("")) {
                System.out.println("[StringPublisher]: publish \"" + allMatches + "\" to " + subscription.getClass());
                subscription.onNext(allMatches);
            }
        }
    }
}