package com.melny;

import java.util.LinkedList;
import java.util.List;

public class FaultTreeInitializer {
    LinkedList<Node> faultTree = new LinkedList<Node>();
    static Node node1 = new Node(Position.NON_TERMINAL, 0.01, 1);
    static Node node2 = new Node(Position.NON_TERMINAL,0.0015, 2);
    static Node node3 = new Node(Position.NON_TERMINAL, 0.03, 3);
    static Node node4 = new Node(Position.NON_TERMINAL, 0.025, 4);
    static Node node5 = new Node(Position.NON_TERMINAL, 0.001, 5);
    static Node node6 = new Node(Position.NON_TERMINAL, 0.0011, 6);
    static Node node7 = new Node(Position.NON_TERMINAL, 0.0103, 7);
    static Node node8 = new Node(Position.NON_TERMINAL, 0.31, 8);
    static Node node9 = new Node(Position.NON_TERMINAL, 0.16, 9);
    static Node node10 = new Node(Position.NON_TERMINAL, 0.039, 10);
    static Node node11 = new Node(Position.NON_TERMINAL, 0.021, 11);
    static Node node12 = new Node(Position.NON_TERMINAL, 0.017, 12);
    static Node node13 = new Node(Position.NON_TERMINAL, 0.011, 13);
    static Node node14 = new Node(Position.NON_TERMINAL, 0.009, 14);
    static Node node15 = new Node(Position.NON_TERMINAL, 0.014, 15);
    static Node node16 = new Node(Position.NON_TERMINAL, 0.018, 16);
    static Node node17 = new Node(Position.NON_TERMINAL, 0.019, 17);
    static Node node18 = new Node(Position.NON_TERMINAL, 0.0096, 18);
    static Node node19 = new Node(Position.NON_TERMINAL, 0.0136, 19);
    static Node node20 = new Node(Position.NON_TERMINAL, 0.0075, 20);
    static Node node21 = new Node(Position.NON_TERMINAL, 0.031, 21);
    static Node node22 = new Node(Position.NON_TERMINAL, 0.014, 22);
    static Node node23 = new Node(Position.NON_TERMINAL, 0.008,23);
    static Node node24 = new Node(Position.NON_TERMINAL, 0.07,24);
    static Node node25 = new Node(Position.NON_TERMINAL, 0.017, 25);
    static Node node26 = new Node(Position.NON_TERMINAL, 0.053,26);
    static Node node27 = new Node(Position.NON_TERMINAL, 0.034,27);
    static Node node28 = new Node(Position.NON_TERMINAL, 0.064,28);
    static Node node29 = new Node(Position.NON_TERMINAL, 0.016,29);
    static Node node30 = new Node(Position.NON_TERMINAL, 0.0083, 30);
    static Node node31 = new Node(Position.NON_TERMINAL, 0.02, 31);
    static Node node33 = new Node(Position.NON_TERMINAL, 0.011, 33);
    static Node node34 = new Node(Position.NON_TERMINAL, 0.0105, 34);
    static Node node35 = new Node(Position.NON_TERMINAL, 0.0057, 35);
    static Node node36 = new Node(Position.NON_TERMINAL, 0.01, 36);
    static Node node37 = new Node(Position.NON_TERMINAL, 0.048, 37);
    static Node node38 = new Node(Position.NON_TERMINAL, 0.0095, 38);
    static Node node39 = new Node(Position.NON_TERMINAL, 0.07, 39);
    static Node node32 = new Node(Position.TERMINAL, Operator.OR, List.of(node29, node30, node31), 32);
    static Node node40 = new Node(Position.TERMINAL, Operator.OR, List.of(node1, node2),40);
    static Node node41 = new Node(Position.TERMINAL, Operator.OR, List.of(node3, node4), 41);
    static Node node42 = new Node(Position.TERMINAL, Operator.OR, List.of(node5, node6, node7), 42);
    static Node node43 = new Node(Position.TERMINAL, Operator.OR, List.of(node40, node41, node42, node39), 43);
    static Node node44 = new Node(Position.TERMINAL, Operator.OR, List.of(node8, node9), 44);
    static Node node45 = new Node(Position.TERMINAL, Operator.OR, List.of(node10, node11), 45);
    static Node node46 = new Node(Position.TERMINAL, Operator.OR, List.of(node12, node13, node14), 46);
    static Node node47 = new Node(Position.TERMINAL, Operator.OR, List.of(node15, node16), 47);
    static Node node48 = new Node(Position.TERMINAL, Operator.OR, List.of(node17, node18, node19, node20), 48);
    static Node node49 = new Node(Position.TERMINAL, Operator.OR, List.of(node18, node33, node34), 49);
    static Node node50 = new Node(Position.TERMINAL, Operator.OR, List.of(node36, node37), 50);
    static Node node51 = new Node(Position.TERMINAL, Operator.AND, List.of(node43, node44), 51);
    static Node node52 = new Node(Position.TERMINAL, Operator.OR, List.of(node50, node38), 52);
    static Node node53 = new Node(Position.TERMINAL, Operator.OR, List.of(node45, node46), 53);
    static Node node54 = new Node(Position.TERMINAL, Operator.OR, List.of(node47, node48), 54);
    static Node node55 = new Node(Position.TERMINAL, Operator.OR, List.of(node21, node22, node23, node24, node25), 55);
    static Node node56 = new Node(Position.TERMINAL, Operator.OR, List.of(node26, node27, node28), 56);
    static Node node57 = new Node(Position.TERMINAL, Operator.AND, List.of(node32, node18), 57);
    static Node node58 = new Node(Position.TERMINAL, Operator.OR, List.of(node49, node35), 58);
    static Node node59 = new Node(Position.TERMINAL, Operator.AND, List.of(node51, node52), 59);
    static Node node60 = new Node(Position.TERMINAL, Operator.OR, List.of(node53, node54, node55, node56, node57, node58), 60);
    static Node node61 = new Node(Position.TERMINAL, Operator.AND, List.of(node59, node60), 61);

    FaultTreeInitializer() {
        faultTree = initializeFaultTree(node1, node2, node3, node4, node5, node6, node7, node8, node9, node10, node11, node12, node13,
                node14, node15, node16, node17, node18, node19, node20, node21, node22, node23, node24, node25, node26, node27, node28,
                node29, node30, node31, node32, node33, node34, node35, node36, node37, node38, node39, node40, node41, node43, node44, node45,
                node46, node47, node48, node49, node50, node51, node52, node53, node54, node55, node56, node57, node58, node59, node60, node61);
    }

    static LinkedList<Node> initializeFaultTree(Node...nodes){
        LinkedList<Node> faultTreeLinkedList = new LinkedList<>();
        for(int i = 0; i < nodes.length; i++) {
            faultTreeLinkedList.add(nodes[i]);
        }
        return faultTreeLinkedList;
    }
}
