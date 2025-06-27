import report.concrete.FinanceReport;
import report.concrete.SalesReport;
import report.template.ReportGenerator;

public class Main {
    public static void main(String[] args) {
        ReportGenerator salesReport = new SalesReport();
        System.out.println("🔹 Generating Sales Report:");
        salesReport.generateReport();

        ReportGenerator financeReport = new FinanceReport();
        System.out.println("🔹 Generating Finance Report:");
        financeReport.generateReport();
    }
}