package com.melny;

import java.util.List;

public class Node {

Position position;
Operator operator;
List<Node> children;
double probability;
String description;
int index;

public Node(Position position, double probability, int index) {
    this.position = position;
    this.probability = probability;
    this.index = index;
}
public Node(Position position, double probability, String description) {
    this.position = position;
    this.probability = probability;
    this.description = description;
}
public Node(Position position, Operator operator, List<Node> child, int index){
    this.position = position;
    this.operator = operator;
    this.children = child;
    this.index = index;
}

}
