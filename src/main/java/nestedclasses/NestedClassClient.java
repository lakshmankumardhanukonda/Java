package nestedclasses;

public class NestedClassClient {

    public void execute() {

        OuterClassForStaticNestedClass.StaticNestedClass staticNestedClass = new OuterClassForStaticNestedClass.StaticNestedClass();
        staticNestedClass.display();
        System.out.println("==================================================================");
        OuterClassForInnerClass.InnerClass innerClass = new OuterClassForInnerClass().new InnerClass();
        innerClass.display();
        System.out.println("==================================================================");
        OuterClassForLocalInnerClass outerClassForLocalInnerClass = new OuterClassForLocalInnerClass();
        outerClassForLocalInnerClass.display();
        System.out.println("==================================================================");
        AnonymousInnerClassExample anonymousInnerClassExample = new AnonymousInnerClassExample() {
            @Override
            public void sayHello() {
                System.out.println("Hello from Anonymous Inner Class");
            }
        };
        anonymousInnerClassExample.sayHello();
        System.out.println("==================================================================");


    }
}
