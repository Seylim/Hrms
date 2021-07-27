package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Resume;

import java.util.List;

public interface ResumeService {
    Result addResume(Resume resume);
    Result delete(int id);
    DataResult<List<Resume>> getAll();
}
