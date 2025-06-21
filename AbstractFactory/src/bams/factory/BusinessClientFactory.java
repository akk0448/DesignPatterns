package bams.factory;

import bams.model.*;

public class BusinessClientFactory implements BankProductFactory {

    @Override
    public Account createAccount() {
        return new CurrentAccount();
    }

    @Override
    public Card createCard() {
        return new CorporateCreditCard();
    }

    @Override
    public Loan createLoan() {
        return new BusinessLoan();
    }
}
