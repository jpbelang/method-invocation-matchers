package ca.eloas.hamcrest.methodinvocation;

import org.aopalliance.intercept.MethodInvocation;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static ca.eloas.hamcrest.methodinvocation.MethodInvocationMatcher.methodName;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author JP
 */
public class MethodInvocationMatcherTest {

    public interface Fun {
        
        public void methodOne();
    }
    
    @Test
    public void justForFun() throws Exception {
        
        Mockery m = new Mockery();
        final MethodInvocation mi = m.mock(MethodInvocation.class);
        m.checking(new Expectations() {
           
            {
                one(mi).getMethod(); will(returnValue(Fun.class.getMethod("methodOne")));
            }
           
        });
        
        Matcher match = methodName(is("methodOne"));
        System.err.println(match);
        match.matches(mi);
        m.assertIsSatisfied();
    }
    
    

    

}
