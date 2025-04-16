package decorator.base;

import decorator.interfaces.IReportTransformer;

public class BaseReport implements IReportTransformer {
    @Override
    public String transform(String content) {
        return content;
    }
}
