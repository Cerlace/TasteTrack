package cerlace.tastetrack.entity;

import cerlace.tastetrack.enums.Gender;
import cerlace.tastetrack.utils.interfaces.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "user")
public class UserEntity implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column
    @Enumerated
    private Gender gender;
    @Column
    private String email;
    @OneToOne(
            cascade = CascadeType.ALL,
            mappedBy = "user")
    private UserDetailsEntity userDetails;

    /**
     * Сеттер для поля {@code userDetails}, реализация которого позволяет
     * корректно обновлять значение в связанной таблице.
     * @param userDetails новое значение {@code userDetails}
     */
    public void setUserDetails(UserDetailsEntity userDetails) {
        if (userDetails == null) {
            if (this.userDetails != null) {
                this.userDetails.setUser(null);
            }
        } else {
            userDetails.setUser(this);
        }
        this.userDetails = userDetails;
    }
}
