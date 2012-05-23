package ca.eloas.hamcrest.methodinvocation;

import org.aopalliance.intercept.MethodInvocation;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * @author JP
 */
public class MethodInvocationMatcher {
    
    public static Matcher methodName(final Matcher<String> m) {
        
        return new TypeSafeMatcher<MethodInvocation>() {

            public void describeTo(Description description) {

                description.appendText("method name " );
                description.appendDescriptionOf(m);
            }

            @Override
            protected boolean matchesSafely(MethodInvocation item) {

                return m.matches(item.getMethod().getName());
            }
        };
    }

    public static Matcher methodClass(final Matcher<Class> m) {

        return new TypeSafeMatcher<MethodInvocation>() {

            public void describeTo(Description description) {

                description.appendText("method class " );
                description.appendDescriptionOf(m);
            }

            @Override
            protected boolean matchesSafely(MethodInvocation item) {

                return m.matches(item.getMethod().getDeclaringClass());
            }
        };
    }

}
