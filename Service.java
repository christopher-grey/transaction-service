package dev.codescreen;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
/**
 * Service class to authorize and handle deductions and loading into user account
 */
public class Service {
  //Map for storing user and their account balances
  private Map<String, Double> userIdToBalance;
  private HashMap<String, Object> hm3 = new HashMap<>();
  
  public Service() {
    userIdToBalance = new HashMap<>();
    hm3 = new HashMap<>();
  }

  /**
   * Returns the system time as an instant
   */ 
   public Instant ping() {
    return Instant.now();
   }

   /** 
   * Deduct funds from a users account
   * @param AuthorizationRequest the request containing user and amount to deduct.
   * @return AuthorizationResponse the response indication success or failure and new balance
   */ 
   public AuthorizationResponse deductFunds(AuthorizationRequest request) {
      if (!userIdToBalance.containsKey(request.userID)) {
        return new AuthorizationResponse(request.userID, request.messageID, ResponseCode.DECLINED, request.transactionAmount, hm3);
      } 
      double userBalance =  userIdToBalance.get(request.userID);
      double requestedAmount = Double.parseDouble(request.transactionAmount.amount); 
      if (requestedAmount > userBalance) {
        return new AuthorizationResponse(request.userID, request.messageID, ResponseCode.DECLINED, request.transactionAmount, hm3);
      }
      double updatedBalance = userBalance - requestedAmount;
      userIdToBalance.put(request.userID, updatedBalance);
       HashMap<String, Object> hm3 = new HashMap<>();
      TransactionAmount newTransactionAmount = new TransactionAmount(String.valueOf(updatedBalance), request.transactionAmount.currency, DebitCredit.DEBIT, hm3);
      return new AuthorizationResponse(request.userID, request.messageID, ResponseCode.APPROVED, newTransactionAmount, hm3);
   }

   /**
   * Adds funds to a users account
   * @param LoadRequest Object containing amount to add to users account
   * @return LoadResponse Object containing new transaction amount
   */ 
   public LoadResponse loadFunds(LoadRequest loadRequest) {
     double requestedAmount = Double.parseDouble(loadRequest.transactionAmount.amount); 
     double userBalance =  userIdToBalance.getOrDefault(loadRequest.userID, 0.0);
     double newBalance = requestedAmount + userBalance;
     userIdToBalance.put(loadRequest.userID, newBalance);
     HashMap<String, Object> hm2 = new HashMap<>();
     TransactionAmount newTransactionAmount = new TransactionAmount(String.valueOf(newBalance), loadRequest.transactionAmount.currency, DebitCredit.CREDIT, hm2);
     HashMap<String, Object> hm = new HashMap<>();
     return new LoadResponse(loadRequest.userID, loadRequest.messageID, newTransactionAmount, hm);
    }
  }

    