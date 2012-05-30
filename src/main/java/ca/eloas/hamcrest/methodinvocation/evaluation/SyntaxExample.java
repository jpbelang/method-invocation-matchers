package ca.eloas.hamcrest.methodinvocation.evaluation;

import ca.eloas.hamcrest.methodinvocation.utils.JavaInvocationHandlerBridge;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Proxy;

import static ca.eloas.hamcrest.methodinvocation.matchers.MethodInvocationMatcher.method;
import static ca.eloas.hamcrest.methodinvocation.matchers.MethodMatcher.name;
import static ca.eloas.hamcrest.methodinvocation.evaluation.OnCall.onCall;
import static org.hamcrest.Matchers.is;

/**
 * @author JP
 */
public class SyntaxExample {

    public interface Idiotic {

        public String foo();
        public Object doo();
    }

    public static void main(String[] args) {

        Idiotic proxy = (Idiotic) Proxy.newProxyInstance(SyntaxExample.class.getClassLoader(), new Class[]{Idiotic.class}, new JavaInvocationHandlerBridge() {
            public Object invoke(MethodInvocation invocation) throws Throwable {
                return onCall(new Verifications() {
                    {

                        iff(method(name(is("foo")))).then(new CallOperation() {
                            public Object doOperation(MethodInvocation mi) {

                                return "String!!!";
                            }
                        });
                        iff(method(name(is("doo")))).then(new CallOperation() {
                            public Object doOperation(MethodInvocation mi) {

                                return "Noooooo!!!";
                            }
                        });

                    }
                }).checkAllAndFail(invocation);
            }
        });

        System.err.println("valued at " + proxy.foo());
        System.err.println("valued at " + proxy.doo());
    }
}
