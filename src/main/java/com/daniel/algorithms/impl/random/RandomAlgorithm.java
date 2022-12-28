package com.daniel.algorithms.impl.random;

import com.daniel.algorithms.IpPool;
import com.daniel.algorithms.LoadBalance;

import java.util.*;

public class RandomAlgorithm implements LoadBalance {

    @Override
    public String getServer(String clientIp) {
        Set<String> servers = IpPool.ipMap.keySet();
        List<String> serverList = new ArrayList<>();
        serverList.addAll(servers);
        int randomIndex = new Random().nextInt(serverList.size());
        String target = serverList.get(randomIndex);

        return target;
    }

}
