package io.ljunggren.yamlUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class YamlUtilsTest {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class User {
        private String name;
        private int age;
        private boolean active;
    }
    
    @Test
    public void objectToYamlTest() throws JsonProcessingException {
        User user = new User("Alex", 40, true);
        String expected = "name: \"Alex\"\n"
                + "age: 40\n"
                + "active: true\n";
        String actual = YamlUtils.objectToYaml(user);
        assertEquals(expected, actual);
    }
    
    @Test
    public void yamlToObjectTest() throws JsonMappingException, JsonProcessingException {
        User user = new User("Alex", 40, true);
        String yaml = YamlUtils.objectToYaml(user);
        User generatedUser = YamlUtils.yamlToObject(yaml, User.class);
        assertEquals(user, generatedUser);
    }
    
    @Test
    public void isValidTest() throws JsonProcessingException {
        User user = new User("Alex", 40, true);
        String yaml = YamlUtils.objectToYaml(user);
        assertTrue(YamlUtils.isValid(yaml));
    }
    
    @Test
    public void isValidFalseTest() {
        String yaml = "`name";
        assertFalse(YamlUtils.isValid(yaml));
    }
    
    @Test
    public void areEqualTest() throws JsonProcessingException {
        User user = new User("Alex", 40, true);
        String expected = "# comment\n"
                + "name: \"Alex\"\n"
                + "age: 40\n"
                + "active: true\n";
        String actual = YamlUtils.objectToYaml(user);
        assertTrue(YamlUtils.areEqual(expected, actual));
    }

    @Test
    public void areEqualFalseTest() throws JsonProcessingException {
        User user = new User("Alex", 40, true);
        String expected = "# comment\n"
                + "name: \"Alexander\"\n"
                + "age: 40\n"
                + "active: true\n";
        String actual = YamlUtils.objectToYaml(user);
        assertFalse(YamlUtils.areEqual(expected, actual));
    }

}
