package com.daniel.algorithms.impl.hash;

import com.daniel.algorithms.IpPool;
import com.daniel.algorithms.LoadBalance;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HashAlgorithm implements LoadBalance {

    @Override
    public String getServer(String clientIp) {
        if (clientIp == null) {
            clientIp = "127.0.0.1";
        }
        Set<String> servers = IpPool.ipMap.keySet();
        List<String> serverList = new ArrayList<>();
        serverList.addAll(servers);
        String remoteId = clientIp;
        Integer index = remoteId.hashCode() % serverList.size();
        String target = serverList.get(index);
        return target;
    }

}
