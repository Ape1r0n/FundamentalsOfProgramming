package Filetree;

import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Directory extends File {

    private final List<File> files;

    public Directory(Path path, List<File> files) {
        super(path);
        this.files = files;
    }

    @Override
    public Iterator<File> iterator() {
        return new Iterator<File>() {
            int index = -1;
            Iterator<File> subIterator;
            @Override
            public boolean hasNext() {
                if(files == null || index == files.size()) return false;
                return true;
            }

            @Override
            public File next() {
                if(index == -1){ index++; return Directory.this; }
                else if(index == files.size()) throw new NoSuchElementException();
                if(subIterator == null) subIterator = files.get(index).iterator();
                File res = subIterator.next();
                if(!subIterator.hasNext()){
                    subIterator = null;
                    index ++;
                }
                return null;
            }
        };
    }

    @Override
    public int getHeight() {
        // TODO
        if(files == null) return 0;
        if(files.size() == 0) return 0;
        int max = 0;
        for(File x : files){
            int depth = 0;
            if((depth = x.getHeight()) > max) max = depth;
        }
        return max + 1;
    }

    @Override
    public boolean isRegularFile() {
        return false;
    }

    public List<File> getFiles() {
        return files;
    }

}
