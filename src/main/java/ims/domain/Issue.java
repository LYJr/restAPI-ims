package ims.domain;


import ims.dto.IssueDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
public class Issue extends AbstractEntity{
    //하나의 유저의 여러개의 이슈 => O[User] to M 관계 [Issue]
    @Column(nullable = false)
//    @Size
    private String subject;

    @Column(nullable = false)
    private String comment;

    public Issue(String subject, String comment) {
        super();
        this.subject = subject;
        this.comment = comment;
    }

    public IssueDto _toIssueDto(){
        return new IssueDto(this.subject, this.comment);
    }
}
