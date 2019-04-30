package ims.web;

import ims.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class IssueController {
    @Autowired
    private IssueService issueService;
}
