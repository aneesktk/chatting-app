import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class StorageService {

    private final FirebaseStorage firebaseStorage;

    public StorageService(FirebaseStorage firebaseStorage) {
        this.firebaseStorage = firebaseStorage;
    }

    public String uploadFile(MultipartFile file, String userId) throws IOException {
        StorageReference storageReference = firebaseStorage.getReference().child("uploads/" + userId + "/" + file.getOriginalFilename());
        storageReference.putBytes(file.getBytes());
        return storageReference.getDownloadUrl().toString();
    }

    public void deleteFile(String filePath) {
        StorageReference storageReference = firebaseStorage.getReference().child(filePath);
        storageReference.delete();
    }
}