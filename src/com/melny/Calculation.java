package com.melny;

import java.util.List;

public class Calculation {
    double probabilityOfChildren;
    String generalMessage = "Event P%s probability %s";
    String messageForChild;

    public void setParentProbability(List<Node> faultTree) {
        for (int i = 0; i < faultTree.size(); i++) {
            probabilityOfChildren = 0;
            double temp = 1;
            if (faultTree.get(i).children != null) {
                //System.out.println("\nCalculating parent event P" + faultTree.get(i).index + " by its children events... ");
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < faultTree.get(i).children.size(); j++) {
                    if (faultTree.get(i).children.get(j).probability != 0) {
                        if (faultTree.get(i).operator.equals(Operator.OR)) {
                            for (int k = 0; k < faultTree.get(i).children.size(); k++) {
                                temp *= (1 - faultTree.get(i).children.get(j).probability);
                            }
                            probabilityOfChildren = 1 - temp;

                            boolean hasAnotherChild = j < faultTree.get(i).children.size() - 1;
                            buildConsoleOutput(faultTree.get(i).children.get(j).index, faultTree.get(i).children.get(j).probability, sb, hasAnotherChild, Operator.OR);
                        } else {
                            if (probabilityOfChildren == 0) probabilityOfChildren = 1;
                            probabilityOfChildren *= faultTree.get(i).children.get(j).probability;

                            boolean hasAnotherChild = j < faultTree.get(i).children.size() - 1;
                            buildConsoleOutput(faultTree.get(i).children.get(j).index, faultTree.get(i).children.get(j).probability, sb, hasAnotherChild, Operator.AND);
                        }
                    }
                }
                faultTree.get(i).probability = probabilityOfChildren;
                //System.out.println(sb);
                //System.out.println("Calculated event P" + faultTree.get(i).index + " probability is " + faultTree.get(i).probability);
            }
        }
    }

    void buildConsoleOutput(int childIndex, double childProbability, StringBuilder sb, boolean hasAnotherChild, Operator operator) {
        messageForChild = String.format(generalMessage, childIndex,
                childProbability);
        sb.append(messageForChild);
        if (hasAnotherChild) {
            if (operator.equals(Operator.OR)) sb.append(" + ");
            else sb.append(" * ");
            generalMessage = generalMessage.substring(0, 1).toLowerCase() + generalMessage.substring(1);
        }
    }
}


