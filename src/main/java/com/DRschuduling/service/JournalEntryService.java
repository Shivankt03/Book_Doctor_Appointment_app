package com.DRschuduling.service;

import com.DRschuduling.entity.journalentry;
import com.DRschuduling.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public List<journalentry> getAllEntries() {
        return journalEntryRepository.findAll();
    }

    public Optional<journalentry> getEntryById(Long id) {
        return journalEntryRepository.findById(id);
    }

    public journalentry createEntry(journalentry entry) {
        return journalEntryRepository.save(entry);
    }

    public Optional<journalentry> updateEntry(Long id, journalentry updatedEntry) {
        if (journalEntryRepository.existsById(id)) {
            updatedEntry.setId(id);
            return Optional.of(journalEntryRepository.save(updatedEntry));
        }
        return Optional.empty();
    }

    public boolean deleteEntry(Long id) {
        if (journalEntryRepository.existsById(id)) {
            journalEntryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
