/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectcontract;
  
/**
 *
 * @author C0472597
 */
public class Contract {
    private String contractId;
    private String originCity;
    private String destCity;
    private String orderItem;
    
    public static final int NUMBER_OF_CONTRACT_ATTRIBUTES = 4;
    public static final int INDEX_OF_CONTRACT_ID = 0;
    public static final int INDEX_OF_ORIGIN_CITY = 1;
    public static final int INDEX_OF_DEST_CITY = 2;
    public static final int INDEX_OF_ORDER_ITEM = 3;
        
    public Contract(String id, String oCity, String dCity, String item){
       contractId = id;
       originCity = oCity;
       destCity = dCity;
       orderItem = item;
    }
    
    public String getContractID(){
       return contractId;
    }
    
    public String getOriginCity(){
       return originCity;
    }
    
    public String getDestCity(){
      return destCity;
    }
    
    public String getOrderItem(){
      return orderItem;
    }

    boolean contains(String city) {
      if (city == originCity) {
          return true;
      }
      else {
          return false;
      }
    }
}
