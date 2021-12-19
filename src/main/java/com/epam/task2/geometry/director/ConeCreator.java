package com.epam.task2.geometry.director;

import com.epam.task2.geometry.entities.Cone;
import com.epam.task2.geometry.entities.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeCreator {

    private static final Logger LOGGER = LogManager.getLogger(ConeCreator.class);
    private static final String DELIMITER = " ";

    public ConeCreator() {
    }

    public Cone create(String inputData) {
        LOGGER.info("Started creating a cone from inputData: " + inputData);
        String[] parameters = inputData.split(DELIMITER);
        double radius = Double.parseDouble(parameters[0]);
        double height = Double.parseDouble(parameters[1]);
        double xCoordinate = Double.parseDouble(parameters[2]);
        double yCoordinate = Double.parseDouble(parameters[3]);
        double zCoordinate = Double.parseDouble(parameters[4]);
        Cone createdCone = new Cone(new Point(xCoordinate, yCoordinate, zCoordinate), radius, height);
        LOGGER.info("A Cone from input data is " + createdCone);
        return createdCone;
    }
}
