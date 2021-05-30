package kodlamaio.hrms.core.utilities;

public class DataResult<T> extends Result{
    private T data;

    public DataResult(T data, boolean Success) {
        super(Success);
        this.data = data;
    }

    public DataResult(T data, boolean Success, String message) {
        super(Success, message);
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
