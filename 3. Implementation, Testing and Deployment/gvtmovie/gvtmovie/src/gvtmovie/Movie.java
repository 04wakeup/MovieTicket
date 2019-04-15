/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gvtmovie;
 
public class Movie {
    private String mNo;
    private String mDate;
    private String mTime;
    private String mTitle;
    private String mActor;
    private String mRateId;
    private String mDesc;
    private String mSpecailPrice;
    private String mPriceChild;
    private String mPriceAdult;
    private String mPriceSenior;
    private String countChildren, countAdult, countSenior;
    
    public static final int NUMBER_OF_MOVIE_ATTRIBUTES = 1000;
    public static final int INDEX_OF_MOVIE_NO = 0;
    public static final int INDEX_OF_MOVIE_DATE = 1;
    public static final int INDEX_OF_MOVIE_TIME = 2;
    public static final int INDEX_OF_MOVIE_TITLE = 3;
    public static final int INDEX_OF_MOVIE_ACTOR = 4;
    public static final int INDEX_OF_MOVIE_RATE_ID = 5;
    public static final int INDEX_OF_MOVIE_DESC = 6;    
    public static final int INDEX_OF_SPECIAL_PRICE = 7;
    public static final int INDEX_OF_PRICE_CHILD = 8;
    public static final int INDEX_OF_PRICE_ADULT = 9;
    public static final int INDEX_OF_PRICE_SENIOR = 10;
        
    public Movie(String iNo, String iDate, String iTime, String iTitle, String iActor, String iRateId, String iDesc,
    String imSpecail_Price , String imPriceChild, String imPriceAdult, String imPriceSenior){
       mNo = iNo;
       mDate = iDate;
       mTime = iTime;
       mTitle = iTitle;
       mActor = iActor;
       mRateId = iRateId;
       mDesc = iDesc;
       mSpecailPrice = imSpecail_Price;
       mPriceChild = imPriceChild;
       mPriceAdult = imPriceAdult;
       mPriceSenior = imPriceSenior;
    }
    
    public String getmNo(){       return mNo;    }    
    public String getmDate(){       return mDate;    }    
    public String getmTime(){      return mTime;    }    
    public String getmTitle(){      return mTitle;    }
    public String getmActor(){      return mActor;    }
    public String getmRateId(){      return mRateId;    }
    public String getmDesc(){      return mDesc;    }
    public String getmSpecial_Price(){      return mSpecailPrice;    }
    public String getmPriceChild(){      return mPriceChild;    }
    public String getmPriceAdult(){      return mPriceAdult;    }
    public String getmPriceSenior(){      return mPriceSenior;    }
    
    public void setCountChildren(String icountChildren){         countChildren = icountChildren;                    };
    public String getCountChildren(){      return countChildren;    }
    public void setCountAdult(String icountAdult){         countAdult = icountAdult;                    };
    public String getCountAdult(){      return countAdult;    }
    public void setCountSenior(String icountSenior){         countSenior = icountSenior;                    };
    public String getCountSenior(){      return countSenior;    }
    
    boolean contains(String iDate) {
      if (iDate == mDate) {
          return true;
      }
      else {
          return false;
      }
    }
    
    boolean contains_time(String iTime) {
      if (mTime == iTime) {
          return true;
      }
      else {
          return false;
      }
    }
}

