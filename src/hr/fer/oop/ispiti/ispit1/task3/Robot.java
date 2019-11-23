package hr.fer.oop.ispiti.ispit1.task3;

public class Robot implements Player {

    private String nickname;
    private String type;
    private Person responsiblePerson;

    public Robot(String nickname, String type){
        this.nickname = nickname;
        this.type = type;
    }

    public void setResponsiblePerson(Person person){
        this.responsiblePerson = person;
    }

    public String getNickname(){
        return nickname;
    }
}
