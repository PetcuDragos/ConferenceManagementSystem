package ui;

import domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import service.*;

import java.util.List;

public class Console {
    @Autowired
    private ServiceAccountInterface serviceAccount;
    @Autowired
    private ServiceAuthorInterface serviceAuthor;
    @Autowired
    private ServiceAuthorProposalInterface serviceAuthorProposal;
    @Autowired
    private ServiceParticipantInterface serviceParticipant;
    @Autowired
    private ServicePcMemberInterface servicePcMember;
    @Autowired
    private ServicePcRoleInterface servicePcRole;
    @Autowired
    private ServicePresentationInterface servicePresentation;
    @Autowired
    private ServicePresentationParticipantInterface servicePresentationParticipant;
    @Autowired
    private ServicePresentationRoleInterface servicePresentationRole;
    @Autowired
    private ServiceProposalInterface serviceProposal;
    @Autowired
    private ServiceProposalReviewInterface serviceProposalReview;

    public Console() {
    }

    public void run(){
        serviceAuthor.addAuthor(new Author("Radu Ninicu", "UBB", "radu@scs"));
        List<Author> authors = serviceAuthor.getAllAuthors();
        for (Author author : authors){
            System.out.println(author);
        }
    }


}
