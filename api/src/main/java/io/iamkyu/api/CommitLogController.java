package io.iamkyu.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/commit-log")
public class CommitLogController {
//
//    private CommitLogService service;
//    private GithubApiClient githubApiClient;
//
//    public CommitLogController(CommitLogService service, GithubApiClient githubApiClient) {
//        this.service = service;
//        this.githubApiClient = githubApiClient;
//    }
//
//    @GetMapping("/test")
//    public void test() {
//        githubApiClient.call();
//    }
//
//    @GetMapping
//    public String getHome() {
//        return "dashboard";
//    }
//
//    @GetMapping("/list")
//    public @ResponseBody
//    GithubResponse getList(@RequestParam(value = "date", required = false) String date)
//            throws IOException {
//
//        if (date == null || date.isEmpty()) {
//            date = getTodayWithFormat("yyyy-MM-dd");
//        }
//
//        return service.findByDate(date);
//    }
//
//    private String getTodayWithFormat(String format) {
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
//
//        return now.format(formatter);
//    }
}
