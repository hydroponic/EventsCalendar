package com.hydroponic.event_calender.services.networks;

import java.util.concurrent.Executor;

public class FireAuthExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
