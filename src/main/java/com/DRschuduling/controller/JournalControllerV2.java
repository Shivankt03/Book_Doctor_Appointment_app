package com.DRschuduling.controller;

import com.DRschuduling.entity.journalentry;
import com.DRschuduling.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Component
@RestController
@RequestMapping("/journal")
public class JournalControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping()
    public List<journalentry> getAll() {
        return journalEntryService.getAllEntries();
    }

    @PostMapping
    public journalentry createEntry(@RequestBody journalentry myentry) {
        return journalEntryService.createEntry(myentry);
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<journalentry> getjournalentryById(@PathVariable Long myId) {
        Optional<journalentry> entry = journalEntryService.getEntryById(myId);
        return entry.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<Void> deletejournalEntryById(@PathVariable Long myId) {
        if (journalEntryService.deleteEntry(myId)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("id/{myId}")
    public ResponseEntity<journalentry> updateEntry(@PathVariable Long myId, @RequestBody journalentry updatedEntry) {
        Optional<journalentry> result = journalEntryService.updateEntry(myId, updatedEntry);
        return result.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }
}


