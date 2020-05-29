package com.epm.fta.designpattern.pages.utils;

public class Utlity {

    public static void waitOperation()  {
        try {
            Thread.sleep( 1000 );
        }catch (InterruptedException ie){

        }
    }
}
