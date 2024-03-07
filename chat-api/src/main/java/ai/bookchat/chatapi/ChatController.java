package ai.bookchat.chatapi;

import dev.langchain4j.chain.ConversationalRetrievalChain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@Slf4j
public class ChatController {
    private final ConversationalRetrievalChain conversationalRetrievalChain;

    @PostMapping
    public String chatWithBook(@RequestBody String text) {
        var response = conversationalRetrievalChain.execute(text);
        log.debug("Response: {}",response);
        return response;
    }
}
