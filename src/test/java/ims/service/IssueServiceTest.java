package ims.service;

import ims.domain.IssueRepository;
import ims.dto.IssueDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IssueServiceTest {

    @Mock
    private IssueRepository issueRepository;

    @InjectMocks
    private IssueService issueService;

    private IssueDto issueDto = new IssueDto("aa","메롱");

    @Before
    public void repositoryInput(){
        when(issueService.findBySubject(issueDto)).thenReturn(issueDto._toIssue());
    }

    @Test
    public void input(){
        assertThat(issueRepository.findBySubject("aa")).isEquelTo(issueDto._toIssue());
    }

    @Test
    public void update(){

    }
}
