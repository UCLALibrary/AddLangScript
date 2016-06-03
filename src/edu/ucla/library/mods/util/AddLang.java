/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucla.library.mods.util;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author pghorpade
 */
public class AddLang implements ErrorHandler {

    private static void updateSubject(Node node_level1) {
//        Pattern p = Pattern.compile("\\p{InHebrew}", Pattern.UNICODE_CASE);
//        Matcher m = null;

        boolean hebrewDetected = false;

        if (node_level1.getNodeType() == Node.ELEMENT_NODE && "mods:subject".equals(node_level1.getNodeName())) {
            NodeList children = node_level1.getChildNodes();

            if (null != children && children.getLength() != 0) {
                for (int count1 = 0; count1 < children.getLength(); count1++) {
                    Node node = children.item(count1);
                    // && "mods:title".equals(node.getNodeName())
                    if (node.getNodeType() == Node.ELEMENT_NODE && "mods:topic".equals(node.getNodeName())) {
                        try {
                            hebrewDetected = false;
                            NodeList nodessubjectChildren = node.getChildNodes();
                            if (null != nodessubjectChildren && nodessubjectChildren.getLength() != 0) {
                                System.out.println("node text count :" + nodessubjectChildren.getLength());
                                StringBuilder br = new StringBuilder();
                                for (int count2 = 0; count2 < nodessubjectChildren.getLength(); count2++) {
                                    Node nodetext = nodessubjectChildren.item(count2);
                                    addLangToElement(hebrewDetected, nodetext, node);
//                                    System.out.println("topic text :" + nodetext.getNodeValue());
//                                    for (int i = 0; i < nodetext.getNodeValue().length(); i++) {
//                                        String letter = nodetext.getNodeValue().charAt(i) + "";
//                                        m = p.matcher(letter);
//                                        hebrewDetected = m.matches();
//                                        if (hebrewDetected) {
//                                            break;
//                                        }
//                                    }
//
//                                    System.out.println("hebrewDetected=" + hebrewDetected); //true
//
//                                    if (hebrewDetected) {
//                                        ((Element) node).setAttribute("lang", "heb");
//                                        ((Element) node).setAttribute("script", "Hebr");
//                                    } else {
//                                        ((Element) node).setAttribute("lang", "eng");
//                                    }

                                }

                            }

                        } catch (NullPointerException ex) {
                            ex.printStackTrace();
                        }
                    }

                    if (node.getNodeType() == Node.ELEMENT_NODE && "mods:geographic".equals(node.getNodeName())) {
                        try {
                            hebrewDetected = false;
                            System.out.println("in:" + node.getNodeValue());
                            NodeList nodessubjectChildren = node.getChildNodes();
                            if (null != nodessubjectChildren && nodessubjectChildren.getLength() != 0) {
                                System.out.println("node text count :" + nodessubjectChildren.getLength());
                                for (int count2 = 0; count2 < nodessubjectChildren.getLength(); count2++) {
                                    Node nodetext = nodessubjectChildren.item(count2);
                                    addLangToElement(hebrewDetected, nodetext, node);
//                                    System.out.println("geographic text :" + nodetext.getNodeValue());
//                                    for (int i = 0; i < nodetext.getNodeValue().length(); i++) {
//                                        String letter = nodetext.getNodeValue().charAt(i) + "";
//                                        m = p.matcher(letter);
//                                        hebrewDetected = m.matches();
//                                        if (hebrewDetected) {
//                                            break;
//                                        }
//                                    }
//
//                                    System.out.println("hebrewDetected=" + hebrewDetected); //true
//
//                                    if (hebrewDetected) {
//                                        ((Element) node).setAttribute("lang", "heb");
//                                        ((Element) node).setAttribute("script", "Hebr");
//                                    } else {
//                                        ((Element) node).setAttribute("lang", "eng");
//                                    }

                                }
                            }

                        } catch (NullPointerException ex) {
                            ex.printStackTrace();
                        }
                    }
                }

            }

            //originInfo.appendChild();
        }
    }

    private static void updateTitle(Node node_level1) {

//        Pattern p = Pattern.compile("\\p{InHebrew}", Pattern.UNICODE_CASE);
//        Matcher m = null;

        boolean hebrewDetected = false;
        if (node_level1.getNodeType() == Node.ELEMENT_NODE && "mods:titleInfo".equals(node_level1.getNodeName())) {
            NodeList children = node_level1.getChildNodes();

            if (null != children && children.getLength() != 0) {
                for (int count1 = 0; count1 < children.getLength(); count1++) {
                    Node node = children.item(count1);
                    // 
                    if (node.getNodeType() == Node.ELEMENT_NODE && "mods:title".equals(node.getNodeName())) {
                        try {
                            hebrewDetected = false;
                            // System.out.println("in:" + node.getNodeValue());
                            NodeList nodestitleInfoChildren = node.getChildNodes();
                            if (null != nodestitleInfoChildren && nodestitleInfoChildren.getLength() != 0) {
                                System.out.println("node text count :" + nodestitleInfoChildren.getLength());
                                for (int count2 = 0; count2 < nodestitleInfoChildren.getLength(); count2++) {
                                    Node nodetitletext = nodestitleInfoChildren.item(count2);
                                    addLangToElement(hebrewDetected, nodetitletext, node);
//                                    System.out.println("title text :" + nodetitletext.getNodeValue());
//
//                                    for (int i = 0; i < nodetitletext.getNodeValue().length(); i++) {
//                                        String letter = nodetitletext.getNodeValue().charAt(i) + "";
//                                        m = p.matcher(letter);
//                                        hebrewDetected = m.matches();
//                                        if (hebrewDetected) {
//                                            break;
//                                        }
//                                    }
//
//                                    System.out.println("hebrewDetected=" + hebrewDetected); //true
//
//                                    if (hebrewDetected) {
//                                        ((Element) node).setAttribute("lang", "heb");
//                                        ((Element) node).setAttribute("script", "Hebr");
//                                    } else {
//                                        ((Element) node).setAttribute("lang", "eng");
//                                    }
                                }
                            }

                        } catch (NullPointerException ex) {
                            ex.printStackTrace();
                        }
                    }
                }

            }

            //originInfo.appendChild();
        }
    }

    private static void updateName(Node node_level1) {
//        Pattern p = Pattern.compile("\\p{InHebrew}", Pattern.UNICODE_CASE);
//        Matcher m = null;

        boolean hebrewDetected = false;
        if (node_level1.getNodeType() == Node.ELEMENT_NODE && "mods:name".equals(node_level1.getNodeName())) {
            NodeList children = node_level1.getChildNodes();

            if (null != children && children.getLength() != 0) {
                for (int count1 = 0; count1 < children.getLength(); count1++) {
                    Node node = children.item(count1);
                    //role

                    if (node.getNodeType() == Node.ELEMENT_NODE && "mods:role".equals(node.getNodeName())) {
                        try {
                            NodeList nodesroleChildren = node.getChildNodes();
                            if (null != nodesroleChildren && nodesroleChildren.getLength() != 0) {
                                System.out.println("node role  count :" + nodesroleChildren.getLength());
                                for (int count2 = 0; count2 < nodesroleChildren.getLength(); count2++) {
                                    Node nodeRoleTerm = nodesroleChildren.item(count2);
                                    if (nodeRoleTerm.getNodeType() == Node.ELEMENT_NODE && "mods:roleTerm".equals(nodeRoleTerm.getNodeName())) {
                                        NamedNodeMap maplist = nodeRoleTerm.getAttributes();
                                        if (maplist.getNamedItem("type").getNodeValue().equals("text")) {
                                            hebrewDetected = false;
                                            NodeList nodesroleTermChildren = nodeRoleTerm.getChildNodes();
                                            if (null != nodesroleTermChildren && nodesroleTermChildren.getLength() != 0) {
                                                System.out.println("node role term text count :" + nodesroleTermChildren.getLength());
                                                for (int count3 = 0; count3 < nodesroleTermChildren.getLength(); count3++) {
                                                    Node noderoleTermtext = nodesroleTermChildren.item(count3);
                                                    addLangToElement(hebrewDetected, noderoleTermtext, node);
//                                                    System.out.println("roleTerm text: " + noderoleTermtext.getNodeValue());
//                                                    for (int i = 0; i < noderoleTermtext.getNodeValue().length(); i++) {
//                                                        String letter = noderoleTermtext.getNodeValue().charAt(i) + "";
//                                                        m = p.matcher(letter);
//                                                        hebrewDetected = m.matches();
//                                                        if (hebrewDetected) {
//                                                            break;
//                                                        }
//                                                    }
//
//                                                    System.out.println("hebrewDetected=" + hebrewDetected); //true
//
//                                                    if (hebrewDetected) {
//                                                        ((Element) nodeRoleTerm).setAttribute("lang", "heb");
//                                                        ((Element) nodeRoleTerm).setAttribute("script", "Hebr");
//                                                    } else {
//                                                        ((Element) nodeRoleTerm).setAttribute("lang", "eng");
//                                                    }
                                                }
                                            }
                                        }
                                    }

                                }
                            }

                        } catch (NullPointerException ex) {
                            ex.printStackTrace();
                        }
                    }
                    // namePart
                    if (node.getNodeType() == Node.ELEMENT_NODE && "mods:namePart".equals(node.getNodeName()) && !((Element) node).hasAttribute("lang")) {
                        try {
                            //System.out.println("in:" + node.getNodeValue());
                            hebrewDetected = false;
                            NodeList nodesnameChildren = node.getChildNodes();
                            if (null != nodesnameChildren && nodesnameChildren.getLength() != 0) {
                                System.out.println("node text count :" + nodesnameChildren.getLength());
                                for (int count2 = 0; count2 < nodesnameChildren.getLength(); count2++) {
                                    Node nodenameParttext = nodesnameChildren.item(count2);
                                    addLangToElement(hebrewDetected, nodenameParttext, node);
//                                    System.out.println("namePart text: " + nodenameParttext.getNodeValue());
//                                    for (int i = 0; i < nodenameParttext.getNodeValue().length(); i++) {
//                                        String letter = nodenameParttext.getNodeValue().charAt(i) + "";
//                                        m = p.matcher(letter);
//                                        hebrewDetected = m.matches();
//                                        if (hebrewDetected) {
//                                            break;
//                                        }
//                                    }
//
//                                    System.out.println("hebrewDetected=" + hebrewDetected); //true
//
//                                    if (hebrewDetected) {
//                                        ((Element) node).setAttribute("lang", "heb");
//                                        ((Element) node).setAttribute("script", "Hebr");
//                                    } else {
//                                        ((Element) node).setAttribute("lang", "eng");
//                                    }

                                }
                            }

                        } catch (NullPointerException ex) {
                            ex.printStackTrace();
                        }
                    }
                }

            }

            //originInfo.appendChild();
        }

    }

    private static void updateLocation(Node node_level1) {
//        Pattern p = Pattern.compile("\\p{InHebrew}", Pattern.UNICODE_CASE);
//        Matcher m = null;

        boolean hebrewDetected = false;
        if (node_level1.getNodeType() == Node.ELEMENT_NODE && "mods:location".equals(node_level1.getNodeName())) {

            NodeList children = node_level1.getChildNodes();

            if (null != children && children.getLength() != 0) {
                for (int count1 = 0; count1 < children.getLength(); count1++) {
                    Node node = children.item(count1);
                    // 
                    if (node.getNodeType() == Node.ELEMENT_NODE && "mods:physicalLocation".equals(node.getNodeName())) {
                        try {
                            hebrewDetected = false;
                            //System.out.println("in:" + node.getNodeValue());
                            NodeList nodeslocationChildren = node.getChildNodes();
                            if (null != nodeslocationChildren && nodeslocationChildren.getLength() != 0) {
                                System.out.println("node text count :" + nodeslocationChildren.getLength());
                                for (int count2 = 0; count2 < nodeslocationChildren.getLength(); count2++) {
                                    Node nodelocationtext = nodeslocationChildren.item(count2);
                                     addLangToElement(hebrewDetected, nodelocationtext, node);
//                                    System.out.println("pyhsical Location text: " + nodelocationtext.getNodeValue());
//                                    for (int i = 0; i < nodelocationtext.getNodeValue().length(); i++) {
//                                        String letter = nodelocationtext.getNodeValue().charAt(i) + "";
//                                        m = p.matcher(letter);
//                                        hebrewDetected = m.matches();
//                                        if (hebrewDetected) {
//                                            break;
//                                        }
//                                    }
//
//                                    System.out.println("hebrewDetected=" + hebrewDetected); //true
//
//                                    if (hebrewDetected) {
//                                        ((Element) node).setAttribute("lang", "heb");
//                                        ((Element) node).setAttribute("script", "Hebr");
//                                    } else {
//                                        ((Element) node).setAttribute("lang", "eng");
//                                    }

                                }
                            }

                        } catch (NullPointerException ex) {
                            ex.printStackTrace();
                        }
                    }
                }

            }

            //originInfo.appendChild();
        }

    }

    private static void updateExtent(Node node_level1) {
//        Pattern p = Pattern.compile("\\p{InHebrew}", Pattern.UNICODE_CASE);
//        Matcher m = null;

        boolean hebrewDetected = false;
        if (node_level1.getNodeType() == Node.ELEMENT_NODE && "mods:physicalDescription".equals(node_level1.getNodeName())) {

            NodeList children = node_level1.getChildNodes();

            if (null != children && children.getLength() != 0) {
                for (int count1 = 0; count1 < children.getLength(); count1++) {
                    Node node = children.item(count1);
                    // 
                    if (node.getNodeType() == Node.ELEMENT_NODE && "mods:extent".equals(node.getNodeName())) {
                        try {
                            //System.out.println("in:" + node.getNodeValue());
                            hebrewDetected = false;
                            NodeList nodesextentChildren = node.getChildNodes();
                            if (null != nodesextentChildren && nodesextentChildren.getLength() != 0) {
                                System.out.println("node text count :" + nodesextentChildren.getLength());
                                for (int count2 = 0; count2 < nodesextentChildren.getLength(); count2++) {
                                    Node nodeextenttext = nodesextentChildren.item(count2);
                                     addLangToElement(hebrewDetected, nodeextenttext, node);
//                                    System.out.println("Extent text: " + nodeextenttext.getNodeValue());
//                                    for (int i = 0; i < nodeextenttext.getNodeValue().length(); i++) {
//                                        String letter = nodeextenttext.getNodeValue().charAt(i) + "";
//                                        m = p.matcher(letter);
//                                        hebrewDetected = m.matches();
//                                        if (hebrewDetected) {
//                                            break;
//                                        }
//                                    }
//
//                                    System.out.println("hebrewDetected=" + hebrewDetected); //true
//
//                                    if (hebrewDetected) {
//                                        ((Element) node).setAttribute("lang", "heb");
//                                        ((Element) node).setAttribute("script", "Hebr");
//                                    } else {
//                                        ((Element) node).setAttribute("lang", "eng");
//                                    }

                                }
                            }

                        } catch (NullPointerException ex) {
                            ex.printStackTrace();
                        }
                    }
                }

            }

            //originInfo.appendChild();
        }

    }

    private static void updatePublisher(Node node_level1) {
//        Pattern p = Pattern.compile("\\p{InHebrew}", Pattern.UNICODE_CASE);
//        Matcher m = null;

        boolean hebrewDetected = false;
        if (node_level1.getNodeType() == Node.ELEMENT_NODE && "mods:originInfo".equals(node_level1.getNodeName())) {

            NodeList children = node_level1.getChildNodes();

            if (null != children && children.getLength() != 0) {
                for (int count1 = 0; count1 < children.getLength(); count1++) {
                    Node node_level2 = children.item(count1);
                    // 
                    if (node_level2.getNodeType() == Node.ELEMENT_NODE && "mods:publisher".equals(node_level2.getNodeName())) {
                        try {
                            hebrewDetected = false;
                            //System.out.println("in:" + node.getNodeValue());
                            NodeList nodeslevel2Children = node_level2.getChildNodes();
                            if (null != nodeslevel2Children && nodeslevel2Children.getLength() != 0) {
                                System.out.println("node text count :" + nodeslevel2Children.getLength());
                                for (int count2 = 0; count2 < nodeslevel2Children.getLength(); count2++) {
                                    Node nodelevel2text = nodeslevel2Children.item(count2);
                                    addLangToElement(hebrewDetected, nodelevel2text, node_level2);
//                                    System.out.println("Publisher text: " + nodelevel2text.getNodeValue());
//                                    for (int i = 0; i < nodelevel2text.getNodeValue().length(); i++) {
//                                        String letter = nodelevel2text.getNodeValue().charAt(i) + "";
//                                        m = p.matcher(letter);
//                                        hebrewDetected = m.matches();
//                                        if (hebrewDetected) {
//                                            break;
//                                        }
//                                    }
//
//                                    System.out.println("hebrewDetected=" + hebrewDetected); //true
//
//                                    if (hebrewDetected) {
//                                        ((Element) node_level2).setAttribute("lang", "heb");
//                                        ((Element) node_level2).setAttribute("script", "Hebr");
//                                    } else {
//                                        ((Element) node_level2).setAttribute("lang", "eng");
//                                    }

                                }
                            }

                        } catch (NullPointerException ex) {
                            ex.printStackTrace();
                        }
                    }
                }

            }

            //originInfo.appendChild();
        }

    }
public static void addLangToElement(boolean hebrewDetected, Node nodeText, Node node){
     Pattern p = Pattern.compile("\\p{InHebrew}", Pattern.UNICODE_CASE);
     Matcher m = null;
    System.out.println("Element text: " + nodeText.getNodeValue());
    for (int i = 0; i < nodeText.getNodeValue().length(); i++) {
        String letter = nodeText.getNodeValue().charAt(i) + "";
        m = p.matcher(letter);
        hebrewDetected = m.matches();
        if (hebrewDetected) {
            break;
        }
    }

    System.out.println("hebrewDetected=" + hebrewDetected); //true

    if (hebrewDetected) {
        ((Element) node).setAttribute("lang", "heb");
        ((Element) node).setAttribute("script", "Hebr");
    } else {
        ((Element) node).setAttribute("lang", "eng");
    }
}
    
    public AddLang() {

    }

    public static void main(String args[]) throws ParserConfigurationException, UnsupportedEncodingException, FileNotFoundException, IOException, SAXException {

//query:
        if (args.length == 0) {
            System.out.println("Proper Usage is: java -jar addLangScriptToMods.jar inputPath outputPath");
            System.exit(0);
        }
        String outputPath = "";
        String inputPath = "";

        try {
            outputPath = args[1];
            inputPath = args[0];
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("ArrayIndexOutOfBoundsException caught");
            System.exit(0);
        }
        File folder = new File(inputPath);
        System.out.println("Folder created");
        File[] listOfFiles = folder.listFiles();
        System.out.println("List of Files found");
        for (File listOfFile : listOfFiles) {
            System.out.println("In for Loop");
            if (listOfFile.isFile()) {
                System.out.println("is a file");
                File file = new File(inputPath + "\\" + listOfFile.getName());
                StringBuilder fileData = new StringBuilder(1000);
                try (BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
                    char[] buf = new char[1024];
                    int numRead = 0;
                    while ((numRead = r1.read(buf)) != -1) {
                        String readData = String.valueOf(buf, 0, numRead);
                        fileData.append(readData);
                        buf = new char[1024];
                    }
                }
                String ouptu = fileData.toString();
                DocumentBuilderFactory docfactory
                        = DocumentBuilderFactory.newInstance();
                docfactory.setCoalescing(true);
                docfactory.setExpandEntityReferences(true);
                docfactory.setIgnoringComments(true);
                docfactory.setNamespaceAware(true);
                // We must set validation false since jdk1.4 parser
                // doesn't know about schemas.
                docfactory.setValidating(false);
                // Ignore whitespace doesn't work unless setValidating(true),
                // according to javadocs.
                docfactory.setIgnoringElementContentWhitespace(false);
                DocumentBuilder docbuilder;
                docbuilder = docfactory.newDocumentBuilder();
                docbuilder.setErrorHandler(new AddLang());
                Document document = docbuilder.parse(new ByteArrayInputStream(ouptu.getBytes("UTF-8")));
                Element contele = document.getDocumentElement();
                // Date Normalization start
                NodeList nodes = contele.getChildNodes();
                if (null != nodes && nodes.getLength() != 0) {
                    for (int count = 0; count < nodes.getLength(); count++) {
                        Node node_level1 = nodes.item(count);
                        updateTitle(node_level1);//, textObjectFactory, languageDetector
                        updateSubject(node_level1);//, textObjectFactory, languageDetector
                        updateName(node_level1);//, textObjectFactory, languageDetector
                        updateExtent(node_level1);
                        updateLocation(node_level1);
                        updatePublisher(node_level1);
                    }
                }
                String fileName = listOfFile.getName();
                writedoc(outputPath + "\\" + fileName.replaceFirst("NNL03.", "").replaceFirst(".PRM-EPH", "-1"), contele, document);
            }
        }
    }

    /**
     * Writes the given element's subtree to the specified file.
     *
     * @param fname The output file.
     * @param ele The xml element subtree.
     * @param doc DESCRIPTION
     * @exception Hexception DESCRIPTION
     */
    private static void writedoc(
            String fname,
            Element ele,
            Document doc) {
        try {
            FileOutputStream fos = new FileOutputStream(fname);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            Writer wtr = new BufferedWriter(osw);
            OutputFormat format = new OutputFormat(doc, "UTF-8", true);
            // Indenting true
            format.setMethod("xml");
            // May not ne necessary to call this
            format.setLineWidth(0);
            // No line wrapping
            XMLSerializer ser = new XMLSerializer(wtr, format);
            ser.serialize(ele);
            fos.close();
            osw.close();
            wtr.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void warning(SAXParseException exception) {
        exception.printStackTrace();
    }

    public void error(SAXParseException exception) {
        exception.printStackTrace();
    }

    public void fatalError(SAXParseException exception) {
        exception.printStackTrace();
    }
}
