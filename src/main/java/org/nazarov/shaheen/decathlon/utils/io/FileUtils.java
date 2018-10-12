package org.nazarov.shaheen.decathlon.utils.io;

import org.nazarov.shaheen.decathlon.data.Athlete;
import org.nazarov.shaheen.decathlon.utils.DecathlonSerializer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.nazarov.shaheen.decathlon.utils.Constants.CLASSPATH;

/**
 * @author nazarov
 * @version 1.0
 */
public class FileUtils {

    /**
     * Get Path class from path in resources
     * @param fileName address of file from resources folder
     * @return path of file
     */
    private Path getPathFromResources(String fileName) {
        //Get file from resources folder
        try {
            return Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get Path class from path
     * @param path address of file
     * @return path of file
     */
    public Path get(String path) {
        if (path.startsWith(CLASSPATH))
            return getPathFromResources(path.replaceFirst(CLASSPATH, ""));
        return Paths.get(path);
    }

    /**
     * Writing file specific address
     * @param serializer Decathlon serializer
     * @param athletes list of athletes
     * @param outputPath address of output file
     * @return
     */
    public void writeFile(DecathlonSerializer serializer, List<Athlete> athletes, String outputPath) throws IOException {
        Path path = get(outputPath);
        Files.write(path, serializer.serialize(athletes));
    }
}
