package ca.eloas.hamcrest.methodinvocation;

import org.aopalliance.intercept.MethodInvocation;
import org.hamcrest.Matcher;

/**
 * @author JP
 */
public class CallLike {
    
    public static Object callLike(MethodInvocation actual, Matcher matcher, MethodInvocation invoke) throws Throwable {
        
        if  ( matcher.matches(actual)) {
            
            return invoke.proceed();
        } else {
            
            throw new RuntimeException();
        }
    }
}
