package io.pivotal.pal.tracker.review;

import org.apache.tomcat.jni.Time;

public interface TimeEntryRepository {
    TimeEntry create(TimeEntry timeEntry);
}
