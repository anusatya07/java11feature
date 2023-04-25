package com.v2;
import java.util.Optional;
interface interface_default {
     default void default_method(){
         System.out.println("We are default method of interface");
    }
}
class derived_class implements interface_default{
 
}
class Main{
   public static void main(String[] args){
        derived_class obj1 = new derived_class();
        obj1.default_method();
    }
}