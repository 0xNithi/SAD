import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.regex.Pattern;

abstract public class StringSubscriber implements Subscriber<String> {
    private Subscription subscription;
    private FileWriter writer;
    private String filename;

    public StringSubscriber(String name) {
        try {
            filename = name + ".txt";
            File file = new File(filename);
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    abstract public String process(String str);

    abstract public Pattern getPattern();

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public void onNext(String item) {
        try {
            writer = new FileWriter(filename, true);
            writer.write(process(item));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onComplete() {
        System.out.println("[Subscriber][Status]: Done");
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
    }
}
