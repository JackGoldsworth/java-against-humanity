package cs319.cards.model.form;

public class JoinForm {

    private final String username;
    private final String id;

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
