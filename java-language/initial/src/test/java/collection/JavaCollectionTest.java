package collection;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class JavaCollectionTest {
    @Nested
    class SimpleArrayListTest {
        @Test
        void 리스트에_요소를_추가할_수_있다() {
            SimpleList list = new SimpleArrayList();
            list.add("hi");
            boolean result = list.add("hi");

            assertThat(result).isTrue();
        }

        @Test
        void 리스트에_여러개의_요소를_추가할_수_있다() {
            SimpleList list = new SimpleArrayList();
            list.add("hi");
            list.add("hi");
            list.add("hi");
            list.add("hi");
            boolean result = list.add("hi");

            assertThat(result).isTrue();
        }

        @Test
        void 지정한_위치에_요소를_추가할_수_있다() {
            //given
            SimpleList list = new SimpleArrayList();
            list.add("hi");
            list.add("bye");

            //when
            list.add(1, "hello");

            //then
            assertThat(list.get(0)).isEqualTo("hi");
            assertThat(list.get(1)).isEqualTo("hello");
            assertThat(list.get(2)).isEqualTo("bye");
        }

        @Test
        void 지정한_요소_추가_위치가_유효하지_않으면_예외를_던진다() {
            //given
            SimpleList list = new SimpleArrayList();

            //when
            //then
            assertThatThrownBy(() -> list.add(1, "hello"))
                    .isInstanceOf(IndexOutOfBoundsException.class);
        }

        @Test
        void 지정한_인덱스의_값을_바꾸고_기존의_값을_반환할_수_있다() {
            //given
            SimpleList list = new SimpleArrayList();
            list.add("hi");

            //when
            String result = list.set(0, "bye");

            //then
            assertThat(result).isEqualTo("hi");
            assertThat(list.get(0)).isEqualTo("bye");
        }

        @Test
        void 값을_바꿀_지정된_인덱스가_유효하지_않으면_예외를_던진다() {
            //given
            SimpleList list = new SimpleArrayList();

            //when
            //then
            assertThatThrownBy(() -> list.set(0, "bye"))
                    .isInstanceOf(IndexOutOfBoundsException.class);
        }

        @Test
        void _2번째_인덱스의_값을_받아올_수_있다() {
            SimpleList list = new SimpleArrayList();
            list.add("1");
            list.add("2");
            list.add("3");

            String result = list.get(2);

            assertThat(result).isEqualTo("3");
        }

        @Test
        void _3번째_인덱스의_값을_받아올_수_있다() {
            SimpleList list = new SimpleArrayList();
            list.add("1");
            list.add("2");
            list.add("3");

            String result = list.get(0);

            assertThat(result).isEqualTo("1");
        }

        @Test
        void 인덱스가_리스트의_길이를_벗어나면_예외를_던진다() {
            SimpleList list = new SimpleArrayList();

            assertThatThrownBy(() -> list.get(0))
                    .isInstanceOf(IndexOutOfBoundsException.class);
        }

        @Test
        void 인덱스가_리스트의_길이를_벗어나면_예외를_던진다2() {
            SimpleList list = new SimpleArrayList();
            list.add("1");
            list.add("2");
            list.add("3");

            assertThatThrownBy(() -> list.get(3))
                    .isInstanceOf(IndexOutOfBoundsException.class);
        }

        @Test
        void 특정_요소가_포함되어있으면_true_를_반환한다() {
            //given
            SimpleList list = new SimpleArrayList();
            list.add("hi");

            //when
            boolean result = list.contains("hi");

            //then
            assertThat(result).isTrue();
        }

        @Test
        void 특정_요소가_포함되어있지_않으면_false_를_반환한다() {
            //given
            SimpleList list = new SimpleArrayList();
            list.add("hi");

            //when
            boolean result = list.contains("11");

            //then
            assertThat(result).isFalse();
        }

        @Test
        void 특정_요소의_인덱스를_반환한다() {
            //given
            SimpleList list = new SimpleArrayList();
            list.add("hi");

            //when
            int result = list.indexOf("hi");

            //then
            assertThat(result).isZero();
        }

        @Test
        void 특정_요소의_인덱스를_반환한다2() {
            //given
            SimpleList list = new SimpleArrayList();
            list.add("hi");
            list.add("bye");

            //when
            int result = list.indexOf("bye");

            //then
            assertThat(result).isEqualTo(1);
        }

        @Test
        void 특정_요소가_존재하지_않으면_minus1을_반환한다() {
            //given
            SimpleList list = new SimpleArrayList();

            //when
            int result = list.indexOf("hi");

            //then
            assertThat(result).isEqualTo(-1);
        }

        @Test
        void 리스트_내_아무_요소도_없으면_true_를_반환한다() {
            //given
            SimpleList list = new SimpleArrayList();

            //when
            boolean result = list.isEmpty();

            //then
            assertThat(result).isTrue();
        }

        @Test
        void 리스트_내_요소가_존재하면_false_를_반환한다() {
            //given
            SimpleList list = new SimpleArrayList();
            list.add("hi");

            //when
            boolean result = list.isEmpty();

            //then
            assertThat(result).isFalse();
        }

        @Test
        void 요소를_삭제하고_true_를_반환한다() {
            //given
            SimpleList list = new SimpleArrayList();
            list.add("hi");

            //when
            boolean result = list.remove("hi");

            //then
            assertThat(result).isTrue();
            assertThat(list.isEmpty()).isTrue();
        }

        @Test
        void 요소를_삭제하고_true_를_반환한다2() {
            //given
            SimpleList list = new SimpleArrayList();
            list.add("hi");
            list.add("bye");
            list.add("good night");

            //when
            boolean result = list.remove("bye");

            //then
            assertThat(result).isTrue();
            assertThat(list.isEmpty()).isFalse();
            assertThat(list.get(0)).isEqualTo("hi");
            assertThat(list.get(1)).isEqualTo("good night");
        }

        @Test
        void 삭제할_요소가_존재하지_않으면_false_를_반환한다() {
            //given
            SimpleList list = new SimpleArrayList();

            //when
            boolean result = list.remove("hi");

            //then
            assertThat(result).isFalse();
        }

        @Test
        void 주어진_인덱스의_요소를_삭제하고_값을_반환한다() {
            //given
            SimpleList list = new SimpleArrayList();
            list.add("hi");

            //when
            String result = list.remove(0);

            //then
            assertThat(result).isEqualTo("hi");
            assertThat(list.isEmpty()).isTrue();
        }

        @Test
        void 주어진_인덱스의_요소를_삭제하고_값을_반환한다2() {
            //given
            SimpleList list = new SimpleArrayList();
            list.add("hi");
            list.add("bye");
            list.add("good night");

            //when
            String result = list.remove(1);

            //then
            assertThat(result).isEqualTo("bye");
            assertThat(list.get(0)).isEqualTo("hi");
            assertThat(list.get(1)).isEqualTo("good night");
        }

        @Test
        void 삭제할_인덱스가_유효하지_않으면_예외를_던진다() {
            //given
            SimpleList list = new SimpleArrayList();

            //when
            //then
            assertThatThrownBy(() -> list.remove(0))
                    .isInstanceOf(IndexOutOfBoundsException.class);

        }

        @Test
        void 리스트를_비울_수_있다() {
            //given
            SimpleList list = new SimpleArrayList();
            list.add("hi");
            list.add("bye");

            //when
            list.clear();

            //then
            assertThat(list.isEmpty()).isTrue();
        }
    }
}
