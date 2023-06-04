# Hrms

Hrms, iş veya çalışan arayanların kullanabileceği bir internet uygulamasıdır.

## Amaç

Bu proje, iş arayanların ilanlara başvurabileceği ve işverenlerin iş ilanları yayınlayabileceği bir platform sağlamayı hedefler. Hrms, kullanıcıların iş deneyimlerini ve becerilerini paylaşmalarına, iş ilanlarını görüntülemelerine ve işverenlerle iletişim kurmalarına olanak tanır.

## Kullanılan Teknolojiler

- Java: Uygulama geliştirmek için kullanılan bir programlama dilidir.
- Spring Boot: Java tabanlı bir framework'tür ve hızlı bir şekilde web uygulamaları geliştirmek için kullanılır.
- JpaRepository: Veritabanı işlemlerini kolaylaştıran bir Spring Boot kütüphanesidir.
- PostgreSQL: Veritabanı yönetim sistemi olarak kullanılan bir ilişkisel veritabanıdır.
- Cloudinary: Bulut tabanlı depolama hizmetiyle resimlerin yüklenmesi ve yönetilmesi için kullanılır.

## Projeyi Geliştirmenin Faydaları

- Java programlama dilini pratik etmek ve güçlü bir web uygulaması geliştirmek.
- Spring Boot framework'ünü öğrenmek ve hızlı ve etkili bir şekilde web uygulamaları geliştirmek.
- JpaRepository kullanarak veritabanı işlemlerini kolaylaştırmak ve veritabanı işlemlerini pratik etmek.
- JWT kullanarak rol bazlı yetki yapısını öğrenmek ve uygulamaya entegre etmek.
- PostgreSQL teknolojisini pratik etmek ve veritabanı işlemlerini gerçekleştirmek.
- Cloudinary ile bulut tabanlı depolama konusunda deneyim kazanmak ve resimlerin yönetimini sağlamak.

## Kurulum

1. Bu depoyu yerel makinenize klonlayın.
2. Bir Java IDE'si (ör. IntelliJ IDEA, Eclipse) kullanarak projeyi açın.
3. PostgreSQL veritabanınızı oluşturun ve bağlantı ayarlarını yapılandırın.
4. Gerekli bağımlılıkları yüklemek için Maven veya Gradle projeyi senkronize edin.
5. Uygulamayı başlatın ve API'yi kullanmaya başlayın.

## API Kullanımı

API'yi kullanmak için aşağıdaki adımları takip edin:

1. **Kullanıcı Kaydı:** Kullanıcı kaydı için `/api/register` endpointini kullanın.
2. **Kullanıcı Girişi:** Kullanıcı girişi için `/api/login` endpointini kullanın ve bir JWT token alın.
3. **İş İlanları:** Tüm iş ilanlarını listelemek için `/api/jobAdvertisements` endpointini kullanın.
4. **İş İlanı Detayı:** Belirli bir iş ilanının detaylarını görmek için `/api/jobAdvertisements/{id}` endpointini kullanın.
5. **İş İlanı Ekleme:** Kendi iş ilanınızı eklemek için `/api/jobAdvertisements` endpointini kullanın.
6. **İş İlanı Düzenleme:** Var olan bir iş ilanını düzenlemek için `/api/jobAdvertisements/{id}` endpointini kullanın.
7. **İş İlanı Silme:** Var olan bir iş ilanını silmek için `/api/jobAdvertisements/{id}` endpointini kullanın.

Daha fazla API endpointi ve kullanımı için lütfen API dokümantasyonuna başvurun.
