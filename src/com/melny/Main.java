package com.melny;

import java.util.*;

import static com.melny.FaultTreeInitializer.node61;
import static com.melny.MinimalCutSets.*;
import static com.melny.PrintUtils.printToFile;

public class Main {

    public static void main(String[] args) {
        FaultTreeInitializer faultTreeInitializer = new FaultTreeInitializer();
        Calculation calculation = new Calculation();
        calculation.setParentProbability(faultTreeInitializer.faultTree);
        List<List<Node>> minimalCutSetsFirstInput = defineTopEventForMinimalCutSetFirstInput(node61);
        List<List<Node>> minimalCutSets = findAllMinimalCutSets(minimalCutSetsFirstInput);
        Set<List<Node>> uniqueMinimalCutSets = findAllUniqueMinimalCutSets(minimalCutSets);
        printToFile(node61, minimalCutSets, uniqueMinimalCutSets, calculateImportanceOfMinCutSets(node61, uniqueMinimalCutSets));
    }

    public static List<List<Node>> defineTopEventForMinimalCutSetFirstInput(Node node){
        List<List<Node>> minimalCutSetsFirstInput = new LinkedList<>();
        List<Node> topEvent = new ArrayList<Node>();
        topEvent.add(node);
        minimalCutSetsFirstInput.add(topEvent);
    return minimalCutSetsFirstInput;
    }

}


/////nodes for test
//        Node node_4 = new Node(Position.NON_TERMINAL, 4, 4);
//        Node node_5 = new Node(Position.NON_TERMINAL, 5, 5);
//        Node node_6 = new Node(Position.NON_TERMINAL, 6, 6);
//        Node node_7 = new Node(Position.NON_TERMINAL, 7, 7);
//        Node node_2 = new Node(Position.TERMINAL, Operator.AND, List.of(node_4, node_5), 2);
//        Node node_3 = new Node(Position.TERMINAL, Operator.OR, List.of(node_6, node_7), 3);
//        Node node_1 = new Node(Position.MAIN, Operator.AND, List.of(node_2, node_3), 1);