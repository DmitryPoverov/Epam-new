package com.epam.xmlXsdTask.parsers;

import com.epam.xmlXsdTask.exceptoin.ParserException;
import com.epam.xmlXsdTask.entities.BusinessVoucher;
import com.epam.xmlXsdTask.entities.FamilyVoucher;
import com.epam.xmlXsdTask.entities.Voucher;
import com.epam.xmlXsdTask.entities.associatedClasses.HotelCharacteristics;
import com.epam.xmlXsdTask.entities.associatedClasses.MealsIncluded;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.MealType;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.RoomType;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.Type;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.epam.xmlXsdTask.entities.associatedClasses.tags.Tags.*;

public class XmlDomParser implements Parser {

    public static void main(String[] args) {
        XmlDomParser xmlDomParser = new XmlDomParser();
        try {
            List<Voucher> vouchers = xmlDomParser.parse("src/main/resources/vouchers.xml");
            for (Voucher iterator : vouchers) {
                System.out.println(iterator);
            }
        } catch (ParserException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Voucher> parse(String filePath) throws ParserException {
        /* Converting XML to DOM Object Model with Error Handling */
        Document domObject = buildDocument(filePath);
        /* Creating list of objects from XML input */
        List<Voucher> listOfVouchers = new ArrayList<>();

        /* Data processing */
        Node rootNode = domObject.getFirstChild();
        NodeList rootChildrenNodes = rootNode.getChildNodes();
        for (int i = 0; i < rootChildrenNodes.getLength(); i++) {

            /* Variables for simplifying understanding */
            Node childNode = rootChildrenNodes.item(i);
            String childNodeName = childNode.getNodeName();

            if (childNode.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            if (childNodeName.equals(getData(TAG_FAMILY_VOUCHER))) {
                listOfVouchers.add(getInformationAboutFamilyVouchers(childNode));
            }

            if (childNodeName.equals(getData(TAG_BUSINESS_VOUCHER))) {
                listOfVouchers.add(getInformationAboutBusinessVouchers(childNode));
            }
        }
        return listOfVouchers;
    }

    private static BusinessVoucher getInformationAboutBusinessVouchers(Node businessVoucherNode) {

        /* BusinessVoucher object creation */
        BusinessVoucher businessVoucher = new BusinessVoucher();

        /* Processing attributes */
        NamedNodeMap attributes = businessVoucherNode.getAttributes();
        String idAttribute = attributes.item(0).getTextContent();
        businessVoucher.setId(Integer.parseInt(idAttribute));

        commonForAllTagsProccesing(businessVoucherNode, businessVoucher);

        /* Avoiding loop reuse by getting the penultimate node */
        Node penultimateNode = businessVoucherNode.getLastChild().getPreviousSibling();
        if (penultimateNode.getNodeName().equalsIgnoreCase(getData(TAG_NUMBER_OF_MEETINGS))) {
            businessVoucher.setNumOfMeetings((Integer.parseInt(penultimateNode.getTextContent())));
        }
        return businessVoucher;

    }// getInformationAboutBusinessVouchers

    private static HotelCharacteristics getHotelCharacteristics(Node hotelCharacteristicsNode) {
        /* HotelCharacteristics class creation */
        HotelCharacteristics hotelCharacteristics = new HotelCharacteristics();

        /* Processing hotelCharacteristicsNode children */
        NodeList hotelCharacteristicsChildren = hotelCharacteristicsNode.getChildNodes();
        for (int i = 0; i < hotelCharacteristicsChildren.getLength(); i++) {

            /* Variables for simplifying understanding */
            Node childNode = hotelCharacteristicsChildren.item(i);
            String childNodeContent = hotelCharacteristicsChildren.item(i).getTextContent();
            String childNodeName = hotelCharacteristicsChildren.item(i).getNodeName();

            if (childNode.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            if (childNodeName.equals(getData(TAG_NUMBER_OF_STARS))) {
                hotelCharacteristics.setNumOfStars(Integer.parseInt(childNodeContent));
                continue;
            }

            if (childNodeName.equals(getData(TAG_MEALS_INCLUDED))) {
                hotelCharacteristics.setMealsIncluded(getInformationAboutMeals(childNode));
                continue;
            }

            if (childNodeName.equals(getData(TAG_ROOM_TYPE))) {
                if (childNodeContent.equalsIgnoreCase(RoomType.SINGLE.toString())) {
                    hotelCharacteristics.setRoomType(RoomType.SINGLE);
                    continue;
                }

                if (childNodeContent.equalsIgnoreCase(RoomType.DOUBLE.toString())) {
                    hotelCharacteristics.setRoomType(RoomType.DOUBLE);
                    continue;
                }

                if (childNodeContent.equalsIgnoreCase(RoomType.TRIPLE.toString())) {
                    hotelCharacteristics.setRoomType(RoomType.TRIPLE);
                    continue;
                }
            }
        } // for
        return hotelCharacteristics;

    }// getHotelCharacteristics

    private static MealsIncluded getInformationAboutMeals(Node hotelCharacteristicsChild) {

        /* MealsIncluded class creation */
        MealsIncluded mealsIncluded = new MealsIncluded();

        /* Processing attributes */
        NamedNodeMap attributes = hotelCharacteristicsChild.getAttributes();
        String trueAttribute = attributes.item(0).getTextContent();

        if (trueAttribute.equalsIgnoreCase("true")) {
            mealsIncluded.setAvailable(true);
            NodeList mealTypeNodesChildren = hotelCharacteristicsChild.getChildNodes();
            for (int i = 0; i < mealTypeNodesChildren.getLength(); i++) {

                /* Variables for simplifying understanding */
                Node childNode = mealTypeNodesChildren.item(i);
                String childNodeContent = childNode.getTextContent();
                String childNodeName = childNode.getNodeName();

                if (childNode.getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                if (childNodeName.equals(getData(TAG_MEAL_TYPE))) {
                    if (childNodeContent.equalsIgnoreCase(MealType.AI.toString())) {
                        mealsIncluded.setMealType(MealType.AI);
                        continue;
                    }
                    if (childNodeContent.equalsIgnoreCase(MealType.BB.toString())) {
                        mealsIncluded.setMealType(MealType.BB);
                        continue;
                    }
                    if (childNodeContent.equalsIgnoreCase(MealType.HB.toString())) {
                        mealsIncluded.setMealType(MealType.HB);
                        continue;
                    }
                }
            }
        }
        return mealsIncluded;

    }// getInformationAboutMeals

    private static FamilyVoucher getInformationAboutFamilyVouchers(Node familyVoucherNode) {

        /* FamilyVoucher object creation */
        FamilyVoucher familyVoucher = new FamilyVoucher();

        /* Processing attributes */
        NamedNodeMap attributes = familyVoucherNode.getAttributes();
        String idAttribute = attributes.item(0).getTextContent();
        familyVoucher.setId(Integer.parseInt(idAttribute));

        commonForAllTagsProccesing(familyVoucherNode, familyVoucher);

        /* Avoiding loop reuse by getting the penultimate node */
        Node penultimateNode = familyVoucherNode.getLastChild().getPreviousSibling();
        if (penultimateNode.getNodeName().equalsIgnoreCase(getData(TAG_NUMBER_OF_FAMILY_MEMBERS))) {
            familyVoucher.setNumOfFamilyMembers((Integer.parseInt(penultimateNode.getTextContent())));
        }
        return familyVoucher;

    }// getInformationAboutFamilyVouchers

    private static Document buildDocument(String filePath) {
        File file = new File(filePath);
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
    }// buildDocument

    private static void commonForAllTagsProccesing(Node voucherNode, Voucher voucher) {

        /* Processing familyVoucherNode children */
        NodeList voucherNodeChildren = voucherNode.getChildNodes();
        for (int i = 0; i < voucherNodeChildren.getLength(); i++) {

            /* Variables for simplifying understanding */
            Node childNode = voucherNodeChildren.item(i);
            String childNodeContent = childNode.getTextContent();
            String childNodeName = childNode.getNodeName();

            if (childNode.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            if (childNodeName.equals(getData(TAG_TYPE))) {
                if (childNodeContent.equalsIgnoreCase(Type.BUSINESS.toString())) {
                    voucher.setType(Type.BUSINESS);
                    continue;
                }
                if (childNodeContent.equalsIgnoreCase(Type.WEEKEND.toString())) {
                    voucher.setType(Type.WEEKEND);
                    continue;
                }
            }

            if (childNodeName.equals(getData(TAG_COUNTRY))) {
                voucher.setCountry(childNodeContent);
                continue;
            }

            if (childNodeName.equals(getData(TAG_TRANSPORT))) {
                voucher.setTransport(childNodeContent);
                continue;
            }

            if (childNodeName.equals(getData(TAG_NUMBER_OF_DAYS))) {
                voucher.setNumberOfDays(Integer.parseInt(childNodeContent));
                continue;
            }

            if (childNodeName.equals(getData(TAG_HOTEL_CHARACTERISTICS))) {
                voucher.setHotelCharacteristics(getHotelCharacteristics(childNode));
                continue;
            }

            if (childNodeName.equals(getData(TAG_COST))) {
                voucher.setCost(Integer.parseInt(childNodeContent));
                continue;
            }
        }

    }// commonForAllTagsProccesing

}// XmlDomParser