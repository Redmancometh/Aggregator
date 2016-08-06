package com.redmancometh.aggregator;

import java.io.File;

public class Aggregator
{
    public static void main(String[] args)
    {
        //String username = args[0];
        //String password = args[1];
        //String url = args[2];
        //String fileName = args[3];
        File outputDir = new File(args[1]);
        if (!outputDir.exists())
        {
            outputDir.mkdir();
        }
        MavenModuleAggregator aggregator = new MavenModuleAggregator(new File(args[0]));
        aggregator.startAggregator();
        aggregator.saveFiles(outputDir);
    }
}
