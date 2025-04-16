package decorator.concrete;

import decorator.abstrac.TransformerDecorator;
import decorator.interfaces.IReportTransformer;

public class CompressionDec extends TransformerDecorator {
    public CompressionDec(IReportTransformer decorated) {
        super(decorated);
    }

    @Override
    public String transform(String content) {
        String result = decorated.transform(content);
        return compress(result);
    }

    private String compress(String text) {
        System.out.println("Applying compression to the report");
        return "[COMPRESSED] " + text;
    }
}
