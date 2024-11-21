# Demo: How to add code coverage badge + report using Codecov and Clover

View the demo [here](https://www.youtube.com/watch?v=tBsFjh-7fRw)

You can follow along in the demo by checking out the [initial-repo](https://github.com/damnePers/demo-coverage-setup/tree/initial-repo) branch, where you can find the repo we start with.

## Step by step 

### Set up codecov to add badge

1. Add pom.xml file to set up maven

        <?xml version="1.0" encoding="UTF-8"?>
        <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
        <modelVersion>4.0.0</modelVersion>

        <groupId>demo</groupId>
        <artifactId>cover-badge</artifactId>
        <packaging>jar</packaging>
        <version>1.0-SNAPSHOT</version>

        <properties>
          <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
          <maven.compiler.source>1.8</maven.compiler.source>
          <maven.compiler.target>1.8</maven.compiler.target>
        </properties>

        <dependencies>
          <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>4.12</version>
                <scope>test</scope>
          </dependency>
        </dependencies>

        <build>
            <plugins>
                <plugin>
                  <artifactId>maven-surefire-plugin</artifactId>
                  <version>2.22.2</version>
                </plugin>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-shade-plugin</artifactId>
                    <version>3.2.4</version>
                    <executions>
                        <execution>
                            <phase>package</phase>
                            <goals>
                                <goal>shade</goal>
                            </goals>
                            <configuration>
                                <transformers>
                                    <transformer
                                        implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                    </transformer>
                                </transformers>
                            </configuration>
                        </execution>
                    </executions>
                </plugin>
                <plugin>
            </plugins>
        </build>
        </project>

2. In terminal, run:
            
        $ mvn install 

and check for build success before you continue.

3. Add .travis.yml file to connect to Travis. Note: This assumes that you have your github conencted to travis already and that you activate the repo there.

        language: java

        jdk:
          - openjdk8

        script: "mvn cobertura:cobertura"

        after_success:
          - bash <(curl -s https://codecov.io/bash)

4. Add covertura plugin to pom.xml

            <plugin>
              <groupId>org.codehaus.mojo</groupId>
              <artifactId>cobertura-maven-plugin</artifactId>
              <version>2.7</version>
              <configuration>
                  <formats>
                      <format>html</format>
                      <format>xml</format>
                  </formats>
                  <check />
              </configuration>
            </plugin>

Here you can run mvn install to make sure that the build passes.

5. Go to [codecov.io](https://about.codecov.io/) and login with your github account

- Note: your repo will show up automatically if you have connected Travis correctly. 

6. Add badge in repo by adding the following line to the readme file

        [![codecov](https://codecov.io/gh/<your-name>/<project-name>/branch/main/graph/badge.svg)](https://codecov.io/gh/<your-name>/<project-name>)

### Set up Clover to get coverage report

7. Add plugins in pom.xml file

            <plugin>
              <groupId>com.atlassian.maven.plugins</groupId>
              <artifactId>clover-maven-plugin</artifactId>
              <configuration>
                <generateJSON>true</generateJSON>
                <generateHTML>true</generateHTML>
              </configuration>
            </plugin>
            <plugin>
              <groupId>org.openclover</groupId>
              <artifactId>clover-maven-plugin</artifactId>
            </plugin>

8. In terminal, run:
 
        $ mvn clean clover:setup test clover:aggregate clover:clover

9. Open report in browser by running the following in the terminal:
  
        $ open /your-path/index.html

### Check that everything works

Add test cases and render new build on travis.

Badge will update automatically.

In terminal, run:

    $ mvn clean clover:setup test clover:aggregate clover:clover 
  
again to genreate an updated report, and open it with the same command as before:
  
    $ open /your-path/index.html
    
The report and the badge should now be updated to match the added tests.
