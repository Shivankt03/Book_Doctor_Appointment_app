package com.DRschuduling.repository;

import com.DRschuduling.entity.journalentry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface journalentryrepository extends MongoRepository<journalentry, String> {

}
