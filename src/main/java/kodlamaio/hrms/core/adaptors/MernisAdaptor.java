package kodlamaio.hrms.core.adaptors;

import kodlamaio.hrms.Mernis.VCPKPSPublicSoap;
import kodlamaio.hrms.core.services.MernisService;
import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

@Service
public class MernisAdaptor implements MernisService {
    @Override
    public boolean IfRealPerson(Candidate candidate) throws Exception {
        VCPKPSPublicSoap proxy = new VCPKPSPublicSoap();
        return proxy.TCKimlikNoDogrula(Long.parseLong(candidate.getNationalIdNumber()),candidate.getFirstName(),candidate.getLastName(), candidate.getYearOfBirth());
    }
}
