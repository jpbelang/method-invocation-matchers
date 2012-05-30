package ca.eloas.hamcrest.methodinvocation;

import org.aopalliance.intercept.MethodInvocation;

/**
 * @author JP
 */
public class OnCall {

    private Verifications verifications;

    public OnCall(Verifications v) {

        this.verifications = v;
    }

    static OnCall onCall(Verifications v) {

        return new OnCall(v);
    }

    public Object check(MethodInvocation mi) {

        return verifications.checkAllAndFail(mi);
    }
}
