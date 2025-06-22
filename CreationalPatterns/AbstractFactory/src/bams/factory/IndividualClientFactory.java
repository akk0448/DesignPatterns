package bams.factory;

import bams.model.*;

public class IndividualClientFactory implements BankProductFactory {

    @Override
    public Account createAccount() {
        return new SavingsAccount();
    }

    @Override
    public Card createCard() {
        return new DebitCard();
    }

    @Override
    public Loan createLoan() {
        return new HomeLoan();
    }
}
