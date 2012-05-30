package ca.eloas.hamcrest.methodinvocation.matchers;

import org.aopalliance.intercept.MethodInvocation;
import org.hamcrest.Description;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.lang.reflect.Method;

/**
 * @author JP
 */
public class MethodInvocationMatcher {
    
    
    public static Matcher<MethodInvocation> method(final Matcher<Method> matcher) {

        return new FeatureMatcher<MethodInvocation, Method>(matcher, "an invocation with method ", "method") {

            @Override
            protected Method featureValueOf(MethodInvocation actual) {
                return actual.getMethod();
            }

        };
    }

    public static  <T> Matcher<MethodInvocation> thisObject(final Matcher<? super T> matcher) {

        return new FeatureMatcher<MethodInvocation, T>(matcher, "an invocation with method ", "this") {

            @Override
            protected T featureValueOf(MethodInvocation actual) {
                return (T) actual.getThis();
            }

        };
    }

    public static <T> Matcher<MethodInvocation> arguments(final Matcher<? super T[]> matcher) {

        return new FeatureMatcher<MethodInvocation, T[]>(matcher, "an invocation with method ", "arguments") {

            @Override
            protected T[] featureValueOf(MethodInvocation actual) {
                return (T[]) actual.getArguments();
            }

        };
    }

}
