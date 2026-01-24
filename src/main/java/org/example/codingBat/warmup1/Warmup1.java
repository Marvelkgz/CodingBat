package org.example.codingBat.warmup1;

public class Warmup1 {
   public  boolean sleepIn(boolean weekDay,boolean vacation){
           return !weekDay || vacation;
       }

       public boolean monkeyTrouble(boolean aSmile,boolean bSmile){
       return !aSmile != bSmile;
       }
}
