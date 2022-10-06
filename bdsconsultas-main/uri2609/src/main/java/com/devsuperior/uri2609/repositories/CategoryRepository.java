package com.devsuperior.uri2609.repositories;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2609.entities.Category;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(nativeQuery = true, value = "select c.name , sum(p.amount) " +
            "from categories c " +
            "inner join products p ON p.id_categories = c.id " +
            "group by c.name")
    List<CategorySumProjection> search1();

    @Query("select new com.devsuperior.uri2609.dto.CategorySumDTO(obj.category.name, sum(obj.amount)) " +
            "from Product obj " +
            "group by obj.category.name")
    List<CategorySumDTO> search2();

}
