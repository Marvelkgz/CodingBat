package codingBatTest.stringTest1;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTest extends BaseStringTest{

   @Test
    void helloName(){
       assertEquals(string1.helloName("Bob"),"Hello Bob!");
       assertEquals(string1.helloName("Alice"),"Hello Alice!");
       assertEquals(string1.helloName("Dolly"),"Hello Dolly!");
       assertEquals(string1.helloName("Xre"),"Hello Xre!");
       assertEquals(string1.helloName("Omega"),"Hello Omega!");
   }

   @Test
    void makeTags(){
       assertEquals(string1.makeTags("Hi","Bye"),"HiByeByeHi");
       assertEquals(string1.makeTags("Yo","Bo"),"YoBoBoYo");
       assertEquals(string1.makeTags("aaa","bb"),"aaabbbbaaa");
       assertEquals(string1.makeTags("xx","yy"),"xxyyyyxx");
   }

   @Test
    void extra(){
       assertEquals(string1.extraEnd("hello"),"lololo");
       assertEquals(string1.extraEnd("yay"),"ayayay");
       assertEquals(string1.extraEnd("address"),"ssssss");
       assertEquals(string1.extraEnd("hi"),"hihihi");

   }

   @Test
    void firstTwo(){
       assertEquals(string1.firstTwo("Hello"),"He");
       assertEquals(string1.firstTwo("ad"),"ad");
       assertEquals(string1.firstTwo("Elka"),"El");
       assertEquals(string1.firstTwo("Sumi"),"Su");
   }
   @Test
    void firstHalf(){
       assertEquals(string1.firstHalf("WooHoo"),"Woo");
       assertEquals(string1.firstHalf("HelloThere"),"Hello");
       assertEquals(string1.firstHalf("abcdef"),"abc");
       assertEquals(string1.firstHalf("kitten"),"kit");
   }

   @Test
    void withoutEnd(){
       assertEquals(string1.withoutEnd("Hello"),"ell");
       assertEquals(string1.withoutEnd("java"),"av");
       assertEquals(string1.withoutEnd("coding"),"odin");
       assertEquals(string1.withoutEnd("kitten"),"itte");
   }

   @Test
    void comboString(){
       assertEquals(string1.comboString("Hello","Hi"),"HiHelloHi");
       assertEquals(string1.comboString("aaa","b"),"baaab");
       assertEquals(string1.comboString("bb","a"),"abba");
       assertEquals(string1.comboString("www","ee"),"eewwwee");
   }
}
