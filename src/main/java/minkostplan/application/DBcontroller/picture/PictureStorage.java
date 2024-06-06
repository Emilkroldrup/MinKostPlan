package minkostplan.application.DBcontroller.picture;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import minkostplan.application.DBcontroller.SimpleDataAccess;
import minkostplan.application.entity.Image;

public interface PictureStorage {

    public void init();

    public void saveUpload(MultipartFile file);

    public Resource load(String filename);

    public boolean delete(String filename);

    public void deleteAll();

    public Stream<Path> loadAll();
}
