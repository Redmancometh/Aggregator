package com.redmancometh.aggregator;

import java.io.File;

public class NexusArtifact
{
    private File binary;
    
    public NexusArtifact(File binary)
    {
        this.binary = binary;
    }

    public File getBinary()
    {
        return binary;
    }

    public void setBinary(File binary)
    {
        this.binary = binary;
    }

    public String getGroup()
    {
        return group;
    }

    public void setGroup(String group)
    {
        this.group = group;
    }

    public String getArtifact()
    {
        return artifact;
    }

    public void setArtifact(String artifact)
    {
        this.artifact = artifact;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    private String group;
    private String artifact;
    private String version;
}
