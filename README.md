# Hibernate Locking Stratejileri - Pessimistic ve Optimistic Locking Örneği

Bu proje, Hibernate’in **Pessimistic** (Kötümser) ve **Optimistic** (İyimser) kilitleme stratejilerini Spring Boot tabanlı bir uygulama üzerinde nasıl kullanabileceğimizi gösteren bir örnek uygulamadır. Veritabanı üzerinde eş zamanlı veri güncellemelerinin nasıl yönetildiğini ve veri tutarlılığının nasıl sağlandığını anlatmayı amaçlamaktadır.

## Proje Amacı

Veritabanı uygulamalarında, aynı verinin birden fazla işlem tarafından aynı anda değiştirilmesi durumu "yarış koşulları" (race conditions) ve veri tutarsızlığına yol açabilir. Bu sorunun çözümü için veritabanı işlemleri sırasında kilitleme (locking) stratejileri kullanılır. Hibernate, iki temel kilitleme stratejisini desteklemektedir:

- **Optimistic Locking**: Eş zamanlı güncellemelere izin verir, ancak veriyi güncellerken bir versiyon kontrolü ile işlemin başarılı olup olmadığını kontrol eder. Bu yaklaşımda kilit, verinin işlem sonunda kontrol edilmesiyle sağlanır.

- **Pessimistic Locking**: Güncellenen veriyi baştan kilitler ve diğer işlemlerin bu veriyi değiştirmesini engeller. Verinin kilidi, işlem süresi boyunca devam eder.

Bu projede, her iki kilitleme stratejisinin ne zaman, nasıl kullanılacağına dair örnekler ve kodlar yer almaktadır. Proje, özellikle çok kullanıcılı sistemlerde veri tutarlılığını sağlama ve yarış koşullarını önleme konularında Hibernate’in sunduğu çözümleri incelemek isteyen geliştiriciler için yararlı olacaktır.

## Proje İçeriği

- **Pessimistic Locking Örneği**: Veritabanı üzerinde satır bazlı kilitleme (row-level locking) mekanizması ile eş zamanlı veri güncellemelerinin nasıl yönetildiğini gösterir.
- **Optimistic Locking Örneği**: Veritabanında versiyon kontrolü ile kilitleme yapılmadan veri tutarlılığının nasıl sağlanacağını gösterir.

## Çalıştırma

Proje standart Spring Boot uygulaması şeklinde çalıştırılabilir. Veritabanı konfigürasyonları için `application.properties` dosyasını düzenlemeniz yeterlidir.

## Detaylı Bilgi İçin
[Hibernate: Optimistic ve Pessimistic Locking Nedir?](https://medium.com/@yunusemrenalbant/hibernate-optimistic-ve-pessimistic-locking-nedir-9429c422ccbd)
