package ca.eloas.hamcrest.methodinvocation;

import org.hamcrest.Matcher;
import org.junit.Test;

import static ca.eloas.hamcrest.methodinvocation.MethodMatcher.declaredArguments;
import static ca.eloas.hamcrest.methodinvocation.MethodMatcher.name;
import static ca.eloas.hamcrest.methodinvocation.MethodMatcher.returnType;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author JP
 */
public class MethodMatcherTest {


    public interface TestInterface {

        public void aMethod();
        public void aMethod(String a);
    }

    @Test
    public void test_name() throws NoSuchMethodException {

        assertThat(TestInterface.class.getMethod("aMethod"), name(is("aMethod")));
    }

    @Test
    public void test_argument() throws NoSuchMethodException {

        assertThat(TestInterface.class.getMethod("aMethod"), declaredArguments(emptyArray()));
        assertThat(TestInterface.class.getMethod("aMethod", String.class), declaredArguments(arrayWithSize(1)));
        assertThat(TestInterface.class.getMethod("aMethod", String.class), declaredArguments(array(equalTo(String.class))));
    }

    @Test
    public void test_return_value() throws NoSuchMethodException {

        assertThat(TestInterface.class.getMethod("aMethod"), returnType(equalTo(void.class)));
        assertThat(TestInterface.class.getMethod("aMethod"), returnType(equalTo(String.class)));
    }

}
