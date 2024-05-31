package com.careerit.bookstore.repository;

import com.careerit.bookstore.domain.BookDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface BookDetailsRepository extends JpaRepository<BookDetails, UUID> {

  @Query("select b from BookDetails b where b.title ilike concat('%',:str,'%') or b.description ilike concat('%',:str,'%')")
  List<BookDetails> search(@Param("str") String str);
}