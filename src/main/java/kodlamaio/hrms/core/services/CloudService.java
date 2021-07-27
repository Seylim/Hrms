package kodlamaio.hrms.core.services;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface CloudService {
    Result upload(File file);
    Result delete(String id) throws IOException;
}
