package com.hms.service.base;

import com.hms.entity.Stay;
import java.util.List;

public interface StayService {

    Stay saveStay(Stay stay);

    List<Stay> getAllStays();

    Stay getStayById(Integer id);

    Stay updateStay(Integer id, Stay stay);

    void deleteStay(Integer id);
}