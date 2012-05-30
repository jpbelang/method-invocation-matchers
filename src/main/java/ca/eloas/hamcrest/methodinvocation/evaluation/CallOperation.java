package ca.eloas.hamcrest.methodinvocation.evaluation;

import org.aopalliance.intercept.MethodInvocation;

/**
 * @author JP
 */
public interface CallOperation {


    public Object doOperation(MethodInvocation mi);
}
