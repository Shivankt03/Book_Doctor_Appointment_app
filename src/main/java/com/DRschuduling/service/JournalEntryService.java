package com.DRschuduling.service;

import com.DRschuduling.entity.journalentry;
import com.DRschuduling.repository.journalentryrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JournalEntryService {
    @Autowired
    private journalentryrepository journalentryrepository;

    public void saveEntry(journalentry entry){
        journalentryrepository.save(entry);
    }
}
