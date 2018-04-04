package edu.stanford.nlp.stanford_corenlp;

import TaggerExample.Tagger;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class TaggerTest{
	 	
		@Test
	    public void tag() throws IOException, ClassNotFoundException, ParserConfigurationException, SAXException {
	        Tagger tagging = new Tagger();
	        //tagging.tag("If you have several test classes, you can combine them into a test suite.");
	        tagging.tag("It will rain tomorrow");
	        tagging.tag("It is going to rain tomorrow");
	        tagging.tag("It might rain tomorrow");
	        tagging.tag("Rain is expected tomorrow");
	        tagging.tag("india won the t20 world cup");
	        tagging.tag("india was the t20 world cup champion");
	        tagging.tag("He played well yesterday");
	        
	        
	        
	    }

}
