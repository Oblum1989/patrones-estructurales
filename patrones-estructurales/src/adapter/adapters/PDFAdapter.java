package adapter.adapters;

import adapter.adaptee.PDFLibrary;
import adapter.interfaces.IReportGenerator;

public class PDFAdapter implements IReportGenerator {
    private PDFLibrary library;

    public PDFAdapter() {
        this.library = new PDFLibrary();
    }

    @Override
    public String generateReport() {
        return library.createPDF();
    }
}
