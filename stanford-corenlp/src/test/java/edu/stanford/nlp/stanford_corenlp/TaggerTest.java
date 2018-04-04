package edu.stanford.nlp.stanford_corenlp;

import TaggerExample.Tagger;

import java.io.IOException;

import org.junit.Test;

public class TaggerTest{
	 	
		@Test
	    public void tag() throws IOException, ClassNotFoundException {
	        Tagger tagging = new Tagger();
	        //tagging.tag("If you have several test classes, you can combine them into a test suite.");
	        tagging.tag("It will rain tomorrow");
	        tagging.tag("It is going to rain tomorrow");
	        tagging.tag("It might rain tomorrow");
	        tagging.tag("Rain is expected tomorrow");
	        tagging.tag("india won the t20 world cup");
	    }

}
