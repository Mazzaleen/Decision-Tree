import java.util.LinkedList;

/**
 * Interface that contains all methods pertaining to a dataset
 * @param <T> -- Object that forms the "rows" of the data table
 */
public interface IAttributeDataset<T extends IAttributeDatum> {


    /**
     * Method that returns all the attributes in the attributeDataset
     * @return all the attributes in the dataset
     */
    public LinkedList<String> getAttributes();



    /**
     * Method that checks if every row/datum have the same value
     * for the given attribute/column
     * @param ofAttribute -- attribute we want to check
     * @return boolean determining if this is true or false
     */
    public boolean allSameValue(String ofAttribute);



    /**
     * Method that calculates the number of data/rows in the attributeDataset
     * @return an integer representing the size of data/rows in the dataset
     */
    public int size();



    /**
     * Method that separates rows into subsets such that each subset has
     * an equal onAttribute
     * @param onAttribute -- the attribute we want to categorize our data on
     * @return Dataset with subsets based on onAttribute values
     */
    public LinkedList<IAttributeDataset<T>> partition(String onAttribute);


    /**
     * Method that gets the value for ofAttribute, which is assumed to be
     * common across all the rows
     * @param ofAttribute -- the attribute we want to see
     * @return value for ofAttribute
     */
    public Object getSharedValue(String ofAttribute);




    /**
     * Method that returns the most common value (mode)
     * of an attribute in dataset
     * @param ofAttribute -- the attribute we want to see the mode of
     * @return the mode of the attribute
     */
    public Object mostCommonValue(String ofAttribute);
}
