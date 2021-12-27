package com.epam.xmlXsdTask.parsers;

import com.epam.xmlXsdTask.entities.associatedClasses.enums.Tags;
import com.epam.xmlXsdTask.exceptoin.ParserException;
import com.epam.xmlXsdTask.entities.BusinessVoucher;
import com.epam.xmlXsdTask.entities.FamilyVoucher;
import com.epam.xmlXsdTask.entities.Voucher;
import com.epam.xmlXsdTask.entities.associatedClasses.HotelCharacteristics;
import com.epam.xmlXsdTask.entities.associatedClasses.MealsIncluded;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.MealType;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.RoomType;
import com.epam.xmlXsdTask.entities.associatedClasses.enums.Type;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.epam.xmlXsdTask.entities.associatedClasses.enums.Tags.*;

public class XmlDomParser implements Parser {

    private static final Logger LOGGER = LogManager.getLogger(XmlDomParser.class);
    @Override
    public List<Voucher> parse(String filePath) {

        Document domObject = buildDocument(filePath);           // Converting XML to DOM Object Model with Error Handling
        List<Voucher> listOfVouchers = new ArrayList<>();       // list for inputting

        Node rootNode = domObject.getFirstChild();
        NodeList rootChildrenNodes = rootNode.getChildNodes();
        for (int i = 0; i < rootChildrenNodes.getLength(); i++) {

            Node childNode = rootChildrenNodes.item(i);
            String childNodeName = childNode.getNodeName();

// Checking for not-empty elements
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
// Two ways for different vouchers
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
//Got businessVoucher attributes
        NamedNodeMap attributes = businessVoucherNode.getAttributes();
//An only attribute and because index is 0
        String idAttribute = attributes.item(0).getTextContent();
// Got id from attribute
        businessVoucher.setId(Integer.parseInt(idAttribute));

        processAllCommonTags(businessVoucherNode, businessVoucher);

        Node lastNode = businessVoucherNode.getLastChild().getPreviousSibling();
        if (lastNode.getNodeName().equalsIgnoreCase(Tags.getData(TAG_NUMBER_OF_MEETINGS))) {
            businessVoucher.setNumOfMeetings((Integer.parseInt(lastNode.getTextContent())));
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
                if (childNodeName.equals(Tags.getData(TAG_NUMBER_OF_STARS))) {
                    hotelCharacteristics.setNumOfStars(Integer.parseInt(childNodeContent));
                } else if (childNodeName.equals(Tags.getData(TAG_MEALS_INCLUDED))) {
                    hotelCharacteristics.setMealsIncluded(getInformationAboutMeals(childNode));
                } else if (childNodeName.equals(Tags.getData(TAG_ROOM_TYPE))) {
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

                if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                    if (childNodeName.equals(Tags.getData(TAG_MEAL_TYPE))) {
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
//Got familyVoucher attributes
        NamedNodeMap attributes = familyVoucherNode.getAttributes();
//An only attribute and because index is 0
        String idAttribute = attributes.item(0).getTextContent();
// Got id from attribute
        familyVoucher.setId(Integer.parseInt(idAttribute));

        processAllCommonTags(familyVoucherNode, familyVoucher);

        Node lastNode = familyVoucherNode.getLastChild().getPreviousSibling();
        if (lastNode.getNodeName().equalsIgnoreCase(Tags.getData(TAG_NUMBER_OF_FAMILY_MEMBERS))) {
            familyVoucher.setNumOfFamilyMembers((Integer.parseInt(lastNode.getTextContent())));
        }
        return familyVoucher;
    }

    private static Document buildDocument(String filePath) {
        File file = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            document = factory.newDocumentBuilder().parse(file);
        } catch (Exception e) {
            LOGGER.error("Document Parsing Error\n" + e.getMessage());
        }
        return document;
    }

    private static void processAllCommonTags(Node voucherNode, Voucher voucher) {

        NodeList voucherNodeChildren = voucherNode.getChildNodes();

        for (int i = 0; i < voucherNodeChildren.getLength(); i++) {

            Node childNode = voucherNodeChildren.item(i);
            String childNodeContent = childNode.getTextContent();
            String childNodeName = childNode.getNodeName();

            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                if (childNodeName.equals(Tags.getData(TAG_TYPE))) {
                    if (childNodeContent.equalsIgnoreCase(Type.BUSINESS.toString())) {
                        voucher.setType(Type.BUSINESS);
                    } else  if (childNodeContent.equalsIgnoreCase(Type.WEEKEND.toString())) {
                        voucher.setType(Type.WEEKEND);
                    }
                } else if (childNodeName.equals(Tags.getData(TAG_COUNTRY))) {
                    voucher.setCountry(childNodeContent);
                } else if (childNodeName.equals(Tags.getData(TAG_TRANSPORT))) {
                    voucher.setTransport(childNodeContent);
                } else if (childNodeName.equals(Tags.getData(TAG_NUMBER_OF_DAYS))) {
                    voucher.setNumberOfDays(Integer.parseInt(childNodeContent));
                } else if (childNodeName.equals(Tags.getData(TAG_HOTEL_CHARACTERISTICS))) {
                    voucher.setHotelCharacteristics(getHotelCharacteristics(childNode));
                } else if (childNodeName.equals(Tags.getData(TAG_COST))) {
                    voucher.setCost(Integer.parseInt(childNodeContent));
                }
            }
        }
    }
}