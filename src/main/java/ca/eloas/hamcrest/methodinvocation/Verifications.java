package ca.eloas.hamcrest.methodinvocation;

import org.aopalliance.intercept.MethodInvocation;
import org.hamcrest.Matcher;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JP
 */
public class Verifications {

    private List<CallEvaluation> evaluations = new ArrayList<CallEvaluation>();

    protected CallEvaluation iff(Matcher<MethodInvocation> m) {

        CallEvaluation ce = new CallEvaluation(m);
        evaluations.add(ce);
        return ce;
    }

    public Object checkAllAndFail(MethodInvocation mi) throws Throwable {

        for (CallEvaluation evaluation : evaluations) {

            if (evaluation.matches(mi) ) {

                return evaluation.operate(mi);
            }
        }

        throw new IllegalStateException("couldn't match a rule!");
    }

    public Object checkAllAndProceed(MethodInvocation mi) throws Throwable {

        for (CallEvaluation evaluation : evaluations) {

            if (evaluation.matches(mi) ) {

                return evaluation.operate(mi);
            }
        }
        return mi.proceed();
    }
}
