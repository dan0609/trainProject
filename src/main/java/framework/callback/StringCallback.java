package framework.callback;

public interface StringCallback {
    void success(String result);
    void failure(int errorCode, String msg);

}
