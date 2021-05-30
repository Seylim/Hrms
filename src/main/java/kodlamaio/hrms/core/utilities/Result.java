package kodlamaio.hrms.core.utilities;

public class Result {
    private boolean Success;
    private String message;

    public Result(boolean Success){
        this.Success = Success;
    }

    public Result(boolean Success, String message){
        this(Success);
        this.message = message;
    }

    public boolean isSuccess(){
        return this.Success;
    }

    public String getMessage() {
        return message;
    }
}
