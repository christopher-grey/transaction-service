package dev.codescreen;

public class LoadRequest {
    public String messageID;
    public String userID;
    public TransactionAmount transactionAmount;


    public LoadRequest(String mID, String uID, TransactionAmount tA) {
        messageID = mID;
        userID = uID;
        transactionAmount = tA;
    }
}
