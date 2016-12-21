package org.mdacc.rists.cghub.ws.service;

import java.util.ArrayList;
import java.util.List;

import org.mdacc.rists.cghub.ws.model.SeqTb;
import org.mdacc.rists.cghub.ws.repository.SeqRepository;
import org.mdacc.rists.cghub.ws.vo.SeqTbVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeqServiceBean implements SeqService {
	
	@Autowired
	private SeqRepository seqRepository;
	
	public List<SeqTbVo> findAll() {
		List<SeqTb> seqs = seqRepository.findAll();
		List<SeqTbVo> seqVos = new ArrayList<SeqTbVo>();
		for (SeqTb seq : seqs) {
			seqVos.add(new SeqTbVo(seq));
		}
		return seqVos;
	}

	public SeqTbVo findByAnalysisId(String analysisId) {
		SeqTb seq = seqRepository.findByAnalysisId(analysisId);
		SeqTbVo seqVo = new SeqTbVo(seq);
		return seqVo;
	}

}
