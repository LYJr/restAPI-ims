package ims.service;

import ims.domain.Issue;
import ims.domain.IssueRepository;
import ims.dto.IssueDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;
    
    public Optional<Issue> findBySubject(IssueDto issueDto) {
        return issueRepository.findBysSbject(issueDto.getSubject());
    }

    public Issue save(IssueDto issueDto){
        return issueRepository.save(issueDto._toIssue());
        // TODO: 2019-04-30 에러 무엇 
    }
}
