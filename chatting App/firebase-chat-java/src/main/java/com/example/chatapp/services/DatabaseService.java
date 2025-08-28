import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.chatapp.models.Message;

import java.util.List;

public class DatabaseService {

    private final DatabaseReference databaseReference;

    public DatabaseService() {
        this.databaseReference = FirebaseDatabase.getInstance().getReference("messages");
    }

    public void saveMessage(Message message) {
        String messageId = databaseReference.push().getKey();
        if (messageId != null) {
            databaseReference.child(messageId).setValue(message);
        }
    }

    public void getMessages(Callback<List<Message>> callback) {
        databaseReference.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                List<Message> messages = task.getResult().getValue(new GenericTypeIndicator<List<Message>>() {});
                callback.onSuccess(messages);
            } else {
                callback.onFailure(task.getException());
            }
        });
    }

    public interface Callback<T> {
        void onSuccess(T result);
        void onFailure(Exception e);
    }
}