package HW9;

import java.util.Objects;

public class FileData {
    private String nameOfFile;
    private long sizeInBytes;
    private String path;

    public FileData(String path, String name, long size){
        this.path = path;
        this.nameOfFile = name;
        this.sizeInBytes = size;
    }


    public String getNameOfFile() {
        return nameOfFile;
    }

    public long getSizeInBytes() {
        return sizeInBytes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileData fileData = (FileData) o;
        return sizeInBytes == fileData.sizeInBytes && Objects.equals(nameOfFile, fileData.nameOfFile) && Objects.equals(path, fileData.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfFile, sizeInBytes, path);
    }

    public String getPath() {
        return path;
    }
}
