package bams.model;

public class HomeLoan implements Loan {

    @Override
    public void displayDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Loan Details ---\n");
        sb.append("Type          : Home Loan\n");
        sb.append("Amount Limit  : Up to ₹75,00,000\n");
        sb.append("Interest Rate : 7.25% per annum\n");
        sb.append("Tenure        : Up to 25 years\n");
        sb.append("------------------------\n");

        System.out.println(sb);
    }
}
