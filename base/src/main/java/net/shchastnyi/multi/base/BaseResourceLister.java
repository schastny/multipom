package net.shchastnyi.multi.base;

import com.google.common.collect.Lists;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class BaseResourceLister {

    public String getResourceDir() {
        String MODULE_NAME = "base";
        return String.format("%1$s/src/main/resources/%1$s/", MODULE_NAME);
    }

    public List<String> readResourcesNames() {
        final String resourceDir = this.getResourceDir();

        List<String> result = Lists.newArrayList();

        try (DirectoryStream<Path> ds =
                     Files.newDirectoryStream( FileSystems.getDefault().getPath(resourceDir)) ) {
            for (Path p : ds) {
                result.add(p.getFileName().toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
