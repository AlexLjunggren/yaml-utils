## YAML Utils

A collection of useful YAML utilities.

Object to YAML

```java
String yaml = YamlUtils.objectToYaml(myObject);
```

YAML to Object

```java
MyClass myObject = YamlUtils.yamlToObject(yaml, MyClass.class);
```

Check if String is a valid YAML

```java
YamlUtils.isValid(yaml)
```

Determine if two YAML Strings are equal

```java
YamlUtils.areEqual(yaml1, yaml2)
```

