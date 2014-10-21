package temp;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by student on 10/21/2014.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder ;
        try {
            documentBuilder = dbFactory.newDocumentBuilder();
            Document doc = documentBuilder.newDocument();
            Element rootElement = doc.createElementNS("www.ya.ua", "banks");
            doc.appendChild(rootElement);

//            rootElement.appendChild(getBankNetwork(doc, "sfera", "UAback", "prvat", "aasdfsdf" ));
//            rootElement.appendChild(getBankNetwork(doc, "sfera", "UAback2", "prvat2", "aasdfsdf2" ));

            rootElement.appendChild(getBankElements(doc, "sfera",  "prvat", "aasdfsdf" ));
            rootElement.appendChild(getBankElements(doc, "sfera3",  "prvat3", "aasdfsdf3" ));
            rootElement.appendChild(getBankElements(doc, "sfera",  "prvat111", "aasdfsdf111" ));


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult file = new StreamResult(new File("src/main/banks.xml"));
            transformer.transform(source, file);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }
//    private static Node getBankNetwork(Document doc, String networkName, String bank, String name , String link){
//        Element network = doc.createElement("network");
//        network.setAttribute("name", networkName);
//        network.appendChild(getBankElements(doc, "bank", bank));
//        network.appendChild(getBankElements(doc, "name", name));
//        network.appendChild(getBankElements(doc, "link", link ));
//
//        return network;
//    }

    private static Node getBankElements(Document doc, String networkName,  String bankName, String link) {
        Element network = doc.createElement("network");
        Element bank = doc.createElement("bank");
        Element nameB = doc.createElement("name");
        Element linkB = doc.createElement("link");
        network.setAttribute("name" , networkName);

        network.appendChild(bank);
        bank.appendChild(nameB);
        bank.appendChild(doc.createTextNode(bankName));
        linkB.appendChild(doc.createTextNode(link));
        bank.appendChild(linkB);

        return network;



//        Element node = doc.createElement(name);
//        node.appendChild(doc.createTextNode(value));
//        return node;
    }
}
