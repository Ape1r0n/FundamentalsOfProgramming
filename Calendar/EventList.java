package Calendar;

public class EventList {
    private Event event;
    private EventList next;

    public EventList(Event event) {
        this.event = event;
    }

    protected EventList(Event event, EventList next) {
        this.event = event;
        this.next = next;
    }

    public Event getEvent() {
        return event;
    }

    public EventList getNext() {
        return next;
    }

    public EventList add(Event event) {
        return new EventList(event, this);
    }
}