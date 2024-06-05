package minkostplan.application.usecase;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import minkostplan.application.DBcontroller.picture.PictureStorage;



@Service
public class PictureStorageService implements PictureStorage {
    private final Path root = Paths.get("./recipe-images");

    /**
     * Initializes the folder for the upload. Name of the folder is recipe-images.
     *  If the folder doesn't exist, it creates it.
     * If the folder already exists, it does nothing.
     * If the folder can't be created, it throws a runtime exception.
     * 
     */
    @Override
    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't initialize folder for upload.");
        }
    }

    /**
     * Saves the specified file in the root folder.
     * If the file already exists, it throws a runtime exception.
     *  If the file can't be saved, it throws a runtime exception.
     *  @param file the file to save
     *  @throws RuntimeException if the file already exists or can't be saved
     * 
     */
    @Override
    public void save(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file with that name already exists.");
            }
        }
    }

    /**
     * Loads the specified file from the root folder.
     * If the file can't be read, it throws a runtime exception.
     * @param filename the name of the file to load
     * @return the resource of the file
     * @throws RuntimeException if the file can't be read
     * 
     */
    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if(resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file.");
            }
        } catch (MalformedURLException e) { 
            throw new RuntimeException("Error: " + e.getMessage()); 
        }
    }
    
    /**
     * Deletes all files in the root folder.
     * If the files can't be deleted, it throws a runtime exception.
     *  @throws RuntimeException if the files can't be deleted
     * 
     */
    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    /**
     * Loads all files from the root folder.
     * If the files can't be loaded, it throws a runtime exception.
     * @return the stream of paths of the files
     * @throws RuntimeException if the files can't be loaded
     * 
     */
    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files.");
        }
    }

    /**
     * Deletes the specified file from the root folder.
     * If the file can't be deleted, it throws a runtime exception.
     * @param filename the name of the file to delete
     * @return true if the file was deleted, false otherwise
     * @throws RuntimeException if the file can't be deleted
     *  
     */
    @Override
    public boolean delete(String filename) {
        try {
            Path file = root.resolve(filename);
            return Files.deleteIfExists(file);
          } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
          }
    }

}

