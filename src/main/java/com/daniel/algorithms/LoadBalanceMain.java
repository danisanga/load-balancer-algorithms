package com.daniel.algorithms;

import com.daniel.algorithms.impl.hash.HashAlgorithm;
import com.daniel.algorithms.impl.random.RandomAlgorithm;
import com.daniel.algorithms.impl.round.robin.RoundRobinAlgorithm;
import com.daniel.algorithms.impl.weight.round.robin.WeightRoundRobinAlgorithm;

public class LoadBalanceMain {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        loadBalance();
    }

    public static void loadBalance() {
        doGetServer(new RandomAlgorithm());
        doGetServer(new RoundRobinAlgorithm());
        doGetServer(new WeightRoundRobinAlgorithm());
        doGetServer(new HashAlgorithm());
    }


    public static void doGetServer(LoadBalance loadBalance) {
        doGetServer(loadBalance, 100);
    }

    private static void doGetServer(LoadBalance loadBalance, int queryTimes) {
        for (int i = 0; i < queryTimes; i++) {
            String serverId = loadBalance.getServer(String.valueOf(i));
            System.out.println(String.format("[%s] index:%s,%s", loadBalance.getClass().getSimpleName(), i, serverId));
        }
    }

}
