package com.redmancometh.aggregator;

import java.io.File;
import java.util.function.Consumer;

public class NexusDeploymentEngine extends DeploymentEngine
{
    MavenModuleAggregator agg;

    public NexusDeploymentEngine(String username, String password, String url, File masterProject, File outputDir)
    {
        super(username, password, url);
        if (!masterProject.exists())
        {
            System.out.println("Project directory does not exist. Terminating.");
            System.exit(1);
        }
        agg = new MavenModuleAggregator(masterProject);
    }

    /**
     * 
     */
    @Override
    public void pushToRepo(File f, Consumer callback)
    {

    }

    @Override
    public MavenModuleAggregator getAggregator()
    {
        return agg;
    }

}
