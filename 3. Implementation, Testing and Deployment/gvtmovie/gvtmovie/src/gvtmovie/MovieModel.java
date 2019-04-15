/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gvtmovie;    

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
 class MovieModel {
    private ArrayList<Movie> theMovies;
    private ArrayList<Movie> theMoviesAll;
    private int movieCounter; 
    private SortedSet<String> MovieDate;
    private SortedSet<String> MovieTime;
     private SortedSet<String> MovieAge;
    
    private static final String filename="C:\\Users\\dojun\\Sync\\ICS125\\Project\\MovieTicket\\3. Implementation, Testing and Deployment\\gvtmovie\\gvtmovie\\src\\gvtmovie\\movies.txt";
    public MovieModel(){
        movieCounter = 0;
        theMovies = new ArrayList<Movie>(); 
        // theContractsAll = new ArrayList<Contract>();    
        
        MovieDate = new TreeSet<>(); 
        MovieTime = new TreeSet<>(); 
        MovieAge = new TreeSet<>(); 
        try(
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String line;

            while((line = bufferedReader.readLine()) != null){
                String[] tokens = line.split(",", Movie.NUMBER_OF_MOVIE_ATTRIBUTES+2 );

                String mNo = tokens[Movie.INDEX_OF_MOVIE_NO ]; 
                String mDate = tokens[Movie.INDEX_OF_MOVIE_DATE  ]; 
                String mTime = tokens[Movie.INDEX_OF_MOVIE_TIME  ]; 
                String mTitle = tokens[Movie.INDEX_OF_MOVIE_TITLE  ]; 
                String mActor = tokens[Movie.INDEX_OF_MOVIE_ACTOR  ]; 
                String mRateId = tokens[Movie.INDEX_OF_MOVIE_RATE_ID  ]; 
                String mDesc = tokens[Movie.INDEX_OF_MOVIE_DESC  ]; 
                String mSpecailPrice = tokens[Movie.INDEX_OF_SPECIAL_PRICE  ]; 
                String mPriceChild = tokens[Movie.INDEX_OF_PRICE_CHILD  ]; 
                String mPriceAdult = tokens[Movie.INDEX_OF_PRICE_ADULT  ]; 
                String mPriceSenior = tokens[Movie.INDEX_OF_PRICE_SENIOR  ]; 

                Movie dataMovie = new Movie(mNo, mDate, mTime, mTitle,mActor, mRateId, mDesc, mSpecailPrice, mPriceChild, mPriceAdult, mPriceSenior);

                theMovies.add(dataMovie);
                MovieDate.add(mDate);
                MovieTime.add(mTime);
                MovieAge.add(mRateId);
            }
                MovieDate.add("All");
                MovieTime.add("All");
                MovieAge.add("All");
                theMoviesAll = new ArrayList<>(theMovies);
            fileReader.close();
            }
        catch(IOException ex){
            System.out.println(ex.getMessage());
         }
    }
    
    public String[] getMovieDate(){
        String[] a;
        a = MovieDate.toArray(new String[MovieDate.size()]);
        return a;
    }
    public String[] getMovieTime(){
        String[] a;
        a = MovieTime.toArray(new String[MovieTime.size()]);
        return a;
    }
    public String[] getMovieAge(){
        String[] a;
        a = MovieAge.toArray(new String[MovieAge.size()]);
        return a;
    }
    public void updateMovieDate(String imdate){
        theMovies = new ArrayList<>(theMoviesAll);
        if(imdate != "All"){ 
            theMovies.removeIf(s -> !s.getmDate().contains(imdate));
        }
        movieCounter = 0;
    }
     public void updateMovieTime(String imtime){
        theMovies = new ArrayList<>(theMoviesAll);
        if(imtime != "All"){ 
            theMovies.removeIf(s -> !s.getmTime().contains(imtime));
        }
        movieCounter = 0;
    }
   public void updateMovieAge(String imRate){
        theMovies = new ArrayList<>(theMoviesAll);
        if(imRate != "All"){ 
            theMovies.removeIf(s -> !s.getmRateId().contains(imRate));
        }
        movieCounter = 0;
    }
    public boolean foundMovies(){        
        if(theMovies.size() > 0){
            return true;
        }
        else {
            return false;
        }
    }
    
    public Movie getTheMovie(){
        
        return theMovies.get(movieCounter);
    }
    
    public int getMovieCount(){
        
        return theMovies.size();
    }   
  
    public int getCurrentMovieNum(){
        return movieCounter;
    }
    
    public void nextMovie(){
        if (movieCounter < Movie.NUMBER_OF_MOVIE_ATTRIBUTES  - 1){
            movieCounter++;
        }        
    }
    
    public void prevContract(){
         if (movieCounter > 0){
            movieCounter--;
        }   
    
    }
    
  
}
