package com.hydroponic.event_calender.views.customs;

import com.hydroponic.event_calender.services.models.Event;

public interface IEventInfo {
    public void sendInsertRequest(Event event);
}
