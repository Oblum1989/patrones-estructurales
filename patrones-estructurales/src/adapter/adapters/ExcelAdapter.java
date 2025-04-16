package adapter.adapters;

import adapter.adaptee.ExcelLibrary;
import adapter.interfaces.IReportGenerator;

public class ExcelAdapter implements IReportGenerator {
    private ExcelLibrary library;

    public ExcelAdapter() {
        this.library = new ExcelLibrary();
    }

    @Override
    public String generateReport() {
        return library.generateXLS();
    }
}
