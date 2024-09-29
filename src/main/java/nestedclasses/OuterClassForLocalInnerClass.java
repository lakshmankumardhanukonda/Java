package nestedclasses;

public class OuterClassForLocalInnerClass {

    public void display() {
        String localVariable = "Local Variable";

        // Local inner class
        class LocalInnerClass {
            public void show() {
                System.out.println("Accessing: " + localVariable);
            }
        }

        LocalInnerClass localInner = new LocalInnerClass();
        localInner.show();  // Outputs: Accessing: Local Variable
    }
}
