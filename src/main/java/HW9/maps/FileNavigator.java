package HW9.maps;

import java.util.*;

public class FileNavigator {
    private final Map<String, List<FileData>> records = new HashMap<>();
    public String add(String path, FileData fileData){

        if(!path.equals(fileData.getPath())){
            return "Error: Inconsistent path";
        }
        if(records.containsKey(path)){
            List<FileData> fileDescription = records.get(path);
            fileDescription.add(fileData);
        } else {
            List<FileData> fileDescription = new ArrayList<>();
            fileDescription.add(fileData);
            records.put(path, fileDescription);
        }
        return "";
    }

    public List<FileData> find(String path){
        if(records.containsKey(path)){
            return records.get(path);
        }
        return records.get(path);
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