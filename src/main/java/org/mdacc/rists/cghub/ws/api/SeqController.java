package org.mdacc.rists.cghub.ws.api;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mdacc.rists.cghub.wc.specification.SeqSpecificationsBuilder;
import org.mdacc.rists.cghub.ws.model.SeqTb;
import org.mdacc.rists.cghub.ws.repository.SeqRepository;
import org.mdacc.rists.cghub.ws.service.SeqService;
import org.mdacc.rists.cghub.ws.vo.SeqTbVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/")
public class SeqController {

	@Autowired
	private SeqService seqService;
	
	@Autowired
	private SeqRepository seqRepository;
	
	@RequestMapping( 
			value = "/seqs/{analysis_id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SeqTb> getSeqByAnalysisId(@PathVariable("analysis_id") String analysis_id) {
		SeqTbVo seqVo = seqService.findByAnalysisId(analysis_id);
		return new ResponseEntity(seqVo, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/samples")
    @ResponseBody
    public List<SeqTbVo> search(@RequestParam(value = "search") String search) {
        SeqSpecificationsBuilder builder = new SeqSpecificationsBuilder();
        System.out.println(search);
        Matcher matcher = getMatcherFromString(search);
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
         
        Specification<SeqTb> spec = builder.build();
        List<SeqTb> seqs = seqRepository.findAll(spec);
        List<SeqTbVo> seqVos = new ArrayList<SeqTbVo>();
        for (SeqTb seq : seqs) {
			seqVos.add(new SeqTbVo(seq));
		}
		return seqVos; 
    }

	/**
	 * @param search
	 * @return
	 */
	static Matcher getMatcherFromString(String str) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
		Pattern pattern = Pattern.compile("(\\w+)(:|<|>)([a-zA-Z0-9_-]*),");
        Matcher matcher = pattern.matcher(str + ",");
        return matcher;
	}
}
