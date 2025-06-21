package bams.model;

public class CorporateCreditCard implements Card {

    @Override
    public void displayDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Card Details ---\n");
        sb.append("Type        : Corporate Credit Card\n");
        sb.append("Limit       : ₹5,00,000 per month\n");
        sb.append("Rewards     : 2% Cashback on all spends\n");
        sb.append("EMI Option  : Available for purchases > ₹10,000\n");
        sb.append("----------------------\n");

        System.out.println(sb);
    }
}
