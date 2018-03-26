package sap.com.travelguide.interactor;

/**
 * Created by I344065 on 2018. 01. 18..
 */

public abstract class Event {

    private int code;
    private Throwable throwable;

    public Event() {
    }

    public Event(int code, Throwable throwable) {
        this.code = code;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

}
