import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseConfig {

    public FirebaseConfig() {
        try {
            FileInputStream serviceAccount = new FileInputStream("path/to/serviceAccountKey.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
                    .build();

            FirebaseApp.initializeApp(options);
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            FirebaseStorage.getInstance();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}