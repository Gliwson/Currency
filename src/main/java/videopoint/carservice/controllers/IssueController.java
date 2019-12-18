package videopoint.carservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.videopoint.carservice.dto.Issue;
import pl.videopoint.carservice.repository.IssuesRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IssueController {

	private IssuesRepository issueRepository;

	@Autowired
	public IssueController(IssuesRepository issueRepository) {
		super();
		this.issueRepository = issueRepository;
	}


	@PostMapping("/addissue")
	public String addIssue(@ModelAttribute Issue issue) {
		issueRepository.addIssue(issue);
		return "confirm";
	}

	@PostMapping("/approve")
	public String approveIssue(@RequestParam Long id, @RequestParam(defaultValue = "false") Boolean approved, Model model) {
		Issue issue = issueRepository.getIssue(id);
		issue.setApproved(approved);
		List<Issue> issues = issueRepository.listIssues();
		model.addAttribute("issues", issues);
		return "issues";
	}


	@GetMapping("/issue/{id}")
	public String getIssue(@PathVariable Long id, Model model) {
		Issue issue = issueRepository.getIssue(id);
		model.addAttribute("issue", issue);
		return "confirm";

	}

	@GetMapping("/issues")
	public String getIssueList(Model model) {
		List<Issue> issues = issueRepository.listIssues();
		model.addAttribute("issues", issues);
		return "issues";

	}

	@GetMapping({"/", "/index", "/index.html"})
	public String index(Model model, HttpServletRequest request) {
		model.addAttribute("user", request.getRemoteUser());
		return "index";

	}

	@GetMapping({"/issue"})
	public String issue(Model model) {
		return "issue";

	}
}
