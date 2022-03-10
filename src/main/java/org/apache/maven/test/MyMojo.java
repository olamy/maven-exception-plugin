package org.apache.maven.test;


import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 */
@Mojo( name = "throw", defaultPhase = LifecyclePhase.PROCESS_SOURCES )
public class MyMojo
    extends AbstractMojo
{

    @Parameter( property = "throwFailureException", required = false )
    private boolean throwFailureException;

    public void execute()
        throws MojoExecutionException, MojoFailureException
    {
        if (throwFailureException) {
            throw new MojoFailureException("it's a MojoFailureException");
        }
        throw new MojoExecutionException("it's a MojoExecutionException");
    }
}
