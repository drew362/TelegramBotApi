public class DataUser {
    public Integer id;
    public String first_name;
    public String last_name;
    public String username;
    public String type;

    public DataUser(Integer id, String first_name, String last_name, String username, String type) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getUsername() {
        return username;
    }

    public String getType() {
        return type;
    }


}
