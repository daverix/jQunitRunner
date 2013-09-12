package net.daverix.jQunitRunner;

import java.io.*;

/**
 * Created by david.laurell on 2013-09-12.
 */
public class FileImporter implements IFileImporter {
    @Override
    public String importFile(String path) throws IOException {
        if(path == null)
            throw new IllegalArgumentException("path must not be null!");

        BufferedReader reader = new BufferedReader(new FileReader(path));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line).append('\n');
        }
        reader.close();

        return builder.toString();
    }
}
