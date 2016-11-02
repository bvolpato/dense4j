dense4j
========

[![Apache License](http://img.shields.io/badge/license-ASL-blue.svg)](https://github.com/brunocvcunha/dense4j/blob/master/LICENSE)
[![Build Status](https://travis-ci.org/brunocvcunha/dense4j.svg)](https://travis-ci.org/brunocvcunha/dense4j)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.brunocvcunha.dense4j/dense4j/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.brunocvcunha.dense4j/dense4j)
[![Coverage Status](https://coveralls.io/repos/github/brunocvcunha/dense4j/badge.svg?branch=master)](https://coveralls.io/github/brunocvcunha/dense4j?branch=master)

Keyword Density API for Java


Download
--------

Download [the latest JAR][1] or grab via Maven:
```xml
<dependency>
  <groupId>org.brunocvcunha.dense4j</groupId>
  <artifactId>dense4j</artifactId>
  <version>0.2</version>
</dependency>
```
or Gradle:
```groovy
compile 'org.brunocvcunha.dense4j:dense4j:0.2'
```

Snapshots of the development version are available in [Sonatype's `snapshots` repository][snap].

Dense4j requires at minimum Java 6.




Usage Example
--------

Java App:
```java
import org.brunocvcunha.dense4j.DenseCalculator;

public class Dense4jMain {
    public static void main(String[] args) throws IOException {
      String text = "Dense4j is an API developed by Bruno Candido Volpato da Cunha. " +
              "Bruno decided to start Dense4j in 2015.";

      Map<String, Integer> density = DenseCalculator.getKeywordsMap(text);

      System.out.println("Density Map: " + density.toString());

      System.out.println("Density for Bruno is: " + density.get("bruno"));
    }
}
```




 [1]: https://search.maven.org/remote_content?g=org.brunocvcunha.dense4j&a=dense4j&v=LATEST
 [snap]: https://oss.sonatype.org/content/repositories/snapshots/
