package com.ljunggren.yamlUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;

public class YamlUtils {

    public static String objectToYaml(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory().disable(Feature.WRITE_DOC_START_MARKER));
        return mapper.writeValueAsString(object);
    }
    
    public static <T> T yamlToObject(String yaml, Class<T> clazz) throws JsonMappingException, JsonProcessingException {
        return new ObjectMapper(new YAMLFactory()).readValue(yaml, clazz);
    }
    
    public static boolean isValid(String yaml) {
        try {
            new ObjectMapper(new YAMLFactory()).readTree(yaml);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean areEqual(String yaml1, String yaml2) throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readTree(yaml1).equals(mapper.readTree(yaml2));
    }
    
}
