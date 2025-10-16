package org.example.java.designpattern.creational.observer;

public class User implements Subscriber{
    private String name;

    public User (String name){
        this.name = name;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println(name + " received notification: New video uploaded - " + videoTitle);
    }
}
