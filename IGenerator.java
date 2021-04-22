/**
 * Interface that  supports building a decision tree for a dataset
 * and making predictions with the generated tree.
 */
public interface IGenerator {


    /**
     * Method that builds a decision tree to predict the named attribute
     * @param targetAttr -- Attribute we want to predict
     * @return Node representing the tree
     */
    public INode buildClassifier(String targetAttr);

    //

    /**
     * Method that produces the decision predicted for the given datum
     * @param forVals -- the datum we are entering (i.e vegetable)
     * @return the recommendation/predicted value
     */
    public Object lookupRecommendation(IAttributeDatum forVals);



    /**
     * Method that prints the decision tree
     */
    public void printTree();
}