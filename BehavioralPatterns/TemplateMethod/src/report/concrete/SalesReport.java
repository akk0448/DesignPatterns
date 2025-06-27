package report.concrete;

import report.template.ReportGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesReport extends ReportGenerator {

    private List<SaleRecord> records = new ArrayList<>();
    private double totalSales = 0;
    private Map<String, Integer> regionCount = new HashMap<>();

    @Override
    protected void fetchData() {
        System.out.println("🔍 Fetching sales records...");
        records.add(new SaleRecord("North", 12000));
        records.add(new SaleRecord("West", 18000));
        records.add(new SaleRecord("North", 7000));
        records.add(new SaleRecord("East", 5000));
        records.add(new SaleRecord("West", 9500));
    }

    @Override
    protected void analyzeData() {
        System.out.println("📊 Analyzing sales...");
        for (SaleRecord record : records) {
            totalSales += record.amount;
            regionCount.put(record.region, regionCount.getOrDefault(record.region, 0) + 1);
        }
    }

    @Override
    protected void formatReport() {
        System.out.println("🖨️ Sales Report:");
        System.out.println("Total Sales: ₹" + totalSales);
        System.out.println("Average Sale: ₹" + (totalSales / records.size()));
        System.out.println("Region-wise Sales Count:");
        for (String region : regionCount.keySet()) {
            System.out.println("  " + region + " → " + regionCount.get(region) + " orders");
        }
    }

    @Override
    protected void postProcessing() {
        System.out.println("🔒 Archiving sales data for audit...");
    }

    static class SaleRecord {
        String region;
        double amount;

        SaleRecord(String region, double amount) {
            this.region = region;
            this.amount = amount;
        }
    }
}