package com.DRschuduling.controller;

import com.DRschuduling.entity.journalentry;
import com.DRschuduling.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RestController
@RequestMapping("/journal")
public class JournalControllerV2 {

 @Autowired
 private JournalEntryService journalEntryService;

 private Map<Long, journalentry> journalEntries =new HashMap<>();

 @GetMapping()
 public List<journalentry> getAll() {

  return null;
 }

 @PostMapping 
public journalentry createEntry(@RequestBody journalentry myentry) {
    journalEntryService.saveEntry(myentry);
    return myentry;
 }
 @GetMapping("id/{myId}")
 public journalentry getjournalentryById(@PathVariable Long myId){

  return null;
 }
 @DeleteMapping("id/{myId}")
  public journalentry deletejournalEntryById(@PathVariable Long myId){

  return null;
 }

}
