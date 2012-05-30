package ca.eloas.hamcrest.methodinvocation;

import org.hamcrest.Matcher;
import org.junit.Test;

import java.lang.reflect.Method;

import static ca.eloas.hamcrest.methodinvocation.MethodMatcher.declaredArguments;
import static ca.eloas.hamcrest.methodinvocation.MethodMatcher.name;
import static ca.eloas.hamcrest.methodinvocation.MethodMatcher.returnType;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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

        assertTrue(declaredArguments(emptyArray()).matches(TestInterface.class.getMethod("aMethod")));
        assertTrue(declaredArguments(arrayWithSize(1)).matches(TestInterface.class.getMethod("aMethod", String.class)));
        assertTrue(declaredArguments(array(equalTo(String.class))).matches(TestInterface.class.getMethod("aMethod", String.class)));
    }



    @Test
    public void test_return_value() throws NoSuchMethodException {

        assertTrue(returnType(equalTo(void.class)).matches(TestInterface.class.getMethod("aMethod")));
    }

}
