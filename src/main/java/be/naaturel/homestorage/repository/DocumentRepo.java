package be.naaturel.homestorage.repository;

import be.naaturel.homestorage.infrastucture.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepo extends JpaRepository<DocumentEntity, Long> { }
