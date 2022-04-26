package com.melny;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;

public class Calculation {
    double probabilityOfChildren;
    String generalMessage="Event P%s probability %s";
    String messageForChild;

    public void setParentProbability(List<Node> faultTree) {
        for (int i = 0; i < faultTree.size(); i++) {
            probabilityOfChildren = 0;
            if (faultTree.get(i).child != null) {
                System.out.println("\nCalculating parent event P"+ faultTree.get(i).index+ " by its children events... ");
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < faultTree.get(i).child.size(); j++) {
                    if (faultTree.get(i).child.get(j).probability != 0) {
                        if (faultTree.get(i).operator.equals(Operator.OR)) {
                            probabilityOfChildren += faultTree.get(i).child.get(j).probability;
                            boolean hasAnotherChild= j < faultTree.get(i).child.size() - 1;
                            buildConsoleOutput(faultTree.get(i).child.get(j).index, faultTree.get(i).child.get(j).probability, sb, hasAnotherChild, Operator.OR);
                        } else {
                            if (probabilityOfChildren == 0) probabilityOfChildren = 1;
                            probabilityOfChildren *= faultTree.get(i).child.get(j).probability;
                            boolean hasAnotherChild= j < faultTree.get(i).child.size() - 1;
                            buildConsoleOutput(faultTree.get(i).child.get(j).index, faultTree.get(i).child.get(j).probability, sb, hasAnotherChild, Operator.AND);
                        }
                    }
                }
                setCalculatedParentProbability(faultTree.get(i));
                System.out.println(sb);
                System.out.println("Calculated event P" + faultTree.get(i).index + " probability is " + faultTree.get(i).probability);
            }
        }
    }

    void buildConsoleOutput(int childIndex, double childProbability, StringBuilder sb, boolean hasAnotherChild, Operator operator){
        messageForChild=String.format(generalMessage, childIndex,
                childProbability);
        sb.append(messageForChild);
        if(hasAnotherChild) {
            if(operator.equals(Operator.OR)) sb.append(" + ");
            else sb.append(" * ");
            generalMessage = generalMessage.substring(0, 1).toLowerCase() + generalMessage.substring(1);
        }
    }

    void setCalculatedParentProbability(Node node){
        DecimalFormat roundToFivePlaces = new DecimalFormat("#.#####");
        String format = roundToFivePlaces.format(probabilityOfChildren);
        try {
            node.probability = (Double) roundToFivePlaces.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}


