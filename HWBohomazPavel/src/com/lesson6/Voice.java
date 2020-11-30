package com.lesson6;

public interface Voice {

    default String voice(){ // corrected
        return "Hello, ";
    }

}
