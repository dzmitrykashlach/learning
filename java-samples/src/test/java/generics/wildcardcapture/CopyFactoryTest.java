package generics.wildcardcapture;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CopyFactoryTest {

    public class TestCapture {

        static void foo(List<?> aList) {
            /*
            This code violates PECS principle, because we cannot be sure that wildcarded type is
            within upper and lower boundaries. The solution is to capture wildcard e.g. to convert
            wildcard into parameterised type through using fooHelper() method
             */
//            aList.set(0, aList.get(0));

            fooHelper(aList);
        }
        static <T> void fooHelper(List<T> aList) {
            aList.set(0, aList.get(0));
        }
    }

    @Test
    public void testWildcardCapture(){
        TestCapture.foo(Arrays.asList(0, 1, 2, 3));
    }

}
