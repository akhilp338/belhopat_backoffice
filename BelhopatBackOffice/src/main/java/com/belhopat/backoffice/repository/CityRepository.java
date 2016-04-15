package com.belhopat.backoffice.repository;

import java.util.List;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.belhopat.backoffice.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>, DataTablesRepository<City, Long> {

	@Query("select c from City c where c.state.id =:stateId")
	List<City> findByState(@Param("stateId") Long stateId);

}
