package cv.report.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @Column(name = "men_code")
    private String menuCode;
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "menu_parent")
    private String menuParent;
    @Column(name = "menu_url")
    private String menuUrl;

}
