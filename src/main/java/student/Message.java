package student;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;


public class Message implements Serializable { //Market

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String body;

    public Message() {}

    public Message(String body, UUID id) {
        this.body = body;
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", body='" + body + '\'' +
                '}';
    }
}
