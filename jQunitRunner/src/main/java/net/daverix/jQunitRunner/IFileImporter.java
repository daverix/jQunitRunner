package net.daverix.jQunitRunner;

import java.io.IOException;

/**
 * Created by david.laurell on 2013-09-12.
 */
public interface IFileImporter {
    public String importFile(String path) throws IOException;
}
