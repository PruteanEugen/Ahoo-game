package student;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;


public class Message implements Serializable { //Market

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String body;

    public Message(UUID id, String body) {
        this.id = id;
        this.body = body;
    }
    // Constructor for creating message object from JSON object
    public Message(JSONObject jo) {
        try {
            this.id = UUID.fromString(jo.getString("id"));
        } catch (IllegalArgumentException | JSONException e) {
            this.id = UUID.randomUUID();
        }
        this.body = jo.getString("body");
    }
    // method that transform message object to JSON
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", this.id.toString());
        jsonObject.put("body", this.body);
        return jsonObject;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {this.id = id;}

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
