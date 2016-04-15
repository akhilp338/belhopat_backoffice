package com.belhopat.backoffice.repository;

import java.util.List;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.belhopat.backoffice.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long>, DataTablesRepository<State, Long> {

	List<State> findByCountry(Long countryId);
}
