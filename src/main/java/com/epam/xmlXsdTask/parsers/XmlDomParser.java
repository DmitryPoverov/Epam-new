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

    @Override
    public List<Voucher> parse(String filePath) throws ParserException {

        Document domObject = buildDocument(filePath);
        List<Voucher> listOfVouchers = new ArrayList<>();

        Node rootNode = domObject.getFirstChild();
        NodeList rootChildrenNodes = rootNode.getChildNodes();
        for (int i = 0; i < rootChildrenNodes.getLength(); i++) {

            Node childNode = rootChildrenNodes.item(i);
            String childNodeName = childNode.getNodeName();

            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                if (childNodeName.equals(getData(TAG_FAMILY_VOUCHER))) {
                    listOfVouchers.add(getInformationAboutFamilyVouchers(childNode));
                } else if (childNodeName.equals(getData(TAG_BUSINESS_VOUCHER))) {
                    listOfVouchers.add(getInformationAboutBusinessVouchers(childNode));
                }
            }
        }
        return listOfVouchers;
    }

    private static BusinessVoucher getInformationAboutBusinessVouchers(Node businessVoucherNode) {

        BusinessVoucher businessVoucher = new BusinessVoucher();

        NamedNodeMap attributes = businessVoucherNode.getAttributes();
        String idAttribute = attributes.item(0).getTextContent();
        businessVoucher.setId(Integer.parseInt(idAttribute));

        commonForAllTagsProcessing(businessVoucherNode, businessVoucher);

        Node penultimateNode = businessVoucherNode.getLastChild().getPreviousSibling();
        if (penultimateNode.getNodeName().equalsIgnoreCase(getData(TAG_NUMBER_OF_MEETINGS))) {
            businessVoucher.setNumOfMeetings((Integer.parseInt(penultimateNode.getTextContent())));
        }
        return businessVoucher;
    }

    private static HotelCharacteristics getHotelCharacteristics(Node hotelCharacteristicsNode) {

        HotelCharacteristics hotelCharacteristics = new HotelCharacteristics();

        NodeList hotelCharacteristicsChildren = hotelCharacteristicsNode.getChildNodes();
        for (int i = 0; i < hotelCharacteristicsChildren.getLength(); i++) {

            Node childNode = hotelCharacteristicsChildren.item(i);
            String childNodeContent = hotelCharacteristicsChildren.item(i).getTextContent();
            String childNodeName = hotelCharacteristicsChildren.item(i).getNodeName();

            if (childNode.getNodeType() == Node.ELEMENT_NODE) {

                if (childNodeName.equals(getData(TAG_NUMBER_OF_STARS))) {
                    hotelCharacteristics.setNumOfStars(Integer.parseInt(childNodeContent));
                } else if (childNodeName.equals(getData(TAG_MEALS_INCLUDED))) {
                    hotelCharacteristics.setMealsIncluded(getInformationAboutMeals(childNode));
                } else if (childNodeName.equals(getData(TAG_ROOM_TYPE))) {
                    if (childNodeContent.equalsIgnoreCase(RoomType.SINGLE.toString())) {
                        hotelCharacteristics.setRoomType(RoomType.SINGLE);
                    } else if (childNodeContent.equalsIgnoreCase(RoomType.DOUBLE.toString())) {
                        hotelCharacteristics.setRoomType(RoomType.DOUBLE);
                    } else if (childNodeContent.equalsIgnoreCase(RoomType.TRIPLE.toString())) {
                        hotelCharacteristics.setRoomType(RoomType.TRIPLE);
                    }
                }
            }
        }
        return hotelCharacteristics;
    }

    private static MealsIncluded getInformationAboutMeals(Node hotelCharacteristicsChild) {

        MealsIncluded mealsIncluded = new MealsIncluded();

        NamedNodeMap attributes = hotelCharacteristicsChild.getAttributes();
        String trueAttribute = attributes.item(0).getTextContent();

        if (trueAttribute.equalsIgnoreCase("true")) {
            mealsIncluded.setAvailable(true);
            NodeList mealTypeNodesChildren = hotelCharacteristicsChild.getChildNodes();
            for (int i = 0; i < mealTypeNodesChildren.getLength(); i++) {

                Node childNode = mealTypeNodesChildren.item(i);
                String childNodeContent = childNode.getTextContent();
                String childNodeName = childNode.getNodeName();

                if (childNode.getNodeType() != Node.ELEMENT_NODE) {
                    if (childNodeName.equals(getData(TAG_MEAL_TYPE))) {
                        if (childNodeContent.equalsIgnoreCase(MealType.AI.toString())) {
                            mealsIncluded.setMealType(MealType.AI);
                        } else if (childNodeContent.equalsIgnoreCase(MealType.BB.toString())) {
                            mealsIncluded.setMealType(MealType.BB);
                        } else if (childNodeContent.equalsIgnoreCase(MealType.HB.toString())) {
                            mealsIncluded.setMealType(MealType.HB);
                        }
                    }
                }
            }
        }
        return mealsIncluded;
    }

    private static FamilyVoucher getInformationAboutFamilyVouchers(Node familyVoucherNode) {

        FamilyVoucher familyVoucher = new FamilyVoucher();

        NamedNodeMap attributes = familyVoucherNode.getAttributes();
        String idAttribute = attributes.item(0).getTextContent();
        familyVoucher.setId(Integer.parseInt(idAttribute));

        commonForAllTagsProcessing(familyVoucherNode, familyVoucher);

        Node penultimateNode = familyVoucherNode.getLastChild().getPreviousSibling();
        if (penultimateNode.getNodeName().equalsIgnoreCase(getData(TAG_NUMBER_OF_FAMILY_MEMBERS))) {
            familyVoucher.setNumOfFamilyMembers((Integer.parseInt(penultimateNode.getTextContent())));
        }
        return familyVoucher;
    }

    private static Document buildDocument(String filePath) {
        File file = new File(filePath);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            document = dbf.newDocumentBuilder().parse(file);
        } catch (Exception e) {
            System.out.println("Document Parsing Error! " + e.getMessage());
        }
        return document;
    }

    private static void commonForAllTagsProcessing(Node voucherNode, Voucher voucher) {

        NodeList voucherNodeChildren = voucherNode.getChildNodes();
        for (int i = 0; i < voucherNodeChildren.getLength(); i++) {

            Node childNode = voucherNodeChildren.item(i);
            String childNodeContent = childNode.getTextContent();
            String childNodeName = childNode.getNodeName();

            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                if (childNodeName.equals(getData(TAG_TYPE))) {
                    if (childNodeContent.equalsIgnoreCase(Type.BUSINESS.toString())) {
                        voucher.setType(Type.BUSINESS);
                    } else if (childNodeContent.equalsIgnoreCase(Type.WEEKEND.toString())) {
                        voucher.setType(Type.WEEKEND);
                    }
                } else if (childNodeName.equals(getData(TAG_COUNTRY))) {
                    voucher.setCountry(childNodeContent);
                } else if (childNodeName.equals(getData(TAG_TRANSPORT))) {
                    voucher.setTransport(childNodeContent);
                }else if (childNodeName.equals(getData(TAG_NUMBER_OF_DAYS))) {
                    voucher.setNumberOfDays(Integer.parseInt(childNodeContent));
                } else if (childNodeName.equals(getData(TAG_HOTEL_CHARACTERISTICS))) {
                    voucher.setHotelCharacteristics(getHotelCharacteristics(childNode));
                } else if (childNodeName.equals(getData(TAG_COST))) {
                    voucher.setCost(Integer.parseInt(childNodeContent));
                }
            }
        }
    }
}