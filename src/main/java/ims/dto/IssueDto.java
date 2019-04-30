package ims.dto;

import ims.domain.Issue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueDto {

    private String subject;
    private String comment;

    public Issue _toIssue(){
        return new Issue(this.subject, this.comment);
    }

}
