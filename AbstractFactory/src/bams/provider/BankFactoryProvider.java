package bams.provider;

import bams.enums.ClientType;
import bams.factory.BankProductFactory;
import bams.factory.BusinessClientFactory;
import bams.factory.IndividualClientFactory;

public class BankFactoryProvider {

    public static BankProductFactory getFactory(ClientType type) {
        return switch (type) {
            case INDIVIDUAL -> new IndividualClientFactory();
            case BUSINESS -> new BusinessClientFactory();
            default -> throw new IllegalArgumentException("Unsupported client type: " + type);
        };
    }
}
