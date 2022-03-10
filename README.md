MojoExecutionException vs MojoFailureException
=

there is no difference in Maven Core :) 

just try this project. 
Look the sources.

```shell
mvn install -Prun-its
```

then 
```shell
mvn org.apache.maven.test:maven-exception-plugin:1.0-SNAPSHOT:throw -e -DthrowFailureException=true
mvn org.apache.maven.test:maven-exception-plugin:1.0-SNAPSHOT:throw -e
```

they both have the same result and output 

one says 
```shell
[INFO] --- maven-exception-plugin:1.0-SNAPSHOT:throw (default-cli) @ maven-exception-plugin ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.219 s
[INFO] Finished at: 2022-03-10T13:06:09+10:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.test:maven-exception-plugin:1.0-SNAPSHOT:throw (default-cli) on project maven-exception-plugin: it's a MojoFailureException -> [Help 1]
```
the one says 
```shell
[INFO] --- maven-exception-plugin:1.0-SNAPSHOT:throw (default-cli) @ maven-exception-plugin ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.163 s
[INFO] Finished at: 2022-03-10T13:07:16+10:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.test:maven-exception-plugin:1.0-SNAPSHOT:throw (default-cli) on project maven-exception-plugin: it's a MojoExecutionException -> [Help 1]
org.apache.maven.lifecycle.LifecycleExecutionException: Failed to execute goal org.apache.maven.test:maven-exception-plugin:1.0-SNAPSHOT:throw (default-cli) on project maven-exception-plugin: it's a MojoExecutionException
```


