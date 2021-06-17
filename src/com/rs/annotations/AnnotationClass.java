package com.rs.annotations;

import java.lang.annotation.*;
import java.util.ArrayList;


//Marker Annotation
//Single Valued annotation
//multi valued annotation

@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone{
    String os() default "Symbian";
    int version() default 1;
}

@SmartPhone(os="Android", version=6)
class NokiaASeries{
    String model;
    int size;

    public NokiaASeries(String model, int size) {
        this.model = model;
        this.size = size;
    }
}

@FunctionalInterface
interface Abc{
    void show();
//    void uu(); only one method in interface
}

class A{
    public void show(){
        System.out.println("In A");
    }
}

class B extends A{
    @Deprecated
    public void deprecatedMethod(){

    }

    @Override
    @SuppressWarnings("unchecked")
    public void show(){
        ArrayList obj = new ArrayList();
        System.out.println("In B");
    }

}

public class AnnotationClass {
    public static void main(String[] args) {
        B obj = new B();
        obj.show();
        obj.deprecatedMethod();

        NokiaASeries obj1 = new NokiaASeries("Fire", 5);

        Class c = obj.getClass();
        Annotation an = c.getAnnotation(SmartPhone.class);
        SmartPhone s = (SmartPhone)an;
        System.out.println(s.os());
    }
}
