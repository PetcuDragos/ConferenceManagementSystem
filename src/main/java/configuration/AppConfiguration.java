package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import service.*;
import ui.Console;


@Configuration
@ComponentScan({"repository", "service", "ui"})
public class AppConfiguration {

    @Bean
    Console console(){
        return new Console();
    }

    @Bean
    ServiceAccountInterface serviceAccount() {
        return new ServiceAccount();
    }

    @Bean
    ServiceAuthorInterface serviceAuthor(){
        return new ServiceAuthor();
    }

    @Bean
    ServiceAuthorProposalInterface serviceAuthorProposal(){
        return new ServiceAuthorProposal();
    }

    @Bean
    ServiceParticipantInterface serviceParticipant(){
        return new ServiceParticipant();
    }

    @Bean
    ServicePcMemberInterface servicePcMember(){
        return new ServicePcMember();
    }

    @Bean
    ServicePcRoleInterface servicePcRole(){
        return new ServicePcRole();
    }

    @Bean
    ServicePresentationInterface servicePresentation(){
        return new ServicePresentation();
    }

    @Bean
    ServicePresentationParticipantInterface servicePresentationParticipant(){
        return new ServicePresentationParticipant();
    }

    @Bean
    ServicePresentationRoleInterface servicePresentationRole(){
        return new ServicePresentationRole();
    }

    @Bean
    ServiceProposalInterface serviceProposal(){
        return new ServiceProposal();
    }

    @Bean
    ServiceProposalReviewInterface serviceProposalReview(){
        return new ServiceProposalReview();
    }
}
