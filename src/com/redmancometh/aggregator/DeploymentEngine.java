package com.redmancometh.aggregator;

import java.io.File;
import java.util.function.Consumer;

public abstract class DeploymentEngine
{
    public DeploymentEngine(String username, String password, String url)
    {

    }

    public abstract MavenModuleAggregator getAggregator();

    public abstract void pushToRepo(File f, Consumer callback);
}
