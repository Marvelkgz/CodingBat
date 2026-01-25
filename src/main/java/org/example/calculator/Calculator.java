package org.example.calculator;

public class Calculator {
   public int sum(int a,int b){
       return a + b;
   }
   public int divide(int a,int b){
       if (b == 0){
           throw new IllegalArgumentException("Dividing by zero");
       }
       return a / b;
   }
}
