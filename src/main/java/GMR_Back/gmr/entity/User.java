package GMR_Back.gmr.entity;

import java.sql.Timestamp;

public class User {
    private Long id;
    private String email;
    private String password;
    private String username;
    private String phone;
    private int weight;
    private int height;
    private String role;
    private Timestamp create_at;

    public User() {}

    public User(String email, String password, String username, String phone, int weight, int height, String role, Timestamp create_at) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.phone = phone;
        this.weight = weight;
        this.height = height;
        this.role = role;
        this.create_at = create_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }
}
