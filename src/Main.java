import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try{
            method("1234512345aSD_","1234","1234");
        } catch (WrongLoginException|WrongPasswordException e){
            System.out.println(e.getMessage());
        }
    }

    public static void method(String login, String password, String confirmPassword) {
        String regex = "^[a-zA-z0-9_]{1,20}$";

        Pattern patternLogin = Pattern.compile(regex);
        Pattern patternPassword = Pattern.compile(regex);

        Matcher matcherLogin = patternLogin.matcher(login);
        Matcher matcherPassword = patternPassword.matcher(password);
            if (!matcherLogin.matches()) {
                throw new WrongLoginException("Не правильно введен логин");
            }

            if (!matcherPassword.matches() || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("не правильно введен пароль");
            }

        System.out.println("Аутенфикация прошла успешно");
    }
}