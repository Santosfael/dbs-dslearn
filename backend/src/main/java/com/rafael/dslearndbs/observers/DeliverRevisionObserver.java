package com.rafael.dslearndbs.observers;

import com.rafael.dslearndbs.entities.Deliver;

public interface DeliverRevisionObserver {

    void onSaveRevision(Deliver deliver);

}
