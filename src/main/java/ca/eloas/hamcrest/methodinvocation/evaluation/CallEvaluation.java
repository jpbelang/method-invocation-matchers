package ca.eloas.hamcrest.methodinvocation.evaluation;

import org.aopalliance.intercept.MethodInvocation;
import org.hamcrest.Matcher;

/**
 * @author JP
 */
public class CallEvaluation {


    private Matcher<MethodInvocation> matcher;
    private CallOperation operation;

    public CallEvaluation(Matcher<MethodInvocation> m) {

        this.matcher = m;
    }

    void then(CallOperation o) {

        this.operation = o;
    }

    public boolean matches(MethodInvocation mi) {

        return matcher.matches(mi);
    }

    public Object operate(MethodInvocation mi) {

        return operation.doOperation(mi);
    }
}
