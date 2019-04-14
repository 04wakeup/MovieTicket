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
    private String countChildren, countAdult, countSenior;
    
    public static final int NUMBER_OF_MOVIE_ATTRIBUTES = 1000;
    public static final int INDEX_OF_MOVIE_NO = 0;
    public static final int INDEX_OF_MOVIE_DATE = 1;
    public static final int INDEX_OF_MOVIE_TIME = 2;
    public static final int INDEX_OF_MOVIE_TITLE = 3;
    public static final int INDEX_OF_MOVIE_ACTOR = 4;
    public static final int INDEX_OF_MOVIE_RATE_ID = 5;
    public static final int INDEX_OF_MOVIE_DESC = 6;
        
    public Movie(String iNo, String iDate, String iTime, String iTitle, String iActor, String iRateId, String iDesc){
       mNo = iNo;
       mDate = iDate;
       mTime = iTime;
       mTitle = iTitle;
       mActor = iActor;
       mRateId = iRateId;
       mDesc = iDesc;
    }
    
    public String getmNo(){       return mNo;    }    
    public String getmDate(){       return mDate;    }    
    public String getmTime(){      return mTime;    }    
    public String getmTitle(){      return mTitle;    }
    public String getmActor(){      return mActor;    }
    public String getmRateId(){      return mRateId;    }
    public String getmDesc(){      return mDesc;    }
    
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
}

