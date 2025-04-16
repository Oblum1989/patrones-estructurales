package decorator.abstrac;

import decorator.interfaces.IReportTransformer;

public abstract class TransformerDecorator implements IReportTransformer {
    protected IReportTransformer decorated;

    public TransformerDecorator(IReportTransformer decorated) {
        this.decorated = decorated;
    }

    @Override
    public String transform(String content) {
        return decorated.transform(content);
    }
}
