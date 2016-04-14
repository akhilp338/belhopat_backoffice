package com.belhopat.backoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.belhopat.backoffice.model.CandidateSequence;

@Repository
public interface CandidateSequenceRepository extends JpaRepository<CandidateSequence, Long> {
}
