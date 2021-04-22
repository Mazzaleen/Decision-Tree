/**
 * Interface for a "row" of a datatable (one item),
 * which is a collection of values for a set of attributes.
 */
public interface IAttributeDatum {



  /**
   * Method that looks up the value associated with the named attribute
   * @param attributeName -- attribute we want to see the value of
   * @return the value of the attribute
   */
  public Object getValueOf(String attributeName);
}
