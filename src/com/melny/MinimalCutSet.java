package com.melny;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MinimalCutSet {
    List<Node> eventsInMinimalCutSet = new LinkedList<>();
    double probability;
    double importance;

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


    public static List<List<Node>> findAllUniqueMinimalCutSets(List<List<Node>> allMinimalCutSets){
        HashSet<List<Node>> set = new HashSet<>(allMinimalCutSets);
        return new LinkedList<>(set);
    }

    public static List<MinimalCutSet> listOfNodesToMinimalCutSetList(List<List<Node>> listOfNodes){
        List<MinimalCutSet> minimalCutSets = new ArrayList<>();
        for (List<Node> listOfNode: listOfNodes){
            MinimalCutSet ms = new MinimalCutSet();
            ms.eventsInMinimalCutSet=listOfNode;
            minimalCutSets.add(ms);
        }
        return minimalCutSets;
    }

    public static void setProbabilityAndImportanceOfMinimalCutSets(List<MinimalCutSet> minimalCutSets, Node topEvent){
        MinimalCutSet minimalCutSet = new MinimalCutSet();
        for(MinimalCutSet minSet : minimalCutSets) {
            double probabilityOfMinCutSet = 1;
            for(Node event: minSet.eventsInMinimalCutSet){
                probabilityOfMinCutSet *=event.probability;
                minSet.probability = roundDouble(probabilityOfMinCutSet, "#.##########");
                minSet.importance = roundDouble(probabilityOfMinCutSet/ topEvent.probability,
                        "#.##########");
            }
        }
    }
    static double roundDouble(double value, String patternForRounding) {
        DecimalFormat roundToThreePlaces = new DecimalFormat(patternForRounding);
        String format = roundToThreePlaces.format(value);
        try {
            return Double.parseDouble(String.valueOf(roundToThreePlaces.parse(format)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static List<MinimalCutSet> sortListByImportance(List<MinimalCutSet> minimalCutSets){
        minimalCutSets.sort((a, b) -> {
            if (a.importance == b.importance) return 0;
            else if (a.importance > b.importance) return 1;
            else return -1;
        });
        Collections.reverse(minimalCutSets);
        return minimalCutSets;
    }

    static HashMap<Node, Integer> eventOccurrences(List<MinimalCutSet> minimalCutSet, List<Node> faultTree){
        HashMap<Node, Integer> ocInSet = new HashMap<>();
        for(Node event : faultTree){
            AtomicInteger occurencesOfEvent = new AtomicInteger();
            for (MinimalCutSet cutSet : minimalCutSet){
                cutSet.eventsInMinimalCutSet.forEach(e-> {
                    if(e.index==event.index) occurencesOfEvent.getAndIncrement();
                });
                ocInSet.put(event, occurencesOfEvent.intValue());
            }
        }
        return ocInSet;
    }
}
