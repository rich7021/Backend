package rifu.demo.engqiz.core.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rifu.demo.engqiz.core.entity.Question;

@Repository
public interface QuestionDAO extends CrudRepository<Question, Long> {
}
