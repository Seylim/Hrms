package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateValidService {
    Result validate(Candidate candidate) throws Exception;
}
