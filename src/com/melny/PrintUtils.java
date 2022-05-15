package com.melny;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PrintUtils {
    public static void printMinimalCutsSets(Set<List<Node>> minimalCutsSets){
        System.out.println("Minimal Cut Sets for the Fault Tree:");
        System.out.print("[");
        for(List<Node> list: minimalCutsSets) {
            printListOfEventsIndexes(list);
        }
        System.out.print("]");
    }

    public static void printMinimalCutSetsAndImportance(HashMap<List<Node>, HashMap<Double,Double>> minCutsAndImportance){
        System.out.printf("%-10.10s %-60.60s %-50.50s%n", "Minimal Cut Set", "Minimal Cut Set Probability",
                "Minimal Cut Set Importance");
        for(HashMap.Entry<List<Node>, HashMap<Double,Double>> entry: minCutsAndImportance.entrySet()){
            listOfEventsIndexesInString(entry.getKey());
            HashMap<Double, Double> pr = entry.getValue();
            for (Map.Entry<Double, Double> prAndImp : pr.entrySet()){
                System.out.printf("%-10.10s %-60.60s %-50.50s%n",
                        listOfEventsIndexesInString(entry.getKey()), prAndImp.getKey(), prAndImp.getValue());
            }
        }
    }

    public static void printToFile(Node topEvent, List<List<Node>> minimalCutSets,
                                   Set<List<Node>> uniqueMinimalCutSets,
                                   HashMap<List<Node>, HashMap<Double,Double>> minCutsAndImportance){
        try {
            Files.deleteIfExists(Paths.get("OutputOfTheProgram.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("OutputOfTheProgram.txt"), "utf-8"));
            writer.write("Top Event "+ topEvent.index + " probability: " + topEvent.probability + "\n");
            writer.write("The amount of all minimal cut sets: " + minimalCutSets.size()+ "\n");
            writer.write("The amount of unique minimal cut sets: " + uniqueMinimalCutSets.size()+ "\n");
            writer.write(String.format("%-30.30s %-30.30s %-30.30s%n", "Minimal Cut Set", "Minimal Cut Set Probability",
                    "Minimal Cut Set Importance"));
            for(HashMap.Entry<List<Node>, HashMap<Double,Double>> entry: minCutsAndImportance.entrySet()){
                listOfEventsIndexesInString(entry.getKey());
                HashMap<Double, Double> pr = entry.getValue();
                for (Map.Entry<Double, Double> prAndImp : pr.entrySet()){
                    writer.write(String.format("%-30.30s %-30.30s %-30.30s%n",
                            listOfEventsIndexesInString(entry.getKey()), prAndImp.getKey(), prAndImp.getValue()));
                }
            }
        } catch (IOException ex) {
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
    }

    public static void printListOfEventsIndexes(List<Node> listOfEvents){
        System.out.println("[");
        for(int i = 0; i < listOfEvents.size(); i++) {
            if(i == 0) System.out.print("" + listOfEvents.get(i).index);
            else {
                System.out.print(", " + listOfEvents.get(i).index);
            }
        }
        System.out.print("] ");
    }

    public static String listOfEventsIndexesInString(List<Node> listOfEvents) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < listOfEvents.size(); i++) {
            if (i == 0) sb.append("" + listOfEvents.get(i).index);
            else {
                sb.append(", " + listOfEvents.get(i).index);
            }
        }
        sb.append("] ");
        return sb.toString();
    }

    public static void printEventEndexAndProbability(List<Node> events) {
        System.out.printf("%-30.30s  %-30.30s%n", "Event", "Event Probability");
        for (Node event : events) {
            System.out.printf("%-30.30s  %-30.30s%n", event.index, event.probability);
        }
    }
}
