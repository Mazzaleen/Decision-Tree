package sol;

import src.IAttributeDatum;
import src.INode;

import java.util.LinkedList;

/**
 * Dataclass that represents the nodes in the decision tree
 * Implements the INode interface
 */
public class Node implements INode {

    private String nodeVal; // Node string
    private LinkedList<Edge> edges; //  All possible edges given an attribute
    private  Object defaultValue; // Default value

    /**
     * constructor for the Node dataclass
     * @param n -- String of the node correspond to columns for DataTable
     *         (excluding names)
     * @param d -- Default value for node
     */
    public Node (String n, Object d) {
        this.nodeVal = n;
        this.edges = new LinkedList<Edge>();
        this.defaultValue = d;
    }

    /**
     * Helper method that gets the node value of a Node
     * @return -- nodeVal field of type String
     */
    public String  getNodeVal(){ return this.nodeVal; }

    /**
     * Helper method that gets the edges linked list of a Node
     * @return -- edges field of type LinkedList<Edge>
     */
    public LinkedList<Edge>  getEdgesVal(){ return this.edges; }

    /**
     * Helper method that gets the defaultValue Object of a Node
     * @return -- defaultValue field of type Object
     */
    public Object getDefaultVal(){ return this.defaultValue; }



    /**
     * Helper method that checks if an edge is already in a list of edges
     * @param edge -- the edge we are trying to check if it is present
     * @return a boolean representing if edge is already present in list
     */
    public boolean inList(Edge edge){

        for(Edge element : this.edges ) {
            if (edge.getEdgeVal().equals(
                    element.getEdgeVal())  &&
                    edge.getTargetNodeVal().equals(
                            element.getTargetNodeVal())) {
                return true;
            }

        }
        return false;

    }

    /**
     * Helper method that adds an edge of a specified value and targetNode
     * @param val - value of the edge we want to add
     * @param o - targetNode of the edge we want to add
     */
    public void addEdge(Object val, INode o) {

         Edge newEdge = new Edge(val, o);


         if (this.inList(newEdge)) {
             throw new RuntimeException("Edge already present");
         }

         edges.addFirst(newEdge); // adding to edge list
    }





    @Override
    public Object lookupDecision(IAttributeDatum attrVals) {

        // gets value of current node
        Object newAttr = attrVals.getValueOf(nodeVal);
        for (Edge e : this.edges) {
            // equate to edge value
            if (newAttr.equals(e.getEdgeVal())) {
                // change the pointer
                return e.getTargetNodeVal().lookupDecision(attrVals);
            }
        }
        return this.defaultValue; // when we get something unexpected
    }


    @Override
    public void printNode(String leadspace) {
        System.out.println(leadspace + this.nodeVal);
        for (Edge e : this.edges) {
            e.printEdge(leadspace + " " );
        }
    }


}
