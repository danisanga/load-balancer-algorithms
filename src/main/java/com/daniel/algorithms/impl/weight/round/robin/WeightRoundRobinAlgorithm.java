package com.daniel.algorithms.impl.weight.round.robin;

import com.daniel.algorithms.IpPool;
import com.daniel.algorithms.LoadBalance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WeightRoundRobinAlgorithm implements LoadBalance {

    private static Integer position = 0;

    @Override
    public String getServer(String clientIp) {
        Set<String> servers = IpPool.ipMap.keySet();
        List<String> serverList = new ArrayList<>();

        Iterator<String> iterator = servers.iterator();
        while (iterator.hasNext()) {
            String serverItem = iterator.next();
            Integer weight = IpPool.ipMap.get(serverItem);
            if (weight > 0) {
                for (int i = 0; i < weight; i++) {
                    serverList.add(serverItem);
                }
            }

        }

        synchronized (position) {
            if (position > serverList.size()) {
                position = 0;
            }

            String target = serverList.get(position);
            position++;
            return target;
        }
    }

}
