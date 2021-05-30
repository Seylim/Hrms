package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateValidService;
import kodlamaio.hrms.core.business.BusinessRules;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

@Service
public class CandidateValidManager implements CandidateValidService {
    @Override
    public Result validate(Candidate candidate) throws Exception {
        Result[] results = BusinessRules.Run(checkFirstNameNotNull(candidate.getFirstName()),checkLastNameNotNull(candidate.getLastName()),
                checkNationalIdNotNull(candidate.getNationalIdNumber()), checkYearOfBirthNotNull(candidate.getYearOfBirth()),
                checkEmailNotNull(candidate.getEmail()),checkPasswordNotNull(candidate.getPassword()),checkPasswordAgainNotNull(candidate.getPasswordAgain()));
        for (Result result:results){
            if (!result.isSuccess()){
                return result;
            }
        }
        return new SuccessResult();
    }

    private Result checkFirstNameNotNull(String firstName){
        if (firstName == null){
            return new ErrorResult("İsim alanı boş bırakılamaz.");
        }
        return new SuccessResult();
    }

    private Result checkLastNameNotNull(String lastName){
        if (lastName == null){
            return new ErrorResult("Soyisim alanı boş bırakılamaz.");
        }
        return new SuccessResult();
    }

    private Result checkNationalIdNotNull(String nationalId){
        if (nationalId.isEmpty() || nationalId == null){
            return new ErrorResult("Kimlik numarası alanı boş bırakılamaz.");
        }
        return new SuccessResult();
    }

    private Result checkYearOfBirthNotNull(int yearOfBirth){
        if (yearOfBirth == 0){
            return new ErrorResult("Doğum yılı alanı boş bırakılamaz.");
        }
        return new SuccessResult();
    }

    private Result checkEmailNotNull(String email){
        if (email == null){
            return new ErrorResult("Email alanı boş bırakılamaz.");
        }
        return new SuccessResult();
    }

    private Result checkPasswordNotNull(String password){
        if (password == null){
            return new ErrorResult("Parola alanı boş bırakılamaz.");
        }
        return new SuccessResult();
    }

    private Result checkPasswordAgainNotNull(String passwordAgain){
        if (passwordAgain == null){
            return new ErrorResult("Parola tekrarı alanı boş bırakılamaz.");
        }
        return new SuccessResult();
    }
}
