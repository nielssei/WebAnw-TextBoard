package edu.fra.uas.text.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.fra.uas.text.model.Text;

// Repository, um alle Texte in einer Datenbank zu speichern wird mithilfe von JPARepository realisiert
@Repository
public interface TextRepository extends JpaRepository<Text, Long> {
    List<Text> findByTitle(String title);
}
