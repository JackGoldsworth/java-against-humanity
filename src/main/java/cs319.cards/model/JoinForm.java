package cs319.cards.model;

public class JoinForm {

    private String username;
    private String id;

    public JoinForm(String username, String id) {
        this.id = id;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }
}
