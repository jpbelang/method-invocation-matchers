package ca.eloas.hamcrest.methodinvocation;

import org.aopalliance.intercept.MethodInvocation;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.lang.reflect.Method;

/**
 * @author JP
 */
public class MethodMatcher {

    public static Matcher<Method> name(final Matcher<String> matcher) {

        return new TypeSafeMatcher<Method>() {
            public void describeTo(Description description) {

                description.appendText("name ");
                description.appendDescriptionOf(matcher);
            }

            @Override
            protected boolean matchesSafely(Method item) {
                return matcher.matches(item.getName());
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

    public static Matcher<Method> declaredArguments(final Matcher matcher) {

        return new TypeSafeMatcher<Method>() {
            public void describeTo(Description description) {

                description.appendText("declared arguments ");
                description.appendDescriptionOf(matcher);
            }

            @Override
            protected boolean matchesSafely(Method item) {
                return matcher.matches(item.getParameterTypes());
            }
        };
    }

    public static Matcher<Method> returnType(final Matcher<Class> matcher) {

        return new TypeSafeMatcher<Method>() {
            public void describeTo(Description description) {

                description.appendText("declared arguments ");
                description.appendDescriptionOf(matcher);
            }

            @Override
            protected boolean matchesSafely(Method item) {
                return matcher.matches(item.getReturnType());
            }
        };
    }


}
