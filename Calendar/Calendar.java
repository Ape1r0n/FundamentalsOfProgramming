package Calendar;

public class Calendar{
    EventList events;

    public void addNewEvent(Event event){
        if(events == null){
            EventList eventList = new EventList(event);
        }else{
            events = events.add(event);
        }
    }

    public Event[] eventsAt(int day){
        if(events == null)
            return new Event[0];

        int counter = 0, j = 0;

        for(EventList i = events; i != null; i = i.getNext()){
            if(i.getEvent().diff(day) == 0){
                ++counter;
            }
        }

        Event[] arr = new Event[counter];

        for(EventList i = events; i != null; i = i.getNext()){
            if(i.getEvent().diff(day) == 0){
                arr[j] = i.getEvent();
                j++;
            }
        }

        return arr;
    }

    public Event nextEvent(int day){
        if(events == null)
            return null;//this.events.getNext();
        else{
            EventList temp = null;
            while(events.getEvent().getDay() != day){
                temp = events.getNext();
            }
            return temp.getEvent();
        }
    }
}