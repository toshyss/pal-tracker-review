package io.pivotal.pal.tracker.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private HashMap<Long, TimeEntry> timeEntries = new HashMap<>();
    private long currentId = 1L;

    @Override
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

    @Override
    public TimeEntry find(Long id) {

        TimeEntry getTimeEntry = timeEntries.get(id);
        return getTimeEntry;
    }

    public List<TimeEntry> list() {
        List resultTimeEntries = new ArrayList<TimeEntry>(timeEntries.values());
        return resultTimeEntries;
    }
}
