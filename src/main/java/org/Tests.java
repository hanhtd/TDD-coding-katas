package org;


public class Tests {

    public static void main(String[] args) {
        System.out.println(new A().getClass().getAnnotation(InheritedAnnotationType.class));
        System.out.println(new B().getClass().getAnnotation(InheritedAnnotationType.class));
        System.out.println(new C().getClass().getAnnotation(InheritedAnnotationType.class));
        System.out.println(D.class.getAnnotation(InheritedAnnotationType.class));
        System.out.println("value on D =" + D.class.getAnnotation(InheritedAnnotationType.class).value());
        System.out.println("_________________________________");
        System.out.println(new A().getClass().getAnnotation(UninheritedAnnotationType.class));
        System.out.println(new B().getClass().getAnnotation(UninheritedAnnotationType.class));
        System.out.println(new C().getClass().getAnnotation(UninheritedAnnotationType.class));
    }
}

@UninheritedAnnotationType
class A {

}

@InheritedAnnotationType("on B class")
class B extends A {

}

class C extends B {

}

@InheritedAnnotationType("on D class")
class D extends C {

}
