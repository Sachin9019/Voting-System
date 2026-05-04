package sachin_voting_swing;

public interface CandidateDAO {
	 void addCandidate(String name);
	    void viewCandidates();
	    void vote(int candidateId);
	    void viewResults();
}
