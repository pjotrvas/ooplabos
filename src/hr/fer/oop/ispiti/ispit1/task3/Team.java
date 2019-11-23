package hr.fer.oop.ispiti.ispit1.task3;

public class Team implements Competitor{

    private String nickname;
    private Player[] team;

    public Team(String teamNickname, Player[] players){
        this.nickname = teamNickname;

        team = new Player[players.length];

        for (int i = 0; i < players.length; i++) {
            this.team[i] = players[i];
        }

    }

    public String getNickname(){
        return nickname;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nickname);
        sb.append(" :");
        for(int i=0; i<team.length; i++) {
            sb.append(' ');
            sb.append(team[i]);
        }
        return sb.toString();
    }

}
