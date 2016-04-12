package com.belhopat.backoffice.repository;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.belhopat.backoffice.model.OfficialDetails;

@Repository
public interface OfficialDetailsRepository extends JpaRepository<OfficialDetails, Long>, DataTablesRepository<OfficialDetails, Long> {}
