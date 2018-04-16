package rifu.demo.engqiz.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rifu.demo.engqiz.core.dao.QuestionDAO;
import rifu.demo.engqiz.core.dto.QuestionDTO;
import rifu.demo.engqiz.core.entity.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    public List<QuestionDTO> listAll() {
        List<Question> pojos = (List<Question>) questionDAO.findAll();
        List<QuestionDTO> dtos = new ArrayList<>();
        dtos.addAll(
                pojos.stream().map(pojo -> QuestionDTO.toDTO(pojo)).collect(Collectors.toList())
        );
        return dtos;
    }
}
