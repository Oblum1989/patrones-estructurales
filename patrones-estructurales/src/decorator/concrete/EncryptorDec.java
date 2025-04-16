package decorator.concrete;

import decorator.abstrac.TransformerDecorator;
import decorator.interfaces.IReportTransformer;

public class EncryptorDec extends TransformerDecorator {
    public EncryptorDec(IReportTransformer decorated) {
        super(decorated);
    }

    @Override
    public String transform(String content) {
        String result = decorated.transform(content);
        return encrypt(result);
    }

    private String encrypt(String text) {
        System.out.println("Applying encryption to the report");
        return "[ENCRYPTED] " + text;
    }
}
