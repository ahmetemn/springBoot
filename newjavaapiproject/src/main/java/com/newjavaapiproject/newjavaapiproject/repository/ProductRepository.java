package com.newjavaapiproject.newjavaapiproject.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.newjavaapiproject.newjavaapiproject.repository.entity.Product;

//7işlemleri yapıcaz burada 

@Repository
// @Repository anotasyonu, Spring Data JPA ve Spring JDBC gibi veritabanı erişim
// teknolojileriyle entegrasyon sağlar. Bu anotasyonu bir sınıfa eklediğinizde,
// Spring otomatik olarak bu sınıftan bir bean oluşturur ve veritabanı
// işlemlerini gerçekleştirmek için kullanılabilir hale getirir.
public interface ProductRepository extends JpaRepository<Product, Long> { /// Product entitiy işaret eder// Long ise 64
                                                                          /// bitlik bir sayıdır ?

    // burada product yazmamız methodun dönüş tipini belirlemek
    Product getByProductIdAndDeletedFalse(Long productId); /// Parametre oalrak verilen product id ile database deki
                                                           /// isdeleted false ise kaydı getir

    List<Product> getAllByDeletedFalse();// isdeleted alanı false olanların hepsini çekicek

}
