package com.github.yoruhinda.eletronicCommercer.services;

import com.github.yoruhinda.eletronicCommercer.domain.entity.product.ProductImage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ImageService {
    public String saveImageToStorage(String uploadDirectory, MultipartFile imageFile) throws IOException {
        String uniqueFileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();

        Path uploadPath = Path.of(uploadDirectory);
        Path filePath = uploadPath.resolve(uniqueFileName);

        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }

        Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return uniqueFileName;
    }

    public byte[] getImage(String imageDirectory, String imageName) throws IOException {
        Path imagePath = Path.of(imageDirectory, imageName);
        if(Files.exists(imagePath)){
            return Files.readAllBytes(imagePath);
        }
        return null;
    }

    public String deleteImage(String imageDirectory, String imageName) throws IOException {
        Path imagePath = Path.of(imageDirectory, imageName);
        if(Files.exists(imagePath)){
            Files.delete(imagePath);
            return "Success";
        }
        return "Failed";
    }

    public List<ProductImage> getAllImagesProducts(String imageDirectory) throws IOException {
        File folder = Path.of(imageDirectory).toFile();
        File[] files = folder.listFiles();
        List<ProductImage> productImageList = new ArrayList<>();
        if(files != null){
            for (File file : files) {
                productImageList.add(new ProductImage(file.getName(), Files.readAllBytes(file.toPath())));
            }
            return productImageList;
        }
        return null;
    }
}
