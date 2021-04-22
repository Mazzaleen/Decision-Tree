package sol;

import src.IAttributeDataset;
import src.IAttributeDatum;
import src.IGenerator;
import src.INode;


import java.util.LinkedList;
import java.util.Random;

/**
 * Dataclass for creating and interacting with a decision tree given a dataset.
 *
 * T is the type of object that we are trying to classify.
 * (like src.Vegetable)
 */
public class TreeGenerator<T extends IAttributeDatum> implements IGenerator {
    // fields:
     private INode firstNode;
     private IAttributeDataset<T> trainingData;

    /**
     * Constructor for thTreeGenerator<T> dataclass .
     * @param initTrainingData - IAttributeDataset of the data table
     */
    public TreeGenerator(IAttributeDataset<T> initTrainingData) {
        this.firstNode = new Node(null,null);
        this.trainingData = initTrainingData;
    }

    /**
     * Helper method that returns the firstnode field of a treeGenerator
     * @return returns the firstnode field of type INode
     */
    public INode getFirstNode(){
        return this.firstNode;
    }

    /**
     * Helper method that returns the trainingData field of a treeGenerator
     * @return returns the trainingData field of type IAttributeDataset<T>
     */
    public IAttributeDataset<T> getTrainingData(){
        return this.trainingData;
    }


    /**
     * Helper method that returns a random attribute our of a list
     * @param attribs -- list of attributes
     * @return a random attribute of type String
     */
    public String randomAttr(LinkedList<String> attribs) { // take in attributes
        Random rand = new Random();
        int randIndex = rand.nextInt(attribs.size());
        String attributeToSplit = attribs.get(randIndex);
        return attributeToSplit;
    }

    /**
     * Helper method that generates the tree
     * @param targetAttr - attribute you want to 'predict'
     * @return a node (representing a tree) based on dataset
     */
    public INode treeGen(String targetAttr,IAttributeDataset<T> dataset) {

        // get random 1st attribute
        LinkedList<String> allAttributes = dataset.getAttributes();



        // initialize a default value for node
        Object defaultVal = dataset.mostCommonValue(targetAttr);


        // check if tree is empty;
        if (dataset.size() == 0) {
            throw new RuntimeException("dataset is empty!");
        }
        /* check if only node is decision; should be all values
         */

        if (dataset.allSameValue(targetAttr)) {
            Node finalNode = new Node(targetAttr, defaultVal);
            return finalNode;
        }

        if (allAttributes.size() != 0) {
            // if neither of above cases, pick random attribute

            // removes target attribute
            allAttributes.remove(targetAttr);
            // pick random attribute
            String attributeSelected = randomAttr(allAttributes);


            // partition into subsets
            LinkedList<IAttributeDataset<T>> partition =
                    dataset.partition(attributeSelected);

            // create new node
            Node newNode = new Node(attributeSelected, defaultVal);

            // recursive call here:
            for (IAttributeDataset<T> list : partition) {
                newNode.addEdge(list.getSharedValue(attributeSelected),
                        treeGen(targetAttr, list));
            }
            return newNode;
        }
        // if we've removed all target attributes successfully
        else {
            // case where all attributes have been removed (return finalNode)
            Node finalNode = new Node(targetAttr, defaultVal);
            return finalNode;
        }
    }


    @Override
    public INode buildClassifier(String targetAttr) {
        // TODO: Implement.

        if (this.trainingData != null) {
            firstNode = treeGen(targetAttr,this.trainingData);
            return firstNode;
        }
        throw new RuntimeException("Empty dataList!");
    }

    @Override
    // use lookupDecision from Node class
    public Object lookupRecommendation(IAttributeDatum forVals) {
        // TODO: Implement.
        return firstNode.lookupDecision(forVals);
    }

    @Override
    public void printTree() {
        firstNode.printNode(" ");
    }
}