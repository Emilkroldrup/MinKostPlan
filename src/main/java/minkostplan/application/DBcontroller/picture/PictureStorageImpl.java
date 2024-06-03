package minkostplan.application.DBcontroller.picture;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.multipart.MultipartFile;

import minkostplan.application.DBcontroller.GenericJdbcRepository;
import minkostplan.application.entity.ImageRecipeInfo;

public class PictureStorageImpl implements PictureStorage{
    private GenericJdbcRepository<ImageRecipeInfo> dataAccess;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PictureStorageImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataAccess = new GenericJdbcRepository<>(jdbcTemplate, ImageRecipeInfo.class);
    }

    public interface PictureStorage {
        void saveImage(ImageRecipeInfo imageRecipeInfo);
        int getIdByIngredientName(String name);
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't initialize folder for upload.");
        }
    }

    @Override
    public void save(MultipartFile file) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Resource load(String filename) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'load'");
    }

    @Override
    public boolean delete(String filename) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public Stream<Path> loadAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadAll'");
    }
}
