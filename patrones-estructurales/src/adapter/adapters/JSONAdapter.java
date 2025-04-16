package adapter.adapters;

import adapter.adaptee.JSONLibrary;
import adapter.interfaces.IReportGenerator;

public class JSONAdapter implements IReportGenerator {
    private JSONLibrary library;

    public JSONAdapter() {
        this.library = new JSONLibrary();
    }

    @Override
    public String generateReport() {
        return library.toJSON();
    }
}
