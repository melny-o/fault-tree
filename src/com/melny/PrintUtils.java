package com.melny;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import static com.melny.MinimalCutSet.roundDouble;

public class PrintUtils {

    public static void printMinimalCutSetsToFile(Node topEvent, List<MinimalCutSet> minimalCutSets) {
        try {
            Files.deleteIfExists(Paths.get("MinimalCutSetsOfFaultTree.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("MinimalCutSetsOfFaultTree.txt"), "utf-8"));
            writer.write("Top Event " + topEvent.index + " probability: " +
                    roundDouble(topEvent.probability, "#.###") + "\n");
            writer.write("The amount of minimal cut sets: " + minimalCutSets.size() + "\n");
            writer.write(String.format("%-30.30s %-30.30s %-30.30s%n", "Minimal Cut Set", "Minimal Cut Set Probability",
                    "Minimal Cut Set Importance"));
            for (MinimalCutSet minCutSet : minimalCutSets) {
                writer.write(String.format("%-30.30s %-30.30s %-30.30s%n",
                        listOfEventsIndexesInString(minCutSet), minCutSet.probability, minCutSet.importance));
            }
        } catch (IOException ex) {
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {/*ignore*/}
        }
    }

    public static void printEventProbabilityAndOccurencesInCutSetsToFile(List<Node> events, List<MinimalCutSet> minimalCutSets) {
        try {
            Files.deleteIfExists(Paths.get("ProbabilityOfFaultTreeEvents.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("ProbabilityOfFaultTreeEvents.txt"), "utf-8"));
            writer.write(String.format("%-30.30s %-30.30s  %-30.30s%n", "Event", "Event Probability",
                    "Occurrences in minimal cut sets"));
            for (Node event : events) {
                AtomicInteger occurencesOfEvent = new AtomicInteger();
                for (MinimalCutSet cutSet : minimalCutSets) {
                    cutSet.eventsInMinimalCutSet.stream().forEach(e -> {
                        if (e.index == event.index) occurencesOfEvent.getAndIncrement();
                    });
                }
                writer.write(String.format("%-30.30s %-30.30s  %-30.30s%n", event.index,
                        roundDouble(event.probability, "#.######"), occurencesOfEvent));
            }
        }catch (IOException ex) {
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {/*ignore*/}
        }
    }

    public static void printMinimalCutsSets(Set<List<Node>> minimalCutsSets) {
        System.out.println("Minimal Cut Sets for the Fault Tree:");
        System.out.print("[");
        for (List<Node> list : minimalCutsSets) {
            printListOfEventsIndexes(list);
        }
        System.out.print("]");
    }

    public static void printListOfEventsIndexes(List<Node> listOfEvents) {
        System.out.println("[");
        for (int i = 0; i < listOfEvents.size(); i++) {
            if (i == 0) System.out.print("" + listOfEvents.get(i).index);
            else {
                System.out.print(", " + listOfEvents.get(i).index);
            }
        }
        System.out.print("] ");
    }

    public static String listOfEventsIndexesInString(MinimalCutSet minimalCutSet) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < minimalCutSet.eventsInMinimalCutSet.size(); i++) {
            if (i == 0) sb.append("" + minimalCutSet.eventsInMinimalCutSet.get(i).index);
            else {
                sb.append(", " + minimalCutSet.eventsInMinimalCutSet.get(i).index);
            }
        }
        sb.append("] ");
        return sb.toString();
    }
}
