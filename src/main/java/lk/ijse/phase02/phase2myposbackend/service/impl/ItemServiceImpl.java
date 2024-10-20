package lk.ijse.phase02.phase2myposbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.phase02.phase2myposbackend.dao.CustomerDao;
import lk.ijse.phase02.phase2myposbackend.dao.ItemDao;
import lk.ijse.phase02.phase2myposbackend.service.ItemService;
import lk.ijse.phase02.phase2myposbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private Mapping mapping;
}
