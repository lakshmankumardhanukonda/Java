import collections.CollectionsClient;
import collections.CollectionsDemo;
import functionalinterfaces.FunctionalInterfaceClient;
import nestedclasses.NestedClassClient;
import streams.StreamsClient;
import streams.StreamsDemo;

public class Main {

    public static void main(String[] args) {
//        StreamsClient streamsClient = new StreamsClient();
//        streamsClient.execute();

//        FunctionalInterfaceClient functionalInterfaceClient = new FunctionalInterfaceClient();
//        functionalInterfaceClient.execute();

//        NestedClassClient nestedClassClient = new NestedClassClient();
//        nestedClassClient.execute();

        CollectionsClient collectionsClient = new CollectionsClient();
        collectionsClient.execute();
    }
}
