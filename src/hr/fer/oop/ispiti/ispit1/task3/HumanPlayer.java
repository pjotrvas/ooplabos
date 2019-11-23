package hr.fer.oop.ispiti.ispit1.task3;

public class HumanPlayer extends Person implements Player {

    private String nickname;

    public HumanPlayer ( String name , String id, String nickname) {
        super(name , id);
        this.nickname = nickname;
    }

    public String getNickname () {
        return nickname;
    }
}
