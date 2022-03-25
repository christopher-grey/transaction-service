package dev.codescreen;
import java.util.HashMap;


public class AuthorizationResponse {
    
    public String messageId;
    public String userID;
    public ResponseCode responseCode;
    public TransactionAmount balance;
    public HashMap<String, Object> hm;

    public AuthorizationResponse(String mID, String uID, ResponseCode rCode, TransactionAmount bal, HashMap hash3) {
        messageId = mID;
        userID = uID;
        responseCode = rCode; 
        balance = bal;
        hm = hash3;

        hm.put("messageId", messageId);
        hm.put("userId", userID);
        hm.put("responseCode", rCode);
        hm.put("balance", bal);
    }
    public HashMap authorize() {
        return hm;
    }
}
