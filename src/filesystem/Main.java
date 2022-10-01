package filesystem;

import java.util.*;

public class Main {

    public static void main(String args[]) {

        FileSystem fileSystem = new FileSystem();

        fileSystem.addFileToDirectory("file1.txt", 100, "");
        fileSystem.addFileToDirectory("file2.txt", 100, "collection1");
        fileSystem.addFileToDirectory("file3.txt", 200, "collection1");
        fileSystem.addFileToDirectory("file4.txt", 300, "collection3");
        fileSystem.addFileToDirectory("file5.txt", 400, "collection4");

        System.out.println(fileSystem.getSizeOfAllFiles());
        List<Directory> topNCollections = fileSystem.getNCollection(2);

        for (Directory collection: topNCollections)
            System.out.println(collection.name+" " + collection.size+" ");
    }
}