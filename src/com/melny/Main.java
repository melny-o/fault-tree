package com.melny;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Node node1 = new Node(Position.NON_TERMINAL, 0.01, 1);
        Node node2 = new Node(Position.NON_TERMINAL,0.0015, 2);
        Node node3 = new Node(Position.NON_TERMINAL, 0.03, 3);
        Node node4 = new Node(Position.NON_TERMINAL, 0.025, 4);
        Node node5 = new Node(Position.NON_TERMINAL, 0.001, 5);
        Node node6 = new Node(Position.NON_TERMINAL, 0.0011, 6);
        Node node7 = new Node(Position.NON_TERMINAL, 0.0103, 7);
        Node node8 = new Node(Position.NON_TERMINAL, 0.31, 8);
        Node node9 = new Node(Position.NON_TERMINAL, 0.16, 9);
        Node node10 = new Node(Position.NON_TERMINAL, 0.039, 10);
        Node node11 = new Node(Position.NON_TERMINAL, 0.021, 11);
        Node node12 = new Node(Position.NON_TERMINAL, 0.017, 12);
        Node node13 = new Node(Position.NON_TERMINAL, 0.011, 13);
        Node node14 = new Node(Position.NON_TERMINAL, 0.009, 14);
        Node node15 = new Node(Position.NON_TERMINAL, 0.014, 15);
        Node node16 = new Node(Position.NON_TERMINAL, 0.018, 16);
        Node node17 = new Node(Position.NON_TERMINAL, 0.019, 17);
        Node node18 = new Node(Position.NON_TERMINAL, 0.0096, 18);
        Node node19 = new Node(Position.NON_TERMINAL, 0.0136, 19);
        Node node20 = new Node(Position.NON_TERMINAL, 0.0075, 20);
        Node node21 = new Node(Position.NON_TERMINAL, 0.031, 21);
        Node node22 = new Node(Position.NON_TERMINAL, 0.014, 22);
        Node node23 = new Node(Position.NON_TERMINAL, 0.008,23);
        Node node24 = new Node(Position.NON_TERMINAL, 0.07,24);
        Node node25 = new Node(Position.NON_TERMINAL, 0.017, 25);
        Node node26 = new Node(Position.NON_TERMINAL, 0.034,26);
        Node node27 = new Node(Position.NON_TERMINAL, 0.064,27);
        Node node28 = new Node(Position.NON_TERMINAL, 0.053,28);
        Node node29 = new Node(Position.NON_TERMINAL, 0.016,29);
        Node node30 = new Node(Position.NON_TERMINAL, 0.0083, 30);
        Node node31 = new Node(Position.NON_TERMINAL, 0.02, 31);
        Node node32 = new Node(Position.NON_TERMINAL, 0.0031, 32);
        Node node33 = new Node(Position.NON_TERMINAL, 0.012, 33);
        Node node34 = new Node(Position.NON_TERMINAL, 0.011, 34);
        Node node35 = new Node(Position.NON_TERMINAL, 0.0098, 35);
        Node node36 = new Node(Position.NON_TERMINAL, 0.0105, 36);
        Node node37 = new Node(Position.NON_TERMINAL, 0.057, 37);
        Node node38 = new Node(Position.NON_TERMINAL, 0.048, 38);
        Node node39 = new Node(Position.NON_TERMINAL, 0.01, 39);
        Node node40 = new Node(Position.NON_TERMINAL, 0.0095, 40);
        Node node41 = new Node(Position.NON_TERMINAL, 0.07, 41);
        Node node42 = new Node(Position.NON_TERMINAL, 0.105, 42);
        Node node43 = new Node(Position.TERMINAL, Operator.OR, List.of(node1, node2), 43);
        Node node44 = new Node(Position.TERMINAL, Operator.OR, List.of(node3, node4), 44);
        Node node45 = new Node(Position.TERMINAL, Operator.OR, List.of(node5, node6, node7), 45);
        Node node46 = new Node(Position.TERMINAL, Operator.OR, List.of(node43, node44, node41, node45), 46);
        Node node47 = new Node(Position.TERMINAL, Operator.OR, List.of(node8, node9), 47);
        Node node48 = new Node(Position.TERMINAL, Operator.OR, List.of(node11, node10), 48);
        Node node49 = new Node(Position.TERMINAL, Operator.OR, List.of(node12, node13, node14), 49);
        Node node50 = new Node(Position.TERMINAL, Operator.OR, List.of(node15, node16), 50);
        Node node51 = new Node(Position.TERMINAL, Operator.OR, List.of(node18, node19, node20), 51);
        Node node52 = new Node(Position.TERMINAL, Operator.OR, List.of(node17, node51), 52);
        Node node53 = new Node(Position.TERMINAL, Operator.OR, List.of(node23, node24, node25), 53);
        Node node54 = new Node(Position.TERMINAL, Operator.OR, List.of(node26, node27), 54);
        Node node55 = new Node(Position.TERMINAL, Operator.OR, List.of(node29, node30, node31), 55);
        Node node56 = new Node(Position.TERMINAL, Operator.OR, List.of(node34, node35, node36), 56);
        Node node57 = new Node(Position.TERMINAL, Operator.AND, List.of(node46, node42, node47), 57);
        Node node58 = new Node(Position.TERMINAL, Operator.OR, List.of(node38, node39, node40), 58);
        Node node59 = new Node(Position.TERMINAL, Operator.OR, List.of(node48, node49), 59);
        Node node60 = new Node(Position.TERMINAL, Operator.OR, List.of(node50, node52), 60);
        Node node61 = new Node(Position.TERMINAL, Operator.OR, List.of(node21, node22, node53), 61);
        Node node62 = new Node(Position.TERMINAL, Operator.OR, List.of(node28, node54), 62);
        Node node63 = new Node(Position.TERMINAL, Operator.OR, List.of(node32, node33, node55), 63);
        Node node64 = new Node(Position.TERMINAL, Operator.OR, List.of(node37, node56), 64);
        Node noname = new Node(Position.TERMINAL, Operator.OR, List.of(node59, node60, node61, node62, node63, node64), 0);
        Node node65 = new Node(Position.MAIN, Operator.AND, List.of(node57, node58, noname), 65);

        LinkedList<Node> faultTree = initializeFaultTree(node1, node2, node3, node4, node5, node6, node7, node8, node9, node10, node11, node12, node13,
                node14, node15,node16,node17,node18,node19,node20,node21,node22,node23,node24,node25, node26,node27,node28,
                node29,node30,node31,node32,node33,node34,node35,node36,node37,node38,node39,node40,node41,node42,node43,node44,node45,
                node46,node47,node48,node49,node50,node51,node52,node53,node54,node55,node56,node57,node58,node59,node60,node61,node62,node63,node64,noname,node65);
//        Calculation calculation = new Calculation();
//        calculation.setParentProbability(faultTree);
        System.out.println(node65.probability);
        /////nodes for test
        Node node_4 = new Node(Position.NON_TERMINAL, 4, 4);
        Node node_5 = new Node(Position.NON_TERMINAL, 5, 5);
        Node node_6 = new Node(Position.NON_TERMINAL, 6, 6);
        Node node_7 = new Node(Position.NON_TERMINAL, 7, 7);
        Node node_2 = new Node(Position.TERMINAL, Operator.AND, List.of(node_4, node_5), 2);
        Node node_3 = new Node(Position.TERMINAL, Operator.OR, List.of(node_6, node_7), 3);
        Node node_1 = new Node(Position.MAIN, Operator.AND, List.of(node_2, node_3), 1);

        MinimalCutSets test = new MinimalCutSets();
        List<List<Node>> minimalCutSets = new LinkedList<>();
        List<Node> topEvent = new ArrayList<Node>();
        topEvent.add(node_1);
        minimalCutSets.add(topEvent);

        System.out.print("[");
        for(List<Node> list: test.findAllMinimalCutSets(minimalCutSets)){
            System.out.print("[");

            for(int i=0;i<list.size();i++){
                if(i==0) System.out.print(""+list.get(i).index);
                else {
                    System.out.print(", "+list.get(i).index);
                }
            }
            System.out.print("] ");
        }
        System.out.print("]");
    }

    static LinkedList<Node> initializeFaultTree(Node...nodes){
        LinkedList<Node> faultTreeLinkedList = new LinkedList<>();
        for(int i = 0; i < nodes.length; i++) {
            faultTreeLinkedList.add(nodes[i]);
        }
        return faultTreeLinkedList;
    }

}
