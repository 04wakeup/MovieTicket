/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticket;    

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList; 
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author C0472597
 */
 class ContractModel {
    private ArrayList<Contract> theContracts;
    private ArrayList<Contract> theContractsAll;
    private int contractCounter; 
    private SortedSet<String> originCityList;
    
    private static final String filename="C:\\Users\\dojun\\Sync\\ICS125\\Project\\MovieTicket\\3. Implementation, Testing and Deployment\\movieticket\\src\\contracts.txt";
    public ContractModel(){
        contractCounter = 0;
        theContracts = new ArrayList<Contract>(); 
        // theContractsAll = new ArrayList<Contract>();  
        
        
        
        originCityList = new TreeSet<>(); 
        try(
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String line;

            while((line = bufferedReader.readLine()) != null){
                String[] tokens = line.split(",", Contract.NUMBER_OF_CONTRACT_ATTRIBUTES);

                String contractID = tokens[Contract.INDEX_OF_CONTRACT_ID];
                String originCity = tokens[Contract.INDEX_OF_ORIGIN_CITY];
                String destCity = tokens[Contract.INDEX_OF_DEST_CITY];
                String orderItem = tokens[Contract.INDEX_OF_ORDER_ITEM];

                Contract dataContract = new Contract(contractID, originCity, destCity, orderItem);

                theContracts.add(dataContract);
                originCityList.add(originCity);
            }
                originCityList.add("All");
                theContractsAll = new ArrayList<>(theContracts);
            fileReader.close();
            }
        catch(IOException ex){
            System.out.println(ex.getMessage());
         }
    }
    
    public String[] getOriginCityList(){
        String[] a;
        a = originCityList.toArray(new String[originCityList.size()]);
        return a;
    }
    
    public void updateContractList(String city){
        theContracts = new ArrayList<>(theContractsAll);
        if(city != "All"){
            theContracts.removeIf(s -> !s.contains(city));
        }
        contractCounter = 0;
    }
    
    public boolean foundContracts(){        
        if(theContracts.size() > 0){
            return true;
        }
        else {
            return false;
        }
    }
    
    public Contract getTheContract(){
        
        return theContracts.get(contractCounter);
    }
    
    public int getContractCount(){
        
        return theContracts.size();
    }   
  
    public int getCurrentContractNum(){
        return contractCounter;
    }
    
    public void nextContract(){
        if (contractCounter < Contract.NUMBER_OF_CONTRACT_ATTRIBUTES - 1){
            contractCounter++;
        }        
    }
    
    public void prevContract(){
         if (contractCounter > 0){
            contractCounter--;
        }   
    
    }
    
  
}
