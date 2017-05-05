/*
 * Project: ARUBA
 * Class:   HtmlFormatter
 *
 * Version info
 * Created: 4/11/17
 * Creator: Haubir Mariwani
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com;

import com.google.gson.Gson;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Type;
import java.util.ArrayList;


/**
 * Class summary.
 * <p>
 * Class Description.
 * </p>
 *
 * @author Haubir Mariwani <haubir.mariwani@fasbros.it>
 * @version JDK 1.8
 * @since 4/17/17
 */
public class Parser {
    private Gson g = new Gson();

    /**
     * Constructs a Parser object that operated with a Gson parser.
     * WARNING: Not complete yet. To be extended with further parsing possibilites!
     */
    public Parser() {}

    /**
     * JSON output parser, converts objects to JSON strings
     * @param obj - the object to be converted
     * @return the JSON string
     */
    public String toJson(Object obj) {
        return g.toJson(obj);
    }

    /**
     * JSON input parser, converts JSON strings to a specified object
     * @param str - JSON string to be converted
     * @param cl - The desired class of the object
     *
     * @return the desired object
     */
    public <T> T fromJson(String str, Type cl) {
        return g.fromJson(str, cl);
    }

    /**
     * Tells whether the user wants debugging information or not
     *
     *
     * @return true or false
     */
    public boolean isDebugMode(String JSONInput) {
        Input received = g.fromJson(JSONInput, Input.class);

        return received.isDebugMode();
    }

    /**
     * Finds out what the format of the JSONInput was.
     *
     * @param JSONInput
     * @return the position format in String representation
     */
    public String findPositionFormat(String JSONInput) {
        String toReturn;

        Input received = g.fromJson(JSONInput, Input.class);

        Position assignmentPosition = received.getAssignment().getPosition();

        if (assignmentPosition.getGeocoordinate() != null) {
            toReturn = "geocoordinate";
        }
        else if (!(assignmentPosition.getAddress().equals("")) ||
                !(assignmentPosition.getAddress() == null)){
            toReturn = "address";
        }
        else if (!(assignmentPosition.getPostcode().equals("")) ||
                !(assignmentPosition.getPostcode() == null)){
            toReturn = "postcode";
        }
        else if (!(assignmentPosition.getZip().equals("")) ||
                !(assignmentPosition.getZip() == null)) {
            toReturn = "zip";
        }
        else if (!(assignmentPosition.getCity().equals("")) ||
                !(assignmentPosition.getCity() == null)){
            toReturn = "city";
        }
        else if (!(assignmentPosition.getCounty().equals("")) ||
                !(assignmentPosition.getCounty() == null)){
            toReturn = "county";
        }
        else if (!(assignmentPosition.getCountry().equals("")) ||
                !(assignmentPosition.getCountry() == null)){
            toReturn = "country";
        }
        else {
            toReturn = "";
        }

        return toReturn;
    }
}
