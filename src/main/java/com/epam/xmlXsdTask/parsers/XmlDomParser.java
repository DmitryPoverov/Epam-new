package com.epam.xmlXsdTask.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlDomParser {
    public static void main(String[] args) {
        Document domObject = buildDocument();
        Node rootNode = domObject.getFirstChild();
        NodeList rootChildNodes = rootNode.getChildNodes();
        for (int i = 0; i < rootChildNodes.getLength(); i++) {
            if (rootChildNodes.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if (rootChildNodes.item(i).getNodeName().equals("familyVoucher")) {
                getInformationAboutFamilyVouchers(rootChildNodes.item(i));
            }
            if (rootChildNodes.item(i).getNodeName().equals("businessVoucher")) {
                getInformationAboutBusinessVouchers(rootChildNodes.item(i));
            }
        }
    }

    private static void getInformationAboutBusinessVouchers(Node businessVoucher) {
        NodeList businessVoucherChildren =  businessVoucher.getChildNodes();
        for (int i = 0; i < businessVoucherChildren.getLength(); i++) {
            if (businessVoucherChildren.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

        }
    }

    private static void getInformationAboutFamilyVouchers(Node familyVoucher) {
        NodeList familyVoucherChildren =  familyVoucher.getChildNodes();
        for (int i = 0; i < familyVoucherChildren.getLength(); i++) {
            if (familyVoucherChildren.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
        }
    }

    private static Document buildDocument() {
        File file = new File("src/main/resources/vouchers.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            document = dbf.newDocumentBuilder().parse(file);
        } catch (Exception e) {
            System.out.println("Document Parsing Error");
            e.printStackTrace();
            System.exit(0);
        }
        return document;
    }
}

