package com.redmancometh.aggregator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import org.apache.commons.io.FilenameUtils;

public class MavenModuleAggregator implements ArtifactAggregator
{
    private List<NexusArtifact> moduleList = new CopyOnWriteArrayList();
    private File projectPath;

    public MavenModuleAggregator(File projectPath)
    {
        this.setProjectPath(projectPath);
    }

    public void startAggregator()
    {
        aggregate(projectPath);
    }

    public void saveFiles(File target)
    {
        applyToEach((artifact) ->
        {
            try
            {
                Files.copy(artifact.getBinary().toPath(), Paths.get(target.getPath() + "/" + artifact.getBinary().getName()), StandardCopyOption.REPLACE_EXISTING);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        });
    }

    public void aggregate(File dir)
    {
        for (File f : dir.listFiles())
        {
            if (f.isDirectory())
            {
                if (isRecursive())
                {
                    aggregate(f);
                }
                continue;
            }
            if (FilenameUtils.getExtension(f.getName()).equals("jar"))
            {
                //Get rid of extraneous maven-shade objects
                if(f.getName().startsWith("original")||f.getName().endsWith("shaded"))
                {
                    continue;
                }
                moduleList.add(new NexusArtifact(f));
            }
        }
    }

    @Override
    public List<NexusArtifact> getArtifacts()
    {
        return moduleList;
    }

    public void applyToEach(Consumer<NexusArtifact> iterMethod)
    {
        for (NexusArtifact artifact : moduleList)
        {
            iterMethod.accept(artifact);
        }
    }

    @Override
    public boolean isRecursive()
    {
        return true;
    }

    @Override
    public String getDirectory()
    {
        // TODO Auto-generated method stub
        return null;
    }

    public File getProjectPath()
    {
        return projectPath;
    }

    public void setProjectPath(File projectPath)
    {
        this.projectPath = projectPath;
    }

}
