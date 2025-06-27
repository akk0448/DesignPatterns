package report.template;

public abstract class ReportGenerator {

    public final void generateReport() {
        System.out.println("📝 Starting Report Generation...\n");
        fetchData();
        analyzeData();
        formatReport();
        postProcessing();
        exportReport();
        System.out.println("✅ Report Generation Completed\n");
    }

    protected abstract void fetchData();

    protected abstract void analyzeData();

    protected abstract void formatReport();

    protected void postProcessing() {
        // default no-op
    }

    protected void exportReport() {
        System.out.println("📤 Exporting report to file system...\n");
    }
}