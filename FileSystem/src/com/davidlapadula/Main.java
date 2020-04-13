package com.davidlapadula;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {
        File file = new File("C:\\Examples\\file.txt");
        Path convertedPath = file.toPath();

        File parent = new File("C:\\Examples\\file.txt");
        File resolvedFile = new File(parent, "dir\\file.txt");

        File workingDir = new File("").getAbsoluteFile();
        File dir2File = new File(workingDir, "\\FileTree\\Dir2");
        String[] dir2Contents = dir2File.list();

        for (int i=0; i<dir2Contents.length; i++) {
            System.out.println(dir2Contents[i]);
        }

    }

    public static void copyFileDir() {
        Path dirPath = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        Path copyPath = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir4" + File.separator + "Dir2Copy");

        try {
            Files.walkFileTree(dirPath, new CopyFiles(dirPath, copyPath));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void walkFileTree() {
        System.out.println("Walk the file tree");
        Path dirPath = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        try {
            Files.walkFileTree(dirPath, new PrintNames());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void getFileStores() {
       Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
       for (FileStore store: stores) {
           System.out.println(store);
           System.out.println(store.name());
       }

        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for (Path path: rootPaths) {
            System.out.println(path);
        }

    }

    public static void createTempFile() {
        try {
            Path tempFile = Files.createTempFile("app", ".txt");
            System.out.println(tempFile.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readDirs() {
        DirectoryStream.Filter<Path> filter =
                new DirectoryStream.Filter<Path>() {
                    public boolean accept(Path path) throws IOException {
                        return (Files.isRegularFile(path));
                    }
                };

        Path dir = FileSystems.getDefault().getPath("FileTree\\Dir2");
        try(DirectoryStream<Path> contents =  Files.newDirectoryStream(dir, filter)) {
            for (Path file: contents)  {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException e) {
            e.getMessage();
        }
    }

    private static void getMetadata() {
        try {
            Path path = FileSystems.getDefault().getPath("Examples", "Dir1\\file1.txt");
            BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("Size: " + attrs.size());
            System.out.println("Created: " + attrs.creationTime());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createDirectory() {
        try {
//            Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir4");
            Path dirsToCreate = FileSystems.getDefault().getPath("Examples", "Dir2\\Dir3\\Dir4\\Dir5\\Dir6");
//            Files.createDirectory(dirToCreate);
            Files.createDirectories(dirsToCreate);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFile() {
        try {
            Path fileToCreate = FileSystems.getDefault().getPath("Examples", "file2.txt");
            Files.createFile(fileToCreate);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteFile() {
        try {
            Path fileToDel = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
            Files.delete(fileToDel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void moveFile() {
        try {
            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
            Path destination = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copycopy.txt");
            Files.move(fileToMove, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyDirectory() {
        try {
            Path sourceDir = FileSystems.getDefault().getPath("Examples", "Dir1");
            Path copyDir = FileSystems.getDefault().getPath("Examples", "Dir4");
            Files.copy(sourceDir, copyDir, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile() {
        try {
            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void testing() {
        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        Path filePath = FileSystems.getDefault().getPath("Files", "Subdirectory.txt");
        Path filePath2 = Paths.get(".","Files", "Subdirectory.txt");
        Path outPath = Paths.get("C:\\Users\\DavidLapadula\\Downloads\\Rename.txt");
        Path path2 = FileSystems.getDefault().getPath(".", "Files", "..", "Files", "Subdirectory.txt");
        Path path4 = Paths.get("C:\\Users\\DavidLapadula\\Downloads\\something.txt");
        Path filesPath = FileSystems.getDefault().getPath("Files");
    }

    private static void printFile(Path path) {
        try (BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;

            while((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
