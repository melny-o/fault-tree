package com.melny;

import java.util.*;

import static com.melny.FaultTreeInitializer.node61;
import static com.melny.MinimalCutSet.*;
import static com.melny.PrintUtils.*;

public class Main {

    public static void main(String[] args) {
        FaultTreeInitializer faultTreeInitializer = new FaultTreeInitializer();
        Calculation calculation = new Calculation();
        calculation.setParentProbability(faultTreeInitializer.faultTree);
        List<List<Node>> minimalCutSets = findAllMinimalCutSets(defineTopEventForMinimalCutSetFirstInput(node61));
        List<MinimalCutSet> listOfMinimalCutSets = listOfNodesToMinimalCutSetList(findAllUniqueMinimalCutSets(minimalCutSets));
        setProbabilityAndImportanceOfMinimalCutSets(listOfMinimalCutSets, node61);
        printMinimalCutSetsToFile(node61, sortListByImportance(listOfMinimalCutSets));
        printEventProbabilityAndOccurencesInCutSetsToFile(faultTreeInitializer.faultTree, listOfMinimalCutSets);
    }

    public static List<List<Node>> defineTopEventForMinimalCutSetFirstInput(Node node){
        List<List<Node>> minimalCutSetsFirstInput = new LinkedList<>();
        List<Node> topEvent = new ArrayList<>();
        topEvent.add(node);
        minimalCutSetsFirstInput.add(topEvent);
    return minimalCutSetsFirstInput;
    }

}