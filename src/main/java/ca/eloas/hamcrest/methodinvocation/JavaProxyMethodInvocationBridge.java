package ca.eloas.hamcrest.methodinvocation;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * @author JP
 */
public class JavaProxyMethodInvocationBridge implements MethodInvocation {

    public Object[] getArguments() {
        return new String[] { "foo", "bar" };
    }

    public Method getMethod() {
        return null;
    }

    public Object proceed() throws Throwable {
        return null;
    }

    public Object getThis() {
        return null;
    }

    public AccessibleObject getStaticPart() {
        return null;
    }
}
