 
package gvtmovie;  

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.SortedSet;
 
class MovieController {
    
    private   MovieView theView;
    private   MovieModel theModel; 
    private   ConfirmBid theBid; 
  public MovieController(MovieView theView, MovieModel theModel) {
        this.theView = theView;
        this.theModel = theModel;  
        this.theView.addPrevListener(new PrevButtonListener());
        this.theView.addBidListener(new   BidButtonListener());
         
        
        this.theView.addNextListener(new NextButtonListener());
        this.theView.addcomboBoxListener(new ComboListener());
        this.theView.setMovieList(this.theModel.getMovieDate());//(this.theModel.getMovieDate());
        setUpDisplay();
   }
    
   private void setUpDisplay(){
       try{
           if(theModel.foundMovies()){
                Movie c = theModel.getTheMovie();
                theView.setmNo(c.getmNo());
                theView.setmDate(c.getmDate());
                theView.setmTime(c.getmTime());
                theView.setmTitle(c.getmTitle());
                theView.setmActor(c.getmActor());
                theView.setmRateId(c.getmRateId());
                theView.setmDesc(c.getmDesc()); 
                    
                theView.updateMovieViewPanel(theModel.getCurrentMovieNum(), theModel.getMovieCount());
                
                theView.setJNextButtonEnable(); // Initialize the visibility
                theView.setJPrevButtonEnable();
                
                if (theModel.getCurrentMovieNum() == theModel.getMovieCount() - 1 ){                     // disable the buttons
                     theView.setJNextButtonDisable();  
                }
                if(theModel.getCurrentMovieNum() == 0){
                     theView.setJPrevButtonDisable();
                }
                
           }
           else {
                theView.setmNo("???");
                theView.setmDate("???");
                theView.setmTime("???");
                theView.setmTitle("???");
                theView.setmActor("???");
                theView.setmRateId("???");
                theView.setmDesc("???"); 
           }
            
       } catch (Error ex){
           System.out.println(ex);
           theView.displayErrorMessage("Error; There was a problem setting the contract.\n");
       }
   }

   class PrevButtonListener implements ActionListener{
     @Override
     public void actionPerformed(ActionEvent e){
        if(theModel.getCurrentMovieNum() == 0){
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
        if(theModel.getCurrentMovieNum() == theModel.getMovieCount()){
           return;
        }
        try{
           theModel.nextMovie();
           
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
               String selectedDate = e.getItem().toString();
               System.out.println(selectedDate);
               theModel.updateMovieDate(selectedDate);
               setUpDisplay();
           }
       }
   }
   
   class BidButtonListener implements ActionListener{
     @Override
     public void actionPerformed(ActionEvent e){
     System.out.println("test1");  
     //String temp = theView.getCountChildren();
     // System.out.println(theView.getCountChildren());
//     System.out.println(theView.getCountChildren());
//     System.out.println(theView.getCountAdult());
//     System.out.println(theView.getCountSenior());
        
        try{
            ConfirmBid cb;
            Movie c = theModel.getTheMovie(); // get the index
            c.setCountChildren(theView.getCountChildren());
            c.setCountAdult(theView.getCountAdult());
            c.setCountSenior(theView.getCountSenior());
             
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
