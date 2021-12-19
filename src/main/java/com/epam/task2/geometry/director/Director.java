package com.epam.task2.geometry.director;

import com.epam.task2.geometry.entities.Cone;
import com.epam.task2.geometry.exception.DataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Director {

    private static final Logger LOGGER = LogManager.getLogger(Director.class);
    private final DataReader reader;
    private final ConeValidator validator;
    private final ConeCreator creator;

    public Director(DataReader reader, ConeValidator validator, ConeCreator creator) {
        this.reader = reader;
        this.validator = validator;
        this.creator = creator;
    }

    public List<Cone> createConesFromInputFile(String path) {
        LOGGER.info("Started reading data from file with address: " + path);
        List<Cone> cones = new ArrayList<>();
        try {
            for (String line : reader.read(path)) {
                if (validator.isValid(line)) {
                    Cone cone = creator.create(line);
                    cones.add(cone);
                }
            }
        } catch (DataException e) {
            LOGGER.error(e.getMessage());
        }
        return cones;
    }
}