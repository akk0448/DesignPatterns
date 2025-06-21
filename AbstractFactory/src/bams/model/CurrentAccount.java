package bams.model;

public class CurrentAccount implements Account {

    @Override
    public void displayDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Account Details ---\n");
        sb.append("Type       : Current Account\n");
        sb.append("Interest   : No interest\n");
        sb.append("Limit      : ₹5,00,000 withdrawal/day\n");
        sb.append("------------------------\n");

        System.out.println(sb);
    }
}
