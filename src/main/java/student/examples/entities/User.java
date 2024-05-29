package student.examples.entities;

public class User {
    private String usarname;
    public User(){}

    public User(String usarname) {
        this.usarname = usarname;
    }

    public String getUsarname() {
        return usarname;
    }

    public void setUsarname(String usarname) {
        this.usarname = usarname;
    }

    @Override
    public String toString() {
        return "User{" +
                "usarname='" + usarname + '\'' +
                '}';
    }
}
