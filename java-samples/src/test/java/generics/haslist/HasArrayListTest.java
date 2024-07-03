package generics.haslist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class HasArrayListTest {

    public class HasList<T extends List> {
        protected final T list;

        public HasList(T list) {
            this.list = list;
        }

        public T getList() {
            return list;
        }
    }

    public class HasArrayList<T extends ArrayList> extends HasList<T> {
        public HasArrayList(T list) {
            super(list);
        }
//        FIXME proceed with https://habr.com/ru/articles/329550/
        /* In order to fix compilation error override getList()
           In this case compiler will generate synthetic bridge method, which will be called.
        @Override
        public T getList() {
            return super.getList();
        }
        */
        @Override
        public T getList() {
            return super.getList();
        }

    }


    @Test
    public void hasArrayListTest(){
        HasArrayList h = new HasArrayList<>(new ArrayList<>());
        /*
        Compilation error:
        Required: ArrayList
        Provided: List
        HasArrayList h = new HasArrayList<>(new ArrayList<>());

         */
        ArrayList list = h.getList();
    }
}

/*
byte code:
with <?>
==============================================
dk@dk-HP:~/src/learning/java-samples/build/classes/java/test/generics/haslist$ javap -c HasArrayListTest$HasArrayList.class
Compiled from "HasArrayListTest.java"
public class generics.haslist.HasArrayListTest {
  public generics.haslist.HasArrayListTest();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public void hasArrayListTest();
    Code:
       0: new           #7                  // class generics/haslist/HasArrayListTest$HasArrayList
       3: dup
       4: aload_0
       5: new           #9                  // class java/util/ArrayList
       8: dup
       9: invokespecial #11                 // Method java/util/ArrayList."<init>":()V
      12: invokespecial #12                 // Method generics/haslist/HasArrayListTest$HasArrayList."<init>":(Lgenerics/haslist/HasArrayListTest;Ljava/util/ArrayList;)V
      15: astore_1
      16: aload_1
      17: invokevirtual #15                 // Method generics/haslist/HasArrayListTest$HasArrayList.getList:()Ljava/util/List;
      20: checkcast     #9                  // class java/util/ArrayList FIXME: why is this checkcast needed ?
                                                https://docs.oracle.com/javase/specs/jvms/se17/html/jvms-6.html#jvms-6.5.checkcast
                                                The following rules are used to determine whether an objectref
                                                that is not null can be cast to the resolved type.
                                                If S is the type of the object referred to by objectref,
                                                and T is the resolved class, array, or interface type,
                                                then checkcast determines whether objectref can be cast to type T as follows:

                                                If S is a class type, then:

                                                                If T is a class type, then S must be the same class as T,
                                                                or S must be a subclass of T;

                                                If T is an interface type, then S must implement interface T.

      23: astore_2
      24: return
}
====================================================
with "@Override public T getList()"
dk@dk-HP:~/src/learning/java-samples/build/classes/java/test/generics/haslist$ javap -c HasArrayListTest$HasArrayList.class
Compiled from "HasArrayListTest.java"
public class generics.haslist.HasArrayListTest {
  public generics.haslist.HasArrayListTest();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public void hasArrayListTest();
    Code:
       0: new           #7                  // class generics/haslist/HasArrayListTest$HasArrayList
       3: dup
       4: aload_0
       5: new           #9                  // class java/util/ArrayList
       8: dup
       9: invokespecial #11                 // Method java/util/ArrayList."<init>":()V
      12: invokespecial #12                 // Method generics/haslist/HasArrayListTest$HasArrayList."<init>":(Lgenerics/haslist/HasArrayListTest;Ljava/util/ArrayList;)V
      15: astore_1
      16: aload_1
      17: invokevirtual #15                 // Method generics/haslist/HasArrayListTest$HasArrayList.getList:()Ljava/util/ArrayList;
      20: astore_2
      21: return
}

 */
