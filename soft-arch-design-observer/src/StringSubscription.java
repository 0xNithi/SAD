import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class StringSubscription implements Subscription {

    private Subscriber subscriber;

    public StringSubscription(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void request(long n) {
    }

    @Override
    public void cancel() {
    }
}