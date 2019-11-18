package io.pivotal.pal.tracker.review;

import java.util.HashMap;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private HashMap<Long, TimeEntry> timeEntries = new HashMap<>();
    private long currentId = 1L;

    public TimeEntry create(TimeEntry timeEntry) {

        long id = currentId++;

        TimeEntry newTimeEntry = new TimeEntry(
                id,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );

        timeEntries.put(id, newTimeEntry);
        return newTimeEntry;
    }

    public TimeEntry find(long id) {

        TimeEntry getTimeEntry = timeEntries.get(id);
        return getTimeEntry;
    }
}
