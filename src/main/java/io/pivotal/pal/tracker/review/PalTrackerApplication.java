package io.pivotal.pal.tracker.review;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import javax.swing.*;
import java.sql.Time;
import java.util.TimeZone;

@SpringBootApplication
public class PalTrackerApplication {

    public static void main(String[] args) {
//        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(PalTrackerApplication.class, args);
    }

//    @Bean
//    TimeEntryRepository timeEntryRepository() {
//        return new InMemoryTimeEntryRepository();
//    }
    @Bean
    TimeEntryRepository timeEntryRepository(DataSource dataSource) {
        return new JdbcTimeEntryRepository(dataSource);
    }
}
