package com.DRschuduling.repository;

import com.DRschuduling.entity.journalentry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepository extends JpaRepository<journalentry, Long> {
    // Basic CRUD operations are automatically provided by JpaRepository
}
