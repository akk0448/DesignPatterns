package bams.model;

public class BusinessLoan implements Loan {

    @Override
    public void displayDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Loan Details ---\n");
        sb.append("Type          : Business Loan\n");
        sb.append("Amount Limit  : Up to ₹2 Crores\n");
        sb.append("Interest Rate : 9.5% per annum\n");
        sb.append("Tenure        : Up to 10 years\n");
        sb.append("------------------------\n");

        System.out.println(sb);
    }
}
