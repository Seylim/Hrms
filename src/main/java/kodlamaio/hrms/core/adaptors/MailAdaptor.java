package kodlamaio.hrms.core.adaptors;

import kodlamaio.hrms.core.services.EmailService;
import org.springframework.stereotype.Service;

@Service
public class MailAdaptor implements EmailService {
    @Override
    public boolean sendMail() {
        return true;
    }
}
