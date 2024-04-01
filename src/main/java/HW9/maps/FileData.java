package HW9.maps;

import lombok.Getter;

import java.util.Objects;

@Getter
public class FileData {
    private final String nameOfFile;
    private final long sizeInBytes;
    private final String path;

    public FileData(String path, String name, long size){
        this.path = path;
        this.nameOfFile = name;
        this.sizeInBytes = size;
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

}
