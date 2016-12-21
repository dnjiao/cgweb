package org.mdacc.rists.cghub.ws.repository;

import java.util.List;

import org.mdacc.rists.cghub.ws.model.SeqTb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SeqRepository extends JpaRepository<SeqTb, Integer>, JpaSpecificationExecutor<SeqTb> {

	public List<SeqTb> findAll();
	public SeqTb findByAnalysisId(String analysisId);
}
