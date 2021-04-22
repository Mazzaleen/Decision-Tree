package sol;


import src.IAttributeDataset;
import src.IAttributeDatum;

import java.util.LinkedList;

/**
 * Data Class for a specific representation of rows in a data table.
 * The type T is the object that forms the "rows" of the data table
 * Extends the IAttributeDatum Interface
 * Implements IAttributeDataset<T> Interface
 */
public class ListObjsData<T extends IAttributeDatum>
        implements IAttributeDataset<T> {
    private LinkedList<String> column;
    private LinkedList<T>  data;

    /**
     * Constructor for the ListObjsData dataclass
     * @param c -- LinkedList<String> representing the columns of datatable
     *          ( i.e Attributes)
     * @param d -- LinkedList<T> representing the rows of datatable
     *          ( i.e Candidates)
     */
    public ListObjsData
            (LinkedList<String> c,LinkedList<T> d){
        this.column = c;
        this.data = d;
    }

    /**
     * Helper method that gets the data of a listObjsData
     * @return data field  of type LinkedList<T>
     */
    public LinkedList<T> getData(){
        return this.data;
    }

    @Override
    public LinkedList<String> getAttributes() {
        // TODO: Implement.
        return this.column;
    }


    @Override
    public boolean allSameValue(String ofAttribute) {
        // TODO: Implement.

       // raise exception if dataset is empty
        if (this.data.isEmpty()) {
            throw new RuntimeException("Empty dataList!");
        }


        // else, Store the attribute for first row/datum
        Object attribute = this.data.getFirst().getValueOf(ofAttribute);

        // and recursively check that all the elements in list have same value
        for (T datum:this.data)  {
            if (!datum.getValueOf(ofAttribute).equals(attribute)){
                return false;
            }

        }
        return true;
    }

    /**
     * Helper Method that finds all unique values of given attribute
     * @param ofAttribute -- the attribute we want to find all values of
     * @return all possible values of given attribute
     */
    public LinkedList<Object> allPossibleVal(String ofAttribute) {
        // TODO: Implement

        //initalize linked list of all unique values thats initally empty
        // adding too it every time that we encounter a value not present

        LinkedList<Object> possibleVal = new LinkedList<Object>();

            /*
        edge case where you raise an exception if you are trying to
        find all possible values in  an empty dataset
         */
        if(this.data.isEmpty()){
            throw new RuntimeException("Empty dataList!");

        }


        for (T datum:this.data) {
            if (possibleVal.contains(datum.getValueOf(ofAttribute))) {
                // check if attribute in existing list
            } else {
                possibleVal.addLast(datum.getValueOf(ofAttribute));
                // add if attribute not in existing list
            }
        }


        return possibleVal; // return all possible values
    }

  @Override
    public int size() {
        // TODO: Implement.
        return this.data.size();
    }

    @Override
    public LinkedList<IAttributeDataset<T>> partition(String onAttribute) {
        // TODO: Implement.

       // raise exception if partitioning an empty dataset
        if(this.data.isEmpty()){
            throw new RuntimeException("Empty dataList!");
        }

        // create list of partitions:
        LinkedList<IAttributeDataset<T>> listOfPartitions = new LinkedList<>();

        // create list of unique values:
        LinkedList<Object> possibleVal = this.allPossibleVal(onAttribute);



        // loop through all possible values of an attribute (eg. green)
        for (Object attVal:possibleVal) {

            // create a current sublist
            LinkedList<T> currentPartition = new LinkedList<T>();

            // loop through dataset (eg. vegetables)
            for (T datum:this.data) {

                // if the vegetable has this value, add to current sublist
                if (datum.getValueOf(onAttribute).equals(attVal)) {
                    currentPartition.addLast(datum);
                }
            }

            // create a current partition table
            // Remove Attribute used to partition from the columnList
            LinkedList<String> updatedCol = this.removeAttribute(onAttribute);

            // add current partition to our list of partitions
            listOfPartitions.addLast(
                    new ListObjsData<T>(updatedCol,currentPartition));
        }
        return listOfPartitions;
    }

    @Override
    public Object getSharedValue(String ofAttribute) {
        // TODO: Implement.
         // assume that all values are already the same:
            return this.data.getFirst().getValueOf(ofAttribute);
        }

    @Override
    public Object mostCommonValue(String ofAttribute) {
        // TODO: Implement.

        /*
        edge case where you raise an exception if you are trying to find
        the most common value of an empty dataset
         */
        if(this.data.isEmpty()){
            throw new RuntimeException("Empty dataList!");

        }


        //create list of all unique values
        LinkedList<Object> possibleVal = this.allPossibleVal(ofAttribute);

        int maxCount = 0; // Initalize maximum counter

        Object currentObj = null;

        for (Object attVal:possibleVal) {
            int currentCount = 0;

            for (T datum:this.data) {
                if (datum.getValueOf(ofAttribute).equals(attVal)) {
                    currentCount++;
                }
            }
            if (currentCount > maxCount) { //Would also work with >=
                /*
                if the number of outcomes for a given attribute is
                greater than the max counter, mutate current obj to that unique
                value
                 */
                maxCount = currentCount;
                currentObj = attVal;
            }
        }
        return currentObj;
        }


    /**
     * Helper method that removes attribute from column list
     * @param ofAttribute -- attribute we want to remove
     * @return col list with attribute removed
     */
    public LinkedList<String> removeAttribute (String ofAttribute) {
        for (String attr: this.column){

            if (attr.equals(ofAttribute)) {
                this.column.remove(attr);
            }
            break;

        }
        return this.column;

    }
}
