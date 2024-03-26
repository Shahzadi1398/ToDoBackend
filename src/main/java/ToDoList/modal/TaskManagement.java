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
 * @Created : 21-03-2024
 * @Weekday : Thursday
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "toDo")
public class TaskManagement {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "\"uuidId\"",nullable = false)
    private UUID uuidId;

    @Column(name = "\"taskName\"")
    private String taskName;

    @Column(name = "\"taskDate\"")
    private LocalDate taskDate;

    @Column(name = "\"completeDate\"")
    private LocalDate completeDate;

    @Column(name = "\"entryDt\"")
    private LocalDate entryDt;

    @Column(name = "\"progressPercentage\"")
    private Integer progressPercentage;

    @Column(name = "\"priorityLevels\"")
    private String priorityLevels;

    @Column(name = "\"categories\"")
    private String categories;

    @Column(name = "\"repeatAfter\"")
    private String repeatAfter;

    @Column(name = "\"isCompleted\"")
    private Boolean isCompleted = false;

    @Column(name = "\"isEnabling\"")
    private Boolean isEnabling;

    @ManyToOne
    @JoinColumn(name = "\"signUp\"", referencedColumnName = "\"uuidId\"" )
    SignUp signUp;
}
