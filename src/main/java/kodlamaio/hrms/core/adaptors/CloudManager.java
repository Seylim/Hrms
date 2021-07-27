package kodlamaio.hrms.core.adaptors;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrms.core.services.CloudService;
import kodlamaio.hrms.core.utilities.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class CloudManager implements CloudService {

    private final Cloudinary cloudinary;
    public CloudManager() {
         cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dkuo6uhq4",
                "api_key", "737194858582369",
                "api_secret", "3wqASrdSoiIKb9btTi5g9RM_Ea0",
                "secure", true));
    }

    @Override
    public Result upload(File file) {
        try{
            Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            return new SuccessResult("Yükleme Başarılı");
        }
        catch (IOException e) {
            e.printStackTrace();
            return new ErrorResult("Yükleme Başarısız");
        }
    }

    @Override
    public Result delete(String id) throws IOException {
        Map result = cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
        return new SuccessResult();
    }
}
