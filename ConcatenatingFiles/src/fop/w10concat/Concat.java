package ConcatenatingFiles.src.fop.w10concat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concat{
    public static void main(String[] args) {
        if(args.length < 3){
            System.out.println("Length not satisfied");
            return;
        }

        Path n1 = Paths.get(args[0]);
        Path n2 = Paths.get(args[1]);
        if(!Files.isRegularFile(n1) || !Files.isRegularFile(n2)){
            System.out.println("Not regular file");
            return;
        }

        Path out = Paths.get(args[2]);
        if(Files.exists(out)){
            System.out.println("Hey bro, we do not need to overwrite this file, we come in peace");
            return;
        }

        try{
            Files.createFile(out);
        }catch (IOException e){
            System.out.println("I can't create it brooooo");
        }

        try {
            Files.write(out, Stream.concat(Files.lines(n1),Files.lines(n2)).collect(Collectors.toList()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}