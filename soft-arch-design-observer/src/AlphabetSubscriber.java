import java.util.regex.Pattern;

public class AlphabetSubscriber extends StringSubscriber {
    public AlphabetSubscriber() {
        super("alphabet");
    }

    @Override
    public String process(String str) {
        return str;
    }

    @Override
    public Pattern getPattern() {
        return Pattern.compile("[a-zA-Z]");
    }
}