package org.example.codingBat.warmup1;

public class Warmup1 {
   public  boolean sleepIn(boolean weekDay,boolean vacation){
           return !weekDay || vacation;
       }

       public int sumDouble(int a, int b){
       int sum = a + b;
       if(a == b){
           sum = sum * 2;
       }
       return sum;
       }

       public int diff21(int n){
       if (n <= 21){
           return 21 - n;
       }else{
           return (n - 21) * 2;
       }
       }

       public boolean parrotTrouble(boolean talking,int hour){
       return (talking && (hour <= 7 || hour > 20));
       }

       public boolean makes10(int a,int b){
       return (a == 10 || b == 10 || a + b == 10);
       }

       public boolean posNeg(int a,int b,boolean negative){
       if (negative){
           return (a < 0 && b < 0);
       }else{
           return ((a < 0 && b > 0) || (a > 0 && b < 0));
       }
       }

}
