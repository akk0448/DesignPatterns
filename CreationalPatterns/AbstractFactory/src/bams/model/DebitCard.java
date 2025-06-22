package bams.model;

public class DebitCard implements Card {

    @Override
    public void displayDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Card Details ---\n");
        sb.append("Type        : Debit Card\n");
        sb.append("Limit       : ₹50,000 per day\n");
        sb.append("Rewards     : 1% Cashback on groceries\n");
        sb.append("EMI Option  : Not Available\n");
        sb.append("----------------------\n");

        System.out.println(sb);
    }
}
