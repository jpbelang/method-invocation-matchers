package ca.eloas.hamcrest.methodinvocation;

import org.aopalliance.intercept.MethodInvocation;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsArray;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static ca.eloas.hamcrest.methodinvocation.MethodInvocationMatcher.arguments;
import static ca.eloas.hamcrest.methodinvocation.MethodInvocationMatcher.method;
import static ca.eloas.hamcrest.methodinvocation.MethodInvocationMatcher.thisObject;
import static ca.eloas.hamcrest.methodinvocation.MethodMatcher.name;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.array;
import static org.junit.Assert.assertTrue;

/**
 * @author JP
 */
public class MethodInvocationMatcherTest {

    public interface Fun {
        
        public void methodOne();
    }
    
    @Test
    public void methodtest() throws Exception {
        
        Mockery m = new Mockery();
        final MethodInvocation mi = m.mock(MethodInvocation.class);
        m.checking(new Expectations() {
           
            {
                one(mi).getMethod(); will(returnValue(Fun.class.getMethod("methodOne")));
            }
           
        });
        
        assertTrue(method(name(is("methodOne"))).matches(mi));
        m.assertIsSatisfied();
    }

    @Test
    public void thistarget() throws Exception {

        Mockery m = new Mockery();
        final MethodInvocation mi = m.mock(MethodInvocation.class);
        final String target = "foo";

        m.checking(new Expectations() {

            {
                one(mi).getThis(); will(returnValue(target));
            }

        });

        assertTrue(thisObject(is("foo")).matches(mi));
        m.assertIsSatisfied();
    }

    @Test
    public void check_arguments() throws Exception {

        Mockery m = new Mockery();
        final MethodInvocation mi = m.mock(MethodInvocation.class);
        final Object[] target = {"foo", "bar"};

        m.checking(new Expectations() {

            {
                one(mi).getArguments(); will(returnValue(target));

            }

        });

        assertTrue(arguments(array(is("foo"), is("bar"))).matches(mi));
        m.assertIsSatisfied();
    }

    

}
