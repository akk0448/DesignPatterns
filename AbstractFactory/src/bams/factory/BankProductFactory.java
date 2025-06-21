package bams.factory;

import bams.model.Account;
import bams.model.Card;
import bams.model.Loan;

public interface BankProductFactory {

    Account createAccount();
    Card createCard();
    Loan createLoan();
}
