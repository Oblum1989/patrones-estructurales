package integration;

import adapter.interfaces.IReportGenerator;
import decorator.interfaces.IReportTransformer;

public class ReportManager {
    private IReportGenerator generator;
    private IReportTransformer transformer;

    public ReportManager(IReportGenerator generator, IReportTransformer transformer) {
        this.generator = generator;
        this.transformer = transformer;
    }

    public String generateAndTransform() {
        String originalContent = generator.generateReport();
        System.out.println("Report generated: " + originalContent);

        String transformedContent = transformer.transform(originalContent);
        System.out.println("Report transformed: " + transformedContent);

        return transformedContent;
    }
}
