package org.biswajit.multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TestMain {
    public static void main(String[] args) throws InterruptedException{
        InnerThread innerThread = new InnerThread();
        Thread inr = new Thread(innerThread);
        inr.setDaemon(true);
        inr.start();

      //  int[] nums = {3,2,2};
int[] nums = {1,2,3,4,5,6,1,7};
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, 2);
            } else {
                map.put(num, 1);
            }
        }

        Optional<Integer> key = map.entrySet().stream().filter(entry->entry.getValue()==2).map(Map.Entry::getKey).findFirst();



        System.out.println(map);
    }

}

class InnerThread implements Runnable{

    @Override
    public void run() {
        int i = 0;
        while(true) {
            System.out.println("This is inner thread : "+i++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

