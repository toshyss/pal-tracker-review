package io.pivotal.pal.tracker.review;

import java.sql.Time;
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

        TimeEntry foundTimeEntry = timeEntries.get(id);
        return foundTimeEntry;
    }

    public List<TimeEntry> list() {
        List resultTimeEntries = new ArrayList<TimeEntry>(timeEntries.values());
        return resultTimeEntries;
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        if (find(id) == null) {
            return null;
        }

        TimeEntry updatedTimeEntry = new TimeEntry(
                id,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );

        timeEntries.replace(id, updatedTimeEntry);

        return updatedTimeEntry;
    }

    @Override
    public void delete(Long id) {
        timeEntries.remove(id);
    }
}
