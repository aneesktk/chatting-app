import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.chatapp.models.Message;
import com.example.chatapp.services.DatabaseService;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private DatabaseService databaseService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody Message message) {
        databaseService.saveMessage(message);
        return ResponseEntity.ok("Message sent successfully");
    }

    @GetMapping("/messages/{userId}")
    public ResponseEntity<List<Message>> getMessages(@PathVariable String userId) {
        List<Message> messages = databaseService.getMessages(userId);
        return ResponseEntity.ok(messages);
    }
}