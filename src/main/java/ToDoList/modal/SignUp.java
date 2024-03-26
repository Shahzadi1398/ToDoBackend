package ToDoList.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @Developer : Shahzadi Parveen
 * @Project-Name : ToDoList
 * @Mailto : shahzadiparveen@cdac.in
 * @Created : 19-03-2024
 * @Weekday : Tuesday
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "singUp")
public class SignUp {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "\"uuidId\"",nullable = false)
    private UUID uuidId;

    @Column(name = "\"firstName\"")
    private String firstName;

    @Column(name = "\"lastName\"")
    private String lastName;

    @Column(name = "\"email\"")
    private String email;

    @Column(name = "\"password\"")
    private String password;

    @Column(name = "\"entryDt\"")
    private LocalDate entryDt;

    @Column(name = "\"isLoggedIn\"")
    private Boolean isLoggedIn;

}
