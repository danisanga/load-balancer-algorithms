package com.daniel.algorithms.impl.weight.round.robin.different.solution;

import com.daniel.algorithms.impl.weight.round.robin.different.solution.node.Node;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class WeightRoundRobin2 {

    List<Node> servers = Arrays.asList(
            new Node("192.168.1.1", 1),
            new Node("192.168.1.2", 2),
            new Node("192.168.1.3", 3),
            new Node("192.168.1.4", 4));
    private Integer totalWeight;

    public WeightRoundRobin2() {
        this.totalWeight = servers.stream()
                .mapToInt(Node::getWeight)
                .reduce(Integer::sum).getAsInt();
    }

    public String getServer() {
        Node node = servers.stream().max(Comparator.comparingInt(Node::getCurrentWeight)).get();
        node.setCurrentWeight(node.getCurrentWeight() - totalWeight);
        servers.forEach(server -> server.setCurrentWeight(server.getCurrentWeight() + server.getWeight()));
        return node.getIp();
    }

    public static void main(String[] args) {
        WeightRoundRobin2 roundRobinTest = new WeightRoundRobin2();
        for (int i = 0; i < 10; i++) {
            String server = roundRobinTest.getServer();
            System.out.println("select server: " + server);
        }
    }

}
