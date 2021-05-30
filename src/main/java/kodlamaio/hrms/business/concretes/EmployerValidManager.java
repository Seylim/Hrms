package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerValidService;
import kodlamaio.hrms.core.business.BusinessRules;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Service;

@Service
public class EmployerValidManager implements EmployerValidService {
    @Override
    public Result validate(Employer employer) throws Exception {
        Result[] results = BusinessRules.Run(checkCompanyNameNotNull(employer.getCompanyName()),checkWebSiteNotNull(employer.getWebAdrress()),
                checkEmailNotNul(employer.getEmail()), checkPhoneNumberNotNull(employer.getPhoneNumber()),
                checkPassword(employer.getPassword()), checkPasswordAgain(employer.getPasswordAgain()));
        for (Result result:results){
            if (!result.isSuccess()){
                return result;
            }
        }

        return new SuccessResult();
    }

    private Result checkCompanyNameNotNull(String companyName){
        if (companyName == null){
            return new ErrorResult("Şirket ismi alanı boş bırakılamaz.");
        }
        return new SuccessResult();
    }

    private Result checkWebSiteNotNull(String webSite){
        if (webSite == null){
            return new ErrorResult("Web sitesi alanı boş bırkaılamaz.");
        }
        return new SuccessResult();
    }

    private Result checkEmailNotNul(String eMail){
        if (eMail == null){
            return new ErrorResult("Email alanı boş bırakılamaz.");
        }
        return new SuccessResult();
    }

    private Result checkPhoneNumberNotNull(String phoneNumber){
        if (phoneNumber == null){
            return new ErrorResult("Telefon alanı boş bırakılamaz.");
        }
        return new SuccessResult();
    }

    private Result checkPassword(String password){
        if (password == null){
            return new ErrorResult("Parola alanı boş bırakılamaz.");
        }
        return new SuccessResult();
    }

    private Result checkPasswordAgain(String passwordAgain){
        if (passwordAgain == null){
            return new ErrorResult("Parola tekrarı alanı boş bırakılamaz.");
        }
        return new SuccessResult();
    }
}
