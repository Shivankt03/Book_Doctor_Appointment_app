package com.DRschuduling.config;

import com.DRschuduling.entity.journalentry;
import com.DRschuduling.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Override
    public void run(String... args) throws Exception {
        // Clear existing data
        journalEntryRepository.deleteAll();

        // Create sample journal entries
        journalentry entry1 = new journalentry();
        entry1.setTitle("First Entry");
        entry1.setContent("This is my first journal entry.");
        entry1.setDate(new Date());
        journalEntryRepository.save(entry1);

        journalentry entry2 = new journalentry();
        entry2.setTitle("Second Entry");
        entry2.setContent("This is my second journal entry with more content.");
        entry2.setDate(new Date());
        journalEntryRepository.save(entry2);

        System.out.println("Sample data loaded into H2 database!");
    }
}
