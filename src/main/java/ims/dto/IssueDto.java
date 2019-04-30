package ims.dto;

import ims.domain.Issue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueDto {

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String comment;

    public Issue _toIssue(){
        return new Issue(this.subject, this.comment);
    }
}
