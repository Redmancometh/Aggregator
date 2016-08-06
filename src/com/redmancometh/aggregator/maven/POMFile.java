package com.redmancometh.aggregator.maven;

import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class POMFile
{

    private JSONObject jsonFile;

    public JSONObject getJson()
    {
        return jsonFile;
    }

    public void parseFile(File f)
    {
        FileReader reader = null;
        try
        {
            reader = new FileReader(f);
            jsonFile = new JSONObject(IOUtils.toString(reader));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("There was an error while trying to parse the file: " + f.getName());
        }
        finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

        }
    }
}
