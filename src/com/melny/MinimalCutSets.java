package com.melny;

import java.util.*;

public class MinimalCutSets {

    public static List<List<Node>> findAllMinimalCutSets(List<List<Node>> minimalCutSets) {
        List<Node> childrenOfCutSetEvent;
        List<Node> cutSet;
        Node event;
        for (int i = 0; i < minimalCutSets.size(); i++) {
            cutSet = minimalCutSets.get(i);
            for (int j = 0; j < cutSet.size(); j++) {
                event = cutSet.get(j);
                childrenOfCutSetEvent = event.children;
                if (childrenOfCutSetEvent != null) {
                    if (event.operator == Operator.OR) {
                        cutSet.remove(event);
                        for (Node child : childrenOfCutSetEvent) {
                            List<Node> newInput = new ArrayList<>();
                            //here we need to add other els from cut set
                            for(Node node: cutSet){
                                newInput.add(node);
                            }
                            newInput.add(child);
                            minimalCutSets.remove(cutSet);
                            minimalCutSets.add(newInput);
                        }

                    }
                    if (event.operator == Operator.AND) {
                        cutSet.remove(event);
                        cutSet.addAll(childrenOfCutSetEvent);
                    }
                    break;
                }
            }
        }

        for (int i = 0; i < minimalCutSets.size(); i++) {
            cutSet = minimalCutSets.get(i);
            for (int j = 0; j < cutSet.size(); j++) {
                event = cutSet.get(j);
                childrenOfCutSetEvent = event.children;
                while (childrenOfCutSetEvent != null) return findAllMinimalCutSets(minimalCutSets);
            }
        }
        return minimalCutSets;
    }

    public static Set<List<Node>> findAllUniqueMinimalCutSets(List<List<Node>> allMinimalCutSets){
        return new HashSet<List<Node>>(allMinimalCutSets);
    }

    public static HashMap<List<Node>, Double> calculateProbabilityOfMinimalCutSets(Set<List<Node>> minimalCutSets){
        HashMap<List<Node>, Double>  probability = new HashMap<>();
        for(List<Node> minSet : minimalCutSets) {
            double probabilityOfMinCutSet = 1;
            for(Node event: minSet){
                probabilityOfMinCutSet *=event.probability;
            }
            probability.put(minSet, probabilityOfMinCutSet);
        }
        return probability;
    }

    public static HashMap<List<Node>, Double> calculateImportanceOfMinCutSets(Node topEvent,
                                                                              Set<List<Node>> minimalCutSets) {
        HashMap<List<Node>, Double> minCutSetsAndProbability = calculateProbabilityOfMinimalCutSets(minimalCutSets);
        HashMap<List<Node>, Double> minCutSetsAndImportance = new HashMap<>();
        for(Map.Entry<List<Node>, Double> entry : minCutSetsAndProbability.entrySet()){
            double importance = entry.getValue()/topEvent.probability;
            minCutSetsAndImportance.put(entry.getKey(), importance);
        }
        return minCutSetsAndImportance;
    }

//    public static minimalCutSetImportance(Node topEvent, Set<List<Node>> minimalCutSets){
//
//    }
}
