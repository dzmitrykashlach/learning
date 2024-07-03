package generics;

import org.junit.jupiter.api.Test;

public class RefTest {
    public class Ref<T> {
        private T value = null;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

    }

    @Test
    public void testRef() {
        Ref ref = new Ref();
/*        Ref<?> ref = new Ref();
        => compilation error, because ref is unboxed to Object.class in getValue */
        ref.setValue(ref.getValue());
    }
}
