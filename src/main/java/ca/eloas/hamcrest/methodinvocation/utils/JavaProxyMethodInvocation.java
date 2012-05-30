package ca.eloas.hamcrest.methodinvocation.utils;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
* @author JP
*/
class JavaProxyMethodInvocation implements MethodInvocation {
    private final Object o;
    private final Method method;
    private final Object[] objects;

    public JavaProxyMethodInvocation(Object o, Method method, Object[] objects) {
        this.o = o;
        this.method = method;
        this.objects = objects;
    }

    public Method getMethod() {

        return method;
    }

    public Object[] getArguments() {
        return objects;
    }

    public Object proceed() throws Throwable {
        return method.invoke(o, objects);
    }

    public Object getThis() {
        return o;
    }

    public AccessibleObject getStaticPart() {
        return null;
    }
}
