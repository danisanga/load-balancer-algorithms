package com.daniel.algorithms.impl.round.robin;

import com.daniel.algorithms.IpPool;
import com.daniel.algorithms.LoadBalance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class RoundRobinAlgorithm implements LoadBalance {

    private static Integer position = 0;

    @Override
    public String getServer(String clientIp) {
        Set<String> servers = IpPool.ipMap.keySet();
        List<String> serverList = new ArrayList<>();
        serverList.addAll(servers);
        String target = null;

        synchronized (position) {
            if (position > serverList.size() - 1) {
                position = 0;
            }
            target = serverList.get(position);
            position++;
        }
        return target;
    }

}
