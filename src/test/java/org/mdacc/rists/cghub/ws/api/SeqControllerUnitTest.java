/**
 * 
 */
package org.mdacc.rists.cghub.ws.api;

import static org.junit.Assert.*;

import java.util.regex.Matcher;

import org.junit.Test;

/**
 * @author djiao
 *
 */
public class SeqControllerUnitTest {

	@Test
	public void test() {
		final String str = "analysisId:fdebfd6e-d046-4192-8b97-ac9f65dc2009";
		Matcher matcher = SeqController.getMatcherFromString(str);
		int counter = 0;
        while (matcher.find()) {
        	counter++;
            System.out.println(matcher.group(1) + " " + matcher.group(2) + " " + matcher.group(3));
        }
        System.out.println(counter);
        assertEquals(counter, 1);
	}

}
