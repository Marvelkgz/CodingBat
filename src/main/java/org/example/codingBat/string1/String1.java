package org.example.codingBat.string1;

public class String1 {

    public String helloName(String name){
        return "Hello " + name + "!";
    }

    public String makeTags(String a, String b){
        return a + b + b + a;
    }
    public String extraEnd(String str){
        String name = str.substring(str.length() - 2);
        return name + name + name;
    }

    public String firstTwo(String str){
        if (str.length() > 2){
            return str.substring(0,2);
        }
        return str;
    }

    public String firstHalf(String str){
        if (str.length() % 2 == 0){
            return str.substring(0,str.length() / 2);
        }
        return str;
    }

    public String withoutEnd(String str){
        if (str.length() >= 2){
            return str.substring(1,str.length() - 1);
        }
        return str;
    }

    public String comboString(String a,String b){
        if (a.length() > b.length()){
            return b + a + b;
        }
        return a + b + a;
    }

}
