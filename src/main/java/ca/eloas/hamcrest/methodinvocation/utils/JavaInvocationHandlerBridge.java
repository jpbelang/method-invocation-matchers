package ca.eloas.hamcrest.methodinvocation.utils;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author JP
 */
abstract public class JavaInvocationHandlerBridge implements MethodInterceptor, InvocationHandler {

    public Object invoke(final Object o, final Method method, final Object[] objects) throws Throwable {
        return invoke(new JavaProxyMethodInvocation(o, method, objects));
    }

}
