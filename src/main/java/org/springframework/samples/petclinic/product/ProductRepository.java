package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAll();

    @Query("SELECT pt FROM ProductType pt")
    List<ProductType> findAllProductTypes();

    @Query("SELECT pt FROM ProductType pt WHERE pt.name = :name")
    ProductType findProductType(@Param("name") String name);

    @Query("SELECT p FROM Product p WHERE p.price < :coste")
    List<Product> findByPriceLessThan(@Param("coste") double coste);

    Optional<Product> findById(int id);
    Product findByName(String name);
    Product save(Product p);
}
