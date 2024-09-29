package nestedclasses;

public class OuterClassForInnerClass {
    private String outerField = "Outer Field";

    public class InnerClass {
        public void display() {
            System.out.println("Accessing: " + outerField);
        }
    }
}
