package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

import java.util.List;

public interface CandidateService {
    Result register(Candidate candidate) throws Exception;
    DataResult<List<Candidate>> getAll();
    DataResult<Candidate> getById(int id);
}
