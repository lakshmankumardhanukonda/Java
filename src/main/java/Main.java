import functionalinterfaces.FunctionalInterfaceClient;
import streams.StreamsClient;
import streams.StreamsDemo;

public class Main {

    public static void main(String[] args) {
        StreamsClient streamsClient = new StreamsClient();
        streamsClient.execute();

        FunctionalInterfaceClient functionalInterfaceClient = new FunctionalInterfaceClient();
        functionalInterfaceClient.execute();
    }
}
