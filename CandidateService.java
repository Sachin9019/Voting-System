package sachin_voting_swing;

public class CandidateService {
	private CandidateDAO dao = new CandidateDAOImpl();

    public void addCandidate(String name) {
        dao.addCandidate(name);
    }

    public void viewCandidates() {
        dao.viewCandidates();
    }

    public void castVote(int id) {
        dao.vote(id);
    }

    public void viewResults() {
        dao.viewResults();
    }




}
