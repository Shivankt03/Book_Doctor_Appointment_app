package com.DRschuduling;

import com.DRschuduling.entity.journalentry;
import com.DRschuduling.repository.JournalEntryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class DRschedulingApplicationTests {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testH2DatabaseConnection() {
        // Test creating a journal entry
        journalentry entry = new journalentry();
        entry.setTitle("Test Entry");
        entry.setContent("Test content for H2 database");
        entry.setDate(new Date());

        journalentry savedEntry = journalEntryRepository.save(entry);
        assertNotNull(savedEntry.getId());
        assertEquals("Test Entry", savedEntry.getTitle());

        // Test retrieving the entry
        List<journalentry> entries = journalEntryRepository.findAll();
        assertFalse(entries.isEmpty());
        assertTrue(entries.stream().anyMatch(e -> e.getTitle().equals("Test Entry")));
    }
}
