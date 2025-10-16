package org.example.java.designpattern.creational.singleton;

public class Singleton {
    private static volatile  Singleton instance;

    private Singleton(){};

    //public access point
    public static Singleton getInstance(){
        if (instance == null){
            synchronized(Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void log(String msg){
        System.out.println("[LOG]: "+msg);
    }



}

