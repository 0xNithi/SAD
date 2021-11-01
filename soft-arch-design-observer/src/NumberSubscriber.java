import java.util.regex.Pattern;

public class NumberSubscriber extends StringSubscriber {
    public NumberSubscriber() {
        super("number");
    }

    @Override
    public String process(String str) {
        return str;
    }

    @Override
    public Pattern getPattern() {
        return Pattern.compile("\\d");
    }
}