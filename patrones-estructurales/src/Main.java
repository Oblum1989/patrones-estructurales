import adapter.adapters.ExcelAdapter;
import adapter.adapters.JSONAdapter;
import adapter.adapters.PDFAdapter;
import adapter.interfaces.IReportGenerator;
import decorator.base.BaseReport;
import decorator.concrete.CompressionDec;
import decorator.concrete.EncryptorDec;
import decorator.concrete.SignatureDec;
import decorator.interfaces.IReportTransformer;
import integration.ReportManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ADAPTER PATTERN DEMONSTRATION ===");
        IReportGenerator pdfGenerator = new PDFAdapter();
        IReportGenerator jsonGenerator = new JSONAdapter();
        IReportGenerator excelGenerator = new ExcelAdapter();
        System.out.println("PDF Report: " + pdfGenerator.generateReport());
        System.out.println("JSON Report: " + jsonGenerator.generateReport());
        System.out.println("Excel Report: " + excelGenerator.generateReport());
        System.out.println("=====================================");

        System.out.println("=== DECORATOR PATTERN DEMONSTRATION ===");
        IReportTransformer baseReport = new BaseReport();
        IReportTransformer encryptor = new EncryptorDec(baseReport);
        IReportTransformer signature = new SignatureDec(encryptor);
        IReportTransformer compressor = new CompressionDec(signature);
        String report = compressor.transform("This is a confidential report.");
        System.out.println("Final Report: " + report);
        System.out.println("=====================================");

        System.out.println("=== INTEGRATION OF ADAPTER AND DECORATOR ===");
        // Create manager with PDF adapter and encryption decorator
        ReportManager pdfManager = new ReportManager(
                new PDFAdapter(),
                new EncryptorDec(new BaseReport())
        );
        pdfManager.generateAndTransform();

        // Create manager with Excel adapter and multiple decorators
        ReportManager completeExcelManager = new ReportManager(
                new ExcelAdapter(),
                new SignatureDec(new CompressionDec(new EncryptorDec(new BaseReport())))
        );
        completeExcelManager.generateAndTransform();
        System.out.println("=====================================");

    }
}