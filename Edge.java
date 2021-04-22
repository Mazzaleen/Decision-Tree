package sol;

import src.INode;

import java.util.LinkedList;

/**
 * Dataclass that represents an edge in the decision tree
 */
public class Edge  {
    private Object edgeVal;
    private INode targetNode;

    /**
     * Constructor for the Edge dataclass
     * @param val -- Value of actual edge
     * @param o -- node that the edge is pointing to (Target node)
     */
    public Edge(Object val, INode o) {
        this.edgeVal = val;
        this.targetNode = o;
    }

    /**
     * Helper method that gets the object value of an Edge
     * @return -- edgeVal field of type Object
     */
    public Object  getEdgeVal(){ return this.edgeVal; }

    /**
     * Helper method that gets the INode value of an Edge
     * @return -- targetNode field of type INode
     */
    public INode  getTargetNodeVal(){ return this.targetNode; }



    /**
     * method that prints the edges
     * @param leadspace -- string of indentations to use
     */
    public void printEdge(String leadspace) {
        System.out.println(leadspace + this.edgeVal);
        this.targetNode.printNode(leadspace + " ");
    }




}
