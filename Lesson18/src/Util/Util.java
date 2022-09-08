package Util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public List<File> getFilesFromFolder(Path path) throws IOException
    {
        return Files.walk(path)
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .filter(file -> file.getName().endsWith(".xml"))
                .collect(Collectors.toList());
    }

    public void inputInFile(String name, String text) throws IOException {
        Files.write(Paths.get(name), Collections.singleton(text));
    }
}