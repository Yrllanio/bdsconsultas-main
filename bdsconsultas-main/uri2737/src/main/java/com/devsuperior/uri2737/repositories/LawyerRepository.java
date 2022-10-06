package com.devsuperior.uri2737.repositories;

import com.devsuperior.uri2737.projections.LawyerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2737.entities.Lawyer;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {

    @Query(nativeQuery = true, value = "(select l.name , l.customers_number as customersNumber from lawyers l where l.customers_number = ( " +
            "select max(l2.customers_number) from lawyers l2)) " +
            "union all " +
            "(select l.name , l.customers_number  from lawyers l where l.customers_number = ( " +
            "select min(l2.customers_number) from lawyers l2)) " +
            "union all " +
            "(select 'Average', round(AVG(l.customers_number),0) from lawyers l)")
    List<LawyerMinProjection> search1();

}
