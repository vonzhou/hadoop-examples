package com.vonzhou.learnhadoop.simple;

import org.apache.hadoop.io.Text;

/**
 * Created by vonzhou on 2016/12/12.
 */
public class TextDemo {
    public static void texts(){
        Text t = new Text("人类的群星");
        System.out.println(t.getLength());
        System.out.println(t.find("人"));
        System.out.println(t.find("类"));
        System.out.println(t.find("的"));
        System.out.println(t.find("群"));
    }
    public static void main(String[] args) {
        texts();
    }
}
