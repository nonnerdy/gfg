package org.example.java.designpattern.creational.observer;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Channel{
    private String channelName;
    private List<Subscriber> subscribers = new ArrayList<>();
    public YoutubeChannel(String channelName){
        this.channelName = channelName;
    }
    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String videoTitle) {
        System.out.println("[" + channelName + "] Uploaded: " + videoTitle);
        for (Subscriber subscriber : subscribers) {
            subscriber.update(videoTitle);
        }
    }
}
