package com.enviro365.enviro.model;

import com.enviro365.enviro.controller.WasteCategoryController;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

public class WasteJsonParser {

    /**
     * The Simple Logging Facade for Java. Spring uses Logback framework.
     */
    private static final Logger log = LoggerFactory.getLogger(WasteCategoryController.class);

    /**
     * The list of waste categories.
     */
    private ArrayList<WasteCategory> categories = new ArrayList<>();

    /**
     * Returns the text value if the token is a VALUE token.
     *
     * @param parser the JsonParser with the token position at a field
     * @return the text value from the Value token
     * @throws IOException          if there is an exception in the Jackson parser
     * @throws WasteParserException if the token does not start with 'VALUE'
     */
    private String getFieldValue(JsonParser parser) throws IOException, WasteParserException {
        JsonToken token = parser.nextToken();
        if (token != null && token.isScalarValue()) {
            return parser.getText();
        } else {
            throw new WasteParserException("Expected VALUE token but found: " + token);
        }
    }

    /**
     * Parses the JSON WasteCategory object and adds a category to the list of categories.
     *
     * @param parser the JsonParser with the token position at the beginning of the WasteCategory object
     * @throws IOException          if there is an exception in the Jackson parser
     * @throws WasteParserException if there is an error getting the field value
     */
    private void parseCategoryObject(JsonParser parser) throws IOException, WasteParserException {
        Long id = parser.nextLongValue(1);
        String name = "";
        String disposalGuidelines = "";
        String recyclingTips = "";

        try {
            log.info("Parsing WasteCategory object");
            while (parser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = parser.currentName();
                parser.nextToken();
                switch (fieldName) {
                    case "name":
                        name = parser.getText();
                        break;
                    case "disposalGuidelines":
                        disposalGuidelines = parser.getText();
                        break;
                    case "recyclingTips":
                        recyclingTips = parser.getText();
                        break;
                    default:
                        throw new WasteParserException("Unknown field: " + fieldName);
                }
            }

            log.info("Finished parsing WasteCategory object with name: " + name);
            categories.add(new WasteCategory(id, name, disposalGuidelines, recyclingTips));
        } catch (Exception e) {
            log.error("Error parsing the JSON WasteCategory Object", e);
            throw e;
        }
    }

    /**
     * Parses a WasteCategory array.
     *
     * @param parser the JsonParser with the token position at the beginning of the WasteCategory array
     * @throws IOException          if there is an exception in the Jackson parser
     * @throws WasteParserException if there is an error getting the field value
     */
    private void parseCategoryArray(JsonParser parser) throws IOException, WasteParserException {
        try {
            log.info("Parsing WasteCategory array");
            while (parser.nextToken() != JsonToken.END_ARRAY) {
                if (parser.currentToken() == JsonToken.START_OBJECT) {
                    parseCategoryObject(parser);
                }
            }
            log.info("Finished parsing WasteCategory array");
        } catch (Exception e) {
            log.error("Error parsing the JSON WasteCategory Object", e);
            throw e;
        }
    }

    /**
     * Parses the JSON array or object and returns a list of WasteCategories.
     *
     * @param payload the JsonNode that begins the JSON tree
     * @return a list of WasteCategories
     * @throws IOException          if there is an error in the Jackson parser
     * @throws WasteParserException if there are any unexpected values in the JSON array
     */
    public ArrayList<WasteCategory> parseJson(JsonNode payload) throws IOException, WasteParserException {
        try (JsonParser parser = new JsonFactory().createParser(payload.toPrettyString().getBytes())) {
            while (parser.nextToken() != null) {
                if (parser.currentToken() == JsonToken.START_ARRAY) {
                    parseCategoryArray(parser);
                } else if (parser.currentToken() == JsonToken.START_OBJECT) {
                    parseCategoryObject(parser);
                }
            }
        } catch (Exception e) {
            log.error("Error parsing the JSON WasteCategory Object", e);
            throw e;
        }

        return categories;
    }
}
