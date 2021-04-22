/**
 * Interface that represents the node in a decision tree
 */
public interface INode {

    //

    /**
     * Method that traverses tree based on attribute values to retrieve decision
     * @param attrVals -- the attributes we are basing tree traversal on
     * @return value of the attribute
     */
    public Object lookupDecision(IAttributeDatum attrVals);



    /**
     * method that prints the tree
     * @param leadspace -- string of indentations to use
     */
    public void printNode(String leadspace);
}
