package com.melny;

import java.util.ArrayList;
import java.util.List;

public class MinimalCutSets {

    public List<List<Node>> findAllMinimalCutSets(List<List<Node>> minimalCutSets) {
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
                        //minimalCutSets.remove(cutSet);
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
    
    public void ar(){
        int[] source = {1, 2, 3};
        int[] destination = new int[3];
        for(int i=0; i<destination.length; i++){
            destination[i]=source[destination.length - i-1];
        }
        for(int i=0; i<destination.length; i++){
            System.out.println(destination[i]);
        }
    }
}
