package TaggerExample;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.io.IOException;

public class Tagger{

    public void tag(String text) throws IOException, ClassNotFoundException {

        MaxentTagger maxentTagger = new MaxentTagger("edu/stanford/nlp/models/pos-tagger/english-left3words/english-left3words-distsim.tagger");
    	//MaxentTagger maxentTagger = new MaxentTagger("edu/stanford/nlp/models/pos-tagger/wsj-0-18-bidirectional-distsim.tagger");
    	String tag = maxentTagger.tagString(text);
        System.out.println(tag);
        String[] eachTag = tag.split("\\s+");
        System.out.println("Word      " + "Standford tag");
        System.out.println("----------------------------------");
        for(int i = 0; i< eachTag.length; i++) {
            System.out.println(eachTag[i].split("_")[0] +"           "+ eachTag[i].split("_")[1]);
        }

    }
}