package filesystem;

class File implements FileSystemAttributes {

    Directory directory;
    String name;
    int size;

    public File(Directory d, String n, int size) {
        this.directory = d;
        this.name = n;
        this.size = size;
    }

    public File(String n, int size) {
        this.name = n;
        this.size = size;
    }
}
