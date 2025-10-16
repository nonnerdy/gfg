package org.example.java.designpattern.creational.observer;

public class ObserverExample {
    public static void main(String[] args) {
        YoutubeChannel channel = new YoutubeChannel("TechWithBiswajit");

        Subscriber user1 = new User("Alice");
        Subscriber user2 = new User("Bob");
        Subscriber user3 = new User("Charlie");

        // Subscribing users
        channel.subscribe(user1);
        channel.subscribe(user2);
        channel.subscribe(user3);

        // New video upload
        channel.notifySubscribers("Java Design Patterns Explained");

        // Bob unsubscribes
        channel.unsubscribe(user2);

        // Another video upload
        channel.notifySubscribers("Observer Pattern in Depth");
    }
}
