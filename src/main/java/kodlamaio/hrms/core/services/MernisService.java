package kodlamaio.hrms.core.services;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface MernisService {
    public boolean IfRealPerson(Candidate candidate) throws Exception;
}
