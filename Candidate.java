package sachin_voting_swing;

public class Candidate {
	private int candidateId;
    private String name;
    private int votes;
    
    public Candidate() {}

    public Candidate(String name) {
        this.name = name;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

}
