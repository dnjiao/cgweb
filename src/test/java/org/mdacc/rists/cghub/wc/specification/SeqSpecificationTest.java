/**
 * 
 */
package org.mdacc.rists.cghub.wc.specification;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdacc.rists.cghub.ws.CgApplication;
import org.mdacc.rists.cghub.ws.model.SeqTb;
import org.mdacc.rists.cghub.ws.repository.SeqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author djiao
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CgApplication.class)
@Transactional
public class SeqSpecificationTest {
	
	@Autowired
	private SeqRepository repository;
	
	private SeqTb seq1;
	private SeqTb seq2;
	
	@Before
	public void init() {
		seq1 = new SeqTb();
		seq1.setAnalysisId("ana001");
		seq1.setDiseaseAbbr("XYZ");
		seq1.setFilename("001.bam");
		seq1.setFilesize(100);
		seq1.setLibrary("WXS");
		seq1.setSeqFormat("bam");
		seq1.setSeqSource("TCGA");
		seq1.setTissueType("normal");
		repository.save(seq1);
		
		seq2 = new SeqTb();
		seq2.setAnalysisId("ana002");
		seq2.setDiseaseAbbr("XYZ");
		seq2.setFilename("002.bam");
		seq2.setFilesize(200);
		seq2.setLibrary("WGS");
		seq2.setSeqFormat("bam");
		seq2.setSeqSource("TCGA");
		seq2.setTissueType("tumor");
		repository.save(seq2);
	}

	@Test
	public void givenDiseaseAndLibrary_whenGettingListOfSeqs_thenCorrect() {
		SeqSpecification spec1 = new SeqSpecification(new SearchCriteria("diseaseAbbr", ":", "XYZ"));
		SeqSpecification spec2 = new SeqSpecification(new SearchCriteria("library", ":", "WGS"));
		List<SeqTb> results = repository.findAll(Specifications.where(spec1).and(spec2));
		assertFalse(results.contains(seq1));
		assertTrue(results.contains(seq2));
	}
	
}
