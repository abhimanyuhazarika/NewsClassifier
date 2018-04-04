package TaggerExample;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Tagger{

    public static void main (String[] args) throws IOException, ClassNotFoundException, ParserConfigurationException, SAXException {

        MaxentTagger maxentTagger = new MaxentTagger("edu/stanford/nlp/models/pos-tagger/english-left3words/english-left3words-distsim.tagger");
    	//MaxentTagger maxentTagger = new MaxentTagger("wsj-0-18-bidirectional-distsim.tagger");
        List<News> nwsList = new ArrayList<News>();
        nwsList = XMLReaderDOM.getNewz();
        Map<String,Boolean> modalCount = new HashMap<String,Boolean>();
        Map<String,Boolean> modalCountTmp = new HashMap<String,Boolean>();
        for (News nws : nwsList) {
	        String tag = maxentTagger.tagString(nws.getContent());
	        //System.out.println(tag);
	        String[] eachTag = tag.split("\\s+");
	        //System.out.println("Word      " + "Standford tag");
	        //System.out.println("----------------------------------");
	        for(int i = 0; i< eachTag.length; i++) {
	        	if(eachTag[i].split("_")[1].equals("MD"))
	        	{
	        		modalCount.put(nws.getTitle(), true);
	        	}
	           // System.out.println(eachTag[i].split("_")[0] +"           "+ eachTag[i].split("_")[1]);
	        }
        }
       
        		for (Map.Entry<String, Boolean> entry : modalCount.entrySet())
        		{
        		    System.out.println(entry.getKey() + "/" + entry.getValue());
        		}
        		

    }
    
    public void tag(String text) throws IOException, ClassNotFoundException, ParserConfigurationException, SAXException {

        MaxentTagger maxentTagger = new MaxentTagger("edu/stanford/nlp/models/pos-tagger/english-left3words/english-left3words-distsim.tagger");
    	//MaxentTagger maxentTagger = new MaxentTagger("wsj-0-18-bidirectional-distsim.tagger");
        List<News> nwsList = new ArrayList<News>();
        nwsList = XMLReaderDOM.getNewz();
        //for (News nws : nwsList) {
	        String tag = maxentTagger.tagString(text);
	        System.out.println(tag);
	        String[] eachTag = tag.split("\\s+");
	        System.out.println("Word      " + "Standford tag");
	        System.out.println("----------------------------------");
	        for(int i = 0; i< eachTag.length; i++) {
	            System.out.println(eachTag[i].split("_")[0] +"           "+ eachTag[i].split("_")[1]);
	        }
       // }

    }
}
