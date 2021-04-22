package sol;

import src.IAttributeDataset;
import src.IAttributeDatum;
import tester.Tester;

import java.util.LinkedList;

public class Project1TestSuite {

    /**
     * Setup method that creates a standard dataset
     * where all the attributes are different for every row/datum
     */
    public <T> ListObjsData setupBasicDataset (){
        Candidate john =
                new Candidate("Male", false,
                        "<1", "<1",
                        "0","0","nonlocal",
                        true);

        Candidate jessica = new Candidate("Female",
                false,
                "1","5+",
                "1","3","local",false);



        Candidate david = new Candidate("Male",
                true,"2",
                "5+","1",
                "<1","local",true);;

        LinkedList<T> data = new LinkedList<T>();
        data.addLast((T) john);
        data.addLast((T)jessica);
        data.addLast((T)david);


        LinkedList<String> columns = new LinkedList<String>();
        columns.addFirst("gender");
        columns.addLast("leadershipExperience");
        columns.addLast("lastPositionDuration");
        columns.addLast("numWorkExperiences");
        columns.addLast("programmingLanguages");
        columns.addLast("gpa");
        columns.addLast("location");
        columns.addLast("hired");




        ListObjsData dataset = new ListObjsData(columns,data);
        return dataset;

    }

    /**
     * Setup method that creates a standard dataset
     * where all the attributes are different for every row/datum
     */
    public <T> ListObjsData setupBasicOneDataset (){
        Candidate john =
                new Candidate("Male", false,
                        "<1", "<1",
                        "0","0","nonlocal",
                        true);


        LinkedList<T> data = new LinkedList<T>();
        data.addLast((T) john);



        LinkedList<String> columns = new LinkedList<String>();
        columns.addFirst("gender");
        columns.addLast("leadershipExperience");
        columns.addLast("lastPositionDuration");
        columns.addLast("numWorkExperiences");
        columns.addLast("programmingLanguages");
        columns.addLast("gpa");
        columns.addLast("location");
        columns.addLast("hired");




        ListObjsData dataset = new ListObjsData(columns,data);
        return dataset;

    }

    /**
     * Setup method that creates an empty Dataset
     * where there are no datums but the columns are populated with attributes
     */
    public  ListObjsData setupEmptyDataSet(){


        LinkedList<Candidate> data = new LinkedList<Candidate>();



        LinkedList<String> columns = new LinkedList<String>();
        columns.addFirst("gender");
        columns.addLast("leadershipExperience");
        columns.addLast("lastPositionDuration");
        columns.addLast("numWorkExperiences");
        columns.addLast("programmingLanguages");
        columns.addLast("gpa");
        columns.addLast("location");
        columns.addLast("hired");

        ListObjsData dataset = new ListObjsData(columns,data);
        return dataset;

    }

    /**
     * Setup method that creates an empty Dataset with an empty columnList
     * where there are no datums or columns
     */
    public ListObjsData setupEmptyDataSetColList(){

        LinkedList<Candidate> data = new LinkedList<Candidate>();
        LinkedList<String> columns = new LinkedList<String>();

        ListObjsData dataset = new ListObjsData(columns,data);
        return dataset;

    }


    /**
     * Setup method that creates a Dataset where all the values
     * are the same for the attribute leadershipExperience for all datums"
     */
    public ListObjsData setupAllLeadersDataset(){
        Candidate john =
                new Candidate("Male", true,
                        "<1", "<1",
                        "0","0","nonlocal",
                        true);

        Candidate jessica = new Candidate("Female",
                true,
                "1","5+",
                "1","3","local",false);



        Candidate david = new Candidate("Male",
                true,"2",
                "5+","1",
                "<1","local",true);;


        LinkedList<Candidate> data = new LinkedList<Candidate>();
        data.addLast(john);
        data.addLast(jessica);
        data.addLast(david);

        LinkedList<String> columns = new LinkedList<String>();
        columns.addFirst("gender");
        columns.addLast("leadershipExperience");
        columns.addLast("lastPositionDuration");
        columns.addLast("numWorkExperiences");
        columns.addLast("programmingLanguages");
        columns.addLast("gpa");
        columns.addLast("location");
        columns.addLast("hired");

        ListObjsData dataset = new ListObjsData(columns,data);
        return dataset;

    }

    /**
     * Tester method that tests the getData method in the
     * ListObjsData dataclass
     * @param t
     */
  public void testListObjsDataGetData(Tester t){
      ListObjsData basicTable1 = setupBasicDataset();
      ListObjsData basicTable2 = setupBasicDataset();
      ListObjsData LeaderTable1 = setupAllLeadersDataset();
      ListObjsData emptyTable1 = setupEmptyDataSet();

      t.checkExpect(basicTable1.getData(), basicTable2.getData() ) ;

      t.checkExpect(basicTable1.getData() != LeaderTable1.getData()
      ,true);

      t.checkExpect(basicTable1.getData() != emptyTable1.getData()
              ,true);

      t.checkExpect(LeaderTable1.getData() != emptyTable1.getData()
              ,true);

  }
    /**
     * Tester method that tests the getAttributes method in the
     * ListObjsData dataclass
     * @param t
     */
    public void testListObjsDatagetAttributes(Tester t ){
        ListObjsData basic = setupBasicDataset();
        ListObjsData basic2 = setupBasicDataset();
        ListObjsData empty = setupEmptyDataSet();
        ListObjsData allLeaders = setupAllLeadersDataset();
        ListObjsData totallyEmpty = setupEmptyDataSetColList();;


        t.checkExpect
                (basic.getAttributes().equals(empty.getAttributes())
                                &&
                                allLeaders.getAttributes().equals(
                                        basic.getAttributes()),
                true);




        t.checkExpect( basic.getAttributes(),basic2.getAttributes());

        t.checkExpect(basic.getAttributes(), empty.getAttributes());

        t.checkExpect(totallyEmpty.getAttributes()
                        == totallyEmpty.getAttributes(),
                true );

        t.checkExpect(empty.getAttributes()  !=
                        totallyEmpty.getAttributes(),
                true );


        t.checkExpect( allLeaders.getAttributes(), basic.getAttributes());


        basic.removeAttribute("gender");

        t.checkExpect( allLeaders.getAttributes() !=
                        basic.getAttributes(),
                true );

        t.checkExpect( empty.getAttributes() !=
                        basic.getAttributes(),
                true );

        t.checkExpect( allLeaders.getAttributes() !=
                        basic.getAttributes(),
                true );

        t.checkExpect( totallyEmpty.getAttributes() !=
                        basic.getAttributes(),
                true );








    }



    /**
     * Tester method that tests the allSameValue method in the
     * ListObjsData dataclass
     * @param t
     */
    public void testListObjsDataAllSameValue(Tester t ){
        ListObjsData basic = setupBasicDataset();
        ListObjsData empty = setupEmptyDataSet();
        ListObjsData allLeaders = setupAllLeadersDataset();
        ListObjsData totallyEmpty = setupEmptyDataSetColList();


       t.checkExpect(basic.allSameValue("leadershipExperience"),
               false);

        t.checkException(new RuntimeException("Empty dataList!"),
                empty, "allSameValue","leadershipExperience" );

        t.checkException(new RuntimeException("Empty dataList!"),
                totallyEmpty, "allSameValue","leadershipExperience" );


        t.checkExpect(allLeaders.allSameValue("leadershipExperience"),
                true);

        t.checkExpect(allLeaders.allSameValue("gender"),
                false);



    }

    /**
     * Tester method that tests the allPossibleVal method
     * in the ListObjsData dataclass
     * @param t
     */
    public void testListObjsDataAllPossibleVal(Tester t) {
        ListObjsData basic = setupBasicDataset();
        ListObjsData empty = setupEmptyDataSet();
        ListObjsData allLeaders = setupAllLeadersDataset();
        ListObjsData totallyEmpty = setupEmptyDataSetColList();



        LinkedList<String> allGenders = new LinkedList<String>();
        allGenders.addLast("Male");
        allGenders.addLast("Female");

        LinkedList<String> wrongorder = new LinkedList<String>();
        wrongorder.addLast("Female");
        wrongorder.addLast("Male");



        t.checkExpect(basic.allPossibleVal("gender"),allGenders);
        t.checkExpect(basic.allPossibleVal("gender")
                != wrongorder,true);


        t.checkException(new RuntimeException("Empty dataList!"),
                empty, "allPossibleVal","gender" );

        t.checkException(new RuntimeException("Empty dataList!"),
                totallyEmpty, "allPossibleVal","gender" );


        t.checkExpect(allLeaders.allPossibleVal("gender"),allGenders);

        LinkedList<Boolean> allBooleans =   new LinkedList<Boolean>();
        allBooleans.addLast(true);

        t.checkExpect(allLeaders.allPossibleVal(
                "leadershipExperience"),allBooleans);




    }

    /**
     * Tester Method that tests the size method
     * in the ListObjsData dataclass
     * @param t
     */
    public void testListObjsDataSize(Tester t ){
        ListObjsData basic = setupBasicDataset();
        ListObjsData empty = setupEmptyDataSet();
        ListObjsData allLeaders = setupAllLeadersDataset();
        ListObjsData totallyEmpty = setupEmptyDataSetColList();
        ListObjsData singular = setupBasicOneDataset();


        t.checkExpect(basic.size() , 3);
        t.checkExpect(empty.size() , 0);
        t.checkExpect(totallyEmpty.size() , 0);
        t.checkExpect(allLeaders.size() , 3);
        t.checkExpect(singular.size() , 1);




    }

    /**
     * Tester ethod that tests the partition method
     * in the ListObjsData dataclass
     * @param t
     */
    public <T> void testListObjsDataPartition(Tester t){
        ListObjsData basic = setupBasicDataset();
        ListObjsData basic2 = setupBasicDataset();
        ListObjsData empty = setupEmptyDataSet();
        ListObjsData allLeaders = setupAllLeadersDataset();
        ListObjsData completelyEmpty = setupEmptyDataSetColList();
        ListObjsData singular = setupBasicOneDataset();


        t.checkException(new RuntimeException("Empty dataList!"),
                empty, "partition","gender" );

        t.checkException(new RuntimeException("Empty dataList!"),
                completelyEmpty, "partition","gender" );


        //Create general partition list
        LinkedList<ListObjsData> basicGenderPartition =
                new LinkedList<ListObjsData>();




        //partitionList for males
        LinkedList<T> basicMales = new LinkedList<T>();
        basicMales.addFirst((T) basic.getData().get(0));
        basicMales.addLast((T) basic.getData().get(2));

        //partitionList for females
        LinkedList<T> basicFemales = new LinkedList<T>();
        basicFemales.addFirst((T) basic.getData().get(1));


        //unique datatables
        ListObjsData basicMalesListObjsData =
                new ListObjsData(basic.getAttributes(), basicMales);

        ListObjsData basicFemalesListObjsData =
                new ListObjsData(basic.getAttributes(), basicFemales);


        basicGenderPartition.addFirst(basicMalesListObjsData);
        basicGenderPartition.addLast(basicFemalesListObjsData);


        t.checkExpect(
                basicGenderPartition.equals(
                        basic.partition("gender"))
                , false);

        t.checkExpect(
                basicGenderPartition.equals(
                        basic2.partition("gender"))
                , false);

        // see what basic 2 returns and copy it

         basicMalesListObjsData.removeAttribute("gender");
         basicFemalesListObjsData.removeAttribute("gender");


        t.checkExpect(basicGenderPartition,
                basic.partition("gender"));

      t.checkExpect(basicGenderPartition,
              basic2.partition("gender"));




        //Create leader partition list
        LinkedList<ListObjsData>allLeaderPartition =
                new LinkedList<ListObjsData>();

        //Initialize attributes
        LinkedList<String> col2 =  allLeaders.getAttributes();

        //Partition list for leaders
        LinkedList<T> leadersPartition = new LinkedList<T>();
        leadersPartition.addFirst((T) allLeaders.getData().get(0));
        leadersPartition.addLast((T) allLeaders.getData().get(1));
        leadersPartition.addLast((T) allLeaders.getData().get(2));

        ListObjsData leaderSplitListObjsData = new ListObjsData(
                col2, leadersPartition);

        allLeaderPartition.addLast(leaderSplitListObjsData);


        leaderSplitListObjsData.removeAttribute(
                "leadershipExperience");


       t.checkExpect(allLeaderPartition,
           allLeaders.partition("leadershipExperience"));

        //Create singular partition list
        LinkedList<ListObjsData>allSingPartition =
                new LinkedList<ListObjsData>();

        //Initialize attributes
        LinkedList<String> singcol =  singular.getAttributes();

        //Partition list for leaders
        LinkedList<T> singPartition = new LinkedList<T>();
        singPartition.addFirst((T) singular.getData().get(0));

        ListObjsData singSplitListObjsData = new ListObjsData(
                singcol, singPartition);

        allSingPartition.addLast(singSplitListObjsData);

        singSplitListObjsData.removeAttribute("gender");

        t.checkExpect(allSingPartition,
                singular.partition("gender"));















    }



    /**
     * Tester Method that tests the getSharedValue method
     * in the ListObjsData dataclass
     * @param t
     */
    public void testListObjsDataGetSharedValue(Tester t){
        ListObjsData allLeaders = setupAllLeadersDataset();


        t.checkExpect(allLeaders.getSharedValue(
                "leadershipExperience"),true);

        /*
        Note that we only run the shared value method in instances where
        all the values for a given attribute are identical across a dataset.
        we don't have an if statement to check this because we run it under
        the assumption that they are all already equal, as such, we have
        no other if statements to test

        we could have included an if statement to decide if allSameAttribute
        returned true, but we elected not to
         */

    }

    /**
     * Tester Method the tests the mostCommonValue method
     * in the ListObjsData dataclass
     * @param t
     */
    public void testListObjsDataMostCommonValue(Tester t){
        ListObjsData basic = setupBasicDataset();
        ListObjsData empty = setupEmptyDataSet();
        ListObjsData allLeaders = setupAllLeadersDataset();




        t.checkExpect(
                basic.mostCommonValue("gender"), "Male");

        t.checkException(new RuntimeException("Empty dataList!"),
                empty, "mostCommonValue","gender" );

        t.checkExpect(
                allLeaders.mostCommonValue("gender"), "Male");

        t.checkExpect(
                allLeaders.mostCommonValue("leadershipExperience"),
                true);

        t.checkExpect(
                basic.mostCommonValue("leadershipExperience"),
                false);




    }

    /**
     * Tester Method that tests the removeAttribute method in the ListObjsData
     * dataclass
     * @param t
     */
    public void testListObsDataRemoveAttribute(Tester t){
        ListObjsData basic = setupBasicDataset();
        ListObjsData empty = setupEmptyDataSet();
        ListObjsData allLeaders = setupAllLeadersDataset();
        ListObjsData completelyEmpty = setupEmptyDataSetColList();

        basic.removeAttribute("gender");
        empty.removeAttribute("gender");
        allLeaders.removeAttribute("gender");


        LinkedList<String> initial = new LinkedList<>();
        initial.addFirst("gender");
        initial.addLast("leadershipExperience");
        initial.addLast("lastPositionDuration");
        initial.addLast("numWorkExperiences");
        initial.addLast("programmingLanguages");
        initial.addLast("gpa");
        initial.addLast("location");
        initial.addLast("hired");


        t.checkExpect( basic.getAttributes() != initial, true );
        t.checkExpect( empty.getAttributes() != initial, true );
        t.checkExpect( allLeaders.getAttributes() != initial,
                true );

    }


    /**
     * Setup method that creates a  Gpa basic node
     */
    public Node setupGPANode() {
        Node gpaNode = new Node("gpa","4.0");
        return gpaNode;
    }

    /**
     * Setup method that creates a basic Leadership node
     */
    public Node setupLeaderNode() {
        Node leaderNode = new Node("leadershipExperience",true);
        return leaderNode;
    }

    /**
     * Setup method that creates a basic  Gender node
     */
    public Node setupGenderNode() {
        Node genderNode = new Node("gender","male");
        return genderNode;
    }

    /**
     * Tester Method that tests the getNodeVal method in the Node dataclass
     * @param t
     */
    public void testNodeGetNodeVal(Tester t) {
        Node leader1 = setupLeaderNode();
        Node leader2 = setupLeaderNode();
        Node gender1 = setupGenderNode();

        t.checkExpect(leader1.getNodeVal(),leader2.getNodeVal() );
        t.checkExpect(leader1.getNodeVal() != gender1.getNodeVal()
        ,true);


    }

    /**
     * Tester Method that tests the getDefaultVal method in the Node dataclass
     * @param t
     */
    public void testNodeGetDefaultVal(Tester t) {
        Node leader1 = setupLeaderNode();
        Node leader2 = setupLeaderNode();
        Node gender1 = setupGenderNode();

        t.checkExpect(leader1.getDefaultVal(),leader2.getDefaultVal() );
        t.checkExpect(leader1.getDefaultVal() != gender1.getDefaultVal()
                ,true);


    }

    /**
     * Tester Method that tests the getEdgesVal method in the Node dataclass
     * @param t
     */
    public void testNodeGetEdgesVal(Tester t) {


        Node leader1 = setupLeaderNode();

        Node leader2 = setupLeaderNode();
        Node gender1 = setupGenderNode();


        leader1.addEdge("<3.0", leader1);
        leader1.addEdge("<3.0", leader2);

        leader2.addEdge("<3.0", leader1);
        leader2.addEdge("<3.0", leader2);

        gender1.addEdge(true, leader1);







        t.checkExpect(leader1.getEdgesVal(),leader2.getEdgesVal() );
        t.checkExpect(leader1.getEdgesVal() != gender1.getEdgesVal()
                ,true);


    }





    /**
     *  Tester Method that tests the addEdges method
     *  in the Node dataclass
     *  @param t
     */
    public void testNodeAddEdges(Tester t){
        Node gpa = setupGPANode();
        Node leader = setupLeaderNode();
        Node gender = setupGenderNode();

        Edge edge1 = new Edge("<3.0",leader);
        Edge edge2 = new Edge("3.3",gender);
        Edge edge3 = new Edge("3.5<",gender);

        Edge edge4 = new Edge("9999", gpa);

        LinkedList<Edge> EdgeList = new LinkedList<Edge>();
        EdgeList.addFirst(edge1);
        EdgeList.addFirst(edge2);
        EdgeList.addFirst(edge3);

        gpa.addEdge("<3.0",leader);
        gpa.addEdge("3.3",gender);
        gpa.addEdge("3.5<",gender);


        t.checkExpect(EdgeList,gpa.getEdgesVal());

        t.checkException(new RuntimeException("Edge already present"),
                gpa, "addEdge","3.5<",gender);



        EdgeList.addFirst(edge4);
        t.checkExpect(EdgeList != gpa.getEdgesVal(), true);
        t.checkExpect(gpa.getEdgesVal().contains(edge4),false);


    }





    /**
     * Tester Method that tests the lookupDecision method
     * in the Node dataclass
     * @param t
     */
    public void testNodeLookupDecision (Tester t) {

        Candidate john =
                new Candidate("Male", false,
                        "<1", "<1",
                        "0","3.5<","nonlocal",
                        true);
        Candidate max =
                new Candidate("Male", true,
                        "<1", "<1",
                        "0","3.5<","nonlocal",
                        true);

        Candidate unexpected =
                new Candidate("Male", false,
                        "<1", "<1",
                        "0","999","nonlocal",
                        true);

        Node gpa = setupGPANode();
        Node leader = setupLeaderNode();
        Node gender = setupGenderNode();


        Node yesHired = new Node("hired",true);
        Node noHired =  new Node("hired",false);




        gpa.addEdge("<3.0",leader);
        gpa.addEdge("3.3",gender);
        gpa.addEdge("3.5<",gender);

        gender.addEdge("Male", leader);
        gender.addEdge("female",leader);

        leader.addEdge(true, yesHired);
        leader.addEdge(false, noHired);


        t.checkExpect(gpa.lookupDecision(john),false);
        t.checkExpect(gpa.lookupDecision(max),true);


        t.checkExpect(gpa.lookupDecision(unexpected),"4.0");

       /*
        below is the printNode method in Node dataclass test, we
        commented it out because we didn't want to print it during
        testing:
        */

       //gpa.printNode(" ");



    }

    /**
     * Tester Method that tests the getEdgeVal method in the Edge dataclass
     * @param t
     */
    public void testEdgeGetEdgeVal(Tester t){
        Node leader = setupLeaderNode();
        Node gender = setupGenderNode();

        Edge edge1 = new Edge("3.3",leader);
        Edge edge2 = new Edge("3.3",gender);

        Edge edge3 = new Edge("3.5<",gender);

        t.checkExpect(edge1.getEdgeVal(), edge2.getEdgeVal());
        t.checkExpect(edge1.getEdgeVal() != edge3.getEdgeVal(),
                true);





    }

    /**
     * Tester Method that tests the getTargetNodeVal method in the Edge dataclass
     * @param t
     */
    public void testEdgeGetTargetNodeVal(Tester t){
        Node leader = setupLeaderNode();
        Node gender = setupGenderNode();

        Edge edge1 = new Edge("3.2",gender);
        Edge edge2 = new Edge("4.0",gender);

        Edge edge3 = new Edge("3.2",leader);

        t.checkExpect(edge1.getTargetNodeVal(), edge2.getTargetNodeVal());
        t.checkExpect(edge1.getTargetNodeVal()
                        != edge3.getTargetNodeVal(),
                true);





    }








    /**
     * main method
     */
    public static void main(String[] args) {
        Tester.run(new Project1TestSuite());
    }

}
