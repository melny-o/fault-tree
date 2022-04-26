package com.melny;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Node node1 = new Node(Position.NON_TERMINAL, 0.01);
        Node node2 = new Node(Position.NON_TERMINAL,0.0015);
        Node node3 = new Node(Position.NON_TERMINAL, 0.03);
        Node node4 = new Node(Position.NON_TERMINAL, 0.025);
        Node node5 = new Node(Position.NON_TERMINAL, 0.001);
        Node node6 = new Node(Position.NON_TERMINAL, 0.0011);
        Node node7 = new Node(Position.NON_TERMINAL, 0.0103);
        Node node8 = new Node(Position.NON_TERMINAL, 0.31);
        Node node9 = new Node(Position.NON_TERMINAL, 0.16);
        Node node10 = new Node(Position.NON_TERMINAL, 0.039);
        Node node11 = new Node(Position.NON_TERMINAL, 0.021);
        Node node12 = new Node(Position.NON_TERMINAL, 0.017);
        Node node13 = new Node(Position.NON_TERMINAL, 0.011);
        Node node14 = new Node(Position.NON_TERMINAL, 0.009);
        Node node15 = new Node(Position.NON_TERMINAL, 0.014);
        Node node16 = new Node(Position.NON_TERMINAL, 0.018);
        Node node17 = new Node(Position.NON_TERMINAL, 0.019);
        Node node18 = new Node(Position.NON_TERMINAL, 0.0096);
        Node node19 = new Node(Position.NON_TERMINAL, 0.0136);
        Node node20 = new Node(Position.NON_TERMINAL, 0.0075);
        Node node21 = new Node(Position.NON_TERMINAL, 0.031);
        Node node22 = new Node(Position.NON_TERMINAL, 0.014);
        Node node23 = new Node(Position.NON_TERMINAL, 0.008);
        Node node24 = new Node(Position.NON_TERMINAL, 0.07);
        Node node25 = new Node(Position.NON_TERMINAL, 0.017);
        Node node26 = new Node(Position.NON_TERMINAL, 0.034);
        Node node27 = new Node(Position.NON_TERMINAL, 0.064);
        Node node28 = new Node(Position.NON_TERMINAL, 0.053);
        Node node29 = new Node(Position.NON_TERMINAL, 0.016);
        Node node30 = new Node(Position.NON_TERMINAL, 0.0083);
        Node node31 = new Node(Position.NON_TERMINAL, 0.02);
        Node node32 = new Node(Position.NON_TERMINAL, 0.0031);
        Node node33 = new Node(Position.NON_TERMINAL, 0.012);
        Node node34 = new Node(Position.NON_TERMINAL, 0.011);
        Node node35 = new Node(Position.NON_TERMINAL, 0.0098);
        Node node36 = new Node(Position.NON_TERMINAL, 0.0105);
        Node node37 = new Node(Position.NON_TERMINAL, 0.057);
        Node node38 = new Node(Position.NON_TERMINAL, 0.048);
        Node node39 = new Node(Position.NON_TERMINAL, 0.01);
        Node node40 = new Node(Position.NON_TERMINAL, 0.0095);
        Node node41 = new Node(Position.NON_TERMINAL, 0.07);
        Node node42 = new Node(Position.NON_TERMINAL, 0.105);
        Node node43 = new Node(Position.TERMINAL, Operator.OR, List.of(node1, node2));
        Node node44 = new Node(Position.TERMINAL, Operator.OR, List.of(node3, node4));
        Node node45 = new Node(Position.TERMINAL, Operator.OR, List.of(node5, node6, node7));
        Node node46 = new Node(Position.TERMINAL, Operator.OR, List.of(node43, node44, node41, node45));
        Node node47 = new Node(Position.TERMINAL, Operator.OR, List.of(node8, node9));
        Node node48 = new Node(Position.TERMINAL, Operator.OR, List.of(node11, node10));
        Node node49 = new Node(Position.TERMINAL, Operator.OR, List.of(node12, node13, node14));
        Node node50 = new Node(Position.TERMINAL, Operator.OR, List.of(node15, node16));
        Node node51 = new Node(Position.TERMINAL, Operator.OR, List.of(node18, node19, node20));
        Node node52 = new Node(Position.TERMINAL, Operator.OR, List.of(node17, node51));
        Node node53 = new Node(Position.TERMINAL, Operator.OR, List.of(node23, node24, node25));
        Node node54 = new Node(Position.TERMINAL, Operator.OR, List.of(node26, node27));
        Node node55 = new Node(Position.TERMINAL, Operator.OR, List.of(node29, node30, node31));
        Node node56 = new Node(Position.TERMINAL, Operator.OR, List.of(node34, node35, node36));
        Node node57 = new Node(Position.TERMINAL, Operator.AND, List.of(node46, node42, node47));
        Node node58 = new Node(Position.TERMINAL, Operator.OR, List.of(node38, node39, node40));
        Node node59 = new Node(Position.TERMINAL, Operator.OR, List.of(node48, node49));
        Node node60 = new Node(Position.TERMINAL, Operator.OR, List.of(node50, node52));
        Node node61 = new Node(Position.TERMINAL, Operator.OR, List.of(node21, node22, node53));
        Node node62 = new Node(Position.TERMINAL, Operator.OR, List.of(node28, node54));
        Node node63 = new Node(Position.TERMINAL, Operator.OR, List.of(node32, node33, node55));
        Node node64 = new Node(Position.TERMINAL, Operator.OR, List.of(node37, node56));
        Node noname = new Node(Position.TERMINAL, Operator.OR, List.of(node59, node60, node61, node62, node63, node64));
        noname.index=0;
        Node.indexCounter-=1;
        Node node65 = new Node(Position.MAIN, Operator.AND, List.of(node57, node58, noname));

        LinkedList<Node> faultTree = initializeFaultTree(node1, node2, node3, node4, node5, node6, node7, node8, node9, node10, node11, node12, node13,
                node14, node15,node16,node17,node18,node19,node20,node21,node22,node23,node24,node25, node26,node27,node28,
                node29,node30,node31,node32,node33,node34,node35,node36,node37,node38,node39,node40,node41,node42,node43,node44,node45,
                node46,node47,node48,node49,node50,node51,node52,node53,node54,node55,node56,node57,node58,node59,node60,node61,node62,node63,node64,noname,node65);
        Calculation calculation = new Calculation();
        calculation.setParentProbability(faultTree);
        System.out.println(node65.probability);
    }

    static LinkedList<Node> initializeFaultTree(Node...nodes){
        LinkedList<Node> faultTreeLinkedList = new LinkedList<>();
        for(int i = 0; i < nodes.length; i++) {
            faultTreeLinkedList.add(nodes[i]);
        }
        return faultTreeLinkedList;
    }
}
