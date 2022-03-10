def logFile = new File( basedir, 'build.log' )
assert logFile.exists()
content = logFile.text

assert content.contains("it's a MojoFailureException")
assert content.contains( 'BUILD FAILURE' )