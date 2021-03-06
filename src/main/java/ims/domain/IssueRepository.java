package ims.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IssueRepository extends JpaRepository<Long, Issue> {
    Optional<Issue> findBysSbject(String subject);
}
