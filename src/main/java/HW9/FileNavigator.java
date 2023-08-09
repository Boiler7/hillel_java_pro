package HW9;

import java.util.*;

public class FileNavigator {
    private final Map<String, List<FileData>> records = new HashMap<>();
    public void add(String path, String nameOfFile, long sizeOfFile){
        FileData fileData = new FileData(path, nameOfFile,sizeOfFile);

        if(records.containsKey(path)){
            List<FileData> fileDescription = records.get(path);
            fileDescription.add(fileData);
        } else {
            List<FileData> fileDescription = new ArrayList<>();
            fileDescription.add(fileData);
            records.put(path, fileDescription);
        }
    }

    public List<FileData> find(String path){
        if(records.containsKey(path)){
            return records.get(path);
        }
        return null;
    }

    public List<FileData> filterBySize(long borderSize){
        List<FileData> filteredBySize = new ArrayList<>();
        for(var elements : records.values()){
            for (var data : elements) {
                if (data.getSizeInBytes() <= borderSize) {
                    filteredBySize.add(data);
                }
            }
        }
        return filteredBySize;
    }

    public void remove(String path){
        List<FileData> files = find(path);
        if (files != null) {
            Iterator<FileData> iterator = files.iterator();
            while (iterator.hasNext()) {
                FileData file = iterator.next();
                iterator.remove();
                records.remove(file.getPath());
            }
        }
        records.remove(path);
    }
    public List<FileData> sortBySize(){
        List<FileData> allFiles = new ArrayList<>();

        for (List<FileData> fileList : records.values()) {
            allFiles.addAll(fileList);
        }

        allFiles.sort(Comparator.comparingLong(FileData::getSizeInBytes));

        return allFiles;
    }
}