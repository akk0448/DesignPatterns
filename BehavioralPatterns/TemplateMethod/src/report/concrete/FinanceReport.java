package report.concrete;

import report.template.ReportGenerator;

import java.util.ArrayList;
import java.util.List;

public class FinanceReport extends ReportGenerator {

    private List<Transaction> expenses = new ArrayList<>();
    private List<Transaction> incomes = new ArrayList<>();
    private double totalIncome = 0;
    private double totalExpense = 0;

    @Override
    protected void fetchData() {
        System.out.println("🔍 Fetching financial transactions...");
        incomes.add(new Transaction("Client Payment", 50000));
        incomes.add(new Transaction("Product Sale", 30000));
        expenses.add(new Transaction("Office Rent", 15000));
        expenses.add(new Transaction("Salaries", 28000));
        expenses.add(new Transaction("Utilities", 4000));
    }

    @Override
    protected void analyzeData() {
        System.out.println("📈 Analyzing financials...");
        for (Transaction t : incomes) totalIncome += t.amount;
        for (Transaction t : expenses) totalExpense += t.amount;
    }

    @Override
    protected void formatReport() {
        System.out.println("🧾 Finance Report:");
        System.out.println("Total Income: ₹" + totalIncome);
        System.out.println("Total Expenses: ₹" + totalExpense);
        System.out.println("Net Profit: ₹" + (totalIncome - totalExpense));
        System.out.println("\n⚠️ High Expenses (₹>10,000):");
        for (Transaction t : expenses) {
            if (t.amount > 10000)
                System.out.println("  - " + t.description + ": ₹" + t.amount);
        }
    }

    @Override
    protected void exportReport() {
        System.out.println("📧 Sending report to CFO via email...\n");
    }

    static class Transaction {
        String description;
        double amount;

        Transaction(String description, double amount) {
            this.description = description;
            this.amount = amount;
        }
    }
}