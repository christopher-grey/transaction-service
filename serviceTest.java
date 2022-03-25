package dev.codescreen;

import java.util.HashMap;

public class serviceTest {
    public static void main(String[] args) {
        Service s1 = new Service();
//        System.out.println(s1.ping());
        Service s2 = new Service();
        HashMap<String, Object> hm = new HashMap<>();
        TransactionAmount ta = new TransactionAmount("9000", "USD", DebitCredit.DEBIT, hm);
        TransactionAmount ta2 = new TransactionAmount("4000", "USD", DebitCredit.DEBIT, hm);
        TransactionAmount ta3 = new TransactionAmount("6000", "USD", DebitCredit.DEBIT, hm);
        AuthorizationRequest a = new AuthorizationRequest("8786e2f9-d472-46a8-958f-d659880e723d","50e70c62-e480-49fc-bc1b-e991ac672173",ta2);
        AuthorizationRequest a2 = new AuthorizationRequest("8786e2f9-d472-46a8-958f-d659880e723d","50e70c62-e480-49fc-bc1b-e991ac672173",ta3);
        LoadRequest lr  = new LoadRequest("loaded some stuff", "8786e2f9-d472-46a8-958f-d659880e723d", ta);
//        System.out.println(s2.deductFunds(a));
        System.out.println(s2.loadFunds(lr).load());
        System.out.println(s2.deductFunds(a).authorize());
        System.out.println(s2.deductFunds(a2).authorize());

    }
}
