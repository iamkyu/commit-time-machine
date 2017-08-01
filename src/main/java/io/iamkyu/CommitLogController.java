package io.iamkyu;

import io.iamkyu.model.GithubResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Kj Nam
 */
@Controller
@RequestMapping("/commit-log")
public class CommitLogController {

    private CommitLogService service;

    @Autowired
    public CommitLogController(CommitLogService service) {
        this.service = service;
    }

    @GetMapping
    public String getHome() {
        return "dashboard";
    }

    @GetMapping("/list")
    public @ResponseBody GithubResponse getList(@RequestParam(value = "date", required = false) String date)
            throws IOException {

        if (date == null || date.isEmpty()) {
            date = getTodayWithFormat("yyyy-MM-dd");
        }

        return service.findByDate(date);
    }

    private String getTodayWithFormat(String format) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

        return now.format(formatter);
    }
}
