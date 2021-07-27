package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Resume;

import java.util.List;

public interface CandidateService {
    Result register(Candidate candidate) throws Exception;
    Result delete(int id);
    DataResult<List<Candidate>> getAll();
    DataResult<Candidate> getById(int id);
}
