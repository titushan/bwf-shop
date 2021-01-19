package com.bwf.shop.website.common;

public class Random {

    public static Integer nextInt( Integer min , Integer max ){
        return (int)(Math.random() * ( max - min ) + min );
    }

}
