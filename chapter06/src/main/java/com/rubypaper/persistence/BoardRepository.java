package com.rubypaper.persistence;

import com.rubypaper.domain.Board;
import org.springframework.data.repository.CrudRepository;

// 단순 CRUD 기능만 구현할 것이기 때문에 CrudRepository 인터페이스만 상속
// https://inma.tistory.com/149     <- H2 데이터베이스 설치
public interface BoardRepository extends CrudRepository<Board, Long> {

}
