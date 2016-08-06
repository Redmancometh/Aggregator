package com.redmancometh.aggregator;

import java.util.List;

public interface ArtifactAggregator
{
    public List<NexusArtifact> getArtifacts();

    public String getDirectory();

    boolean isRecursive();
}
