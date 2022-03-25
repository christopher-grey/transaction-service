package dev.codescreen;


public class AuthorizationRequest {
    public String userID;
    public String messageID;
    public TransactionAmount transactionAmount;

    public AuthorizationRequest(String uID, String mID, TransactionAmount tA) {
        userID = uID;
        messageID = mID;
        transactionAmount = tA;
    }
}


