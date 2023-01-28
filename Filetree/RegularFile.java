package Filetree;

import java.nio.file.Path;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RegularFile extends File {

    public RegularFile(Path path) {
        super(path);
    }

    @Override
    public Iterator<File> iterator() {
        // TODO
        return new Iterator<File>() {
            boolean visited = false;
            @Override
            public boolean hasNext() {
                return !visited;
            }

            @Override
            public File next() {
                if(visited) throw new NoSuchElementException();
                else{
                    visited = true;
                    return RegularFile.this;
                }
            }
        };
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public boolean isRegularFile() {
        return true;
    }

}
