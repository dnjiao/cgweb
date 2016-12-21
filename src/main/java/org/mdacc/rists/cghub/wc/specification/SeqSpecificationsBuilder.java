/**
 * 
 */
package org.mdacc.rists.cghub.wc.specification;

import java.util.ArrayList;
import java.util.List;

import org.mdacc.rists.cghub.ws.model.SeqTb;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

/**
 * @author djiao
 *
 */
public class SeqSpecificationsBuilder {
	private final List<SearchCriteria> params;
	 
    public SeqSpecificationsBuilder() {
        params = new ArrayList<SearchCriteria>();
    }
 
    public SeqSpecificationsBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }
 
    public Specification<SeqTb> build() {
        if (params.size() == 0) {
            return null;
        }
 
        List<Specification<SeqTb>> specs = new ArrayList<Specification<SeqTb>>();
        for (SearchCriteria param : params) {
            specs.add(new SeqSpecification(param));
        }
 
        Specification<SeqTb> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = Specifications.where(result).and(specs.get(i));
        }
        return result;
    }
}
