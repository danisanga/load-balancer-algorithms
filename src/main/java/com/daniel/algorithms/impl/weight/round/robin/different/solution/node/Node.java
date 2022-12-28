package com.daniel.algorithms.impl.weight.round.robin.different.solution.node;

public class Node {
    private String ip;

    private Integer weight;

    private Integer currentWeight;

    public Node(String ip, Integer weight) {
        this.ip = ip;
        this.weight = weight;
        this.currentWeight = weight;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Integer currentWeight) {
        this.currentWeight = currentWeight;
    }

}
