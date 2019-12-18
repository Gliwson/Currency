package videopoint.carservice.repository;

import org.springframework.stereotype.Component;
import pl.videopoint.carservice.dto.Issue;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalLong;

@Component
public class IssuesRepository {

	private List<Issue> issues = new ArrayList<Issue>();

	@PostConstruct
	private void init() {
		issues.add(new Issue(1L, "Opel", "AA 234544", "Jan Kowalski", "Samoch�d czasem nie skr�ca", "Problem ze skr�caniem"));
	}

	public Issue getIssue(Long id) {
		return issues.stream().filter(issue -> issue.getId().equals(id)).findFirst().orElse(null);
	}

	public List<Issue> listIssues() {
		return Collections.unmodifiableList(issues);
	}

	public Long addIssue(Issue issue) {
		OptionalLong maxId = issues.stream().mapToLong(iss -> iss.getId()).max();
		Long id = maxId.orElse(1L);
		issue.setId(id);
		issues.add(issue);
		return id;
	}
}
