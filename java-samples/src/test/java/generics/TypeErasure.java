package generics;

public class TypeErasure {
    public void typeErazure() {

//        Deprecated d = Object.class.getAnnotation(Deprecated.class);

        Class<Object> clazz = Object.class;

        /*
        Class clazz = Object.class;
        Compilation error =>
        incompatible types:

         java.lang.annotation.Annotation cannot be converted to java.lang.Deprecated
         */
        Deprecated d = clazz.getAnnotation(Deprecated.class);
    }
}