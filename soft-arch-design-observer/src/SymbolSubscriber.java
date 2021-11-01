import java.util.regex.Pattern;

public class SymbolSubscriber extends StringSubscriber {
    public SymbolSubscriber() {
        super("symbol");
    }

    @Override
    public String process(String str) {
        return str;
    }

    @Override
    public Pattern getPattern() {
        return Pattern.compile("\\W");
    }
}