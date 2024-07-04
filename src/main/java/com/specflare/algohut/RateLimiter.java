package com.specflare.algohut;

import java.util.*;

public class RateLimiter {
    private int maxRequestsPerMinute;
    Map<String, LinkedList<Long>> requests;

    public RateLimiter(int maxRequestsPerMinute) {
        this.maxRequestsPerMinute = maxRequestsPerMinute;
        requests = new HashMap<>();
    }

    public boolean request(String user) {
        long currTs = System.currentTimeMillis();
        long backTs = currTs - 60 * 1000;

        LinkedList<Long> userQueue = requests.get(user);
        if (userQueue != null) {
            while (!userQueue.isEmpty()) {
                Long peekVal = userQueue.peek();
                if (peekVal < backTs) {
                    userQueue.poll();
                } else {
                    break;
                }
            }

            if (userQueue.size() >= maxRequestsPerMinute) {
                System.out.println("Request discarded for user: " + user);
                return false;
            }

            userQueue.add(currTs);
        } else {
            LinkedList<Long> newQueue = new LinkedList<>();
            newQueue.add(currTs);
            requests.put(user, newQueue);
        }

        System.out.println("Request accepted for user: " + user);
        return true;
    }

    public static void main(String[] args) {
        RateLimiter rl = new RateLimiter(2);

        rl.request("liviu");
        rl.request("adrian");
        rl.request("liviu");
        rl.request("liviu");
    }
}