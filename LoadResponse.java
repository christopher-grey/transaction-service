package dev.codescreen;

import java.util.HashMap;

public class LoadResponse {
    public String messageID;
    public String userID;
    public TransactionAmount transactionAmount;
    public HashMap<String, Object> hm;

    public LoadResponse (String mID, String uID, TransactionAmount tA, HashMap hashy){
        messageID = mID;
        userID = uID;
        transactionAmount = tA;
        hm = hashy;
        hm.put("messageId", messageID);
        hm.put("userId", userID);
        hm.put("balance", tA.transact());

    }

    public HashMap load() {
        return hm;
    }


}
