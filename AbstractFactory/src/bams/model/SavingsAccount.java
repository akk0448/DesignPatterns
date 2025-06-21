package bams.model;

public class SavingsAccount implements Account {

    @Override
    public void displayDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Account Details ---\n");
        sb.append("Type       : Savings Account\n");
        sb.append("Interest   : 3.5% per annum\n");
        sb.append("Limit      : ₹1,00,000 withdrawal/day\n");
        sb.append("------------------------\n");

        System.out.println(sb);
    }
}
