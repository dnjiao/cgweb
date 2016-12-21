package org.mdacc.rists.cghub.ws.service;

import java.util.List;

import org.mdacc.rists.cghub.ws.model.SeqTb;
import org.mdacc.rists.cghub.ws.vo.SeqTbVo;

public interface SeqService {
	List<SeqTbVo> findAll();
	SeqTbVo findByAnalysisId(String analysisId);
}
