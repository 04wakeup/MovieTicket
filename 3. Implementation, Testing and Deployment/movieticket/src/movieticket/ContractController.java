/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticket;  

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.SortedSet;
/**
 *
 * @author C0472597
 */
class ContractController {
    
    private   ContractView theView;
    private   ContractModel theModel;
  public ContractController(ContractView theView, ContractModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
        this.theView.addPrevListener(new PrevButtonListener());
        this.theView.addBidListener(new   BidButtonListener());
        this.theView.addNextListener(new NextButtonListener());
        this.theView.addcomboBoxListener(new ComboListener());
        this.theView.setOriginCityList(this.theModel.getOriginCityList());
        setUpDisplay();
   }
    
   private void setUpDisplay(){
       try{
           if(theModel.foundContracts()){
                Contract c = theModel.getTheContract();
                theView.setContractID(c.getContractID());
                theView.setDestCity(c.getDestCity());
                theView.setOriginCity(c.getOriginCity());
                theView.setOrderItem(c.getOrderItem());
                
                theView.updateContractViewPanel(theModel.getCurrentContractNum(), theModel.getContractCount());
                
                theView.setJNextButtonEnable(); // Initialize the visibility
                theView.setJPrevButtonEnable();
                
                if (theModel.getCurrentContractNum() == theModel.getContractCount() - 1 ){                     // disable the buttons
                     theView.setJNextButtonDisable();  
                }
                if(theModel.getCurrentContractNum() == 0){
                     theView.setJPrevButtonDisable();
                }
                
           }
           else {
                theView.setContractID("???");
                theView.setDestCity("???");
                theView.setOriginCity("???");
                theView.setOrderItem("???");
           }
            
       } catch (Error ex){
           System.out.println(ex);
           theView.displayErrorMessage("Error; There was a problem setting the contract.\n");
       }
   }

   class PrevButtonListener implements ActionListener{
     @Override
     public void actionPerformed(ActionEvent e){
        if(theModel.getCurrentContractNum() == 0){
           return;
        }
        try{
           theModel.prevContract();
           
        }catch(Exception ex){
           System.out.println(ex);
           theView.displayErrorMessage("Error: There is a problem setting a previous contract.");
        }
        setUpDisplay();
     }
   }
   
   class NextButtonListener implements ActionListener{
     @Override
     public void actionPerformed(ActionEvent e){  // last page check
        if(theModel.getCurrentContractNum() == theModel.getContractCount()){
           return;
        }
        try{
           theModel.nextContract();
           
        }catch(Exception ex){
           System.out.println(ex);
           theView.displayErrorMessage("Error: There is a problem setting a previous contract.");
        }
        setUpDisplay();
     }
   }
   
   class ComboListener implements ItemListener{
      // private ArrayList<Contract> theContractsAll; ; // ???
       //SortedSet<String> originCityList;  // here or in model?
       
       @Override   
       public void itemStateChanged(ItemEvent e){
           System.out.println(e.getItem().toString());
           if(e.getStateChange() == ItemEvent.SELECTED){
               String selectedCity = e.getItem().toString();
               System.out.println(selectedCity);
               theModel.updateContractList(selectedCity);
               setUpDisplay();
           }
       }
   }
   
   class BidButtonListener implements ActionListener{
     @Override
     public void actionPerformed(ActionEvent e){
 
        try{
            ConfirmBid cb;
            Contract c = theModel.getTheContract(); // add it james
            
            cb = new ConfirmBid(theView, true, c);
            cb.setLocationRelativeTo(null);
            cb.setVisible(true);
           
        }catch(Exception ex){
           System.out.println(ex);
           theView.displayErrorMessage("Error: There is a problem setting a previous contract.");
        }
        setUpDisplay();
     }  // git , project(git-add, commit) then team(remote-push!!!)
   }
    
}
