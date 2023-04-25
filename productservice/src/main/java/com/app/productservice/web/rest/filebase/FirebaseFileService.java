//package com.app.productservice.web.rest.filebase;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.cloud.storage.BlobId;
//import com.google.cloud.storage.BlobInfo;
//import com.google.cloud.storage.Storage;
//import com.google.cloud.storage.StorageOptions;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//@Service
//public class FirebaseFileService {
//
//    private Storage storage;
//
//    @EventListener
//    public void init(ApplicationReadyEvent event) {
//        try {
//            InputStream serviceAccount = getClass().getResourceAsStream("/firebase.json");
//            storage = StorageOptions.newBuilder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .setProjectId("appweb-70c6e")
//                .build()
//                .getService();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public String saveTest(MultipartFile file) throws IOException{
//        String imageName = generateFileName(file.getOriginalFilename());
//        Map<String, String> map = new HashMap<>();
//        map.put("firebaseStorageDownloadTokens", imageName);
//        BlobId blobId = BlobId.of("gs://appweb-70c6e/product", imageName);
//        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
//            .setMetadata(map)
//            .setContentType(file.getContentType())
//            .build();
//        storage.create(blobInfo, file.getInputStream());
//        return imageName;
//    }
//
//    private String generateFileName(String originalFileName) {
//        return UUID.randomUUID().toString() + "." + getExtension(originalFileName);
//    }
//
//    private String getExtension(String originalFileName) {
//        return StringUtils.getFilenameExtension(originalFileName);
//    }
//
//    public UUID generateUUID() {
//        UUID uuid = UUID.randomUUID();
//        return uuid;
//    }
//}
