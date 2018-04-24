package rifu.demo.engqiz.service.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rifu.demo.engqiz.core.dao.QuestionDAO;
import rifu.demo.engqiz.core.dto.QuestionDTO;
import rifu.demo.engqiz.core.entity.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    public List<QuestionDTO> insert(List<Question> entities) {
        Iterable<Question> resultEntities = questionDAO.save(entities);

        List<QuestionDTO> resultDTOs = StreamSupport.stream(resultEntities.spliterator(), false).map(pojo -> {
            QuestionDTO dto = new QuestionDTO();
            BeanUtils.copyProperties(pojo, dto);
            return dto;
        }).collect(Collectors.toList());

        return resultDTOs;
    }

    public List<QuestionDTO> listAll(boolean showAnswers) {
        List<Question> pojos = (List<Question>) questionDAO.findAll();
        List<QuestionDTO> dtos = new ArrayList<>();
        dtos.addAll(
                pojos.stream().map(pojo -> QuestionDTO.toDTO(pojo, showAnswers)).collect(Collectors.toList())
        );
        return dtos;
    }


}
