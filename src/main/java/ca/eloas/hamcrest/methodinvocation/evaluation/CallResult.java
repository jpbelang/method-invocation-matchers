package ca.eloas.hamcrest.methodinvocation.evaluation;

/**
 * @author JP
 */
public class CallResult {


    private Object value;
    private boolean returnedValue;


    public void returnValue(Object o) {

        this.value = o;
        this.returnedValue = true;
    }

    public void startEvaluation() {

        returnedValue = false;
    }
}
