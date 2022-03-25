package dev.codescreen;

import java.util.HashMap;

public class TransactionAmount {
    public String amount;
    public String currency;
    public DebitCredit debitOrCredit;
    public HashMap<String, Object> hm;

    public TransactionAmount(String am, String curr, DebitCredit dOC, HashMap hash2) {
        amount = am;
        currency = curr;
        debitOrCredit = dOC;
        hm = hash2;
        hm.put("amount", amount);
        hm.put("currency", currency);
        hm.put("debitOrCredit", debitOrCredit);
    }

    public HashMap transact() {
        return hm;
    }

}