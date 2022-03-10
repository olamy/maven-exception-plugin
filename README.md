MojoExecutionException vs MojoFailureException
=

there is no difference in Maven Core 3 output between results with plugin-api's
[MojoExecutionException](https://maven.apache.org/ref/3.8.4/maven-plugin-api/apidocs/org/apache/maven/plugin/MojoExecutionException.html)
vs [MojoFailureException ](https://maven.apache.org/ref/3.8.4/maven-plugin-api/apidocs/org/apache/maven/plugin/MojoFailureException.html):
there was in Maven 2.

just try this project. 
Look the sources.

```shell
mvn install -Prun-its
```

then 
```shell
mvn org.apache.maven.test:maven-exception-plugin:1.0-SNAPSHOT:throw -e -DthrowFailureException
mvn org.apache.maven.test:maven-exception-plugin:1.0-SNAPSHOT:throw -e
```

they both have the same result and output when run with Maven 3 (with different Help links: http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException vs http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException):

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
...
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException

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
...
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
```

But with Maven 2, the difference is shown:

one says 
```shell
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Building maven-exception-plugin Maven Plugin
[INFO]    task-segment: [org.apache.maven.test:maven-exception-plugin:1.0-SNAPSHOT:throw]
[INFO] ------------------------------------------------------------------------
[INFO] [exception:throw {execution: default-cli}]
[INFO] ------------------------------------------------------------------------
[ERROR] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] it's a MojoFailureException
[INFO] ------------------------------------------------------------------------
[INFO] Trace
org.apache.maven.BuildFailureException: it's a MojoFailureException
        at org.apache.maven.lifecycle.DefaultLifecycleExecutor.executeGoals(DefaultLifecycleExecutor.java:715)
```
the one says 
```shell
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Building maven-exception-plugin Maven Plugin
[INFO]    task-segment: [org.apache.maven.test:maven-exception-plugin:1.0-SNAPSHOT:throw]
[INFO] ------------------------------------------------------------------------
[INFO] [exception:throw {execution: default-cli}]
[INFO] ------------------------------------------------------------------------
[ERROR] BUILD ERROR
[INFO] ------------------------------------------------------------------------
[INFO] it's a MojoExecutionException
[INFO] ------------------------------------------------------------------------
[INFO] Trace
org.apache.maven.lifecycle.LifecycleExecutionException: it's a MojoExecutionException
        at org.apache.maven.lifecycle.DefaultLifecycleExecutor.executeGoals(DefaultLifecycleExecutor.java:719)
```
