package com.melny;

import java.util.List;

public class Node {

Position position;
Operator operator;
List<Node> child;
Node parent;
double probability;
static int indexCounter=1;
int index;
String description;

public Node(Position position, double probability) {
    this.position = position;
    this.probability = probability;

    this.index=indexCounter;
    indexCounter++;
}
public Node(Position position, double probability, String description) {
    this.position = position;
    this.probability = probability;
    this.description = description;
}
public Node(Position position, Operator operator, List<Node> child){
    this.position = position;
    this.operator = operator;
    this.child = child;

    this.index=indexCounter;
    indexCounter++;
}

}
