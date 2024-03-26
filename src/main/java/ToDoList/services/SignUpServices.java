package ToDoList.services;

import ToDoList.modal.SignUp;
import ToDoList.repo.SignUpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Developer : Shahzadi Parveen
 * @Project-Name : ToDoList
 * @Mailto : shahzadiparveen@cdac.in
 * @Created : 19-03-2024
 * @Weekday : Tuesday
 **/

@Service
public class SignUpServices {

    @Autowired
    SignUpRepo signUpRepo;

    public void saveSignUp(SignUp signUp){
        LocalDate date = LocalDate.now();
        signUp.setEntryDt(date);
        signUpRepo.save(signUp);
    }

    public List<SignUp> getDataSignUp(){
        return signUpRepo.findAll();
    }

    public SignUp updateSingUpWhenLogout(String email, String password){
        List<SignUp> signUpList = signUpRepo.findAll();
        List<SignUp> signUp = signUpList.stream()
                .filter(s-> s.getEmail().equals(email))
                .filter(s-> s.getPassword().equals(password))
                .collect(Collectors.toList());
        if (!signUp.isEmpty()) {
            SignUp user = signUp.get(0);
            user.setIsLoggedIn(false);
            return signUpRepo.save(user);
        }
        return null;
    }

    public List<SignUp> getSingUpWhenLogin(String email, String password){
        List<SignUp> signUpList = signUpRepo.findAll();
        List<SignUp> signUp = signUpList.stream()
                .filter(s-> s.getEmail().equals(email))
                .filter(s-> s.getPassword().equals(password))
                .collect(Collectors.toList());
        if (!signUp.isEmpty()) {
            SignUp user = signUp.get(0);
            user.setIsLoggedIn(true);
            signUpRepo.save(user);
        }
        return signUp;
    }
}
