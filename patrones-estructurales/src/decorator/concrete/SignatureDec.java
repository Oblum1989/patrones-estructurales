package decorator.concrete;

import decorator.abstrac.TransformerDecorator;
import decorator.interfaces.IReportTransformer;

public class SignatureDec extends TransformerDecorator {
    public SignatureDec(IReportTransformer decorated) {
        super(decorated);
    }

    @Override
    public String transform(String content) {
        String result = decorated.transform(content);
        return sign(result);
    }

    private String sign(String text) {
        System.out.println("Applying digital signature to the report");
        return "[SIGNED] " + text;
    }
}
