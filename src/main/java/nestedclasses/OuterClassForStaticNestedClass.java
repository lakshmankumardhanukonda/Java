package nestedclasses;

public class OuterClassForStaticNestedClass {
    private static String staticOuterField = "Static Outer Field";


    public static class StaticNestedClass {
        public void display() {
            System.out.println("Accessing: " + staticOuterField);
        }
    }
}
