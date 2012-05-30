package ca.eloas.hamcrest.methodinvocation;

import org.aopalliance.intercept.MethodInvocation;
import org.hamcrest.Description;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.lang.reflect.Method;

/**
 * @author JP
 */
public class MethodMatcher {

    public static Matcher<Method> name(final Matcher<String> matcher) {

        return new FeatureMatcher<Method, String>(matcher, "method", "name") {

            @Override
            protected String featureValueOf(Method actual) {
                return actual.getName();
            }
        };
    }

    public static Matcher<Method> declaringClass(final Matcher<Class> matcher) {

        return new TypeSafeMatcher<Method>() {
            public void describeTo(Description description) {

                description.appendText("declaring class ");
                description.appendDescriptionOf(matcher);
            }

            @Override
            protected boolean matchesSafely(Method item) {
                return matcher.matches(item.getDeclaringClass());
            }
        };
    }


    public static <T> Matcher<Method> declaredArguments(final Matcher<? super T[]> matcher) {

        return new FeatureMatcher<Method, T[]>(matcher, "a matching", "parameter types") {

            @Override
            protected T[] featureValueOf(Method item) {
                return (T[]) item.getParameterTypes();
            }
        };
    }

    public static <T> Matcher<Method> returnType(final Matcher<Class<T>> matcher) {

        return new FeatureMatcher<Method, Class<T>>(matcher, "a matching", "return type") {

            @Override
            protected Class<T> featureValueOf(Method item) {
                return (Class<T>) item.getReturnType();
            }
        };
    }
}
