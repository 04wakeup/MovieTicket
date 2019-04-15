 
package gvtmovie;  

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
        this.theView.addcomboBoxTimeListener(new ComboTimeListener());
        this.theView.addcomboBoxAgeListener(new ComboAgeListener());
        
        this.theView.setMovieList(this.theModel.getMovieDate());//(this.theModel.getMovieDate());
        this.theView.setMovieListTime(this.theModel.getMovieTime());
        this.theView.setMovieListAge(this.theModel.getMovieAge());
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
                theView.setmSpecial_Price(c.getmSpecial_Price()); 
                theView.setmPriceChild(c.getmPriceChild()); 
                theView.setmPriceAdult(c.getmPriceAdult()); 
                theView.setmPriceSenior(c.getmPriceSenior()); 
                    
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
      class ComboTimeListener implements ItemListener{
      // private ArrayList<Contract> theContractsAll; ; // ???
       //SortedSet<String> originCityList;  // here or in model?
       
       @Override   
       public void itemStateChanged(ItemEvent e){
           System.out.println(e.getItem().toString());
           if(e.getStateChange() == ItemEvent.SELECTED){
               String selectedTime = e.getItem().toString();
               System.out.println(selectedTime);
               theModel.updateMovieTime(selectedTime);
               setUpDisplay();
           }
       }
   }
      
 class ComboAgeListener implements ItemListener{ 
       @Override   
       public void itemStateChanged(ItemEvent e){
           System.out.println(e.getItem().toString());
           if(e.getStateChange() == ItemEvent.SELECTED){
               String selectedAge = e.getItem().toString();
               System.out.println(selectedAge);
               theModel.updateMovieAge(selectedAge);
               setUpDisplay();
           }
       }
   }
   class BidButtonListener implements ActionListener{
     @Override
     public void actionPerformed(ActionEvent e){
          DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM dd YYYY HH:mm z"); 
            int DD, MM, YYYY;
            int sDD, sMM, sYYYY;
            String text2 = ZonedDateTime.now().format(FORMATTER); 
            String text1 = theView.getmDate();
            DD = Integer.parseInt(text2.substring(3,5));
            MM = Integer.parseInt(text2.substring(0,2))-1;
            YYYY =Integer.parseInt(text2.substring(6,10));
            Calendar end = Calendar.getInstance();            
            sDD = Integer.parseInt(text1.substring(8,10))+1;
            sMM = Integer.parseInt(text1.substring(5,7))-1;
            sYYYY =Integer.parseInt(text1.substring(0,4)); 
            Calendar start = Calendar.getInstance();
        
        start.set(YYYY, MM, DD);
        end.set(sYYYY, sMM, sDD);
        Date startDate = start.getTime();
        Date endDate = end.getTime();
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        long diffTime = endTime - startTime;
        long diffDays = diffTime / (1000 * 60 * 60 * 24);
        DateFormat dateFormat = DateFormat.getDateInstance();
//        System.out.println("The difference between "+
//          dateFormat.format(startDate)+" and "+
//          dateFormat.format(endDate)+" is "+
//          diffDays+" days.");

     //System.out.println("test1");  
     //String temp = theView.getCountChildren();
     // System.out.println(theView.getCountChildren());
//     System.out.println(theView.getCountChildren());
//     System.out.println(theView.getCountAdult());
//     System.out.println(theView.getCountSenior());
         
        if (!theView.getCountChildren().equals("0") && (theView.getmRateId().equals("RESTRICTED") | (theView.getmRateId().equals("NO CHILDREN(OVER17)")) | (theView.getmRateId().equals("PARENTAL  GUIDANCE")) | (theView.getmRateId().equals("PARENTAL GUIDANCE(OVER13)")))                    ){
            theView.displayErrorMessage("Children can't watch RESTRICTED movie."); 
           }
        else if (diffDays > 7){ 
                theView.displayErrorMessage("You can but a ticke within 7 days."); 
        }
        else {
                try{
                    ConfirmBid cb;
                    Movie c = theModel.getTheMovie(); // get the index
                    c.setCountChildren(theView.getCountChildren());
                    c.setCountAdult(theView.getCountAdult());
                    c.setCountSenior(theView.getCountSenior());
                    // check start

                    // check end
                    cb = new ConfirmBid(theView, true, c); 
                    cb.setLocationRelativeTo(null);
                    cb.setVisible(true);

                }catch(Exception ex){
                   System.out.println(ex);
                   theView.displayErrorMessage("Error: There is a problem setting a previous contract.");
                }
                setUpDisplay();
        }
     }  // git , project(git-add, commit) then team(remote-push!!!)
   }
   

    
}
