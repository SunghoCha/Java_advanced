package io.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class FilesMain {

    public static void main(String[] args) throws IOException {
        Path file = Path.of("temp/example.txt");
        Path directory = Path.of("temp/exampleDir");

        // 1. exists(): 파일이나 디렉토리의 존재 여부 확인
        System.out.println("=== exists() ===");
        System.out.println("File exists: " + Files.exists(file));
        System.out.println();

        // 2. createFile(): 새 파일 생성
        System.out.println("=== createFile() ===");
        try {
            Files.createFile(file);
            System.out.println("File created");
        } catch (FileAlreadyExistsException e) {
            System.out.println("File already exists: " + file);
        }
        System.out.println();

        // 3. createDirectory(): 새 디렉토리 생성
        System.out.println("=== createDirectory() ===");
        try {
            Files.createDirectory(directory);
            System.out.println("directory created");
        } catch (FileAlreadyExistsException e) {
            System.out.println("Directory already exists: " + directory);
        }
        System.out.println();

        // 4. delete(): 파일이나 디렉토리 삭제
        System.out.println("=== delete() ===");
        Path fileForDelete = Path.of("temp/exampleForDelete.txt");
        Files.createFile(fileForDelete);
        System.out.println("File created: " + Files.exists(fileForDelete));
        Files.delete(fileForDelete);
        System.out.println("File deleted: " + !Files.exists(fileForDelete));
        System.out.println();

        // 5. isRegularFile(): 일반 파일인지 확인
        System.out.println("=== isRegularFile() ===");
        System.out.println("Is regular file: " + Files.isRegularFile(file));
        System.out.println();

        // 6. isDirectory(): 디렉토리인지 확인
        System.out.println("=== isDirectory() ===");
        System.out.println("Is directory: " + Files.isDirectory(directory));
        System.out.println();

        // 7. getFileName(): 파일이나 디렉토리의 이름 반환
        System.out.println("=== getFileName() ===");
        System.out.println("File name: " + file.getFileName());
        System.out.println();

        // 8. size(): 파일의 크기를 바이트 단위로 반환
        System.out.println("=== size() ===");
        System.out.println("File size: " + Files.size(file) + " bytes");
        System.out.println();

        // 9. move(): 파일의 이름을 변경하거나 이동
        System.out.println("=== move() ===");
        Path newFile = Path.of("temp/newExample.txt");
        Files.move(file, newFile, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File moved/renamed");
        System.out.println();

        // 10. getLastModifiedTime(): 마지막으로 수정된 시간 반환
        System.out.println("=== getLastModifiedTime() ===");
        System.out.println("Last modified: " + Files.getLastModifiedTime(newFile));
        System.out.println();

        // 11. readAttributes(): 파일의 기본 속성들 한 번에 읽기
        System.out.println("=== readAttributes() ===");
        BasicFileAttributes attrs = Files.readAttributes(newFile, BasicFileAttributes.class);
        System.out.println("Creation time: " + attrs.creationTime());
        System.out.println("Is directory: " + attrs.isDirectory());
        System.out.println("Is regular file: " + attrs.isRegularFile());
        System.out.println("Is symbolic link: " + attrs.isSymbolicLink());
        System.out.println("Size: " + attrs.size());
    }
}
