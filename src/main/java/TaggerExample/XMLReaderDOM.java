package TaggerExample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XMLReaderDOM {

    public static List<News> getNewz() throws ParserConfigurationException, SAXException {
        String filePath = "NewsCorpus.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        List<News> nwsList = new ArrayList<News>();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("news");
            //now XML is loaded as Document in memory, lets convert it to Object List
            
            for (int i = 0; i < nodeList.getLength(); i++) {
            	nwsList.add(getNews(nodeList.item(i)));
            }
            //lets print Employee list information
            for (News nws : nwsList) {
                //System.out.println(nws.toString());
            }
            return nwsList;
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return nwsList;
    }


    private static News getNews(Node node) {
        //XMLReaderDOM domReader = new XMLReaderDOM();
        News nws = new News();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            nws.setTitle(getTagValue("title", element));
            nws.setContent(getTagValue("content", element));
        }
        return nws;
    }


    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

}