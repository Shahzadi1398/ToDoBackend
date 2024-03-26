package ToDoList.repo;

import ToDoList.modal.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @Developer : Shahzadi Parveen
 * @Project-Name : ToDoList
 * @Mailto : shahzadiparveen@cdac.in
 * @Created : 19-03-2024
 * @Weekday : Tuesday
 **/

@Repository
public interface SignUpRepo   extends JpaRepository<SignUp, UUID> {
}
