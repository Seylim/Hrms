package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.SystemEmployeeService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemEmployeeDao;
import kodlamaio.hrms.entities.concretes.SystemEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemEmployeeManager implements SystemEmployeeService {

    private SystemEmployeeDao systemEmployeeDao;

    @Autowired
    public SystemEmployeeManager(SystemEmployeeDao systemEmployeeDao){
        this.systemEmployeeDao = systemEmployeeDao;
    }

    @Override
    public DataResult<List<SystemEmployee>> getAll() {
        return new SuccessDataResult<List<SystemEmployee>>(this.systemEmployeeDao.findAll(),"Başarıyla listelendi.");
    }

    @Override
    public Result add(SystemEmployee systemEmployee) {
        this.systemEmployeeDao.save(systemEmployee);
        return new SuccessResult("Kayıt başarılı.");
    }

    @Override
    public Result delete(int id) {
        this.systemEmployeeDao.deleteById(id);
        return new SuccessResult("Kayıt silindi.");
    }
}
