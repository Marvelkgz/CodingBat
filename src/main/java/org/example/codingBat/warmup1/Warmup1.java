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

       public String notString(String str) {
           if (str.length() >= 3 && str.substring(0, 3).equals("not ")) {
           }
           return "not " + str;
       }

       public String missingChar(String str,int n){
       String front = str.substring(0,n);
       String back = str.substring(n + 1,str.length());
       return front + back;
       }

       public String frontBack(String str){
       if (str.length() <= 1)return str;
       String mid = str.substring(1,str.length() - 1);
       return str.charAt(str.length() - 1) + mid + str.charAt(0);
       }





    public boolean nearHundred(int n){
        return ((Math.abs(100 - n) <= 10) || (Math.abs(200 - n) <= 10));
    }
       }
