package cv.report.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "appuser")
public class AppUser {
    @Id
    @Column(name = "user_code")
    private String userCode;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "short_name")
    private String shortName;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "active")
    private boolean active;
    @Transient
    private String status = "NEW";
}
