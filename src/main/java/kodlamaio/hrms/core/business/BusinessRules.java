package kodlamaio.hrms.core.business;

import kodlamaio.hrms.core.utilities.Result;

import java.util.ArrayList;
import java.util.List;

public class BusinessRules {
    public static Result[] Run(Result... logics){
        List<Result> results = new ArrayList<Result>();
        for (Result logic:logics){
            if (!logic.isSuccess()) {
                results.add(logic);
            }
        }
        return results.toArray(new Result[results.size()]);
    }
}
