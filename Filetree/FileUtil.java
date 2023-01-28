package Filetree;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class FileUtil {

    public static File toFileRepresentation(Path path) throws IOException {
        // TODO
        if(Files.isRegularFile(path)) return new RegularFile(path);
        Stream<Path> stream = Files.list(path);
        Iterator<Path> itr = stream.iterator();
        List<File> content = new LinkedList<>();
        while(itr.hasNext()){
            if(Files.isRegularFile(itr.next())) content.add(new RegularFile(itr.next()));
            else content.add(toFileRepresentation(itr.next()));
        }
        return new Directory(path,content);
    }

}