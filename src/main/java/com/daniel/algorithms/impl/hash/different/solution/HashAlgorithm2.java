package com.daniel.algorithms.impl.hash.different.solution;

import java.util.Arrays;
import java.util.List;

public class HashAlgorithm2 {

    private static final List<String> servers =
            Arrays.asList(
                    "192.168.1.1",
                    "192.168.1.2",
                    "192.168.1.3",
                    "192.168.1.4");

    public static String getServer(String key) {
        int hash = key.hashCode();
        int index =  hash % servers.size();
        return servers.get(index);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String server = getServer(String.valueOf(i));
            System.out.println("select server: "+server);
        }
    }

}
